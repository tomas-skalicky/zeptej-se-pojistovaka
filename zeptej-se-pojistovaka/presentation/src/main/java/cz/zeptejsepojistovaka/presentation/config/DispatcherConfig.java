package cz.zeptejsepojistovaka.presentation.config;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

import cz.zeptejsepojistovaka.commons.CharacterEncoding;
import cz.zeptejsepojistovaka.commons.TimeConstants;

/**
 * @author <a href="mailto:skalicky.tomas@gmail.com">Tomas Skalicky</a>
 */
@Configuration
@ComponentScan(basePackages = "cz.zeptejsepojistovaka", useDefaultFilters = false, includeFilters = @Filter(value = Controller.class, type = FilterType.ANNOTATION))
@EnableWebMvc
public class DispatcherConfig extends WebMvcConfigurerAdapter {

    private static final String SLASH = "/";
    private static final String JSP_HOME = "/WEB-INF/jsp";
    private static final String JSP_EXTENSION = ".jsp";

    @Bean
    public ReloadableResourceBundleMessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setCacheSeconds(TimeConstants.SECONDS_PER_HOUR);
        messageSource.setDefaultEncoding(CharacterEncoding.getDefault().getName());
        messageSource.setBasename("classpath:locale/messages");
        return messageSource;
    }

    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        return new LocaleChangeInterceptor();
    }

    @Bean
    public CookieLocaleResolver localeResolver() {
        CookieLocaleResolver localeResolver = new CookieLocaleResolver();
        localeResolver.setDefaultLocale(Locale.forLanguageTag("cs_CZ"));
        return localeResolver;
    }

    @Bean
    public TilesViewResolver tilesViewResolver() {
        TilesViewResolver viewResolver = new TilesViewResolver();
        viewResolver.setOrder(0);
        viewResolver.setViewClass(TilesView.class);
        return viewResolver;
    }

    @Bean
    public TilesConfigurer tilesConfigurer() {
        TilesConfigurer tilesConfigurer = new TilesConfigurer();
        tilesConfigurer
                .setDefinitions(new String[] { "classpath:META-INF/zeptej-se-pojistovaka/tiles-defs.xml" });
        return tilesConfigurer;
    }

    @Bean
    public InternalResourceViewResolver jstlViewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setOrder(1);
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix(JSP_HOME + SLASH);
        viewResolver.setSuffix(JSP_EXTENSION);
        return viewResolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/bootstrap/**").addResourceLocations("/bootstrap/");
        registry.addResourceHandler("/images/**").addResourceLocations("/images/");
        registry.addResourceHandler("/jquery/**").addResourceLocations("/jquery/");
        registry.addResourceHandler("/lib/**").addResourceLocations("/lib/");
    }
}
