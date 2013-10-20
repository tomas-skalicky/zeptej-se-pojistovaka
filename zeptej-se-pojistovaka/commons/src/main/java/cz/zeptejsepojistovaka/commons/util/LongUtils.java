package cz.zeptejsepojistovaka.commons.util;

/**
 * @author <a href="mailto:skalicky.tomas@gmail.com">Tomas Skalicky</a>
 */
public final class LongUtils {

    private LongUtils() {
    }

    /**
     * Gets the given {@code number} rounded to the given order (10^order).
     * 
     * <pre>
     * Example:
     *   LongUtils.round(29, 0) = 29
     *   LongUtils.round(29, 1) = 20
     *   LongUtils.round(29, 2) =  0
     * </pre>
     */
    public static long floor(long number, int roundingOrder) {
        long poweredOrder = (long) Math.pow(10, roundingOrder);

        // If number = 29 and roundingOrder = 1, base = 2
        long base = number / poweredOrder;

        return base * poweredOrder;
    }
}
