package cz.zeptejsepojistovaka.persistence.repository;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cz.zeptejsepojistovaka.domainmodel.Answer;
import cz.zeptejsepojistovaka.domainmodel.Question;

@Repository
public class AnswerRepositoryServiceImpl implements AnswerRepositoryService {

    @Inject
    private AnswerRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<Answer> findByQuestion(Question question) {
        return this.repository.findByQuestion(question);
    }
}
