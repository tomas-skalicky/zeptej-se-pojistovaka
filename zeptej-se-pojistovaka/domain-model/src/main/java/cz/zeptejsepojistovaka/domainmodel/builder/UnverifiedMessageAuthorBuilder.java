package cz.zeptejsepojistovaka.domainmodel.builder;

import cz.zeptejsepojistovaka.domainmodel.UnverifiedMessageAuthor;

public class UnverifiedMessageAuthorBuilder {

    private final UnverifiedMessageAuthor author = new UnverifiedMessageAuthor();

    private UnverifiedMessageAuthorBuilder() {
    }

    public static UnverifiedMessageAuthorBuilder newUnverifiedMessageAuthor() {
        return new UnverifiedMessageAuthorBuilder();
    }

    public UnverifiedMessageAuthorBuilder withId(Integer id) {
        this.author.setId(id);
        return this;
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
