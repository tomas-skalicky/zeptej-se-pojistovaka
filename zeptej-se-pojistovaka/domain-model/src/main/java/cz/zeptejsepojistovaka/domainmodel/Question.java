package cz.zeptejsepojistovaka.domainmodel;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

/**
 * The {@code answers} property is excluded from the {@code equals}, {@code hashCode} and {@code toString}
 * methods since the property is lazy loaded.
 * 
 * @author <a href="mailto:skalicky.tomas@gmail.com">Tomas Skalicky</a>
 */
@Entity
@EqualsAndHashCode(callSuper = true, exclude = "answers")
@ToString(exclude = "answers")
public class Question extends AbstractContribution {

    private static final long serialVersionUID = -1765131095010510075L;

    @NotNull
    @NonNull
    @Getter
    @Setter
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "question", cascade = CascadeType.ALL)
    private List<Answer> answers;
}
