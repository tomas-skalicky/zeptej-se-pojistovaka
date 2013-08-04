package cz.zeptejsepojistovaka.domainmodel;

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
public class Message {

    public static final int MIN_TEXT_LENGTH = 10;

    @Min(1)
    @Getter
    @Setter
    private int id;

    @NotNull
    @NonNull
    @Getter
    @Setter
    private MessageType type;

    @NotNull
    @NonNull
    @Getter
    @Setter
    private MessageAuthor author;

    @NotBlank
    @Size(min = MIN_TEXT_LENGTH)
    @NonNull
    @Getter
    @Setter
    private String text;
}
