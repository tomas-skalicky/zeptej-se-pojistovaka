package cz.zeptejsepojistovaka.businesslogic;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cz.zeptejsepojistovaka.domainmodel.ContributionAuthor;
import cz.zeptejsepojistovaka.domainmodel.Question;
import cz.zeptejsepojistovaka.persistence.repository.QuestionRepository;

/**
 * @author <a href="mailto:skalicky.tomas@gmail.com">Tomas Skalicky</a>
 */
@Service
public class QuestionService extends AbstractContributionService {

    @Inject
    private QuestionRepository questionRepository;

    @Transactional
    public Question save(Question question) {
        super.setUpTimestamps(question);
        return this.questionRepository.save(question);
    }

    @Transactional
    public Question findOneAndOverwriteTextAuthorNameAndEmail(Question question) {
        Question retrievedQuestion = this.questionRepository.findOne(question.getId());
        retrievedQuestion.setText(question.getText());

        ContributionAuthor retrievedAuthor = retrievedQuestion.getAuthor();
        ContributionAuthor inputAuthor = question.getAuthor();
        retrievedAuthor.setName(inputAuthor.getName());
        retrievedAuthor.setEmail(inputAuthor.getEmail());
        return retrievedQuestion;
    }
}
