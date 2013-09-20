package cz.zeptejsepojistovaka.domainmodel;

import javax.persistence.Entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.annotate.JsonTypeName;
import org.hibernate.validator.constraints.Email;

/**
 * @author <a href="mailto:skalicky.tomas@gmail.com">Tomas Skalicky</a>
 */
@JsonTypeName(UnverifiedContributionAuthor.JSON_TYPE_NAME)
@JsonTypeInfo(use = JsonTypeInfo.Id.NONE)
@Entity
@EqualsAndHashCode(callSuper = true)
public class UnverifiedContributionAuthor extends AbstractUnverifiedUser implements ContributionAuthor {

    private static final long serialVersionUID = 5722350189695963109L;

    public static final String JSON_TYPE_NAME = "UNVERIFIED_CONTRIBUTION_AUTHOR";

    @Email
    @Getter
    @Setter
    private String email;
}
