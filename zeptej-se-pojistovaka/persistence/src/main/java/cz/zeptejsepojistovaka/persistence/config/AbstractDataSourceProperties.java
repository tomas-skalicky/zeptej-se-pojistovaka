package cz.zeptejsepojistovaka.persistence.config;

import java.io.IOException;
import java.util.Properties;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

public abstract class AbstractDataSourceProperties implements DataSourceProperties {

    @NonNull
    @Getter
    @Setter(AccessLevel.PRIVATE)
    private String dbDriver;
    @NonNull
    @Getter
    @Setter(AccessLevel.PRIVATE)
    private String dbUrl;
    @NonNull
    @Getter
    @Setter(AccessLevel.PRIVATE)
    private String dbUsername;
    @NonNull
    @Getter
    @Setter(AccessLevel.PRIVATE)
    private String dbPassword;
    @NonNull
    @Getter
    @Setter(AccessLevel.PRIVATE)
    private String hibernateDialect;
    @NonNull
    @Getter
    @Setter(AccessLevel.PRIVATE)
    private boolean hibernateShowSql;

    public AbstractDataSourceProperties(String propertyFileClassPath) throws IOException {
        loadPropertyValuesFromFile(propertyFileClassPath);
    }

    private void loadPropertyValuesFromFile(String propertyFileClassPath) throws IOException {
        Resource propertyFile = new ClassPathResource(propertyFileClassPath);
        Properties loadedProperties = PropertiesLoaderUtils.loadProperties(propertyFile);

        setDbDriver(loadedProperties.getProperty(DATABASE_DRIVER_PROPERTY_NAME));
        setDbUrl(loadedProperties.getProperty(DATABASE_URL_PROPERTY_NAME));
        setDbUsername(loadedProperties.getProperty(DATABASE_USERNAME_PROPERTY_NAME));
        setDbPassword(loadedProperties.getProperty(DATABASE_PASSWORD_PROPERTY_NAME));
        setHibernateDialect(loadedProperties.getProperty(HIBERNATE_DIALECT_PROPERTY_NAME));
        setHibernateShowSql(Boolean.valueOf(loadedProperties.getProperty(HIBERNATE_SHOW_SQL_PROPERTY_NAME)));
    }
}
