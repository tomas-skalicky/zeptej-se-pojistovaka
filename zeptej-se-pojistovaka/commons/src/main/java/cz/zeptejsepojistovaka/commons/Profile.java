package cz.zeptejsepojistovaka.commons;

import java.util.HashMap;
import java.util.Map;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import org.apache.commons.lang3.StringUtils;

import cz.zeptejsepojistovaka.commons.annotation.InDevelopment;
import cz.zeptejsepojistovaka.commons.annotation.InProduction;
import cz.zeptejsepojistovaka.commons.annotation.InTest;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum Profile {

    DEV(InDevelopment.PROFILE_NAME) {
    },
    TEST(InTest.PROFILE_NAME) {
    },
    PRODUCTION(InProduction.PROFILE_NAME) {
    };

    @NonNull
    @Getter
    private final String name;

    public static final Map<String, Profile> LOWER_CASED_NAME_TO_TYPE = initializeLowerCasedNameToType();

    private static Map<String, Profile> initializeLowerCasedNameToType() {
        // 2 * length is a heuristic to make the initialization faster.
        Map<String, Profile> resultMap = new HashMap<String, Profile>(2 * values().length);

        for (Profile type : values()) {
            resultMap.put(StringUtils.lowerCase(type.name), type);
        }
        return resultMap;
    }

    /**
     * Gets a {@link Profile} type which corresponds to the given {@code name}. Lower/upper case is not
     * decisive.
     */
    public static Profile getType(String name) {
        String lowerCasedName = StringUtils.lowerCase(name);
        if (LOWER_CASED_NAME_TO_TYPE.containsKey(lowerCasedName)) {
            return LOWER_CASED_NAME_TO_TYPE.get(lowerCasedName);
        } else {
            throw new IllegalArgumentException("Profile with name " + name + " does not exist");
        }
    }
}
