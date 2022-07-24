/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Khanh
 */
public class DAOScheduleTest {
    
    DAOSchedule dao = new DAOSchedule();
    
    public DAOScheduleTest() {
    }

    /**
     * Test of addSchedule method, of class DAOSchedule.
     */
    @Test
    public void testAddSchedule() {
        //assertTrue(dao.addSchedule("GG007", "morning afternoon"));
    }
 
    /**
     * Test of listAllScheduleOfStaff method, of class DAOSchedule.
     */
    @Test
    public void testListStaffWithSchedule() {
        assertEquals("[Schedule{profile=GG007, shift=morning}]", 
                dao.listStaffWithSchedule().toString());
    }

    /**
     * Test of searchSchedule method, of class DAOSchedule.
     */
    @Test
    public void testSearchSchedule() {
        assertEquals("[Schedule{profile=GG007, shift=morning}]",
                dao.searchSchedule("Gio").toString());
    }

    /**
     * Test of updateSchedule method, of class DAOSchedule.
     */
    @Test
    public void testUpdateSchedule() {
        assertTrue(dao.updateSchedule("GG007", "morning"));
    }
    
    @Test
    public void testGetStaffSchedule() {
        assertEquals("Schedule{profile=GG007, shift=morning}",
                dao.getStaffSchedule("GG007").toString());
    }
}
