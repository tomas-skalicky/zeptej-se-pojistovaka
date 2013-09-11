package cz.zeptejsepojistovaka.commons.util;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author <a href="mailto:skalicky.tomas@gmail.com">Tomas Skalicky</a>
 */
public final class ArrayUtils {

    private ArrayUtils() {
    }

    /**
     * Sorts the given {@code items} according to a standard {@link Comparator} of the {@code T} type. The
     * method is {@code null}-tolerant, i.e. it does not throw {@link NullPointerException} due to a null
     * item.
     */
    public static <T extends Comparable<T>> Object[] sort(T... items) {
        List<T> itemList = Arrays.asList(items);
        Collections.sort(itemList, new Comparator<T>() {

            @Override
            public int compare(T obj1, T obj2) {
                if (obj1 == null) {
                    return -1;
                }
                if (obj2 == null) {
                    return 1;
                }
                return obj1.compareTo(obj2);
            }
        });
        return itemList.toArray();
    }
}
