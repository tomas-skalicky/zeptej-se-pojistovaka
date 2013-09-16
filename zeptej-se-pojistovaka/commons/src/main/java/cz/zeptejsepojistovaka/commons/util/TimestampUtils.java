package cz.zeptejsepojistovaka.commons.util;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @author <a href="mailto:skalicky.tomas@gmail.com">Tomas Skalicky</a>
 */
public final class TimestampUtils {

    private TimestampUtils() {
    }

    public static Timestamp getNow() {
        return new Timestamp((new Date()).getTime());
    }
}
