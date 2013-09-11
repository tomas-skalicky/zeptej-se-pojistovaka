package cz.zeptejsepojistovaka.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cz.zeptejsepojistovaka.domainmodel.Message;

public interface MessageRepository extends JpaRepository<Message, Integer> {
}
