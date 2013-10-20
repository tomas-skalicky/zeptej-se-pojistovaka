package cz.zeptejsepojistovaka.persistence.repository;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;

import cz.zeptejsepojistovaka.commons.annotation.InTest;
import cz.zeptejsepojistovaka.commons.util.ArrayUtils;
import cz.zeptejsepojistovaka.domainmodel.UnverifiedMessageAuthor;
import cz.zeptejsepojistovaka.persistence.config.DataSourceConfig;
import cz.zeptejsepojistovaka.persistence.test.DbInitializerBootstrap;

/**
 * @author <a href="mailto:skalicky.tomas@gmail.com">Tomas Skalicky</a>
 */
@ContextConfiguration(classes = DataSourceConfig.class)
@ActiveProfiles(profiles = InTest.PROFILE_NAME)
@TransactionConfiguration(defaultRollback = true)
public class UnverifiedMessageAuthorRepositoryTest extends AbstractJUnit4SpringContextTests {

    @Inject
    private UnverifiedMessageAuthorRepository unverifiedMessageAuthorRepository;

    @Before
    public void initDb() {
        DbInitializerBootstrap.initDatabase();
    }

    @Test
    public void testFindByEmail() throws Exception {
        List<UnverifiedMessageAuthor> foundAuthors = this.unverifiedMessageAuthorRepository
                .findByEmail("message.author@abc.com");

        // Checks
        assertEquals(2, foundAuthors.size());
        assertArrayEquals(ArrayUtils.sort("Test Author Name", null),
                ArrayUtils.sort(foundAuthors.get(0).getName(), foundAuthors.get(1).getName()));
    }
}
