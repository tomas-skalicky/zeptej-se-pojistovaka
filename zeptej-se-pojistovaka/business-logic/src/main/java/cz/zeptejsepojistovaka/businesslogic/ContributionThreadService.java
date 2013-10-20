package cz.zeptejsepojistovaka.businesslogic;

import java.util.ArrayList;

import javax.inject.Inject;

import lombok.Setter;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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

    private static final int FIND_ALL_FIRST_PAGE_INDEX = 0;
    private static final int FIND_ALL_PAGE_SIZE = 10;
    private static final Sort FIND_ALL_SORT = new Sort(new Sort.Order(Sort.Direction.DESC,
            ContributionThread.LAST_CHANGE_TIME_PROPERTY_NAME));

    @Inject
    private ContributionThreadRepository threadRepository;

    @Inject
    private QuestionRepository questionRepository;

    @Inject
    @Setter
    private QuestionService questionService;

    @Transactional
    public ContributionThread save(ContributionThread thread) {
        thread.setLastChangeTime(TimestampUtils.getNowFlooredToSec());
        prepareQuestionForSave(thread);

        ContributionThread persistedThread = this.threadRepository.save(thread);
        // To avoid LazyInitializationException later on.
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

    /**
     * Retrieves the first 10 {@link ContributionThread ContributionThreads} (according to the their last
     * change time) from the databases sorted according to the <i>last change time</i> in the descending
     * order.
     */
    @Transactional
    public Page<ContributionThread> findLatest() {
        return this.threadRepository.findAll(new PageRequest(FIND_ALL_FIRST_PAGE_INDEX, FIND_ALL_PAGE_SIZE,
                FIND_ALL_SORT));
    }
}
