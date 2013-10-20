package cz.zeptejsepojistovaka.persistence.config;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import cz.zeptejsepojistovaka.commons.annotation.InTest;
import cz.zeptejsepojistovaka.persistence.db.migration.DatabaseMigrationHelper;

/**
 * @author <a href="mailto:skalicky.tomas@gmail.com">Tomas Skalicky</a>
 */
@Configuration
@InTest
public class TestDataSourceConfig {

    private static final Boolean DATABASE_INITIALIZED = Boolean.FALSE;

    @Inject
    private DataSourcePropertyLoader dataSourcePropertyLoader;

    @Bean
    public DataSource dataSource() {
        DataSource dataSource = new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.HSQL)
                .setName(this.dataSourcePropertyLoader.getDatabaseName()).build();
        initializeDatabase(dataSource);
        return dataSource;
    }

    /**
     * Initializes a HSQLDB, but exactly once.
     */
    private static void initializeDatabase(DataSource dataSource) {
        if (!DATABASE_INITIALIZED) {
            synchronized (DATABASE_INITIALIZED) {
                if (!DATABASE_INITIALIZED) {
                    JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
                    try {
                        DatabaseMigrationHelper.processAllMigrations(jdbcTemplate);
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        }
    }
}
