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
public class DAOCompanyTest {
    
    DAOCompany dao = new DAOCompany();
    
    public DAOCompanyTest() {
    }

    /**
     * Test of listAllCompany method, of class DAOCompany.
     */
    @Test
    public void testListAllCompany() {
        assertEquals("[Company{id=1, name=C1}, Company{id=2, name=C2}]", 
                dao.listAllCompany().toString());
    }

    /**
     * Test of getCompanyByID method, of class DAOCompany.
     */
    @Test
    public void testGetCompanyByID1() {
        assertEquals("Company{id=1, name=C1}", dao.getCompanyByID(1).toString());
    }
    
    @Test
    public void testGetCompanyByID2() {
        assertNull(dao.getCompanyByID(3));
    }
}
