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
public class DAOShiftTest {
    
    DAOShift dao = new DAOShift();
    
    public DAOShiftTest() {
    }

    /**
     * Test of listShift method, of class DAOShift.
     */
    @Test
    public void testListShift() {
        assertEquals("[shift{name=afternoon shift, start_time=1:30, end_time=5:00}, "
                + "shift{name=morning shift, start_time=8:30, end_time=11:30}]", 
                dao.listShift().toString());        
    }

    /**
     * Test of addShift method, of class DAOShift.
     */
    @Test
    public void testAdd() {
        //assertTrue(dao.addShift("morning", "8:30", "11:30"));
    }

    /**
     * Test of editShift method, of class DAOShift.
     */
    @Test
    public void testEdit() {
        //assertTrue(dao.editShift("morning-shift", "8:30", "11:30", "morning"));
    }

    /**
     * Test of deleteShift method, of class DAOShift.
     */
    @Test
    public void testDelete() {
        //assertTrue(dao.deleteShift("morning-shift"));
    }

}
