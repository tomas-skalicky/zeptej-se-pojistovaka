package cz.zeptejsepojistovaka.presentation.config;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.util.IntrospectorCleanupListener;
import org.springframework.web.util.Log4jConfigListener;

import cz.zeptejsepojistovaka.commons.CharacterEncoding;

/**
 * @author <a href="mailto:skalicky.tomas@gmail.com">Tomas Skalicky</a>
 */
public class WebAppInitializer implements WebApplicationInitializer {

    private static final String DISPATCHER_SERVLET_NAME = "dispatcher";

    @Override
    public void onStartup(ServletContext container) throws ServletException {
        addListeners(container);
        initDispatcherContext(container);
        addFilters(container);
    }

    private void addListeners(ServletContext container) {
        addIntrospectorCleanupListener(container);
        addLog4jConfigListener(container);
        initRootContext(container);
    }

    private void addIntrospectorCleanupListener(ServletContext container) {
        // Prevents from memory leaks.
        // see
        // http://static.springsource.org/spring/docs/3.2.x/javadoc-api/org/springframework/web/util/IntrospectorCleanupListener.html
        container.addListener(IntrospectorCleanupListener.class);
    }

    private void addLog4jConfigListener(ServletContext container) {
        container.addListener(Log4jConfigListener.class);
    }

    private void initRootContext(ServletContext container) {
        // Creates the 'root' Spring application context
        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(AppConfig.class, AppSecurityConfig.class);

        // Manages the lifecycle of the root application context
        container.addListener(new ContextLoaderListener(rootContext));
    }

    private void initDispatcherContext(ServletContext container) {
        // Creates the dispatcher servlet's Spring application context
        AnnotationConfigWebApplicationContext dispatcherContext = new AnnotationConfigWebApplicationContext();
        dispatcherContext.register(DispatcherConfig.class);

        // Registers and map the dispatcher servlet
        ServletRegistration.Dynamic dispatcher = container.addServlet(DISPATCHER_SERVLET_NAME,
                new DispatcherServlet(dispatcherContext));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
    }

    private void addFilters(ServletContext container) {
        addHttpMethodFilter(container);
        addSpringSecurityFilters(container);
        addEncodingFilter(container);
    }

    private void addHttpMethodFilter(ServletContext container) {
        FilterRegistration filterRegi = container.addFilter("HttpMethodFilter", HiddenHttpMethodFilter.class);
        filterRegi.addMappingForUrlPatterns(null, false, "/*");
    }

    private void addSpringSecurityFilters(ServletContext container) {
        // TODO : tsskal
        // container.addFilter("springSecurityFilterChain",
        // new DelegatingFilterProxy("springSecurityFilterChain")).addMappingForUrlPatterns(null, false,
        // "/*");
    }

    private void addEncodingFilter(ServletContext container) {
        FilterRegistration filterRegi = container.addFilter("CharacterEncodingFilter",
                CharacterEncodingFilter.class);
        filterRegi.setInitParameter("encoding", CharacterEncoding.getDefault().getName());
        filterRegi.setInitParameter("forceEncoding", "true");
        filterRegi.addMappingForUrlPatterns(null, false, "/*");
    }
}
