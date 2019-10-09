package ua;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static ua.training.controller.util.Util.*;

public class CheckPathTest {


    @Test
    public void testGetActionFromURI() {

        assertEquals("cruiseCompany", getActionFromURI("/cruiseCompany"));
        assertEquals("cruise", getActionFromURI("/cruiseCompany/cruise"));
        assertEquals("cruise", getActionFromURI("/cruiseCompany/cruise/2"));
        assertEquals(2, getIdFromURI("/cruiseCompany/cruise/2"));
        assertEquals("cart", getActionFromURI("/cruiseCompany/cart"));
        assertEquals("countryadd", getActionFromURI("/cruiseCompany/countryadd"));
        assertEquals(5, getPage(10, 2));
    }
}
