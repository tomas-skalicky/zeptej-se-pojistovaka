package cz.zeptejsepojistovaka.persistence.repository;

import java.util.HashSet;
import java.util.Set;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cz.zeptejsepojistovaka.domainmodel.Right;
import cz.zeptejsepojistovaka.domainmodel.VerifiedUser;

/**
 * @author <a href="mailto:skalicky.tomas@gmail.com">Tomas Skalicky</a>
 */
@Repository(value = "cz.zeptejsepojistovaka.persistence.repository.CustomVerifiedUserRepository")
public class CustomVerifiedUserRepositoryImpl implements CustomVerifiedUserRepository {

    @Inject
    private VerifiedUserRepository verifiedUserRepository;

    @Inject
    private RightRepository rightRepository;

    @Transactional
    @Override
    public VerifiedUser saveWithRights(VerifiedUser user) {
        Set<Right> userRights = user.getRights();

        user.setRights(new HashSet<Right>());
        VerifiedUser savedUser = this.verifiedUserRepository.save(user);

        for (Right right : userRights) {
            right.setUser(savedUser);
            savedUser.addRight(this.rightRepository.save(right).getRightType());
        }

        return savedUser;
    }
}
