package cz.zeptejsepojistovaka.commons.util;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author <a href="mailto:skalicky.tomas@gmail.com">Tomas Skalicky</a>
 */
public class ArrayUtilsTest {

    @Test
    public void testSort() throws Exception {
        assertArrayEquals(new String[] { "AAA", "BB" }, ArrayUtils.sort("BB", "AAA"));
    }

    @Test
    public void testSortWithNull() throws Exception {
        assertArrayEquals(new String[] { null, "AAA", "BB" }, ArrayUtils.sort("BB", null, "AAA"));
    }
}
