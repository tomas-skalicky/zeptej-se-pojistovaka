package cz.zeptejsepojistovaka.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cz.zeptejsepojistovaka.domainmodel.UnverifiedMessageAuthor;
import cz.zeptejsepojistovaka.domainmodel.VerifiedUser;

public interface UnverifiedMessageAuthorRepository extends JpaRepository<UnverifiedMessageAuthor, Integer> {

    /**
     * Retrieves all {@link UnverifiedMessageAuthor UnverifiedMessageAuthors} with the given {@code name}.
     */
    List<UnverifiedMessageAuthor> findByName(String name);

    /**
     * Retrieves all {@link UnverifiedMessageAuthor UnverifiedMessageAuthors} with the given {@code email}.
     * There may be more since the table contains not just {@link VerifiedUser}, but also the unverified ones.
     */
    List<UnverifiedMessageAuthor> findByEmail(String email);
}
