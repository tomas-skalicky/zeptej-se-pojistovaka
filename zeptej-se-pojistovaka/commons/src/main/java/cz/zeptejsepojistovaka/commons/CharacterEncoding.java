package cz.zeptejsepojistovaka.commons;

import lombok.Getter;

public enum CharacterEncoding {

    UTF_8("UTF-8");

    @Getter
    private final String name;

    private CharacterEncoding(String name) {
        this.name = name;
    }

    public static CharacterEncoding getDefault() {
        return UTF_8;
    }
}
