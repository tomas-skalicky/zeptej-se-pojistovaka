package cz.zeptejsepojistovaka.persistence.repository;

import java.util.List;

import cz.zeptejsepojistovaka.domainmodel.ContributionThread;

public interface ContributionThreadRepositoryService {

    /**
     * Retrieves a {@link ContributionThread} with the given {@code threadId}.
     */
    ContributionThread findById(int threadId);

    List<Thread> findAll();
}
