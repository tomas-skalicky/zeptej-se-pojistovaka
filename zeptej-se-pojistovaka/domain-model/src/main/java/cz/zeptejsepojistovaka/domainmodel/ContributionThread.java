package cz.zeptejsepojistovaka.domainmodel;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * @author <a href="mailto:skalicky.tomas@gmail.com">Tomas Skalicky</a>
 */
@Entity
@Table(name = ContributionThread.TABLE_NAME)
public class ContributionThread implements Serializable {

    private static final long serialVersionUID = -4754136234136946020L;

    public static final String TABLE_NAME = "threads";
    public static final String ID_COLUMN_NAME = "id";

    public static final String TAG_THREAD_JOIN_TABLE_NAME = "tag_thread_references";
    public static final String TAG_ID_COLUMN_NAME = "tag_id";
    public static final String THREAD_ID_COLUMN_NAME = "thread_id";

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
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = TAG_THREAD_JOIN_TABLE_NAME, joinColumns = { @JoinColumn(name = THREAD_ID_COLUMN_NAME, referencedColumnName = ID_COLUMN_NAME, nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = TAG_ID_COLUMN_NAME, referencedColumnName = Tag.ID_COLUMN_NAME, nullable = false, updatable = false) }, uniqueConstraints = { @UniqueConstraint(columnNames = {
            TAG_ID_COLUMN_NAME, THREAD_ID_COLUMN_NAME }) })
    private List<Tag> tags;

    @NotNull
    @NonNull
    @Getter
    @Setter
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "thread")
    private Question question;

    @NotNull
    @NonNull
    @Getter
    @Setter
    private String thema;
}
