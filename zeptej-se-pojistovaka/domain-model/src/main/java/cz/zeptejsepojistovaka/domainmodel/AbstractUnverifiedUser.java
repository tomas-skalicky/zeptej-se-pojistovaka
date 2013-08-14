package cz.zeptejsepojistovaka.domainmodel;

import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

/**
 * @author <a href="mailto:skalicky.tomas@gmail.com">Tomas Skalicky</a>
 */
public abstract class AbstractUnverifiedUser extends AbstractUser {

    @Size(min = AbstractUser.MIN_NAME_LENGTH)
    @Getter
    @Setter
    private String name;
}
