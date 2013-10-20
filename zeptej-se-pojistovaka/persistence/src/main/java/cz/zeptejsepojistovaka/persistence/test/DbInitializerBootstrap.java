package cz.zeptejsepojistovaka.persistence.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

/**
 * Just for Unit test purposes.
 * 
 * @author <a href="mailto:skalicky.tomas@gmail.com">Tomas Skalicky</a>
 */
public class DbInitializerBootstrap {

    private static DbInitializer dbInitializer = null;

    public static void initDatabase() {
        // Double check
        if (dbInitializer == null) {
            synchronized (DbInitializerBootstrap.class) {
                if (dbInitializer == null) {
                    performDbInitialization();
                }
            }
        }
    }

    @SuppressWarnings("resource")
    private static void performDbInitialization() {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(
                "cz.zeptejsepojistovaka.persistence");
        dbInitializer = context.getBean(DbInitializer.class);
        dbInitializer.initDatabase();
    }
}
