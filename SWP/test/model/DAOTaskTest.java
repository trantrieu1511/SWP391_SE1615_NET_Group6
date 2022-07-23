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
public class DAOTaskTest {
    
    DAOTask dao = new DAOTask();
    
    public DAOTaskTest() {
    }

    /**
     * Test of addTask method, of class DAOTask.
     */
    @Test
    public void testAdd() {
        assertTrue(dao.addTask("test", 0, "07/07/2022", 0, "GG007", "pj1"));
    }


    /**
     * Test of listTaskByStatus method, of class DAOTask.
     */
    @Test
    public void testList() {
        assertEquals("[task{name=test, priority=0, deadline=07/07/2022, status=2,"
                + " assigned=KUGHY, project=Test}]", dao.listTaskByStatus(2).toString());
    }

    /**
     * Test of listProjectTask method, of class DAOTask.
     */
    @Test
    public void testListProjectTask() {
        assertEquals("[task{name=test, priority=0, deadline=07/07/2022, status=2,"
                + " assigned=KUGHY, project=Test}]", dao.listProjectTask(2, "Test").toString());
    }

    /**
     * Test of updateStatus method, of class DAOTask.
     */
    @Test
    public void testUpdateStatus() {
        assertTrue(dao.updateStatus(2,0));
    }
    
}
