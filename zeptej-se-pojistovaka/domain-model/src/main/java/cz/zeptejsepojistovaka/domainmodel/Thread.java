package cz.zeptejsepojistovaka.domainmodel;

import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * @author <a href="mailto:skalicky.tomas@gmail.com">Tomas Skalicky</a>
 */
public class Thread {

    @Min(1)
    @Getter
    @Setter
    private int id;

    @NotNull
    @NonNull
    @Getter
    @Setter
    private List<Tag> tags;

    @NotNull
    @NonNull
    @Getter
    @Setter
    private Question question;

    @NotNull
    @NonNull
    @Getter
    @Setter
    private Question thema;
}
