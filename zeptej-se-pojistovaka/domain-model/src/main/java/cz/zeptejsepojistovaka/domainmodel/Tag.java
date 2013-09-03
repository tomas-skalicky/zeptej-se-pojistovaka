package cz.zeptejsepojistovaka.domainmodel;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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

    private static final long serialVersionUID = -1647584659983351288L;

    public static final int MIN_NAME_LENGTH = 2;
    public static final String TABLE_NAME = "tags";
    public static final String ID_COLUMN_NAME = "id";

    @Min(1)
    @Getter
    @Setter
    @Id
    @GeneratedValue
    private int id;

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
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = TagPattern.TAG_ID_COLUMN_NAME, referencedColumnName = ID_COLUMN_NAME)
    private Set<TagPattern> patterns;
}
