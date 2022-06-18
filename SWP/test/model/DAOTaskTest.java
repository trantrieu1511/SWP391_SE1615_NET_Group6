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
     * Test of add method, of class DAOTask.
     */
    @Test
    public void testAdd1() {
        //assertTrue(dao.add("task-demo", 0, "20/06/2022", 0, "QWERT", "project_demo"));
    }
    
    @Test
    public void testAdd2() {
        assertFalse(dao.add("task-demo", 0, "20/06/2022", 0, "24344", "project_demo"));
    }
    
    @Test
    public void testAdd3() {
        assertFalse(dao.add("task-demo", 0, "20/06/2022", 0, "QWERT", "0650295"));
    }

    /**
     * Test of list method, of class DAOTask.
     */
    @Test
    public void testList1() {
        assertEquals("[task{name=task-demo, priority=0, deadline=20/06/2022, "
                + "status=0, assigned=QWERT, project=project_demo}, task{name=task-demo,"
                + " priority=0, deadline=20/06/2022, status=0, assigned=QWERT,"
                + " project=project_demo}, task{name=task-demo, priority=0,"
                + " deadline=20/06/2022, status=0, assigned=QWERT, project=project_demo}, "
                + "task{name=task-demo, priority=0, deadline=20/06/2022, status=0, "
                + "assigned=QWERT, project=project_demo}]", dao.list(0).toString());
    }
    
    @Test
    public void testList2() {
        assertEquals("[]", dao.list(1).toString());
    }
               
}
