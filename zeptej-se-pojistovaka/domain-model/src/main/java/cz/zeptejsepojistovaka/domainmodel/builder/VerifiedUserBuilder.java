package cz.zeptejsepojistovaka.domainmodel.builder;

import java.util.HashSet;

import cz.zeptejsepojistovaka.domainmodel.Right;
import cz.zeptejsepojistovaka.domainmodel.RightType;
import cz.zeptejsepojistovaka.domainmodel.VerifiedUser;

public class VerifiedUserBuilder {

    private final VerifiedUser user = new VerifiedUser();

    private VerifiedUserBuilder() {
        withNoRights();
    }

    public static VerifiedUserBuilder newVerifiedUser() {
        return new VerifiedUserBuilder();
    }

    public VerifiedUserBuilder withName(String name) {
        this.user.setName(name);
        return this;
    }

    public VerifiedUserBuilder withEmail(String email) {
        this.user.setEmail(email);
        return this;
    }

    public VerifiedUserBuilder withIsMale(boolean isMale) {
        this.user.setMale(isMale);
        return this;
    }

    public VerifiedUserBuilder withPasswordHash(String passwordHash) {
        this.user.setPasswordHash(passwordHash);
        return this;
    }

    public VerifiedUserBuilder withEnabled(boolean enabled) {
        this.user.setEnabled(enabled);
        return this;
    }

    public VerifiedUserBuilder withNoRights() {
        this.user.setRights(new HashSet<Right>());
        return this;
    }

    public VerifiedUserBuilder add(RightType rightType) {
        this.user.addRight(rightType);
        return this;
    }

    public VerifiedUser build() {
        return this.user;
    }
}
