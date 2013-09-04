package cz.zeptejsepojistovaka.persistence.repository;

import cz.zeptejsepojistovaka.domainmodel.Message;

public interface MessageRepositoryService {

    /**
     * Persists the given {@link Message}. If it has a specified ID, the method carries out UPDATE; otherwise,
     * INSERT and the returned instance has its ID set.
     */
    Message save(Message message);
}
