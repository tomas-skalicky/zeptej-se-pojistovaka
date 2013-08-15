package cz.zeptejsepojistovaka.domainmodel;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RightTypeTest {

    @Test
    public void testGetTypeWithDev() throws Exception {
        assertEquals(RightType.ADD_TAG, RightType.getType(3));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetTypeWithDevelopment() throws Exception {
        RightType.getType(6);
    }
}
