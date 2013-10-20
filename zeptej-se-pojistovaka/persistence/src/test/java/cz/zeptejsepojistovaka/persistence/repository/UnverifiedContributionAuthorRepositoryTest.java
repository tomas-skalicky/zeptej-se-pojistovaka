package cz.zeptejsepojistovaka.persistence.repository;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;

import cz.zeptejsepojistovaka.domainmodel.UnverifiedContributionAuthor;
import cz.zeptejsepojistovaka.persistence.config.DataSourceConfig;
import cz.zeptejsepojistovaka.persistence.test.DbInitializerBootstrap;

/**
 * @author <a href="mailto:skalicky.tomas@gmail.com">Tomas Skalicky</a>
 */
@ContextConfiguration(classes = DataSourceConfig.class)
@TransactionConfiguration(defaultRollback = true)
public class UnverifiedContributionAuthorRepositoryTest extends AbstractJUnit4SpringContextTests {

    @Inject
    private UnverifiedContributionAuthorRepository unverifiedContributionAuthorRepository;

    @Before
    public void initDb() {
        DbInitializerBootstrap.initDatabase();
    }

    @Test
    public void testFindByEmail() throws Exception {
        List<UnverifiedContributionAuthor> foundAuthors = this.unverifiedContributionAuthorRepository
                .findByEmail("contribution.author@abc.com");

        // Checks
        assertEquals(1, foundAuthors.size());
        assertEquals("Test Author Name", foundAuthors.get(0).getName());
    }
}
