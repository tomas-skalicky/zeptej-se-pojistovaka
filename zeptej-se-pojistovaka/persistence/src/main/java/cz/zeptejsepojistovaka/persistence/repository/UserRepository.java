package cz.zeptejsepojistovaka.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cz.zeptejsepojistovaka.domainmodel.User;
import cz.zeptejsepojistovaka.domainmodel.VerifiedUser;

public interface UserRepository extends JpaRepository<User, Integer> {

    /**
     * Retrieves all {@link User Users} with the given {@code email}. There may be more since the table
     * contains not just {@link VerifiedUser}, but also the unverified ones.
     */
    List<User> findByEmail(String email);
}
