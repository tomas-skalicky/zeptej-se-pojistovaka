package cz.zeptejsepojistovaka.persistence.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.stereotype.Service;

import cz.zeptejsepojistovaka.domainmodel.User;
import cz.zeptejsepojistovaka.domainmodel.builder.UnverifiedMessageAuthorBuilder;

@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
class DbInitializer {

    private static UserRepository userRepository;
    private static AnswerRepository answerRepository;

    static {
        injectBeans();
        trancateAffectedTables();
        insertUsers();
    }

    @SuppressWarnings("resource")
    private static void injectBeans() {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(
                "cz.zeptejsepojistovaka.persistence");
        userRepository = context.getBean(UserRepository.class);
        answerRepository = context.getBean(AnswerRepository.class);
    }

    private static void trancateAffectedTables() {
    }

    private static void insertUsers() {
        List<User> users = new ArrayList<User>();
        users.add(UnverifiedMessageAuthorBuilder.unverifiedMessageAuthorBuilder()
                .withEmail("message.author@abc.com").build());
        userRepository.save(users);
    }
}
