package cz.zeptejsepojistovaka.commons.util;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author <a href="mailto:skalicky.tomas@gmail.com">Tomas Skalicky</a>
 */
public class LongUtilsTest {

    @Test
    public void testGetNowRoundedToSecWithOrder0() throws Exception {
        assertEquals(29, LongUtils.floor(29, 0));
    }

    @Test
    public void testGetNowRoundedToSecWithOrder1() throws Exception {
        assertEquals(20, LongUtils.floor(29, 1));
    }

    @Test
    public void testGetNowRoundedToSecWithOrder2() throws Exception {
        assertEquals(0, LongUtils.floor(29, 2));
    }
}
