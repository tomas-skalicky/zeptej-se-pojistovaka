package cz.zeptejsepojistovaka.domainmodel;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import org.hibernate.validator.constraints.NotBlank;

/**
 * @author <a href="mailto:skalicky.tomas@gmail.com">Tomas Skalicky</a>
 */
@Entity
@Table(name = Tag.TABLE_NAME)
public class Tag implements Serializable {

    private static final long serialVersionUID = 7998378353779938815L;

    public static final int MIN_NAME_LENGTH = 2;
    public static final String TABLE_NAME = "tags";
    public static final String ID_COLUMN_NAME = "id";

    public static final String TAG_PATTERN_JOIN_TABLE_NAME = "tag_patterns";
    public static final String TAG_ID_COLUMN_NAME = "tag_id";
    public static final String PATTERN_COLUMN_NAME = "pattern";

    @Min(1)
    @Getter
    @Setter
    @Id
    @GeneratedValue
    private Integer id;

    @NotBlank
    @Size(min = MIN_NAME_LENGTH)
    @NonNull
    @Getter
    @Setter
    private String name;

    @NotNull
    @NonNull
    @Getter
    @Setter
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "tags")
    private Set<ContributionThread> threads;

    @NotNull
    @NonNull
    @Getter
    @Setter
    @Column(name = PATTERN_COLUMN_NAME)
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = TAG_PATTERN_JOIN_TABLE_NAME, joinColumns = { @JoinColumn(name = TAG_ID_COLUMN_NAME, referencedColumnName = ID_COLUMN_NAME, nullable = false, updatable = false) }, uniqueConstraints = { @UniqueConstraint(columnNames = {
            TAG_ID_COLUMN_NAME, PATTERN_COLUMN_NAME }) })
    private Set<String> patterns;
}
