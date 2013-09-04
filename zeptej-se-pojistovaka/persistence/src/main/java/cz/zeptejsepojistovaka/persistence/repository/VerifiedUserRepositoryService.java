package cz.zeptejsepojistovaka.persistence.repository;

import cz.zeptejsepojistovaka.domainmodel.VerifiedUser;

public interface VerifiedUserRepositoryService {

    VerifiedUser findByEmail(String email);
}
