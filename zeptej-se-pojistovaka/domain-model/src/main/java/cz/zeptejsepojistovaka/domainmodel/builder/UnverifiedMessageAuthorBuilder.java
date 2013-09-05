package cz.zeptejsepojistovaka.domainmodel.builder;

import cz.zeptejsepojistovaka.domainmodel.UnverifiedMessageAuthor;

public class UnverifiedMessageAuthorBuilder {

    private final UnverifiedMessageAuthor author = new UnverifiedMessageAuthor();

    public static UnverifiedMessageAuthorBuilder unverifiedMessageAuthorBuilder() {
        return new UnverifiedMessageAuthorBuilder();
    }

    public UnverifiedMessageAuthorBuilder withName(String name) {
        this.author.setName(name);
        return this;
    }

    public UnverifiedMessageAuthorBuilder withEmail(String email) {
        this.author.setEmail(email);
        return this;
    }

    public UnverifiedMessageAuthor build() {
        return this.author;
    }
}
