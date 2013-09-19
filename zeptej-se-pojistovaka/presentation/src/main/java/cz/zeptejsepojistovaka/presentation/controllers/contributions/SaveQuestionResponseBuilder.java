package cz.zeptejsepojistovaka.presentation.controllers.contributions;

import java.util.List;

import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import cz.zeptejsepojistovaka.domainmodel.Answer;
import cz.zeptejsepojistovaka.domainmodel.ContributionThread;
import cz.zeptejsepojistovaka.domainmodel.Question;

/**
 * @author <a href="mailto:skalicky.tomas@gmail.com">Tomas Skalicky</a>
 */
public class SaveQuestionResponseBuilder {

    private final SaveQuestionResponse response = new SaveQuestionResponse();

    private SaveQuestionResponseBuilder() {
    }

    public static SaveQuestionResponseBuilder newSaveQuestionResponseBuilder() {
        return new SaveQuestionResponseBuilder();
    }

    public SaveQuestionResponseBuilder succeeded() {
        this.response.setSuccessful(true);
        return this;
    }

    public SaveQuestionResponseBuilder failed() {
        this.response.setSuccessful(false);
        return this;
    }

    public SaveQuestionResponseBuilder with(ContributionThread thread) {
        this.response.setThread(thread);
        return this;
    }

    public SaveQuestionResponseBuilder withFieldErrors(List<FieldError> fieldErrors) {
        this.response.setFieldErrors(fieldErrors);
        return this;
    }

    public SaveQuestionResponseBuilder withGlobalErrors(List<ObjectError> globalErrors) {
        this.response.setGlobalErrors(globalErrors);
        return this;
    }

    public SaveQuestionResponseBuilder withExceptionMessage(String exceptionMessage) {
        this.response.setExceptionMessage(exceptionMessage);
        return this;
    }

    public SaveQuestionResponse build() {
        removeThreadLoops(this.response.getThread());
        return this.response;
    }

    private void removeThreadLoops(ContributionThread thread) {
        if (thread != null) {
            Question question = thread.getQuestion();
            if (question != null) {

                question.setThread(null);
                List<Answer> answers = question.getAnswers();
                for (Answer answer : answers) {
                    answer.setThread(null);
                    answer.setQuestion(null);
                }
            }
        }
    }
}
