package cz.zeptejsepojistovaka.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cz.zeptejsepojistovaka.domainmodel.Answer;
import cz.zeptejsepojistovaka.domainmodel.Question;

public interface AnswerRepository extends JpaRepository<Answer, Integer> {

    /**
     * Retrieves all {@link Answer Answers} which are associated with the given {@link Question}.
     */
    List<Answer> findByQuestion(Question question);
}
