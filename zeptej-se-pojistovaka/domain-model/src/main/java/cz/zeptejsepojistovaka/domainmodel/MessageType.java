package cz.zeptejsepojistovaka.domainmodel;

import javax.validation.constraints.Min;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import org.hibernate.validator.constraints.NotBlank;

/**
 * @author <a href="mailto:skalicky.tomas@gmail.com">Tomas Skalicky</a>
 */
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum MessageType {

    TECHNICAL_PROBLEM(1, "message-type.technical-problem") {
    },
    OTHER_ISSUE(2, "message-type.other-issue") {
    };

    @NotBlank
    @Min(1)
    @NonNull
    @Getter
    private final int order;

    @NotBlank
    @NonNull
    @Getter
    private final String localizationCode;
}
