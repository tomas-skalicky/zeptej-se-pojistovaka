package cz.zeptejsepojistovaka.domainmodel.builder;

import cz.zeptejsepojistovaka.domainmodel.Answer;
import cz.zeptejsepojistovaka.domainmodel.ContributionAuthor;

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

    public Answer build() {
        return this.answer;
    }
}
