package cz.zeptejsepojistovaka.commons.util;

import java.sql.Timestamp;
import java.util.Date;

import cz.zeptejsepojistovaka.commons.TimeConstants;

/**
 * @author <a href="mailto:skalicky.tomas@gmail.com">Tomas Skalicky</a>
 */
public final class TimestampUtils {

    private TimestampUtils() {
    }

    public static Timestamp getNow() {
        return new Timestamp((new Date()).getTime());
    }

    /**
     * Gets the current time floored to seconds. The function calls a function similar to
     * {@link Math#floor(double)}.
     * <p>
     * <b>NOTE:</b> The function is often called by persisting methods which must cope with time. There can be
     * a check whether "creation time" or "last save time" of a particular record is really in the past.
     * Therefore, flooring is better than rounding, but naturally not so precise.
     */
    public static Timestamp getNowFlooredToSec() {
        return new Timestamp(LongUtils.floor(TimestampUtils.getNow().getTime(),
                TimeConstants.MILLISEC_TO_SEC_ROUNDING_ORDER));
    }
}
