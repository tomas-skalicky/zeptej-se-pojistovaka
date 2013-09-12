package cz.zeptejsepojistovaka.presentation.controllers.contributions;

import lombok.Getter;
import lombok.Setter;
import cz.zeptejsepojistovaka.domainmodel.Answer;

/**
 * @author <a href="mailto:skalicky.tomas@gmail.com">Tomas Skalicky</a>
 */
public class SaveNewAnswerResponse {

    @Getter
    @Setter
    private boolean isSuccessful;

    @Getter
    @Setter
    private Answer answer;
}
