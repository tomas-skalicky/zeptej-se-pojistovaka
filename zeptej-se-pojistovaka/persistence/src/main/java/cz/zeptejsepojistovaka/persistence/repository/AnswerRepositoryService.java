package cz.zeptejsepojistovaka.persistence.repository;

import java.util.List;

import cz.zeptejsepojistovaka.domainmodel.Answer;
import cz.zeptejsepojistovaka.domainmodel.Question;

public interface AnswerRepositoryService {

    /**
     * Retrieves all {@link Answer Answers} which are associated with the given {@link Question}.
     */
    List<Answer> findByQuestion(Question question);
}
