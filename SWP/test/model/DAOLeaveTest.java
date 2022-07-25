/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Leave;
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
public class DAOLeaveTest {
    
    public DAOLeaveTest() {
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
     * Test of listAllMyLeave method, of class DAOLeave.
     */
    @Test
    public void testListAllMyLeave() {
        System.out.println("listAllMyLeave");
        String id = "";
        DAOLeave instance = new DAOLeave();
        List<Leave> expResult = null;
        List<Leave> result = instance.listAllMyLeave(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listAllCheckLeaveAdmin method, of class DAOLeave.
     */
    @Test
    public void testListAllCheckLeaveAdmin() {
        System.out.println("listAllCheckLeaveAdmin");
        DAOLeave instance = new DAOLeave();
        List<Leave> expResult = null;
        List<Leave> result = instance.listAllCheckLeaveAdmin();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listAllCheckLeaveManager method, of class DAOLeave.
     */
    @Test
    public void testListAllCheckLeaveManager() {
        System.out.println("listAllCheckLeaveManager");
        String id = "";
        DAOLeave instance = new DAOLeave();
        List<Leave> expResult = null;
        List<Leave> result = instance.listAllCheckLeaveManager(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLeaveByID method, of class DAOLeave.
     */
    @Test
    public void testGetLeaveByID() {
        System.out.println("getLeaveByID");
        String profile_id = "";
        DAOLeave instance = new DAOLeave();
        Leave expResult = null;
        Leave result = instance.getLeaveByID(profile_id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addLeave method, of class DAOLeave.
     */
    @Test
    public void testAddLeave() {
        System.out.println("addLeave");
        Leave leave = null;
        DAOLeave instance = new DAOLeave();
        boolean expResult = false;
        boolean result = instance.addLeave(leave);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addLeave2 method, of class DAOLeave.
     */
    @Test
    public void testAddLeave2() {
        System.out.println("addLeave2");
        Leave leave = null;
        DAOLeave instance = new DAOLeave();
        boolean expResult = false;
        boolean result = instance.addLeave2(leave);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of editLeave method, of class DAOLeave.
     */
    @Test
    public void testEditLeave() {
        System.out.println("editLeave");
        Leave leave = null;
        DAOLeave instance = new DAOLeave();
        boolean expResult = false;
        boolean result = instance.editLeave(leave);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of editLeave2 method, of class DAOLeave.
     */
    @Test
    public void testEditLeave2() {
        System.out.println("editLeave2");
        Leave leave = null;
        DAOLeave instance = new DAOLeave();
        boolean expResult = false;
        boolean result = instance.editLeave2(leave);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteLeave method, of class DAOLeave.
     */
    @Test
    public void testDeleteLeave() {
        System.out.println("deleteLeave");
        int id = 0;
        DAOLeave instance = new DAOLeave();
        boolean expResult = false;
        boolean result = instance.deleteLeave(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of DecrementAnnualLeave method, of class DAOLeave.
     */
    @Test
    public void testDecrementAnnualLeave() {
        System.out.println("DecrementAnnualLeave");
        String profile_id = "";
        DAOLeave instance = new DAOLeave();
        boolean expResult = false;
        boolean result = instance.DecrementAnnualLeave(profile_id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of IncrementAnnualLeave method, of class DAOLeave.
     */
    @Test
    public void testIncrementAnnualLeave() {
        System.out.println("IncrementAnnualLeave");
        String profile_id = "";
        DAOLeave instance = new DAOLeave();
        boolean expResult = false;
        boolean result = instance.IncrementAnnualLeave(profile_id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateStatus method, of class DAOLeave.
     */
    @Test
    public void testUpdateStatus() {
        System.out.println("updateStatus");
        int id = 0;
        int status = 0;
        DAOLeave instance = new DAOLeave();
        boolean expResult = false;
        boolean result = instance.updateStatus(id, status);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class DAOLeave.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        DAOLeave.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
