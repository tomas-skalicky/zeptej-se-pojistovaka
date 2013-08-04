package cz.zeptejsepojistovaka.domainmodel.right;

import javax.validation.constraints.Min;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import org.hibernate.validator.constraints.NotBlank;

/**
 * @author <a href="mailto:skalicky.tomas@gmail.com">Tomas Skalicky</a>
 */
public class AbstractRight {

    @NotBlank
    @Min(1)
    @NonNull
    @Getter
    @Setter
    private int id;
}
