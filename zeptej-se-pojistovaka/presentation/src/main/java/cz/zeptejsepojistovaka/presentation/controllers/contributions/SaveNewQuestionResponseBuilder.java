package cz.zeptejsepojistovaka.presentation.controllers.contributions;

import java.util.List;

import cz.zeptejsepojistovaka.domainmodel.Answer;
import cz.zeptejsepojistovaka.domainmodel.ContributionThread;

/**
 * @author <a href="mailto:skalicky.tomas@gmail.com">Tomas Skalicky</a>
 */
public class SaveNewQuestionResponseBuilder {

    private final SaveNewQuestionResponse response = new SaveNewQuestionResponse();

    private SaveNewQuestionResponseBuilder() {
    }

    public static SaveNewQuestionResponseBuilder newSaveNewQuestionResponseBuilder() {
        return new SaveNewQuestionResponseBuilder();
    }

    public SaveNewQuestionResponseBuilder succeeded() {
        this.response.setSuccessful(true);
        return this;
    }

    public SaveNewQuestionResponseBuilder failed() {
        this.response.setSuccessful(false);
        return this;
    }

    public SaveNewQuestionResponseBuilder with(ContributionThread thread) {
        this.response.setThread(thread);
        return this;
    }

    public SaveNewQuestionResponse build() {
        removeThreadLoops(this.response.getThread());
        return this.response;
    }

    private void removeThreadLoops(ContributionThread thread) {
        thread.getQuestion().setThread(null);
        List<Answer> answers = thread.getQuestion().getAnswers();
        for (Answer answer : answers) {
            answer.setThread(null);
            answer.setQuestion(null);
        }
    }
}
