package cz.zeptejsepojistovaka.domainmodel.builder;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import cz.zeptejsepojistovaka.domainmodel.Answer;
import cz.zeptejsepojistovaka.domainmodel.ContributionAuthor;
import cz.zeptejsepojistovaka.domainmodel.ContributionThread;
import cz.zeptejsepojistovaka.domainmodel.Question;

public class QuestionBuilder {

    private final Question question = new Question();

    private QuestionBuilder() {
    }

    public static QuestionBuilder newQuestion() {
        return new QuestionBuilder();
    }

    public QuestionBuilder withText(String text) {
        this.question.setText(text);
        return this;
    }

    public QuestionBuilder with(ContributionAuthor author) {
        this.question.setAuthor(author);
        return this;
    }

    public QuestionBuilder with(ContributionThread thread) {
        this.question.setThread(thread);
        return this;
    }

    public QuestionBuilder with(List<Answer> answers) {
        this.question.setAnswers(answers);
        return this;
    }

    public QuestionBuilder withCreationTime(Timestamp creationTime) {
        this.question.setCreationTime(creationTime);
        return this;
    }

    public QuestionBuilder withLastUpdateTime(Timestamp lastUpdateTime) {
        this.question.setLastUpdateTime(lastUpdateTime);
        return this;
    }

    public Question build() {
        avoidConstraintViolations();
        return this.question;
    }

    private void avoidConstraintViolations() {
        if (this.question.getAnswers() == null) {
            this.question.setAnswers(new ArrayList<Answer>());
        }
    }
}
