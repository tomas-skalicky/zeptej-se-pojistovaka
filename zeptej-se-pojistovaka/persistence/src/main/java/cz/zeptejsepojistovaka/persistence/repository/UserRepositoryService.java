package cz.zeptejsepojistovaka.persistence.repository;

import java.util.List;

import cz.zeptejsepojistovaka.domainmodel.User;
import cz.zeptejsepojistovaka.domainmodel.VerifiedUser;

public interface UserRepositoryService {

    /**
     * Persists the given {@link User}. If it has a specified ID, the method carries out UPDATE; otherwise,
     * the method carries out INSERT and the returned instance of {@link User} has its ID set.
     */
    User save(User user);

    /**
     * Retrieves all {@link User Users} with the given {@code email}. There may be more since the table
     * contains not just {@link VerifiedUser}, but also the unverified ones.
     */
    List<User> findByEmail(String email);
}
