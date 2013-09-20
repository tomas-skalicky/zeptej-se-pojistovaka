package cz.zeptejsepojistovaka.domainmodel.builder;

import java.sql.Timestamp;

import cz.zeptejsepojistovaka.domainmodel.Answer;
import cz.zeptejsepojistovaka.domainmodel.ContributionAuthor;
import cz.zeptejsepojistovaka.domainmodel.ContributionThread;
import cz.zeptejsepojistovaka.domainmodel.Question;

public class AnswerBuilder {

    private final Answer answer = new Answer();

    private AnswerBuilder() {
    }

    public static AnswerBuilder newAnswer() {
        return new AnswerBuilder();
    }

    public AnswerBuilder withText(String text) {
        this.answer.setText(text);
        return this;
    }

    public AnswerBuilder with(ContributionAuthor author) {
        this.answer.setAuthor(author);
        return this;
    }

    public AnswerBuilder with(ContributionThread thread) {
        this.answer.setThread(thread);
        return this;
    }

    public AnswerBuilder with(Question question) {
        this.answer.setQuestion(question);
        return this;
    }

    public AnswerBuilder withCreationTime(Timestamp creationTime) {
        this.answer.setCreationTime(creationTime);
        return this;
    }

    public AnswerBuilder withLastUpdateTime(Timestamp lastUpdateTime) {
        this.answer.setLastUpdateTime(lastUpdateTime);
        return this;
    }

    public Answer build() {
        return this.answer;
    }
}
