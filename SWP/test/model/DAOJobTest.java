/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Jobs;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author DELL
 */
public class DAOJobTest {
    
    public DAOJobTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of listAllJob method, of class DAOJob.
     */
    @Test
    public void testListAllJob() {
        System.out.println("listAllJob");
        DAOJob instance = new DAOJob();
        List<Jobs> expResult = null;
        List<Jobs> result = instance.listAllJob();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getJobByTitle method, of class DAOJob.
     */
    @Test
    public void testGetJobByTitle() {
        System.out.println("getJobByTitle");
        String title = "";
        DAOJob instance = new DAOJob();
        Jobs expResult = null;
        Jobs result = instance.getJobByTitle(title);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getJobById method, of class DAOJob.
     */
    @Test
    public void testGetJobById() {
        System.out.println("getJobById");
        int id = 0;
        DAOJob instance = new DAOJob();
        Jobs expResult = null;
        Jobs result = instance.getJobById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addJob method, of class DAOJob.
     */
    @Test
    public void testAddJob() {
        System.out.println("addJob");
        String title = "AI";
        double min = 0.0;
        double max = 0.0;
        DAOJob instance = new DAOJob();
        boolean expResult = true;
        boolean result = instance.addJob(title, min, max);
        assertEquals(expResult, result);
    }

    /**
     * Test of editJob method, of class DAOJob.
     */
    @Test
    public void testEditJob() {
        System.out.println("editJob");
        int id = 1;
        String title = "Web Design";
        double min = 1.0;
        double max = 2.0;
        DAOJob instance = new DAOJob();
        boolean expResult = true;
        boolean result = instance.editJob(id, title, min, max);
        assertEquals(expResult, result);
    }
    
}
