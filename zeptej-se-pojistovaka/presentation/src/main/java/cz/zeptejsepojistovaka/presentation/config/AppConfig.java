package cz.zeptejsepojistovaka.presentation.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import cz.zeptejsepojistovaka.persistence.config.DataSourceConfig;

/**
 * @author <a href="mailto:skalicky.tomas@gmail.com">Tomas Skalicky</a>
 */
@Configuration
@Import({ DataSourceConfig.class, CacheConfig.class })
@ComponentScan(basePackages = "cz.zeptejsepojistovaka", excludeFilters = @Filter(value = Controller.class, type = FilterType.ANNOTATION))
@EnableWebMvc
public class AppConfig {
}
