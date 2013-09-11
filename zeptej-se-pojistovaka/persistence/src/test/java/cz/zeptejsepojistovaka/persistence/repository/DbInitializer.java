package cz.zeptejsepojistovaka.persistence.repository;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.stereotype.Service;

import cz.zeptejsepojistovaka.domainmodel.RightType;
import cz.zeptejsepojistovaka.domainmodel.builder.UnverifiedContributionAuthorBuilder;
import cz.zeptejsepojistovaka.domainmodel.builder.UnverifiedMessageAuthorBuilder;
import cz.zeptejsepojistovaka.domainmodel.builder.VerifiedUserBuilder;

@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
class DbInitializer {

    private static VerifiedUserRepository verifiedUserRepository;
    private static CustomVerifiedUserRepository customVerifiedUserRepository;
    private static UnverifiedContributionAuthorRepository unverifiedContributionAuthorRepository;
    private static UnverifiedMessageAuthorRepository unverifiedMessageAuthorRepository;

    static {
        injectBeans();
        trancateAffectedTables();
        insertUsers();
    }

    @SuppressWarnings("resource")
    private static void injectBeans() {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(
                "cz.zeptejsepojistovaka.persistence");
        verifiedUserRepository = context.getBean(VerifiedUserRepository.class);
        customVerifiedUserRepository = context.getBean(CustomVerifiedUserRepository.class);
        unverifiedContributionAuthorRepository = context
                .getBean(UnverifiedContributionAuthorRepository.class);
        unverifiedMessageAuthorRepository = context.getBean(UnverifiedMessageAuthorRepository.class);
    }

    private static void trancateAffectedTables() {
        verifiedUserRepository.deleteAll();
        unverifiedContributionAuthorRepository.deleteAll();
        unverifiedMessageAuthorRepository.deleteAll();
    }

    private static void insertUsers() {
        unverifiedMessageAuthorRepository.save(UnverifiedMessageAuthorBuilder.newUnverifiedMessageAuthor()
                .withEmail("message.author@abc.com").build());

        unverifiedContributionAuthorRepository.save(UnverifiedContributionAuthorBuilder
                .newUnverifiedContributionAuthor().build());

        customVerifiedUserRepository.saveWithRights(VerifiedUserBuilder.newVerifiedUser()
                .withName("Tomáš Skalický").withEmail("tomsky@seznam.cz").withIsMale(true)
                .withPasswordHash("XYZ").add(RightType.ASK_QUESTION).add(RightType.SEND_MESSAGE).build());
        customVerifiedUserRepository.saveWithRights(VerifiedUserBuilder.newVerifiedUser()
                .withName("Tomas Skalicky").withEmail("tomas.skalicky@gfk.com").withIsMale(true)
                .withPasswordHash("XYZ").add(RightType.SEND_MESSAGE).withEnabled(false).build());

        unverifiedMessageAuthorRepository.save(UnverifiedMessageAuthorBuilder.newUnverifiedMessageAuthor()
                .withName("Test Author Name").withEmail("message.author@abc.com").build());

        unverifiedContributionAuthorRepository.save(UnverifiedContributionAuthorBuilder
                .newUnverifiedContributionAuthor().withName("Test Author Name")
                .withEmail("contribution.author@abc.com").build());

        customVerifiedUserRepository.saveWithRights(VerifiedUserBuilder.newVerifiedUser().withName("Tomas")
                .withEmail("skalicky.tomas@gmail.com").withIsMale(false).withPasswordHash("password")
                .withEnabled(true).build());
    }
}
