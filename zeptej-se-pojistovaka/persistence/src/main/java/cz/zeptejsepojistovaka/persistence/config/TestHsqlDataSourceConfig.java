package cz.zeptejsepojistovaka.persistence.config;

import java.sql.Connection;
import java.sql.SQLException;

import javax.inject.Inject;
import javax.sql.DataSource;

import liquibase.Liquibase;
import liquibase.database.jvm.HsqlConnection;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.LiquibaseException;
import liquibase.resource.ClassLoaderResourceAccessor;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import cz.zeptejsepojistovaka.commons.annotation.InTest;

/**
 * @author <a href="mailto:skalicky.tomas@gmail.com">Tomas Skalicky</a>
 */
@Configuration
@InTest
public class TestHsqlDataSourceConfig {

    private static final Boolean DATABASE_INITIALIZED = Boolean.FALSE;

    @Inject
    private DataSourcePropertyLoader dataSourcePropertyLoader;

    @Bean
    public DataSource dataSource() {
        DataSource dataSource = new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.HSQL).build();
        initializeDatabase(dataSource, this.dataSourcePropertyLoader.getLiquibaseChangeLogFileName());
        return dataSource;
    }

    /**
     * Initializes a test database, but exactly once.
     */
    private static void initializeDatabase(DataSource dataSource, String liquibaseChangeLogFileName) {
        if (!DATABASE_INITIALIZED) {
            synchronized (DATABASE_INITIALIZED) {
                if (!DATABASE_INITIALIZED) {
                    initializeLiquibase(dataSource, liquibaseChangeLogFileName);
                }
            }
        }
    }

    private static void initializeLiquibase(DataSource dataSource, String liquibaseChangeLogFileName) {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            Liquibase liquibase = new Liquibase(liquibaseChangeLogFileName,
                    new ClassLoaderResourceAccessor(), getCorrespondingJdbcConnection(connection));

            liquibase.update(StringUtils.EMPTY);

        } catch (SQLException | LiquibaseException ex) {
            throw new RuntimeException(ex);
        } finally {

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex2) {
                    throw new RuntimeException(ex2);
                }
            }
        }
    }

    private static JdbcConnection getCorrespondingJdbcConnection(Connection connection) {
        return new HsqlConnection(connection);
    }
}
