package cz.zeptejsepojistovaka.persistence.config;

public interface DataSourceProperties {

    public static final String DATABASE_DRIVER_PROPERTY_NAME = "db.driver";
    public static final String DATABASE_URL_PROPERTY_NAME = "db.url";
    public static final String DATABASE_USERNAME_PROPERTY_NAME = "db.username";
    public static final String DATABASE_PASSWORD_PROPERTY_NAME = "db.password";

    public static final String HIBERNATE_DIALECT_PROPERTY_NAME = "hibernate.dialect";
    public static final String HIBERNATE_SHOW_SQL_PROPERTY_NAME = "hibernate.show_sql";

    public static final String COMPONENT_NAME = "dataSourceProperties";

    String getDbDriver();

    String getDbUrl();

    String getDbUsername();

    String getDbPassword();

    String getHibernateDialect();

    boolean isHibernateShowSql();
}
