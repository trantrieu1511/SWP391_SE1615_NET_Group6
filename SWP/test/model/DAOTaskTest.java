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
    public void testAddTask() {
        //assertTrue(dao.addTask("test", 0, "07/07/2022", 0, "GG007", "pj1"));
    }
    
    /**
     * Test of editTask method, of class DAOTask.
     */
    @Test
    public void testEditTask() {
        //assertTrue(dao.editTask(3, "Test", 2, "19/07/2022", "GG007"));
    }
    
    /**
     * Test of deleteTask method, of class DAOTask.
     */
    @Test
    public void testDeleteTask() {
        //assertTrue(dao.deleteTask(3));
    }

    /**
     * Test of getTaskById method, of class DAOTask.
     */
    @Test
    public void testGetTaskById() {
        assertEquals("Task{id=1, name=task, priority=1, deadline=19/07/2022, "
                + "status=0, assigned=GG007, project=pj1}", 
                dao.getTaskById(1).toString());
    }
    
    /**
     * Test of listAllTask method, of class DAOTask.
     */
    @Test
    public void testListAllTask() {
        assertEquals("[Task{id=1, name=task, priority=1, deadline=19/07/2022, "
                + "status=0, assigned=GG007, project=pj1}, Task{id=2, name=task 2"
                + ", priority=1, deadline=01/08/2022, status=2, assigned=GG007, "
                + "project=pj2}]", dao.listAllTask().toString());
    }
    
    /**
     * Test of listProjectTask method, of class DAOTask.
     */
    @Test
    public void testListProjectTask_String() {
        assertEquals("[Task{id=1, name=task, priority=1, deadline=19/07/2022,"
                + " status=0, assigned=GG007, project=pj1}]", 
                dao.listProjectTask("pj1").toString());
    }
    
    /**
     * Test of listProjectTask method, of class DAOTask.
     */
    @Test
    public void testListProjectTask_int_String() {
        assertEquals("[Task{id=1, name=task, priority=1, deadline=19/07/2022, "
                + "status=0, assigned=GG007, project=pj1}]", 
                dao.listProjectTask(0, "pj1").toString());
    }    
    
    /**
     * Test of listTaskAssignedTo method, of class DAOTask.
     */
    @Test
    public void testListTaskAssignedTo_String() {
        assertEquals("[Task{id=1, name=task, priority=1, deadline=19/07/2022,"
                + " status=0, assigned=GG007, project=pj1}, Task{id=2, name=task 2,"
                + " priority=1, deadline=01/08/2022, status=2, assigned=GG007, "
                + "project=pj2}]", dao.listTaskAssignedTo("GG007").toString());
    }
    
    /**
     * Test of listTaskAssignedTo method, of class DAOTask.
     */
    @Test
    public void testListTaskAssignedTo_String_int() {
        assertEquals("[Task{id=1, name=task, priority=1, deadline=19/07/2022, status=0,"
                + " assigned=GG007, project=pj1}]", 
                dao.listTaskAssignedTo("GG007", 0).toString());
    }
    
    /**
     * Test of listTaskByStatus method, of class DAOTask.
     */
    @Test
    public void testListTaskByStatus() {
        assertEquals("[Task{id=1, name=task, priority=1, deadline=19/07/2022, "
                + "status=0, assigned=GG007, project=pj1}]",
                dao.listTaskByStatus(0).toString());
    }

    /**
     * Test of updateStatus method, of class DAOTask.
     */
    @Test
    public void testUpdateStatus() {
        assertTrue(dao.updateStatus(2,2));
    }   
    
}
