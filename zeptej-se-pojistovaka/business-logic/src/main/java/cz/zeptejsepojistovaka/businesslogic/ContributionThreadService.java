package cz.zeptejsepojistovaka.businesslogic;

import java.util.ArrayList;

import javax.inject.Inject;

import lombok.Setter;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cz.zeptejsepojistovaka.commons.util.TimestampUtils;
import cz.zeptejsepojistovaka.domainmodel.Answer;
import cz.zeptejsepojistovaka.domainmodel.ContributionThread;
import cz.zeptejsepojistovaka.domainmodel.Question;
import cz.zeptejsepojistovaka.persistence.repository.ContributionThreadRepository;
import cz.zeptejsepojistovaka.persistence.repository.QuestionRepository;

/**
 * @author <a href="mailto:skalicky.tomas@gmail.com">Tomas Skalicky</a>
 */
@Service
public class ContributionThreadService {

    @Inject
    private ContributionThreadRepository threadRepository;

    @Inject
    private QuestionRepository questionRepository;

    @Inject
    @Setter
    private QuestionService questionService;

    @Transactional
    public ContributionThread save(ContributionThread thread) {
        thread.setLastChangeTime(TimestampUtils.getNow());
        prepareQuestionForSave(thread);

        ContributionThread persistedThread = this.threadRepository.save(thread);
        // To avoid LazyInitializationException later on.
        persistedThread.getQuestion().getAnswers().isEmpty();
        return persistedThread;
    }

    private void prepareQuestionForSave(ContributionThread thread) {
        Question question = thread.getQuestion();
        if (question.isPersistedInStorage()) {
            question = this.questionService.findOneAndOverwriteTextAuthorNameAndEmail(question);
            thread.setQuestion(question);
        }

        question.setThread(thread);
        if (question.getAnswers() == null) {
            question.setAnswers(new ArrayList<Answer>());
        }
        this.questionService.setUpTimestamps(question, thread.getLastChangeTime());
    }

    @Transactional
    public void deleteByQuestionId(Integer questionId) {
        Question question = this.questionRepository.findOne(questionId);
        this.threadRepository.delete(question.getThread());
    }
}
