package cz.zeptejsepojistovaka.domainmodel;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * @author <a href="mailto:skalicky.tomas@gmail.com">Tomas Skalicky</a>
 */
@Entity
@EqualsAndHashCode(callSuper = true, exclude = "question")
public class Answer extends AbstractContribution {

    private static final long serialVersionUID = 4729919240799217682L;

    public static final String QUESTION_COLUMN_NAME = "question_id";

    /**
     * Do NOT propagate (cascade) any operation.
     */
    @NotNull
    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.EAGER, cascade = {})
    @JoinColumn(name = QUESTION_COLUMN_NAME, referencedColumnName = AbstractContribution.ID_COLUMN_NAME)
    private Question question;
}
