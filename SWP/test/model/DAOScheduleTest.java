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
        //assertTrue(dao.addSchedule("KUGHY", "morning afternoon"));
    }

    /**
     * Test of checkExist method, of class DAOSchedule.
     */
//    @Test
//    public void testCheckExist() {
//        assertTrue(dao.checkExist("KUGHY"));
//    }   
// 
    /**
     * Test of listAllScheduleOfStaff method, of class DAOSchedule.
     */
    @Test
    public void testListStaffWithSchedule() {
        assertEquals("[schedule{profile=KUGHY}]", dao.listStaffWithSchedule().toString());
    }

    /**
     * Test of searchSchedule method, of class DAOSchedule.
     */
    @Test
    public void testSearchSchedule() {
        assertEquals("[schedule{profile=KUGHY}]", dao.searchSchedule("Joe").toString());
    }

    /**
     * Test of updateSchedule method, of class DAOSchedule.
     */
    @Test
    public void testUpdateSchedule() {
        assertTrue(dao.updateSchedule("KUGHY", "morning"));
    }
    
}
