package cz.zeptejsepojistovaka.persistence.repository;

import java.sql.Timestamp;
import java.util.List;

import cz.zeptejsepojistovaka.domainmodel.ContributionThread;

public interface ContributionThreadRepositoryService {

    /**
     * Retrieves a {@link ContributionThread} with the given {@code threadId}.
     */
    ContributionThread findById(int threadId);

    /**
     * Retrieves the given number of {@link ContributionThread ContributionThreads} whose lastChangeTimes of
     * threads are less then the given {@code lastChangeTime} and maximal possible. The threads are sorted in
     * the result {@link List} from those with maximal lastChangeTime to those with less lastChangeTime.
     */
    List<ContributionThread> findOlder(Timestamp lastChangeTime, int count);
}
