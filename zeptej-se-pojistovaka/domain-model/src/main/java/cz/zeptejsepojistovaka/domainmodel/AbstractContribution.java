package cz.zeptejsepojistovaka.domainmodel;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author <a href="mailto:skalicky.tomas@gmail.com">Tomas Skalicky</a>
 */
@Entity
@Table(name = AbstractContribution.TABLE_NAME)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class AbstractContribution implements Serializable {

    private static final long serialVersionUID = 6088344590164907016L;

    public static final int MIN_TEXT_LENGTH = 4;
    public static final String TABLE_NAME = "contributions";
    public static final String ID_COLUMN_NAME = "id";
    public static final String AUTHOR_COLUMN_NAME = "author_id";
    public static final String CREATION_TIMESTAMP_COLUMN_NAME = "creation_timestamp";
    public static final String LAST_UPDATE_TIMESTAMP_COLUMN_NAME = "last_update_timestamp";

    @Min(1)
    @Getter
    @Setter
    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @NonNull
    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = AbstractUser.class, cascade = CascadeType.ALL)
    @JoinColumn(name = AUTHOR_COLUMN_NAME, referencedColumnName = AbstractUser.ID_COLUMN_NAME)
    private ContributionAuthor author;

    @NotBlank
    @Size(min = MIN_TEXT_LENGTH)
    @NonNull
    @Getter
    @Setter
    @Type(type = HibernateConstants.TEXT_TYPE)
    private String text;

    @NotNull
    @Past
    @Getter
    @Setter
    @Column(name = CREATION_TIMESTAMP_COLUMN_NAME)
    private Timestamp creationTimestamp;

    @Past
    @Getter
    @Setter
    @Column(name = LAST_UPDATE_TIMESTAMP_COLUMN_NAME)
    private Timestamp lastUpdateTimestamp;

    @NotNull
    @NonNull
    @Getter
    @Setter
    @OneToOne(fetch = FetchType.EAGER)
    private ContributionThread thread;
}
