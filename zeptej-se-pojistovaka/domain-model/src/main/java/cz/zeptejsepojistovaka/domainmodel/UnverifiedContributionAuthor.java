package cz.zeptejsepojistovaka.domainmodel;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

import org.hibernate.validator.constraints.Email;

/**
 * @author <a href="mailto:skalicky.tomas@gmail.com">Tomas Skalicky</a>
 */
@Entity
public class UnverifiedContributionAuthor extends AbstractUnverifiedUser implements ContributionAuthor {

    private static final long serialVersionUID = 5722350189695963109L;

    @Email
    @Getter
    @Setter
    private String email;
}
