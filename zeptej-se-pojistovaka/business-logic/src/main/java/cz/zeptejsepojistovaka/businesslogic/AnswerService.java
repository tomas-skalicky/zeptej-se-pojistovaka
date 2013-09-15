package cz.zeptejsepojistovaka.businesslogic;

import java.sql.Timestamp;
import java.util.Date;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import cz.zeptejsepojistovaka.domainmodel.Answer;
import cz.zeptejsepojistovaka.persistence.repository.AnswerRepository;

/**
 * @author <a href="mailto:skalicky.tomas@gmail.com">Tomas Skalicky</a>
 */
@Service
public class AnswerService {

    @Inject
    private AnswerRepository answerRepository;

    public Answer save(Answer answer) {
        answer.setCreationTimestamp(new Timestamp((new Date()).getTime()));
        answer.setLastUpdateTimestamp(answer.getCreationTimestamp());
        return this.answerRepository.save(answer);
    }
}
