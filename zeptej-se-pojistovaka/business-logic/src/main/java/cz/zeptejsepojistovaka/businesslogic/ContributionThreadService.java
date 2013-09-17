package cz.zeptejsepojistovaka.businesslogic;

import java.sql.Timestamp;
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

/**
 * @author <a href="mailto:skalicky.tomas@gmail.com">Tomas Skalicky</a>
 */
@Service
public class ContributionThreadService {

    @Inject
    private ContributionThreadRepository threadRepository;

    @Inject
    @Setter
    private QuestionService questionService;

    @Transactional
    public ContributionThread save(ContributionThread thread) {
        Timestamp now = TimestampUtils.getNow();
        thread.setLastChangeTime(now);

        Question question = thread.getQuestion();
        question.setThread(thread);
        question.setAnswers(new ArrayList<Answer>());
        this.questionService.setUpTimestamps(question, now);

        return this.threadRepository.save(thread);
    }
}
