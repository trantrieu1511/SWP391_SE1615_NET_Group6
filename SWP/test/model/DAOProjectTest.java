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
public class DAOProjectTest {
    
    DAOProject dao = new DAOProject();
    
    public DAOProjectTest() {
    }

    /**
     * Test of getProject method, of class DAOProject.
     */
    @Test
    public void testListProject() {
        assertEquals("[projects{title=Test, client=BUKFS, period=30/06/2022 - "
                + "17/8/2022, rate=10000.0, manager=ABCDE, description=demo test},"
                + " projects{title=Test 2, client=BUKFS, period=30/06/2022 - 17/8/2022, "
                + "rate=100000.0, manager=ABCDE, description=demo test}]", 
                dao.listProject().toString());
    }

    /**
     * Test of getP method, of class DAOProject.
     */
    @Test
    public void testGetProject() {
        assertEquals("projects{title=Test, client=BUKFS, period=30/06/2022 - "
                + "17/8/2022, rate=10000.0, manager=ABCDE, description=demo test}",
                dao.getProject("Test").toString());
    }

    /**
     * Test of addProject method, of class DAOProject.
     */
    @Test
    public void testAddProject() {
        //assertTrue(dao.addProject("Test", "BUKFS", "30/06/2022 - 17/8/2022", 10000, "ABCDE", "demo test"));
    }

    /**
     * Test of deleteProject method, of class DAOProject.
     */
    @Test
    public void testDeleteProject() {
        //assertTrue(dao.deleteProject("NewTest"));
    }

    /**
     * Test of updateProject method, of class DAOProject.
     */
    @Test
    public void testUpdateProject() {
        //assertTrue(dao.updateProject("Test", "NewTest", "BUKFS", "30/06/2022 - 17/8/2022", 15000, "ABCDE", "demo test"));
    }

    /**
     * Test of search method, of class DAOProject.
     */
    @Test
    public void testSearch() {
        assertEquals("[projects{title=Test, client=BUKFS, period=30/06/2022 - "
                + "17/8/2022, rate=10000.0, manager=ABCDE, description=demo test}, "
                + "projects{title=Test 2, client=BUKFS, period=30/06/2022 - "
                + "17/8/2022, rate=100000.0, manager=ABCDE, description=demo test}]", 
                dao.search("Test").toString());
    }
    
}
