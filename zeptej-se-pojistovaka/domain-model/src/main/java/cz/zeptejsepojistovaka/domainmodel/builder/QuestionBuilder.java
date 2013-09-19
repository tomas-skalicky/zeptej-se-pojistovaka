package cz.zeptejsepojistovaka.domainmodel.builder;

import cz.zeptejsepojistovaka.domainmodel.ContributionAuthor;
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

    public Question build() {
        return this.question;
    }
}
