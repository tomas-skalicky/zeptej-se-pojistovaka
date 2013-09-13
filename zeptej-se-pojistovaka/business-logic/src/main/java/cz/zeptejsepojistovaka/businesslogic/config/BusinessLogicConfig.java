package cz.zeptejsepojistovaka.businesslogic.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import cz.zeptejsepojistovaka.persistence.config.DataSourceConfig;

/**
 * @author <a href="mailto:skalicky.tomas@gmail.com">Tomas Skalicky</a>
 */
@Configuration
@Import({ DataSourceConfig.class })
@ComponentScan("cz.zeptejsepojistovaka.businesslogic")
public class BusinessLogicConfig {
}
