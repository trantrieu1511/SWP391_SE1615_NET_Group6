/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Khanh
 */
public class DAOProjectTest {

    DAOProject dao = new DAOProject();

    public DAOProjectTest() {
    }

    /**
     * Test of getProject method, of class DAOProject.
     */
    @Test
    public void testGetProject1() {
        assertEquals("projects{title=Project, client=ZXCVB, start_date=2022-06-14, "
                + "end_date=2022-06-30, rate=10000.0, manager=12345, description=N/A}",
                dao.getProject("12345").toString());
    }

    @Test
    public void testGetProject2() {
        assertNull(dao.getProject("86495"));
    }

    /**
     * Test of addProject method, of class DAOProject.
     */
    @Test
    public void testAddProject1() {
        assertTrue(dao.addProject("test", "ZXCVB", "01/01/2001", "01/01/2001", 0, "12345", "N/A"));
    }

    @Test
    public void testAddProject2() {
        assertFalse(dao.addProject("test", "00000", "01/01/2001", "01/01/2001", 0, "12345", "N/A"));
    }

    @Test
    public void testAddProject3() {
        assertFalse(dao.addProject("test", "ZXCVB", "01/01/2001", "01/01/2001", 0, "00000", "N/A"));
    }
}
