package cz.zeptejsepojistovaka.presentation.controllers.contributions;

import lombok.Getter;
import lombok.Setter;
import cz.zeptejsepojistovaka.domainmodel.ContributionThread;

/**
 * @author <a href="mailto:skalicky.tomas@gmail.com">Tomas Skalicky</a>
 */
public class SaveNewQuestionResponse {

    @Getter
    @Setter
    private boolean isSuccessful;

    @Getter
    @Setter
    private ContributionThread thread;
}
