package cz.zeptejsepojistovaka.domainmodel;

import java.util.List;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * @author <a href="mailto:skalicky.tomas@gmail.com">Tomas Skalicky</a>
 */
public class Question extends AbstractContribution {

    @NotNull
    @NonNull
    @Getter
    @Setter
    private List<Answer> answers;

    @Getter
    @Setter
    private Thread thread;
}
