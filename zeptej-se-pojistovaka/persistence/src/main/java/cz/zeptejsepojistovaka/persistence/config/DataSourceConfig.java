package cz.zeptejsepojistovaka.persistence.config;

import java.util.Properties;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.hibernate.ejb.HibernatePersistence;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author <a href="mailto:skalicky.tomas@gmail.com">Tomas Skalicky</a>
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("cz.zeptejsepojistovaka.persistence.repository")
public class DataSourceConfig {

    private static final String ENTITYMANAGER_PACKAGES_TO_SCAN = "cz.zeptejsepojistovaka.domainmodel";

    @Inject
    private DataSourceProperties dataSourceProperties;

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName(this.dataSourceProperties.getDbDriver());
        dataSource.setUrl(this.dataSourceProperties.getDbUrl());
        dataSource.setUsername(this.dataSourceProperties.getDbUsername());
        dataSource.setPassword(this.dataSourceProperties.getDbPassword());

        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource());
        entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistence.class);
        entityManagerFactoryBean.setPackagesToScan(ENTITYMANAGER_PACKAGES_TO_SCAN);

        entityManagerFactoryBean.setJpaProperties(getHibernateProperties());

        return entityManagerFactoryBean;
    }

    private Properties getHibernateProperties() {
        Properties properties = new Properties();
        properties.put(DataSourceProperties.HIBERNATE_DIALECT_PROPERTY_NAME,
                this.dataSourceProperties.getHibernateDialect());
        properties.put(DataSourceProperties.HIBERNATE_SHOW_SQL_PROPERTY_NAME,
                this.dataSourceProperties.isHibernateShowSql());
        return properties;
    }

    @Bean
    public JpaTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return transactionManager;
    }
}
