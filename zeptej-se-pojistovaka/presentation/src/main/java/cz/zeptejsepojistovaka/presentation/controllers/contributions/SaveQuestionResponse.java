package cz.zeptejsepojistovaka.presentation.controllers.contributions;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import cz.zeptejsepojistovaka.domainmodel.ContributionThread;

/**
 * @author <a href="mailto:skalicky.tomas@gmail.com">Tomas Skalicky</a>
 */
public class SaveQuestionResponse {

    @Getter
    @Setter
    private boolean isSuccessful;

    @Getter
    @Setter
    private ContributionThread thread;

    @Getter
    @Setter
    private List<FieldError> fieldErrors;

    @Getter
    @Setter
    private List<ObjectError> globalErrors;

    @Getter
    @Setter
    private String exceptionMessage;
}
