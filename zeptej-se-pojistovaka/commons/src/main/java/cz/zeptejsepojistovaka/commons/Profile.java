package cz.zeptejsepojistovaka.commons;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

public enum Profile {
    DEV, TEST, PRODUCTION;

    public static final Map<String, Profile> LOWER_CASED_NAME_TO_TYPE = initializeLowerCasedNameToType();

    private static Map<String, Profile> initializeLowerCasedNameToType() {
        // 2 * length is a heuristic to make the initialization faster.
        Map<String, Profile> resultMap = new HashMap<String, Profile>(2 * values().length);

        for (Profile type : values()) {
            resultMap.put(StringUtils.lowerCase(type.name()), type);
        }
        return resultMap;
    }

    /**
     * @param name
     *            Name of profile. Need not to be lower cased.
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
