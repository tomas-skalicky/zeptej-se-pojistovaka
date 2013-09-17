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

import cz.zeptejsepojistovaka.domainmodel.Question;
import cz.zeptejsepojistovaka.persistence.repository.QuestionRepository;

/**
 * @author <a href="mailto:skalicky.tomas@gmail.com">Tomas Skalicky</a>
 */
public class QuestionServiceTest {

    @Mock
    private QuestionRepository questionRepository;

    @InjectMocks
    private final QuestionService questionService = new QuestionService();

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSave() throws Exception {
        Question question = new Question();
        long now = (new Date()).getTime();

        when(this.questionRepository.save(any(Question.class))).thenReturn(question);

        Question savedQuestion = this.questionService.save(question);

        long actualCreationTimestamp = savedQuestion.getCreationTimestamp().getTime();
        assertTrue(actualCreationTimestamp >= now);
        assertEquals(actualCreationTimestamp, savedQuestion.getLastUpdateTimestamp().getTime());
    }
}
