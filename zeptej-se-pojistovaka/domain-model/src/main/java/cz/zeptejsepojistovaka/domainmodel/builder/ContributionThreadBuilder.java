package cz.zeptejsepojistovaka.domainmodel.builder;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import cz.zeptejsepojistovaka.domainmodel.ContributionThread;
import cz.zeptejsepojistovaka.domainmodel.Question;
import cz.zeptejsepojistovaka.domainmodel.Tag;

/**
 * @author <a href="mailto:skalicky.tomas@gmail.com">Tomas Skalicky</a>
 */
public class ContributionThreadBuilder {

    private final ContributionThread thread = new ContributionThread();

    private ContributionThreadBuilder() {
    }

    public static ContributionThreadBuilder newThread() {
        return new ContributionThreadBuilder();
    }

    public ContributionThreadBuilder with(List<Tag> tags) {
        this.thread.setTags(tags);
        return this;
    }

    public ContributionThreadBuilder with(Question question) {
        this.thread.setQuestion(question);
        return this;
    }

    public ContributionThreadBuilder withThema(String thema) {
        this.thread.setThema(thema);
        return this;
    }

    public ContributionThreadBuilder withLastChangeTime(Timestamp lastChangeTime) {
        this.thread.setLastChangeTime(lastChangeTime);
        return this;
    }

    public ContributionThread build() {
        avoidConstraintViolations();
        return this.thread;
    }

    private void avoidConstraintViolations() {
        if (this.thread.getTags() == null) {
            this.thread.setTags(new ArrayList<Tag>());
        }
    }
}
