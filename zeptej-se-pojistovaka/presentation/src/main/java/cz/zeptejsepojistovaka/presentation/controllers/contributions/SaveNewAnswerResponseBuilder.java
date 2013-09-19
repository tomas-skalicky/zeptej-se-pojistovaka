package cz.zeptejsepojistovaka.presentation.controllers.contributions;

import java.util.List;

import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

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

    public SaveNewAnswerResponseBuilder withFieldErrors(List<FieldError> fieldErrors) {
        this.response.setFieldErrors(fieldErrors);
        return this;
    }

    public SaveNewAnswerResponseBuilder withGlobalErrors(List<ObjectError> globalErrors) {
        this.response.setGlobalErrors(globalErrors);
        return this;
    }

    public SaveNewAnswerResponseBuilder withExceptionMessage(String exceptionMessage) {
        this.response.setExceptionMessage(exceptionMessage);
        return this;
    }

    public SaveNewAnswerResponse build() {
        return this.response;
    }
}
