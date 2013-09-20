package cz.zeptejsepojistovaka.domainmodel;

import javax.persistence.Entity;
import javax.validation.constraints.Size;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * @author <a href="mailto:skalicky.tomas@gmail.com">Tomas Skalicky</a>
 */
@Entity
@EqualsAndHashCode(callSuper = true)
public abstract class AbstractUnverifiedUser extends AbstractUser {

    private static final long serialVersionUID = -1617101233945284202L;

    @Size(min = AbstractUser.MIN_NAME_LENGTH)
    @Getter
    @Setter
    private String name;
}
