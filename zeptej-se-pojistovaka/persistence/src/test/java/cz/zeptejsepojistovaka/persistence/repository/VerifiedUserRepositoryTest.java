package cz.zeptejsepojistovaka.persistence.repository;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;

import cz.zeptejsepojistovaka.commons.annotation.InTest;
import cz.zeptejsepojistovaka.domainmodel.VerifiedUser;
import cz.zeptejsepojistovaka.persistence.config.DataSourceConfig;
import cz.zeptejsepojistovaka.persistence.test.DbInitializerBootstrap;

/**
 * @author <a href="mailto:skalicky.tomas@gmail.com">Tomas Skalicky</a>
 */
@ActiveProfiles(profiles = InTest.PROFILE_NAME)
@ContextConfiguration(classes = DataSourceConfig.class)
@TransactionConfiguration(defaultRollback = true)
public class VerifiedUserRepositoryTest extends AbstractJUnit4SpringContextTests {

    @Inject
    private VerifiedUserRepository verifiedUserRepository;

    @Before
    public void initDb() {
        DbInitializerBootstrap.initDatabase();
    }

    @Test
    public void testFindByEmailWithNotExistingAddress() throws Exception {
        VerifiedUser foundUser = this.verifiedUserRepository.findByEmail("message.author@abc.com");
        assertEquals(null, foundUser);
    }

    @Test
    public void testFindByEmailWithExistingAddress() throws Exception {
        VerifiedUser foundUser = this.verifiedUserRepository.findByEmail("skalicky.tomas@gmail.com");
        assertEquals("Tomas", foundUser.getName());
    }
}
