/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.LeaveType;
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
public class DAOLeaveTypeTest {
    
    public DAOLeaveTypeTest() {
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
     * Test of listAllLeaveType method, of class DAOLeaveType.
     */
    @Test
    public void testListAllLeaveType() {
        System.out.println("listAllLeaveType");
        DAOLeaveType instance = new DAOLeaveType();
        List<LeaveType> expResult = null;
        List<LeaveType> result = instance.listAllLeaveType();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLeaveTypeByID method, of class DAOLeaveType.
     */
    @Test
    public void testGetLeaveTypeByID() {
        System.out.println("getLeaveTypeByID");
        String id = "";
        DAOLeaveType instance = new DAOLeaveType();
        LeaveType expResult = null;
        LeaveType result = instance.getLeaveTypeByID(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class DAOLeaveType.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        DAOLeaveType.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
