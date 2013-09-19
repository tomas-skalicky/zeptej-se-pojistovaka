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

import cz.zeptejsepojistovaka.domainmodel.ContributionAuthor;
import cz.zeptejsepojistovaka.domainmodel.Question;
import cz.zeptejsepojistovaka.domainmodel.builder.QuestionBuilder;
import cz.zeptejsepojistovaka.domainmodel.builder.UnverifiedContributionAuthorBuilder;
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

        long actualCreationTime = savedQuestion.getCreationTime().getTime();
        assertTrue(actualCreationTime >= now);
        assertEquals(actualCreationTime, savedQuestion.getLastUpdateTime().getTime());
    }

    @Test
    public void testFindOneAndOverwriteTextAuthorNameAndEmail() throws Exception {
        Integer authorId = 123;
        String newQuestionText = "new text";
        String newName = "New Tomas";
        String newEmail = "new.email@gmail.com";

        ContributionAuthor inputAuthor = UnverifiedContributionAuthorBuilder
                .newUnverifiedContributionAuthor().withName(newName).withEmail(newEmail).build();
        Question inputQuestion = QuestionBuilder.newQuestion().withText(newQuestionText).with(inputAuthor)
                .build();

        ContributionAuthor retrievedAuthor = UnverifiedContributionAuthorBuilder
                .newUnverifiedContributionAuthor().withId(authorId).withName("Tomas")
                .withEmail("email@gmail.com").build();
        Question retrievedQuestion = QuestionBuilder.newQuestion().with(retrievedAuthor).build();

        when(this.questionRepository.findOne(any(Integer.class))).thenReturn(retrievedQuestion);

        Question returnedQuestion = this.questionService
                .findOneAndOverwriteTextAuthorNameAndEmail(inputQuestion);

        // Checks
        assertEquals(newQuestionText, returnedQuestion.getText());
        ContributionAuthor actualAuthor = returnedQuestion.getAuthor();
        assertEquals(authorId, actualAuthor.getId());
        assertEquals(newName, actualAuthor.getName());
        assertEquals(newEmail, actualAuthor.getEmail());
    }
}
