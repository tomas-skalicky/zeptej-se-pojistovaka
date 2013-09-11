package cz.zeptejsepojistovaka.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cz.zeptejsepojistovaka.domainmodel.Tag;

public interface TagRepository extends JpaRepository<Tag, Integer> {
}
