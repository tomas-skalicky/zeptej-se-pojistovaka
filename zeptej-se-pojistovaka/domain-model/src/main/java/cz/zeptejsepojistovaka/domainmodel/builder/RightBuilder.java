package cz.zeptejsepojistovaka.domainmodel.builder;

import cz.zeptejsepojistovaka.domainmodel.Right;
import cz.zeptejsepojistovaka.domainmodel.RightType;
import cz.zeptejsepojistovaka.domainmodel.VerifiedUser;

public class RightBuilder {

    private final Right right = new Right();

    private RightBuilder() {
    }

    public static RightBuilder newRight() {
        return new RightBuilder();
    }

    public RightBuilder withUser(VerifiedUser user) {
        this.right.setUser(user);
        return this;
    }

    public RightBuilder withRightType(RightType rightType) {
        this.right.setRightType(rightType);
        return this;
    }

    public Right build() {
        return this.right;
    }
}
