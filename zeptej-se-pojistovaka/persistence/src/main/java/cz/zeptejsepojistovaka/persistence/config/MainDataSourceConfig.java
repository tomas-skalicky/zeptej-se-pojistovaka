package cz.zeptejsepojistovaka.persistence.config;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import cz.zeptejsepojistovaka.commons.annotation.InDevelopment;
import cz.zeptejsepojistovaka.commons.annotation.InProduction;

/**
 * @author <a href="mailto:skalicky.tomas@gmail.com">Tomas Skalicky</a>
 */
@Configuration
@Profile(value = { InDevelopment.PROFILE_NAME, InProduction.PROFILE_NAME })
public class MainDataSourceConfig {

    @Inject
    private DataSourcePropertyLoader dataSourcePropertyLoader;

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName(this.dataSourcePropertyLoader.getDatabaseDriverClass());
        dataSource.setUrl(this.dataSourcePropertyLoader.getDatabaseConnectionUrl());
        dataSource.setUsername(this.dataSourcePropertyLoader.getDatabaseUsername());
        dataSource.setPassword(this.dataSourcePropertyLoader.getDatabasePassword());

        return dataSource;
    }
}
