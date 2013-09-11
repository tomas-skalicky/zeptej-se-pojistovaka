package cz.zeptejsepojistovaka.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cz.zeptejsepojistovaka.domainmodel.ContributionThread;

public interface AnswerRepository extends JpaRepository<ContributionThread, Integer> {
}
