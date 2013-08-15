package cz.zeptejsepojistovaka.commons;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ProfileTest {

    @Test
    public void testGetTypeWithDev() throws Exception {
        assertEquals(Profile.DEV, Profile.getType("dEv"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetTypeWithDevelopment() throws Exception {
        Profile.getType("DEVELOPMENT");
    }
}
