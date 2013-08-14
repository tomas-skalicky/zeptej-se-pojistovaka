package cz.zeptejsepojistovaka.domainmodel;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * @author <a href="mailto:skalicky.tomas@gmail.com">Tomas Skalicky</a>
 */
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum Sex {

    MALE(1), FEMALE(2);

    @NotNull
    @Min(1)
    @NonNull
    @Getter
    private final int id;
}
