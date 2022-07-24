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
        assertEquals("[Projects{title=pj1, client=MS003, period=07/18/2022 - "
                + "08/23/2022, rate=10000.0, manager=NK006, description=Demo, "
                + "status=0}, Projects{title=pj2, client=JD002, period=07/18/2022"
                + " - 09/10/2022, rate=10000.0, manager=NK006, description=Demo,"
                + " status=0}]", dao.listProject().toString());
    }

    /**
     * Test of getP method, of class DAOProject.
     */
    @Test
    public void testGetProject() {
        assertEquals("Projects{title=pj1, client=MS003, period=07/18/2022 - "
                + "08/23/2022, rate=10000.0, manager=NK006, description=Demo, "
                + "status=0}", dao.getProject("pj1").toString());
    }

    /**
     * Test of addProject method, of class DAOProject.
     */
    @Test
    public void testAddProject() {
        assertTrue(dao.addProject("Test", "MS003", "30/06/2022 - 17/8/2022", 10000, "NK006", "demo test"));
    }

    /**
     * Test of deleteProject method, of class DAOProject.
     */
    @Test
    public void testDeleteProject() {
        assertTrue(dao.deleteProject("Test"));
    }

    /**
     * Test of updateProject method, of class DAOProject.
     */
    @Test
    public void testUpdateProject() {
        assertTrue(dao.updateProject("Test", "NewTest", "MS003", "30/06/2022 - 17/8/2022", 15000, "NK006", "demo test", 1));
    }

    /**
     * Test of searchProject method, of class DAOProject.
     */
    @Test
    public void testSearchProject() {
        assertEquals("[Projects{title=pj1, client=MS003, period=07/18/2022 - "
                + "08/23/2022, rate=10000.0, manager=NK006, description=Demo, "
                + "status=0}]", dao.searchProject("pj1").toString());
    }   
}
