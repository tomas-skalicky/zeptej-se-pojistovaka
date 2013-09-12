package cz.zeptejsepojistovaka.presentation.controllers.contributions;

import cz.zeptejsepojistovaka.domainmodel.Answer;

/**
 * @author <a href="mailto:skalicky.tomas@gmail.com">Tomas Skalicky</a>
 */
public class SaveNewAnswerResponseBuilder {

    private final SaveNewAnswerResponse response = new SaveNewAnswerResponse();

    private SaveNewAnswerResponseBuilder() {
    }

    public static SaveNewAnswerResponseBuilder newSaveNewAnswerResponseBuilder() {
        return new SaveNewAnswerResponseBuilder();
    }

    public SaveNewAnswerResponseBuilder succeeded() {
        this.response.setSuccessful(true);
        return this;
    }

    public SaveNewAnswerResponseBuilder failed() {
        this.response.setSuccessful(false);
        return this;
    }

    public SaveNewAnswerResponseBuilder with(Answer answer) {
        this.response.setAnswer(answer);
        return this;
    }

    public SaveNewAnswerResponse build() {
        return this.response;
    }
}
