package cz.zeptejsepojistovaka.domainmodel;

import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * @author <a href="mailto:skalicky.tomas@gmail.com">Tomas Skalicky</a>
 */
@Entity
@Table(name = AbstractContribution.TABLE_NAME)
public class Question extends AbstractContribution {

    private static final long serialVersionUID = -1765131095010510075L;

    @NotNull
    @NonNull
    @Getter
    @Setter
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = Answer.QUESTION_COLUMN_NAME, table = AbstractContribution.TABLE_NAME)
    private List<Answer> answers;

    @Getter
    @Setter
    @Embedded
    private Thread thread;
}
