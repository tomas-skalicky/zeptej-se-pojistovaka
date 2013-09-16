package cz.zeptejsepojistovaka.businesslogic;

import cz.zeptejsepojistovaka.commons.util.TimestampUtils;
import cz.zeptejsepojistovaka.domainmodel.AbstractContribution;

/**
 * @author <a href="mailto:skalicky.tomas@gmail.com">Tomas Skalicky</a>
 */
public abstract class AbstractContributionService {

    protected void setUpTimestamps(AbstractContribution contribution) {
        if (contribution.getId() == null) {
            setUpCreationTimestamps(contribution);
        } else {
            setUpUpdateTimestamps(contribution);
        }
    }

    private void setUpCreationTimestamps(AbstractContribution contribution) {
        contribution.setCreationTimestamp(TimestampUtils.getNow());
        contribution.setLastUpdateTimestamp(contribution.getCreationTimestamp());
    }

    private void setUpUpdateTimestamps(AbstractContribution contribution) {
        contribution.setLastUpdateTimestamp(TimestampUtils.getNow());
    }
}
