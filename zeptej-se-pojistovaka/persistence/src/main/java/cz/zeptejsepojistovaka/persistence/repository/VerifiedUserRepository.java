package cz.zeptejsepojistovaka.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cz.zeptejsepojistovaka.domainmodel.VerifiedUser;

public interface VerifiedUserRepository extends JpaRepository<VerifiedUser, Integer> {

    /**
     * Retrieves all {@link VerifiedUser VerifiedUsers} with the given {@code name}.
     */
    List<VerifiedUser> findByName(String name);

    /**
     * Retrieves all {@link VerifiedUser VerifiedUsers} with the given {@code email} address. There must at
     * most one user with such an email.
     */
    VerifiedUser findByEmail(String email);
}
