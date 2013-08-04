package cz.zeptejsepojistovaka.domainmodel;

import lombok.Getter;
import lombok.NonNull;

import org.hibernate.validator.constraints.NotBlank;

/**
 * @author <a href="mailto:skalicky.tomas@gmail.com">Tomas Skalicky</a>
 */
public enum MessageType {

    TECHNICAL_PROBLEM("message-type.technical-problem") {
    },
    OTHER_ISSUE("message-type.other-issue") {
    };

    @NotBlank
    @NonNull
    @Getter
    private final String localizationCode;

    private MessageType(String localizationCode) {
        this.localizationCode = localizationCode;
    }
}
