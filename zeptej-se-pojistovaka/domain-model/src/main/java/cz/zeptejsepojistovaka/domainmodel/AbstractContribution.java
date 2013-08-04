package cz.zeptejsepojistovaka.domainmodel;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import org.hibernate.validator.constraints.NotBlank;

/**
 * @author <a href="mailto:skalicky.tomas@gmail.com">Tomas Skalicky</a>
 */
public abstract class AbstractContribution {

    public static final int MIN_TEXT_LENGTH = 4;

    @Min(1)
    @Getter
    @Setter
    private int id;

    @NotNull
    @NonNull
    @Getter
    @Setter
    private ContributionAuthor author;

    @NotBlank
    @Size(min = MIN_TEXT_LENGTH)
    @NonNull
    @Getter
    @Setter
    private int text;

    @Past
    private Date creationDateTime;

    @Past
    private Date lastUpdateDateTime;
}
