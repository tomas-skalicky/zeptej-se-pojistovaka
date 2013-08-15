package cz.zeptejsepojistovaka.persistence.config;

import java.io.IOException;

import org.springframework.stereotype.Component;

import cz.zeptejsepojistovaka.commons.annotation.Production;

@Production
@Component(value = DataSourceProperties.COMPONENT_NAME)
public class ProductionDataSourcePropertiesImpl extends AbstractDataSourceProperties {

    private static final String PROPERTY_FILE_CLASSPATH = "environment/zeptejsepojistovaka_production.properties";

    public ProductionDataSourcePropertiesImpl() throws IOException {
        super(PROPERTY_FILE_CLASSPATH);
    }
}
