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
import org.springframework.stereotype.Service;

@Service(value = DataSourcePropertyLoader.SERVICE_NAME)
public class DataSourcePropertyLoader {

    private static final String DATABASE_DRIVER_CLASS_PROPERTY_NAME = "database.driverClass";
    private static final String DATABASE_CONNECTION_URL_PROPERTY_NAME = "database.connectionUrl";
    private static final String DATABASE_USERNAME_PROPERTY_NAME = "database.username";
    private static final String DATABASE_PASSWORD_PROPERTY_NAME = "database.password";

    private static final String LIQUIBASE_CHANGE_LOG_FILE_NAME = "liquibase.changeLogFileName";

    static final String HIBERNATE_DIALECT_PROPERTY_NAME = "hibernate.dialect";
    static final String HIBERNATE_SHOW_SQL_PROPERTY_NAME = "hibernate.show_sql";
    static final String HIBERNATE_HBM2DDL_AUTO_PROPERTY_NAME = "hibernate.hbm2ddl.auto";

    public static final String SERVICE_NAME = "dataSourcePropertyLoader";

    @NonNull
    @Getter
    @Setter(AccessLevel.PRIVATE)
    private String databaseDriverClass;

    @NonNull
    @Getter
    @Setter(AccessLevel.PRIVATE)
    private String databaseConnectionUrl;

    @NonNull
    @Getter
    @Setter(AccessLevel.PRIVATE)
    private String databaseUsername;

    @NonNull
    @Getter
    @Setter(AccessLevel.PRIVATE)
    private String databasePassword;

    @NonNull
    @Getter
    @Setter(AccessLevel.PRIVATE)
    private String liquibaseChangeLogFileName;

    @NonNull
    @Getter
    @Setter(AccessLevel.PRIVATE)
    private String hibernateDialect;

    @NonNull
    @Getter
    @Setter(AccessLevel.PRIVATE)
    private boolean hibernateShowSql;

    @NonNull
    @Getter
    @Setter(AccessLevel.PRIVATE)
    private String hibernateHbm2ddlAuto;

    public DataSourcePropertyLoader() throws IOException {
        loadPropertyValuesFromFile("environment/dataSource.properties");
    }

    private void loadPropertyValuesFromFile(String propertyFileClassPath) throws IOException {
        Resource propertyFile = new ClassPathResource(propertyFileClassPath);
        Properties loadedProperties = PropertiesLoaderUtils.loadProperties(propertyFile);

        setDatabaseDriverClass(loadedProperties.getProperty(DATABASE_DRIVER_CLASS_PROPERTY_NAME));
        setDatabaseConnectionUrl(loadedProperties.getProperty(DATABASE_CONNECTION_URL_PROPERTY_NAME));
        setDatabaseUsername(loadedProperties.getProperty(DATABASE_USERNAME_PROPERTY_NAME));
        setDatabasePassword(loadedProperties.getProperty(DATABASE_PASSWORD_PROPERTY_NAME));
        setLiquibaseChangeLogFileName(loadedProperties.getProperty(LIQUIBASE_CHANGE_LOG_FILE_NAME));
        setHibernateDialect(loadedProperties.getProperty(HIBERNATE_DIALECT_PROPERTY_NAME));
        setHibernateShowSql(Boolean.valueOf(loadedProperties.getProperty(HIBERNATE_SHOW_SQL_PROPERTY_NAME)));
        setHibernateHbm2ddlAuto(loadedProperties.getProperty(HIBERNATE_HBM2DDL_AUTO_PROPERTY_NAME));
    }
}
