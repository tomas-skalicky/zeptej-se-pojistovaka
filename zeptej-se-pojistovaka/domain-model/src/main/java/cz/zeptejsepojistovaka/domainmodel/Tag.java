package cz.zeptejsepojistovaka.domainmodel;

import java.util.List;

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
public class Tag {

    public static final int MIN_NAME_LENGTH = 2;

    @Min(1)
    @Getter
    @Setter
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
    private List<Thread> threads;

    @NotNull
    @NonNull
    @Getter
    @Setter
    private List<String> patterns;
}
