package cz.zeptejsepojistovaka.persistence.repository;

import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;

import cz.zeptejsepojistovaka.persistence.config.DataSourceConfig;

@ContextConfiguration(classes = DataSourceConfig.class)
@TransactionConfiguration(defaultRollback = true)
public class AnswerRepositoryServiceImplTest extends AbstractJUnit4SpringContextTests {

    @Test
    public void testFindByQuestion() throws Exception {
        // throw new RuntimeException("not implemented yet");
    }
}
