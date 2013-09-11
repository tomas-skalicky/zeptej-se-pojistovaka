package cz.zeptejsepojistovaka.persistence.repository;

import cz.zeptejsepojistovaka.domainmodel.VerifiedUser;

public interface CustomVerifiedUserRepository {

    /**
     * Either inserts a new {@link VerifiedUser}, or updates an already-persisted one. The ID of the given
     * {@code user} is decisive. Then, persists rights of the user.
     */
    VerifiedUser saveWithRights(VerifiedUser user);
}
