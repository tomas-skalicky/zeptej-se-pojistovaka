package cz.zeptejsepojistovaka.persistence.test;

import java.sql.Timestamp;
import java.util.Arrays;

import javax.inject.Inject;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import cz.zeptejsepojistovaka.commons.util.TimestampUtils;
import cz.zeptejsepojistovaka.domainmodel.Answer;
import cz.zeptejsepojistovaka.domainmodel.ContributionAuthor;
import cz.zeptejsepojistovaka.domainmodel.ContributionThread;
import cz.zeptejsepojistovaka.domainmodel.Question;
import cz.zeptejsepojistovaka.domainmodel.RightType;
import cz.zeptejsepojistovaka.domainmodel.builder.AnswerBuilder;
import cz.zeptejsepojistovaka.domainmodel.builder.ContributionThreadBuilder;
import cz.zeptejsepojistovaka.domainmodel.builder.QuestionBuilder;
import cz.zeptejsepojistovaka.domainmodel.builder.UnverifiedContributionAuthorBuilder;
import cz.zeptejsepojistovaka.domainmodel.builder.UnverifiedMessageAuthorBuilder;
import cz.zeptejsepojistovaka.domainmodel.builder.VerifiedUserBuilder;
import cz.zeptejsepojistovaka.persistence.repository.ContributionThreadRepository;
import cz.zeptejsepojistovaka.persistence.repository.CustomVerifiedUserRepository;
import cz.zeptejsepojistovaka.persistence.repository.RightRepository;
import cz.zeptejsepojistovaka.persistence.repository.UnverifiedContributionAuthorRepository;
import cz.zeptejsepojistovaka.persistence.repository.UnverifiedMessageAuthorRepository;
import cz.zeptejsepojistovaka.persistence.repository.VerifiedUserRepository;

@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class DbInitializer {

    private static final String UNVERIFIED_CONTRIBUTION_AUTHOR_2_NAME = "Test Author Name";
    private static final String UNVERIFIED_CONTRIBUTION_AUTHOR_2_EMAIL = "contribution.author@abc.com";
    private static final String VERIFIED_USER_1_EMAIL = "tomsky@seznam.cz";
    private static final String VERIFIED_USER_2_EMAIL = "tomas.skalicky@gfk.com";
    private static final String VERIFIED_USER_3_NAME = "Tomas";

    @Inject
    private VerifiedUserRepository verifiedUserRepository;

    @Inject
    private UnverifiedContributionAuthorRepository unverifiedContributionAuthorRepository;

    @Inject
    private UnverifiedMessageAuthorRepository unverifiedMessageAuthorRepository;

    @Inject
    private CustomVerifiedUserRepository customVerifiedUserRepository;

    @Inject
    private ContributionThreadRepository contributionThreadRepository;

    @Inject
    private RightRepository rightRepository;

    public void initDatabase() {
        trancateAffectedTables();
        insertUsers();
        insertThreads();
    }

    private void trancateAffectedTables() {
        this.rightRepository.deleteAll();
        this.verifiedUserRepository.deleteAll();
        this.unverifiedContributionAuthorRepository.deleteAll();
        this.unverifiedMessageAuthorRepository.deleteAll();
        this.contributionThreadRepository.deleteAll();
    }

    private void insertUsers() {
        this.unverifiedMessageAuthorRepository.save(UnverifiedMessageAuthorBuilder
                .newUnverifiedMessageAuthor().withEmail("message.author@abc.com").build());

        this.unverifiedContributionAuthorRepository.save(UnverifiedContributionAuthorBuilder
                .newUnverifiedContributionAuthor().build());

        this.customVerifiedUserRepository.saveWithRights(VerifiedUserBuilder.newVerifiedUser()
                .withName("Tomáš Skalický").withEmail(VERIFIED_USER_1_EMAIL).withIsMale(true)
                .withPasswordHash("XYZ").add(RightType.ASK_QUESTION).add(RightType.SEND_MESSAGE).build());
        this.customVerifiedUserRepository.saveWithRights(VerifiedUserBuilder.newVerifiedUser()
                .withName("Tomas Skalicky").withEmail(VERIFIED_USER_2_EMAIL).withIsMale(true)
                .withPasswordHash("XYZ").add(RightType.SEND_MESSAGE).withEnabled(false).build());

        this.unverifiedMessageAuthorRepository.save(UnverifiedMessageAuthorBuilder
                .newUnverifiedMessageAuthor().withName("Test Author Name")
                .withEmail("message.author@abc.com").build());

        this.unverifiedContributionAuthorRepository.save(UnverifiedContributionAuthorBuilder
                .newUnverifiedContributionAuthor().withName(UNVERIFIED_CONTRIBUTION_AUTHOR_2_NAME)
                .withEmail(UNVERIFIED_CONTRIBUTION_AUTHOR_2_EMAIL).build());

        this.customVerifiedUserRepository.saveWithRights(VerifiedUserBuilder.newVerifiedUser()
                .withName(VERIFIED_USER_3_NAME).withEmail("skalicky.tomas@gmail.com").withIsMale(false)
                .withPasswordHash("password").withEnabled(true).build());
    }

    private void insertThreads() {
        insertThreadWithNoAnswer();
        insertThreadWithOneAnswer();
        insertThreadWithTwoAnswers();
        insertThread4to21();
    }

    private void insertThreadWithNoAnswer() {
        Timestamp lastChangeTime = TimestampUtils.getNowFlooredToSec();
        ContributionThread thread = ContributionThreadBuilder.newThread().withThema("thema with NO answer")
                .withLastChangeTime(lastChangeTime).build();

        ContributionAuthor questionAuthor = this.unverifiedContributionAuthorRepository.findByEmail(
                UNVERIFIED_CONTRIBUTION_AUTHOR_2_EMAIL).get(0);
        Timestamp questionCreationTime = new Timestamp(lastChangeTime.getTime() - DateUtils.MILLIS_PER_DAY);
        Timestamp questionLastUpdateTime = lastChangeTime;
        Question question = QuestionBuilder.newQuestion().with(questionAuthor)
                .withText("question with NO answer").with(thread).withCreationTime(questionCreationTime)
                .withLastUpdateTime(questionLastUpdateTime).build();
        thread.setQuestion(question);

        this.contributionThreadRepository.save(thread);
    }

    private void insertThreadWithOneAnswer() {
        Timestamp lastChangeTime = TimestampUtils.getNowFlooredToSec();
        ContributionThread thread = ContributionThreadBuilder.newThread().withThema("thema with ONE answer")
                .withLastChangeTime(lastChangeTime).build();

        ContributionAuthor questionAuthor = this.verifiedUserRepository.findByEmail(VERIFIED_USER_2_EMAIL);
        Timestamp questionCreationTime = new Timestamp(lastChangeTime.getTime() - DateUtils.MILLIS_PER_DAY);
        Timestamp questionLastUpdateTime = new Timestamp(questionCreationTime.getTime()
                + DateUtils.MILLIS_PER_HOUR);
        Question question = QuestionBuilder.newQuestion().with(questionAuthor)
                .withText("question with ONE answer").with(thread).withCreationTime(questionCreationTime)
                .withLastUpdateTime(questionLastUpdateTime).build();
        thread.setQuestion(question);

        ContributionAuthor answerAuthor = this.verifiedUserRepository.findByEmail(VERIFIED_USER_1_EMAIL);
        Timestamp answerCreationTime = new Timestamp(lastChangeTime.getTime() - DateUtils.MILLIS_PER_HOUR);
        Timestamp answerLastUpdateTime = lastChangeTime;
        Answer answer = AnswerBuilder.newAnswer().with(answerAuthor)
                .withText("the only answer of a question").with(thread).withCreationTime(answerCreationTime)
                .withLastUpdateTime(answerLastUpdateTime).with(question).build();
        question.setAnswers(Arrays.asList(answer));

        this.contributionThreadRepository.save(thread);
    }

    private void insertThreadWithTwoAnswers() {
        Timestamp lastChangeTime = TimestampUtils.getNowFlooredToSec();
        ContributionThread thread = ContributionThreadBuilder.newThread().withThema("thema with TWO answers")
                .withLastChangeTime(lastChangeTime).build();

        ContributionAuthor questionAuthor = this.unverifiedContributionAuthorRepository.findByName(
                UNVERIFIED_CONTRIBUTION_AUTHOR_2_NAME).get(0);
        Timestamp questionCreationTime = new Timestamp(lastChangeTime.getTime() - DateUtils.MILLIS_PER_DAY);
        Timestamp questionLastUpdateTime = new Timestamp(questionCreationTime.getTime()
                + DateUtils.MILLIS_PER_HOUR);
        Question question = QuestionBuilder.newQuestion().with(questionAuthor)
                .withText("question with TWO answers").with(thread).withCreationTime(questionCreationTime)
                .withLastUpdateTime(questionLastUpdateTime).build();
        thread.setQuestion(question);

        ContributionAuthor answer1Author = this.verifiedUserRepository.findByName(VERIFIED_USER_3_NAME)
                .get(0);
        Timestamp answer1CreationTime = new Timestamp(lastChangeTime.getTime() - DateUtils.MILLIS_PER_HOUR);
        Timestamp answer1LastUpdateTime = lastChangeTime;
        Answer answer1 = AnswerBuilder.newAnswer().with(answer1Author)
                .withText("the first answer of a question").with(thread)
                .withCreationTime(answer1CreationTime).withLastUpdateTime(answer1LastUpdateTime)
                .with(question).build();

        ContributionAuthor answer2Author = this.verifiedUserRepository.findByEmail(VERIFIED_USER_2_EMAIL);
        Timestamp answer2CreationTime = new Timestamp(lastChangeTime.getTime() - DateUtils.MILLIS_PER_MINUTE);
        Timestamp answer2LastUpdateTime = answer2CreationTime;
        Answer answer2 = AnswerBuilder.newAnswer().with(answer2Author)
                .withText("the second answer of a question").with(thread)
                .withCreationTime(answer2CreationTime).withLastUpdateTime(answer2LastUpdateTime)
                .with(question).build();
        question.setAnswers(Arrays.asList(answer1, answer2));

        this.contributionThreadRepository.save(thread);
    }

    private void insertThread4to21() {
        for (int threadNo = 4; threadNo <= 21; ++threadNo) {
            Timestamp lastChangeTime = TimestampUtils.getNowFlooredToSec();
            ContributionThread thread = ContributionThreadBuilder.newThread()
                    .withThema("thema No. " + threadNo).withLastChangeTime(lastChangeTime).build();

            ContributionAuthor questionAuthor = this.unverifiedContributionAuthorRepository.findByEmail(
                    UNVERIFIED_CONTRIBUTION_AUTHOR_2_EMAIL).get(0);
            Timestamp questionCreationTime = lastChangeTime;
            Timestamp questionLastUpdateTime = lastChangeTime;
            Question question = QuestionBuilder.newQuestion().with(questionAuthor)
                    .withText("question No. " + threadNo).with(thread).withCreationTime(questionCreationTime)
                    .withLastUpdateTime(questionLastUpdateTime).build();
            thread.setQuestion(question);

            this.contributionThreadRepository.save(thread);

            try {
                // Waits ten milliseconds to produce DB tuples which have a unambiguously defined order.
                Thread.sleep(DateUtils.MILLIS_PER_SECOND);
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
