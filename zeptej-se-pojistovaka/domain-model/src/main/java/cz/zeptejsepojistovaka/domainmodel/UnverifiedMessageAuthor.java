package cz.zeptejsepojistovaka.domainmodel;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author <a href="mailto:skalicky.tomas@gmail.com">Tomas Skalicky</a>
 */
public class UnverifiedMessageAuthor extends AbstractUnverifiedUser implements MessageAuthor {

    @NotBlank
    @Email
    @NonNull
    @Getter
    @Setter
    private String email;
}
