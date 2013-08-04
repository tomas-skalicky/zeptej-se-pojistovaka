package cz.zeptejsepojistovaka.domainmodel;

import javax.validation.constraints.Min;

import lombok.Getter;
import lombok.Setter;

/**
 * @author <a href="mailto:skalicky.tomas@gmail.com">Tomas Skalicky</a>
 */
public abstract class AbstractPerson {

    public static final int MIN_NAME_LENGTH = 3;

    @Min(1)
    @Getter
    @Setter
    private int id;
}
