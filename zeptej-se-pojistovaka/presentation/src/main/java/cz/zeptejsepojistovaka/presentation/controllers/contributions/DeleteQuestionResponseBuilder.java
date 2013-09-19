package cz.zeptejsepojistovaka.presentation.controllers.contributions;

/**
 * @author <a href="mailto:skalicky.tomas@gmail.com">Tomas Skalicky</a>
 */
public class DeleteQuestionResponseBuilder {

    private final DeleteQuestionResponse response = new DeleteQuestionResponse();

    private DeleteQuestionResponseBuilder() {
    }

    public static DeleteQuestionResponseBuilder newDeleteQuestionResponseBuilder() {
        return new DeleteQuestionResponseBuilder();
    }

    public DeleteQuestionResponseBuilder succeeded() {
        this.response.setSuccessful(true);
        return this;
    }

    public DeleteQuestionResponseBuilder failed() {
        this.response.setSuccessful(false);
        return this;
    }

    public DeleteQuestionResponseBuilder withExceptionMessage(String exceptionMessage) {
        this.response.setExceptionMessage(exceptionMessage);
        return this;
    }

    public DeleteQuestionResponse build() {
        return this.response;
    }
}
