package cz.zeptejsepojistovaka.businesslogic;

import java.sql.Timestamp;

import cz.zeptejsepojistovaka.commons.util.TimestampUtils;
import cz.zeptejsepojistovaka.domainmodel.AbstractContribution;

/**
 * @author <a href="mailto:skalicky.tomas@gmail.com">Tomas Skalicky</a>
 */
public abstract class AbstractContributionService {

    protected void setUpTimestamps(AbstractContribution contribution) {
        setUpTimestamps(contribution, TimestampUtils.getNowFlooredToSec());
    }

    protected void setUpTimestamps(AbstractContribution contribution, Timestamp timestamp) {
        if (contribution.isPersistedInStorage()) {
            setUpUpdateTimestamps(contribution, timestamp);
        } else {
            setUpCreationTimestamps(contribution, timestamp);
        }
    }

    private void setUpCreationTimestamps(AbstractContribution contribution, Timestamp timestamp) {
        contribution.setCreationTime(timestamp);
        contribution.setLastUpdateTime(timestamp);
    }

    private void setUpUpdateTimestamps(AbstractContribution contribution, Timestamp timestamp) {
        contribution.setLastUpdateTime(timestamp);
    }
}
