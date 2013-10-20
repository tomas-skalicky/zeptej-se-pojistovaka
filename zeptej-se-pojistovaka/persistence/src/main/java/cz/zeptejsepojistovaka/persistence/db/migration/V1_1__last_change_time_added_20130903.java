package cz.zeptejsepojistovaka.persistence.db.migration;

import java.util.logging.Logger;

import org.springframework.jdbc.core.JdbcTemplate;

import com.googlecode.flyway.core.api.migration.spring.SpringJdbcMigration;

import cz.zeptejsepojistovaka.domainmodel.ContributionThread;

/**
 * @author <a href="mailto:skalicky.tomas@gmail.com">Tomas Skalicky</a>
 */
public class V1_1__last_change_time_added_20130903 implements SpringJdbcMigration {

    private final Logger logger = Logger.getLogger(V1_1__last_change_time_added_20130903.class.getName());

    @Override
    public void migrate(JdbcTemplate jdbcTemplate) throws Exception {
        String sqlStatement = "ALTER TABLE " + ContributionThread.TABLE_NAME
                + " ADD COLUMN last_change_time TIMESTAMP NOT NULL;";
        this.logger.info(sqlStatement);
        jdbcTemplate.update(sqlStatement);
    }
}
