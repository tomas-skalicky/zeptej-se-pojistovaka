package cz.zeptejsepojistovaka.presentation.controllers.contributions;

import lombok.Getter;
import lombok.Setter;

/**
 * @author <a href="mailto:skalicky.tomas@gmail.com">Tomas Skalicky</a>
 */
public class DeleteQuestionResponse {

    @Getter
    @Setter
    private boolean isSuccessful;

    @Getter
    @Setter
    private String exceptionMessage;
}
