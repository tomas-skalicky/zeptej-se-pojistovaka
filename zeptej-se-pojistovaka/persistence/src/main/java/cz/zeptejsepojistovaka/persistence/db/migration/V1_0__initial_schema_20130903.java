package cz.zeptejsepojistovaka.persistence.db.migration;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.jdbc.core.JdbcTemplate;

import com.googlecode.flyway.core.api.migration.spring.SpringJdbcMigration;

import cz.zeptejsepojistovaka.domainmodel.AbstractContribution;
import cz.zeptejsepojistovaka.domainmodel.AbstractUser;
import cz.zeptejsepojistovaka.domainmodel.ContributionThread;
import cz.zeptejsepojistovaka.domainmodel.Message;
import cz.zeptejsepojistovaka.domainmodel.Right;
import cz.zeptejsepojistovaka.domainmodel.Tag;
import cz.zeptejsepojistovaka.persistence.db.migration.SqlSnippet.ForeignConstraintActionType;

/**
 * @author <a href="mailto:skalicky.tomas@gmail.com">Tomas Skalicky</a>
 */
public class V1_0__initial_schema_20130903 implements SpringJdbcMigration {

    private final Logger logger = Logger.getLogger(V1_0__initial_schema_20130903.class.getName());

    @Override
    public void migrate(JdbcTemplate jdbcTemplate) throws Exception {
        List<String> sqlStatements = new ArrayList<>();

        removeTables1(sqlStatements);
        createUserTable(sqlStatements);
        createRightTable(sqlStatements);
        createContributionThreadTable(sqlStatements);
        createContributionTable(sqlStatements);
        removeTables2(sqlStatements);
        createTagTable(sqlStatements);
        createTagContributionThreadTable(sqlStatements);
        createTagPatternTable(sqlStatements);
        createMessageTable(sqlStatements);

        logAllStatements(sqlStatements);
        jdbcTemplate.batchUpdate(sqlStatements.toArray(new String[sqlStatements.size()]));
    }

    private void removeTables1(List<String> sqlStatements) {
        sqlStatements.add(SqlSnippet.DROP_TABLE_STATEMENT_PREFIX
                + ContributionThread.TAG_THREAD_JOIN_TABLE_NAME);
        sqlStatements.add(SqlSnippet.DROP_TABLE_STATEMENT_PREFIX + AbstractContribution.TABLE_NAME);
        sqlStatements.add(SqlSnippet.DROP_TABLE_STATEMENT_PREFIX + ContributionThread.TABLE_NAME);
        sqlStatements.add(SqlSnippet.DROP_TABLE_STATEMENT_PREFIX + Message.TABLE_NAME);
        sqlStatements.add(SqlSnippet.DROP_TABLE_STATEMENT_PREFIX + Right.TABLE_NAME);
        sqlStatements.add(SqlSnippet.DROP_TABLE_STATEMENT_PREFIX + AbstractUser.TABLE_NAME);
    }

    /**
     * The users table covers AbstractUser, VerifiedUser, AbstractUnverifiedUser, UnverifiedContributionAuthor
     * and UnverifiedMessageAuthor java classes. </p>
     * <p>
     * <b>IMPORTANT:</b> see <a href=
     * "http://static.springsource.org/spring-security/site/docs/current/reference/appendix-schema.html"
     * >spring security and users and rights</a>
     * </p>
     * <p>
     * <b>DTYPE:</b> Discriminator-Type column created by Hibernate<br />
     * The email is UNIQUE, hence it is necessary to use {@code null} as the default value, not the empty
     * string.
     */
    private void createUserTable(List<String> sqlStatements) {
        // @formatter:off
        sqlStatements.add(SqlSnippet.CREATE_TABLE_STATEMENT_PREFIX + AbstractUser.TABLE_NAME + " ("
                + " DTYPE VARCHAR(31) NOT NULL,"
                + " id INT(11) PRIMARY KEY AUTO_INCREMENT,"
                + " password_hash VARCHAR(100),"
                + " enabled BOOLEAN,"
                + " name VARCHAR(50),"
                + " email VARCHAR(100),"
                + " is_male BOOLEAN,"
                + " CONSTRAINT email_validator CHECK (email LIKE '_%@_%._%'),"
                + " INDEX email_index (email)"
                + ") " + SqlSnippet.CREATE_TABLE_STATEMENT_SUFFIX);
        // @formatter:on
    }

    private void createRightTable(List<String> sqlStatements) {
        // @formatter:off
        sqlStatements.add(SqlSnippet.CREATE_TABLE_STATEMENT_PREFIX + Right.TABLE_NAME + " ("
                + " user_id INT(11) NOT NULL,"
                + " right_type VARCHAR(50) NOT NULL,"
                + " PRIMARY KEY (user_id, right_type),"
                + SqlSnippet.buildForeignConstraint("FK_rights_users", "user_id",
                        AbstractUser.TABLE_NAME, AbstractUser.ID_COLUMN_NAME,
                        ForeignConstraintActionType.CASCADE, ForeignConstraintActionType.CASCADE)
                + ") " + SqlSnippet.CREATE_TABLE_STATEMENT_SUFFIX);
        // @formatter:on
    }

    private void createContributionThreadTable(List<String> sqlStatements) {
        // @formatter:off
        sqlStatements.add(SqlSnippet.CREATE_TABLE_STATEMENT_PREFIX + ContributionThread.TABLE_NAME + " ("
                + " id INT(11) PRIMARY KEY AUTO_INCREMENT,"
                + " thema VARCHAR(255) NOT NULL"
                + ") " + SqlSnippet.CREATE_TABLE_STATEMENT_SUFFIX);
        // @formatter:on
    }

    /**
     * The contributions table covers AbstractContribution, Question and Answer java classes.
     * <p>
     * <b>DTYPE:</b> Discriminator-Type column created by Hibernate<br />
     * DATETIME vs. TIMESTAMP ... see <a
     * href="http://stackoverflow.com/questions/409286/datetime-vs-timestamp">datetime vs. timestamp</a>
     * <p>
     * Do NOT propagate a deletion of an author.
     */
    private void createContributionTable(List<String> sqlStatements) {
        // @formatter:off
        sqlStatements.add(SqlSnippet.CREATE_TABLE_STATEMENT_PREFIX + AbstractContribution.TABLE_NAME + " ("
                + " DTYPE VARCHAR(31) NOT NULL,"
                + " id INT(11) PRIMARY KEY AUTO_INCREMENT,"
                + " author_id INT(11) NOT NULL,"
                + " text TEXT NOT NULL,"
                + " creation_time TIMESTAMP NOT NULL,"
                + " last_update_time TIMESTAMP,"
                + " thread_id INT(11) NOT NULL,"
                + " question_id INT(11),"
                + SqlSnippet.buildForeignConstraint("FK_contributions_users", "author_id",
                        AbstractUser.TABLE_NAME, AbstractUser.ID_COLUMN_NAME,
                        ForeignConstraintActionType.CASCADE, ForeignConstraintActionType.CASCADE) + ","
                + SqlSnippet.buildForeignConstraint("FK_contributions_threads", "thread_id",
                        ContributionThread.TABLE_NAME, ContributionThread.ID_COLUMN_NAME,
                        ForeignConstraintActionType.CASCADE, ForeignConstraintActionType.CASCADE) + ","
                + SqlSnippet.buildForeignConstraint("FK_answers_questions", "question_id",
                        AbstractContribution.TABLE_NAME, AbstractContribution.ID_COLUMN_NAME,
                        ForeignConstraintActionType.CASCADE, ForeignConstraintActionType.CASCADE)
                + ") " + SqlSnippet.CREATE_TABLE_STATEMENT_SUFFIX);
        // @formatter:on
    }

    private void removeTables2(List<String> sqlStatements) {
        sqlStatements.add(SqlSnippet.DROP_TABLE_STATEMENT_PREFIX + Tag.TAG_PATTERN_JOIN_TABLE_NAME);
        sqlStatements.add(SqlSnippet.DROP_TABLE_STATEMENT_PREFIX + Tag.TABLE_NAME);
    }

    private void createTagTable(List<String> sqlStatements) {
        // @formatter:off
        sqlStatements.add(SqlSnippet.CREATE_TABLE_STATEMENT_PREFIX + Tag.TABLE_NAME + " ("
                + " id INT(11) PRIMARY KEY AUTO_INCREMENT,"
                + " name VARCHAR(50) NOT NULL UNIQUE"
                + ") " + SqlSnippet.CREATE_TABLE_STATEMENT_SUFFIX);
        // @formatter:on
    }

    private void createTagContributionThreadTable(List<String> sqlStatements) {
        // @formatter:off
        sqlStatements.add(SqlSnippet.CREATE_TABLE_STATEMENT_PREFIX + ContributionThread.TAG_THREAD_JOIN_TABLE_NAME + " ("
                + " tag_id INT(11) NOT NULL,"
                + " thread_id INT(11) NOT NULL,"
                + " PRIMARY KEY (tag_id, thread_id),"
                + SqlSnippet.buildForeignConstraint("FK_tag_thread_references_tags", "tag_id",
                        Tag.TABLE_NAME, Tag.ID_COLUMN_NAME,
                        ForeignConstraintActionType.CASCADE, ForeignConstraintActionType.CASCADE) + ","
                + SqlSnippet.buildForeignConstraint("FK_tag_thread_references_threads", "thread_id",
                        ContributionThread.TABLE_NAME, ContributionThread.ID_COLUMN_NAME,
                        ForeignConstraintActionType.CASCADE, ForeignConstraintActionType.CASCADE)
                + ") " + SqlSnippet.CREATE_TABLE_STATEMENT_SUFFIX);
        // @formatter:on
    }

    private void createTagPatternTable(List<String> sqlStatements) {
        // @formatter:off
        sqlStatements.add(SqlSnippet.CREATE_TABLE_STATEMENT_PREFIX + Tag.TAG_PATTERN_JOIN_TABLE_NAME + " ("
                + " tag_id INT(11) NOT NULL,"
                + " pattern VARCHAR(100) NOT NULL,"
                + " PRIMARY KEY (tag_id, pattern),"
                + SqlSnippet.buildForeignConstraint("FK_tag_patterns_tags", "tag_id",
                        Tag.TABLE_NAME, Tag.ID_COLUMN_NAME,
                        ForeignConstraintActionType.CASCADE, ForeignConstraintActionType.CASCADE)
                + ") " + SqlSnippet.CREATE_TABLE_STATEMENT_SUFFIX);
        // @formatter:on
    }

    private void createMessageTable(List<String> sqlStatements) {
        // @formatter:off
        sqlStatements.add(SqlSnippet.CREATE_TABLE_STATEMENT_PREFIX + Message.TABLE_NAME + " ("
                + " id INT(11) PRIMARY KEY AUTO_INCREMENT,"
                + " type VARCHAR(30) NOT NULL,"
                + " author_id INT(11) NOT NULL,"
                + " text TEXT,"
                + SqlSnippet.buildForeignConstraint("FK_messages_users", "author_id",
                        AbstractUser.TABLE_NAME, AbstractUser.ID_COLUMN_NAME,
                        ForeignConstraintActionType.CASCADE, ForeignConstraintActionType.CASCADE)
                + ") " + SqlSnippet.CREATE_TABLE_STATEMENT_SUFFIX);
        // @formatter:on
    }

    private void logAllStatements(List<String> sqlStatements) {
        for (String statement : sqlStatements) {
            this.logger.info(statement);
        }
    }
}
