package cz.zeptejsepojistovaka.persistence.repository;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.stereotype.Service;

@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
class DbInitializerBootstrap {

    private static DbInitializer dbInitializer;

    static {
        initDatabase();
    }

    @SuppressWarnings("resource")
    private static void initDatabase() {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(
                "cz.zeptejsepojistovaka.persistence");
        dbInitializer = context.getBean(DbInitializer.class);
        dbInitializer.initDatabase();
    }
}
