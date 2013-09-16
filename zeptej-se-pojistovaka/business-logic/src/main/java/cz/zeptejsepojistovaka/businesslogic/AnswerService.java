package cz.zeptejsepojistovaka.businesslogic;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import cz.zeptejsepojistovaka.domainmodel.Answer;
import cz.zeptejsepojistovaka.persistence.repository.AnswerRepository;

/**
 * @author <a href="mailto:skalicky.tomas@gmail.com">Tomas Skalicky</a>
 */
@Service
public class AnswerService extends AbstractContributionService {

    @Inject
    private AnswerRepository answerRepository;

    public Answer save(Answer answer) {
        super.setUpTimestamps(answer);
        return this.answerRepository.save(answer);
    }
}
