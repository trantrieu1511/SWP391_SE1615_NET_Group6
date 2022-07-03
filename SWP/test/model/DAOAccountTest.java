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
public class DAOAccountTest {
    
    DAOAccount dao = new DAOAccount();
    
    public DAOAccountTest() {
    }

    /**
     * Test of login method, of class DAOAccount.
     */
    @Test
    public void testLogin1() {
        assertEquals("account{profile_id=ABCDE, user=manager, pass=khanhcnn49, "
                + "isAdmin=false, isManager=true}", 
                dao.login("manager", "khanhcnn49").toString());
    }
    
    @Test
    public void testLogin2() {
        assertNull(dao.login("ABC", "123456"));
    }

    /**
     * Test of getAccount method, of class DAOAccount.
     */
    @Test
    public void testGetAccount1() {
        assertEquals("account{profile_id=ABCDE, user=manager, pass=khanhcnn49, "
                + "isAdmin=false, isManager=true}", 
                dao.getAccount("ABCDE").toString());
    }
    
    @Test
    public void testGetAccount2() {
        assertNull(dao.getAccount("43293"));
    }

    /**
     * Test of getAccountwithList method, of class DAOAccount.
     */
    @Test
    public void testGetAccountwithList() {
    }

    /**
     * Test of addAccount method, of class DAOAccount.
     */
    @Test
    public void testAddAccount1() {
        //assertFalse(dao.addAccount("ABCDE", "test", "123456"));
    }
    
    @Test
    public void testAddAccount2() {
        assertFalse(dao.addAccount("34091", "test", "123456"));
    }

    /**
     * Test of editAccount method, of class DAOAccount.
     */
    @Test
    public void testEditAccount1() {
        assertTrue(dao.editAccount("WRYYY", "GER", "123456"));
    }
    
    @Test
    public void testEditAccount2() {
        //assertFalse(dao.editAccount("47439", "manager", "khanhcnn49"));
    }

    /**
     * Test of deleteAccount method, of class DAOAccount.
     */
    @Test
    public void testDeleteAccount1() {
        //assertTrue(dao.deleteAccount("ABCDE"));
    }
    
    @Test
    public void testDeleteAccount2() {
        assertTrue(dao.deleteAccount("35252"));
    }
}
