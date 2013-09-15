package cz.zeptejsepojistovaka.businesslogic;

import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import cz.zeptejsepojistovaka.businesslogic.config.BusinessLogicConfig;
import cz.zeptejsepojistovaka.domainmodel.Answer;
import cz.zeptejsepojistovaka.persistence.repository.AnswerRepository;

/**
 * @author <a href="mailto:skalicky.tomas@gmail.com">Tomas Skalicky</a>
 */
@ContextConfiguration(classes = BusinessLogicConfig.class)
public class AnswerServiceTest extends AbstractJUnit4SpringContextTests {

    @Mock
    private AnswerRepository answerRepository;

    @InjectMocks
    private final AnswerService answerService = new AnswerService();

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSave() throws Exception {
        Answer answer = new Answer();
        long now = (new Date()).getTime();

        when(this.answerRepository.save(any(Answer.class))).thenReturn(answer);

        Answer savedAnswer = this.answerService.save(answer);

        long actualCreationTimestamp = savedAnswer.getCreationTimestamp().getTime();
        assertTrue(actualCreationTimestamp > now);
        assertEquals(actualCreationTimestamp, savedAnswer.getLastUpdateTimestamp().getTime());
    }
}
