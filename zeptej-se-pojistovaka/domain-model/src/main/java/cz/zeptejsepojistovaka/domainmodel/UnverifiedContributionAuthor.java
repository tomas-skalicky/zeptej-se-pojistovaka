package cz.zeptejsepojistovaka.domainmodel;

import lombok.Getter;
import lombok.Setter;

import org.hibernate.validator.constraints.Email;

/**
 * @author <a href="mailto:skalicky.tomas@gmail.com">Tomas Skalicky</a>
 */
public class UnverifiedContributionAuthor extends AbstractUnverifiedUser implements ContributionAuthor {

    @Email
    @Getter
    @Setter
    private String email;
}
