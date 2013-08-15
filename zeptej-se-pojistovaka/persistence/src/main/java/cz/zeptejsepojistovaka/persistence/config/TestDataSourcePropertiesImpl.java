package cz.zeptejsepojistovaka.persistence.config;

import java.io.IOException;

import org.springframework.stereotype.Component;

import cz.zeptejsepojistovaka.commons.annotation.Test;

@Test
@Component(value = DataSourceProperties.COMPONENT_NAME)
public class TestDataSourcePropertiesImpl extends AbstractDataSourceProperties {

    private static final String PROPERTY_FILE_CLASSPATH = "environment/zeptejsepojistovaka_test.properties";

    public TestDataSourcePropertiesImpl() throws IOException {
        super(PROPERTY_FILE_CLASSPATH);
    }
}
