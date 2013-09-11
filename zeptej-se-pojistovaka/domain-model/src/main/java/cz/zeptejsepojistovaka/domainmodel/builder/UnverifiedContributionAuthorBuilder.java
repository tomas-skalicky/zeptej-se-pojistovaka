package cz.zeptejsepojistovaka.domainmodel.builder;

import cz.zeptejsepojistovaka.domainmodel.UnverifiedContributionAuthor;

public class UnverifiedContributionAuthorBuilder {

    private final UnverifiedContributionAuthor author = new UnverifiedContributionAuthor();

    private UnverifiedContributionAuthorBuilder() {
    }

    public static UnverifiedContributionAuthorBuilder newUnverifiedContributionAuthor() {
        return new UnverifiedContributionAuthorBuilder();
    }

    public UnverifiedContributionAuthorBuilder withName(String name) {
        this.author.setName(name);
        return this;
    }

    public UnverifiedContributionAuthorBuilder withEmail(String email) {
        this.author.setEmail(email);
        return this;
    }

    public UnverifiedContributionAuthor build() {
        return this.author;
    }
}
