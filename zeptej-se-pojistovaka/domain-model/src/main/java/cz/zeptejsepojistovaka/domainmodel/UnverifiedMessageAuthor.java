package cz.zeptejsepojistovaka.domainmodel;

import javax.persistence.Entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.annotate.JsonTypeName;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author <a href="mailto:skalicky.tomas@gmail.com">Tomas Skalicky</a>
 */
@JsonTypeName(UnverifiedMessageAuthor.JSON_TYPE_NAME)
@JsonTypeInfo(use = JsonTypeInfo.Id.NONE)
@Entity
@EqualsAndHashCode(callSuper = true)
public class UnverifiedMessageAuthor extends AbstractUnverifiedUser implements MessageAuthor {

    private static final long serialVersionUID = -6819011743293259868L;

    public static final String JSON_TYPE_NAME = "UNVERIFIED_MESSAGE_AUTHOR";

    @NotBlank
    @Email
    @NonNull
    @Getter
    @Setter
    private String email;
}
