package cz.zeptejsepojistovaka.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cz.zeptejsepojistovaka.domainmodel.UnverifiedContributionAuthor;
import cz.zeptejsepojistovaka.domainmodel.VerifiedUser;

public interface UnverifiedContributionAuthorRepository extends
        JpaRepository<UnverifiedContributionAuthor, Integer> {

    /**
     * Retrieves all {@link UnverifiedContributionAuthor UnverifiedContributionAuthors} with the given
     * {@code email}. There may be more since the table contains not just {@link VerifiedUser}, but also the
     * unverified ones.
     */
    List<UnverifiedContributionAuthor> findByEmail(String email);
}
