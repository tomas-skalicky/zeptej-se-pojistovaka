package cz.zeptejsepojistovaka.presentation.controllers.contributions;

import java.util.List;

import cz.zeptejsepojistovaka.domainmodel.Answer;
import cz.zeptejsepojistovaka.domainmodel.ContributionThread;

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
