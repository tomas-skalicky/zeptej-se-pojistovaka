package cz.zeptejsepojistovaka.domainmodel;

import java.io.Serializable;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import org.hibernate.validator.constraints.NotBlank;

/**
 * Helper with the representation of the composite primary key of {@link Right}.
 * 
 * @author <a href="mailto:skalicky.tomas@gmail.com">Tomas Skalicky</a>
 */
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
public class TagPatternKey implements Serializable {

    private static final long serialVersionUID = -8585348166567032660L;

    @NotNull
    @Min(1)
    @NonNull
    @Getter
    @Setter
    private int tagId;

    @NotBlank
    @NonNull
    @Getter
    @Setter
    private String pattern;
}
