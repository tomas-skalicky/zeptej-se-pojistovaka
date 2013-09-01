package cz.zeptejsepojistovaka.domainmodel;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * @author <a href="mailto:skalicky.tomas@gmail.com">Tomas Skalicky</a>
 */
@Embeddable
public class ContributionThread implements Serializable {

    private static final long serialVersionUID = -4754136234136946020L;

    @NotNull
    @NonNull
    @Getter
    @Setter
    @ManyToMany
    private List<Tag> tags;

    @NotNull
    @NonNull
    @Getter
    @Setter
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Question question;

    @NotNull
    @NonNull
    @Getter
    @Setter
    private String thema;
}
