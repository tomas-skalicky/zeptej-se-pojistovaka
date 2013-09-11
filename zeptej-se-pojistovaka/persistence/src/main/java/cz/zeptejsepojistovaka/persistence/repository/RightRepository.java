package cz.zeptejsepojistovaka.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cz.zeptejsepojistovaka.domainmodel.Right;
import cz.zeptejsepojistovaka.domainmodel.RightKey;

public interface RightRepository extends JpaRepository<Right, RightKey> {
}
