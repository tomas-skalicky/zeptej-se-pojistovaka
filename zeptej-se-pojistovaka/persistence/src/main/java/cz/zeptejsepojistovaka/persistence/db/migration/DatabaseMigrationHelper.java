package cz.zeptejsepojistovaka.persistence.db.migration;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

import net.sf.extcos.ComponentQuery;
import net.sf.extcos.ComponentScanner;

import org.springframework.jdbc.core.JdbcTemplate;

import com.googlecode.flyway.core.api.migration.spring.SpringJdbcMigration;

/**
 * @author <a href="mailto:skalicky.tomas@gmail.com">Tomas Skalicky</a>
 */
public final class DatabaseMigrationHelper {

    private static final String DATABASE_MIGRATION_PACKAGE_NAME = "cz.zeptejsepojistovaka.persistence.db.migration";
    private static final String MIGRATE_METHOD_NAME = "migrate";

    private DatabaseMigrationHelper() {
    }

    public static void processAllMigrations(JdbcTemplate jdbcTemplate) throws Exception {
        Set<Class<? extends SpringJdbcMigration>> migrationClasses = getAllMigrationClasses();
        for (Class<? extends SpringJdbcMigration> migrationClass : migrationClasses) {
            Method migrateMethod = migrationClass.getMethod(MIGRATE_METHOD_NAME, JdbcTemplate.class);
            migrateMethod.invoke(migrationClass.newInstance(), jdbcTemplate);
        }
    }

    public static Set<Class<? extends SpringJdbcMigration>> getAllMigrationClasses() {
        final Set<Class<? extends SpringJdbcMigration>> migrationClasses = new HashSet<>();

        ComponentScanner scanner = new ComponentScanner();
        scanner.getClasses(new ComponentQuery() {
            @Override
            protected void query() {
                select().from(DATABASE_MIGRATION_PACKAGE_NAME)
                        .andStore(thoseImplementing(SpringJdbcMigration.class).into(migrationClasses))
                        .returning(none());
            }
        });

        return migrationClasses;
    }
}
