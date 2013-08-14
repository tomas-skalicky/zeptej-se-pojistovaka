package cz.zeptejsepojistovaka.domainmodel;

import java.util.HashMap;
import java.util.Map;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import org.hibernate.validator.constraints.NotBlank;

/**
 * All user rights (authorities) which appear in the application.
 * 
 * @author <a href="mailto:skalicky.tomas@gmail.com">Tomas Skalicky</a>
 */
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum RightType {

    ASK_QUESTION(1, "user-right.ask-question") {
    },
    ANSWER_QUESTION(2, "user-right.answer-question") {
    },
    ADD_TAG(3, "user-right.add-tag") {
    },
    TAG_THREAD(4, "user-right.tag-thread") {
    },
    SEND_MESSAGE(5, "user-right.send-message") {
    };

    @NotNull
    @Min(1)
    @NonNull
    @Getter
    private final int id;

    @NotBlank
    @NonNull
    @Getter
    private final String titleLocalizationCode;

    private static final Map<Integer, RightType> ID_TO_TYPE = initializeIdToType();

    private static Map<Integer, RightType> initializeIdToType() {
        // 2 * length is a heuristic to make the initialization faster.
        Map<Integer, RightType> resultMap = new HashMap<Integer, RightType>(2 * values().length);

        for (RightType type : values()) {
            resultMap.put(type.id, type);
        }
        return resultMap;
    }

    public static RightType getType(int id) {
        if (ID_TO_TYPE.containsKey(id)) {
            return ID_TO_TYPE.get(id);
        } else {
            throw new IllegalArgumentException("Right type with ID " + id + " does not exist");
        }
    }
}
