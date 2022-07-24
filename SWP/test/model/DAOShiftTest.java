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
        assertEquals("[shift{name=afternoon, start_time=1:30 PM, end_time=5:30 PM},"
                + " shift{name=evening, start_time=8:00 AM, end_time=11:30 PM},"
                + " shift{name=morning, start_time=8:30 AM, end_time=12:30 PM}]", 
                dao.listShift().toString());        
    }

    /**
     * Test of addShift method, of class DAOShift.
     */
    @Test
    public void testAdd() {
        assertTrue(dao.addShift("morning", "8:30 AM", "11:30 AM"));
    }

    /**
     * Test of editShift method, of class DAOShift.
     */
    @Test
    public void testEdit() {
        assertTrue(dao.editShift("morning", "8:30 AM", "12:30 PM", "morning"));
    }

    /**
     * Test of deleteShift method, of class DAOShift.
     */
    @Test
    public void testDelete() {
        //assertTrue(dao.deleteShift("morning"));
    }

}
