package cz.zeptejsepojistovaka.persistence.config;

import lombok.Getter;
import lombok.NonNull;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component(value = DataSourceProperties.COMPONENT_NAME)
public class DataSourceProperties {

    private static final String DATABASE_DRIVER_CLASS_PROPERTY_NAME = "database.driverClass";
    private static final String DATABASE_CONNECTION_URL_PROPERTY_NAME = "database.connectionUrl";
    private static final String DATABASE_USERNAME_PROPERTY_NAME = "database.username";
    private static final String DATABASE_PASSWORD_PROPERTY_NAME = "database.password";

    static final String HIBERNATE_DIALECT_PROPERTY_NAME = "hibernate.dialect";
    static final String HIBERNATE_SHOW_SQL_PROPERTY_NAME = "hibernate.show_sql";
    static final String HIBERNATE_HBM2DDL_AUTO_PROPERTY_NAME = "hibernate.hbm2ddl.auto";

    public static final String COMPONENT_NAME = "dataSourceProperties";

    @NonNull
    @Getter
    @Value("${" + DATABASE_DRIVER_CLASS_PROPERTY_NAME + "}")
    private String databaseDriverClass;

    @NonNull
    @Getter
    @Value("${" + DATABASE_CONNECTION_URL_PROPERTY_NAME + "}")
    private String databaseConnectionUrl;

    @NonNull
    @Getter
    @Value("${" + DATABASE_USERNAME_PROPERTY_NAME + "}")
    private String databaseUsername;

    @NonNull
    @Getter
    @Value("${" + DATABASE_PASSWORD_PROPERTY_NAME + "}")
    private String databasePassword;
    @NonNull
    @Getter
    @Value("${" + HIBERNATE_DIALECT_PROPERTY_NAME + "}")
    private String hibernateDialect;

    @NonNull
    @Getter
    @Value("#{new Boolean('${" + HIBERNATE_SHOW_SQL_PROPERTY_NAME + "}')}")
    private boolean hibernateShowSql;

    @NonNull
    @Getter
    @Value("${" + HIBERNATE_HBM2DDL_AUTO_PROPERTY_NAME + "}")
    private String hibernateHbm2ddlAuto;
}
