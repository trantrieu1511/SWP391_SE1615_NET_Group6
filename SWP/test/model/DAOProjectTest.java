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
    public void testGetProject1() {
        assertEquals("[projects{title=pj1, client=2    , start_date=16/06/2022, "
                + "end_date=05/07/2022, rate=10000.0, manager=ABCDE, "
                + "description=N/A}, projects{title=pj20, client=1    , "
                + "start_date=20/06/2022, end_date=30/07/2022, rate=10000.0, "
                + "manager=ABCDE, description=<p>Demo</p>}, projects{title=pj22, "
                + "client=1    , start_date=20/06/2022, end_date=30/07/2022, "
                + "rate=10000.0, manager=ABCDE, description=<p>Demo</p>},"
                + " projects{title=pj3, client=1    , start_date=15/06/2022,"
                + " end_date=23/06/2022, rate=0.0, manager=ABCDE, "
                + "description=<p>demo</p>}, projects{title=pj4, client=1    ,"
                + " start_date=30/05/2022, end_date=30/06/2022, rate=0.0, "
                + "manager=ABCDE, description=<p>Demo</p>}, projects{title=pj5, "
                + "client=1    , start_date=01/06/2022, end_date=08/07/2022, "
                + "rate=10000.0, manager=ABCDE, description=<p>Demo</p>},"
                + " projects{title=pj6, client=2    , start_date=15/06/2022, "
                + "end_date=16/06/2022, rate=1000.0, manager=ABCDE, "
                + "description=<p>Demo</p>}, projects{title=pj9, client=1    , "
                + "start_date=15/06/2022, end_date=24/06/2022, rate=10000.0, "
                + "manager=ABCDE, description=<p>Demo</p>}, "
                + "projects{title=project_demo, client=1    , start_date=20/06/2022, "
                + "end_date=30/06/2022, rate=10000.0, manager=ABCDE, description=}, "
                + "projects{title=Qutsor, client=1    , start_date=20/06/2022,"
                + " end_date=30/07/2022, rate=10000.0, manager=ABCDE, "
                + "description=<p>Demo</p>}, projects{title=tiuwq2, client=1    "
                + ", start_date=20/06/2022, end_date=30/07/2022, rate=10000.0, "
                + "manager=ABCDE, description=<p>Demo</p>}, projects{title=utusdh, "
                + "client=1    , start_date=20/06/2022, end_date=30/07/2022, "
                + "rate=10000.0, manager=ABCDE, description=<p>Demo</p>}]",
                dao.getProject("ABCDE").toString());
    }

    @Test
    public void testgetProject2() {
        assertEquals("[]", dao.getProject("79852").toString());
    }

    /**
     * Test of getP method, of class DAOProject.
     */
    @Test
    public void testGetP1() {
        assertEquals("projects{title=pj3, client=1    , start_date=15/06/2022,"
                + " end_date=23/06/2022, rate=0.0, manager=ABCDE, description=<p>demo</p>}",
                dao.getP("pj3").toString());
    }

    @Test
    public void testGetP2() {
        assertNull(dao.getP("24962"));
    }

    /**
     * Test of addProject method, of class DAOProject.
     */
    @Test
    public void testAddProject1() {
        //assertTrue(dao.addProject("tiuwq2", "1    ","20/06/2022", "30/07/2022", 10000, "ABCDE", "<p>Demo</p>"));
    }

    @Test
    public void testAddProject2() {
        assertFalse(dao.addProject("tiuwq2", "1    ", "20/06/2022 - 30/07/2022", 10000, "ABCDE", "<p>Demo</p>"));
    }

    @Test
    public void testAddProject3() {
        assertFalse(dao.addProject("flhwoifwh", "1    ", "20/06/2022 - 30/07/2022", 10000, "yigd", "<p>Demo</p>"));
    }

    /**
     * Test of deleteProject method, of class DAOProject.
     */
    @Test
    public void testDeleteProject() {
        //assertTrue(dao.deleteProject("pj18"));
    }

    /**
     * Test of updateProject method, of class DAOProject.
     */
    @Test
    public void testUpdateProject() {
        //assertTrue(dao.updateProject("project_demo", "1", "20/06/2022", "30/06/2022", 10000, "ABCDE", ""));      
    }

    /**
     * Test of search method, of class DAOProject.
     */
    @Test
    public void testSearch1() {
        assertEquals("[projects{title=project_demo, client=1    , start_date=20/06/2022, "
                + "end_date=30/06/2022, rate=10000.0, manager=ABCDE, description=}]",
                dao.search("pro", "ABCDE").toString());
    }

    @Test
    public void testSearch2() {
        assertEquals("[]", dao.search("pro", "8381242").toString());
    }

    @Test
    public void testSearch3() {
        assertEquals("[]", dao.search("ybc", "ABCDE").toString());
    }

    /**
     * Test of getProject method, of class DAOProject.
     */
    @Test
    public void testGetProject() {
    }

    /**
     * Test of getP method, of class DAOProject.
     */
    @Test
    public void testGetP() {
    }

    /**
     * Test of addProject method, of class DAOProject.
     */
    @Test
    public void testAddProject() {
    }

    /**
     * Test of search method, of class DAOProject.
     */
    @Test
    public void testSearch() {
    }

    /**
     * Test of main method, of class DAOProject.
     */
    @Test
    public void testMain() {
    }

}
