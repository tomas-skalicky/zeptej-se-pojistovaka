package cz.zeptejsepojistovaka.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cz.zeptejsepojistovaka.domainmodel.Answer;

public interface ContributionThreadRepository extends JpaRepository<Answer, Integer> {
}
