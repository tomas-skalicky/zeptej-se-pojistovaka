package cz.zeptejsepojistovaka.persistence.repository;

import cz.zeptejsepojistovaka.domainmodel.VerifiedUser;

public interface VerifiedUserRepositoryService {

    /**
     * Retrieves {@link VerifiedUser} with the given {@code email}. There must be at most one with such an
     * email.
     */
    VerifiedUser findByEmail(String email);
}
