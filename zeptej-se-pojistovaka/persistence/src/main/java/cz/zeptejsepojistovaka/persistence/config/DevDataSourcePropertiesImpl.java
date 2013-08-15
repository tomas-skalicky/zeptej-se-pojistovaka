package cz.zeptejsepojistovaka.persistence.config;

import java.io.IOException;

import org.springframework.stereotype.Component;

import cz.zeptejsepojistovaka.commons.annotation.Dev;

@Dev
@Component(value = DataSourceProperties.COMPONENT_NAME)
public class DevDataSourcePropertiesImpl extends AbstractDataSourceProperties {

    private static final String PROPERTY_FILE_CLASSPATH = "environment/zeptejsepojistovaka_dev.properties";

    public DevDataSourcePropertiesImpl() throws IOException {
        super(PROPERTY_FILE_CLASSPATH);
    }
}
