package cz.zeptejsepojistovaka.businesslogic;

import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;

import cz.zeptejsepojistovaka.businesslogic.config.BusinessLogicConfig;
import cz.zeptejsepojistovaka.commons.util.TimestampUtils;
import cz.zeptejsepojistovaka.domainmodel.ContributionAuthor;
import cz.zeptejsepojistovaka.domainmodel.ContributionThread;
import cz.zeptejsepojistovaka.domainmodel.Question;
import cz.zeptejsepojistovaka.domainmodel.builder.ContributionThreadBuilder;
import cz.zeptejsepojistovaka.domainmodel.builder.QuestionBuilder;
import cz.zeptejsepojistovaka.persistence.config.DataSourceConfig;
import cz.zeptejsepojistovaka.persistence.repository.ContributionThreadRepository;
import cz.zeptejsepojistovaka.persistence.repository.UnverifiedContributionAuthorRepository;
import cz.zeptejsepojistovaka.persistence.test.DbInitializerBootstrap;

/**
 * @author <a href="mailto:skalicky.tomas@gmail.com">Tomas Skalicky</a>
 */
@ContextConfiguration(classes = { BusinessLogicConfig.class, DataSourceConfig.class })
@TransactionConfiguration(defaultRollback = true)
public class ContributionThreadServiceTest extends AbstractJUnit4SpringContextTests {

    @Mock
    private ContributionThreadRepository threadRepositoryMock;

    @InjectMocks
    private final ContributionThreadService threadServiceMock = new ContributionThreadService();

    @Inject
    private QuestionService questionService;

    @Inject
    private ContributionThreadRepository threadRepository;

    @Inject
    private ContributionThreadService threadService;

    @Inject
    private UnverifiedContributionAuthorRepository unverifiedContributionAuthorRepository;

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
        this.threadServiceMock.setQuestionService(this.questionService);
    }

    @Before
    public void initDb() {
        DbInitializerBootstrap.initDatabase();
    }

    @Test
    public void testSaveWithoutDbAccess() throws Exception {
        ContributionThread thread = new ContributionThread();
        thread.setQuestion(new Question());
        long now = TimestampUtils.getNowFlooredToSec().getTime();

        when(this.threadRepositoryMock.save(any(ContributionThread.class))).thenReturn(thread);

        ContributionThread savedThread = this.threadServiceMock.save(thread);

        long threadLastChangeTime = savedThread.getLastChangeTime().getTime();
        assertTrue(threadLastChangeTime >= now);
        Question question = savedThread.getQuestion();
        assertEquals(threadLastChangeTime, question.getCreationTime().getTime());
        assertEquals(threadLastChangeTime, question.getLastUpdateTime().getTime());
    }

    @Test
    public void testSaveWithDbAccess() throws Exception {
        ContributionThread thread = ContributionThreadBuilder.newThread().withThema("thread name XXX")
                .build();
        ContributionAuthor questionAuthor = this.unverifiedContributionAuthorRepository.findByEmail(
                "contribution.author@abc.com").get(0);
        thread.setQuestion(QuestionBuilder.newQuestion().withText("question text YYY").with(thread)
                .with(questionAuthor).build());

        ContributionThread savedThread = this.threadService.save(thread);
        ContributionThread foundThread = this.threadRepository.findOne(savedThread.getId());
        System.out.println(savedThread);
        System.out.println(foundThread);

        assertEquals(savedThread, foundThread);
    }

    @Test
    public void testFindLatestWithoutChanges() throws Exception {
        Page<ContributionThread> retrievedThreads = this.threadService.findLatest();

        // Checks
        assertEquals(0, retrievedThreads.getNumber());
        assertEquals(10, retrievedThreads.getNumberOfElements());
        assertEquals(3, retrievedThreads.getTotalPages());

        List<String> expectedTopics = new ArrayList<String>();
        for (int expectedThreadNo = 21; expectedThreadNo > 11; --expectedThreadNo) {
            expectedTopics.add("thema No. " + expectedThreadNo);
        }
        assertArrayEquals(expectedTopics.toArray(), extractThreadTopics(retrievedThreads.getContent()));
    }

    /**
     * Extracts {@link ContributionThread}'s topics from the given threads.
     */
    private String[] extractThreadTopics(List<ContributionThread> threads) {
        List<String> topics = new ArrayList<String>();
        for (ContributionThread thread : threads) {
            topics.add(thread.getThema());
        }
        return topics.toArray(new String[topics.size()]);
    }
}
