package cz.zeptejsepojistovaka.domainmodel;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import cz.zeptejsepojistovaka.domainmodel.right.AbstractRight;

/**
 * @author <a href="mailto:skalicky.tomas@gmail.com">Tomas Skalicky</a>
 */
public class VerifiedUser extends AbstractUser implements ContributionAuthor, MessageAuthor {

    @NotBlank
    @Size(min = AbstractUser.MIN_NAME_LENGTH)
    @NonNull
    @Getter
    @Setter
    private String name;

    @NotBlank
    @Email
    @NonNull
    @Getter
    @Setter
    private String email;

    @NotBlank
    @NonNull
    @Getter
    @Setter
    private Sex sex;

    @NotBlank
    @NonNull
    @Getter
    @Setter
    private String passwordHash;

    @NotNull
    @NonNull
    @Getter
    @Setter
    private List<AbstractRight> rights;
}
