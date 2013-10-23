package cz.zeptejsepojistovaka.persistence.config;

import java.util.Properties;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.hibernate.ejb.HibernatePersistence;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author <a href="mailto:skalicky.tomas@gmail.com">Tomas Skalicky</a>
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("cz.zeptejsepojistovaka.persistence.repository")
@Import({ MainDataSourceConfig.class, TestHsqlDataSourceConfig.class })
@ComponentScan("cz.zeptejsepojistovaka.persistence")
public class DataSourceConfig {

    private static final String ENTITYMANAGER_PACKAGES_TO_SCAN = "cz.zeptejsepojistovaka.domainmodel";

    @Inject
    private DataSourcePropertyLoader dataSourcePropertyLoader;

    @Inject
    private DataSource dataSource;

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(this.dataSource);
        entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistence.class);
        entityManagerFactoryBean.setPackagesToScan(ENTITYMANAGER_PACKAGES_TO_SCAN);

        entityManagerFactoryBean.setJpaProperties(getHibernateProperties());

        return entityManagerFactoryBean;
    }

    private Properties getHibernateProperties() {
        Properties properties = new Properties();
        properties.put(DataSourcePropertyLoader.HIBERNATE_DIALECT_PROPERTY_NAME,
                this.dataSourcePropertyLoader.getHibernateDialect());
        properties.put(DataSourcePropertyLoader.HIBERNATE_SHOW_SQL_PROPERTY_NAME,
                this.dataSourcePropertyLoader.isHibernateShowSql());
        properties.put(DataSourcePropertyLoader.HIBERNATE_HBM2DDL_AUTO_PROPERTY_NAME,
                this.dataSourcePropertyLoader.getHibernateHbm2ddlAuto());
        return properties;
    }

    @Bean
    public JpaTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return transactionManager;
    }
}
