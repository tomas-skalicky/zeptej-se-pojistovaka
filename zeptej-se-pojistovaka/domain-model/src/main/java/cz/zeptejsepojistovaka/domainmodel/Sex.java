package cz.zeptejsepojistovaka.domainmodel;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NonNull;

/**
 * @author <a href="mailto:skalicky.tomas@gmail.com">Tomas Skalicky</a>
 */
public enum Sex {

    MALE(1), FEMALE(2);

    @NotNull
    @Min(1)
    @NonNull
    @Getter
    private final int id;

    private Sex(int id) {
        this.id = id;
    }
}
