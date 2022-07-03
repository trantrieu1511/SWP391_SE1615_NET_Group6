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
public class DAODepartmentTest {
    
    DAODepartment dao = new DAODepartment();
    
    public DAODepartmentTest() {
    }

    /**
     * Test of listAllDepartment method, of class DAODepartment.
     */
    @Test
    public void testListAllDepartment() {
        assertEquals("[departments{id=1, name=Dev}]", dao.listAllDepartment().toString());
    }

    /**
     * Test of getDepartmentByName method, of class DAODepartment.
     */
    @Test
    public void testGetDepartmentByName1() {
        assertEquals("departments{id=1, name=Dev}", dao.getDepartmentByID(1).toString());
    }
    
    @Test
    public void testGetDepartmentByName2() {
        assertNull(dao.getDepartmentByID(2));
    }

    /**
     * Test of getDepartmentByID method, of class DAODepartment.
     */
    @Test
    public void testGetDepartmentByID1() {
        assertNull(dao.getDepartmentByName("no"));
    }

}
