package cz.zeptejsepojistovaka.domainmodel;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

import org.hibernate.validator.constraints.NotBlank;

/**
 * @author <a href="mailto:skalicky.tomas@gmail.com">Tomas Skalicky</a>
 */
@NoArgsConstructor
@ToString
@Entity
@Table(name = TagPattern.TABLE_NAME)
@IdClass(value = TagPatternKey.class)
public class TagPattern implements Serializable {

    private static final long serialVersionUID = 4554284741613442996L;

    public static final String TABLE_NAME = "tag_patterns";
    public static final String TAG_ID_COLUMN_NAME = "tag_id";
    public static final String PATTERN_COLUMN_NAME = "pattern";

    @NotNull
    @Min(1)
    @NonNull
    @Getter
    @Setter
    @Id
    @Column(name = TAG_ID_COLUMN_NAME)
    private int tagId;

    @NotBlank
    @NonNull
    @Getter
    @Setter
    @Id
    @Column(name = PATTERN_COLUMN_NAME)
    private String pattern;
}
