package cz.zeptejsepojistovaka.businesslogic;

import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import java.util.Date;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import cz.zeptejsepojistovaka.businesslogic.config.BusinessLogicConfig;
import cz.zeptejsepojistovaka.domainmodel.ContributionThread;
import cz.zeptejsepojistovaka.domainmodel.Question;
import cz.zeptejsepojistovaka.persistence.repository.ContributionThreadRepository;

/**
 * @author <a href="mailto:skalicky.tomas@gmail.com">Tomas Skalicky</a>
 */
@ContextConfiguration(classes = BusinessLogicConfig.class)
public class ContributionThreadServiceTest extends AbstractJUnit4SpringContextTests {

    @Mock
    private ContributionThreadRepository threadRepository;

    @Inject
    private QuestionService questionService;

    @InjectMocks
    private final ContributionThreadService threadService = new ContributionThreadService();

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
        this.threadService.setQuestionService(this.questionService);
    }

    @Test
    public void testSave() throws Exception {
        ContributionThread thread = new ContributionThread();
        thread.setQuestion(new Question());
        long now = (new Date()).getTime();

        when(this.threadRepository.save(any(ContributionThread.class))).thenReturn(thread);

        ContributionThread savedThread = this.threadService.save(thread);

        long threadLastChangeTimestamp = savedThread.getLastChangeTime().getTime();
        assertTrue(threadLastChangeTimestamp >= now);
        Question question = savedThread.getQuestion();
        assertEquals(threadLastChangeTimestamp, question.getCreationTimestamp().getTime());
        assertEquals(threadLastChangeTimestamp, question.getLastUpdateTimestamp().getTime());
    }
}
