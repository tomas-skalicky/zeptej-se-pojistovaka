package cz.zeptejsepojistovaka.persistence.repository;

import java.util.List;

import cz.zeptejsepojistovaka.domainmodel.User;

public interface UserRepositoryService {

    User save(User user);

    List<User> findByEmail(String email);
}
