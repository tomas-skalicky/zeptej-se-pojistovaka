package cz.zeptejsepojistovaka.domainmodel;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * @author <a href="mailto:skalicky.tomas@gmail.com">Tomas Skalicky</a>
 */
public class Answer extends AbstractContribution {

    @NotNull
    @NonNull
    @Getter
    @Setter
    private Question question;
}
