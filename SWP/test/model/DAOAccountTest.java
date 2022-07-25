/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Account;
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
public class DAOAccountTest {
    
    public DAOAccountTest() {
    }
    
    /**
     * Test of getStatus method, of class DAOAccount.
     */
    @Test
    public void testGetStatus() {
        System.out.println("getStatus");
        String user = "admin01";
        DAOAccount instance = new DAOAccount();
        boolean expResult = true;
        boolean result = instance.getStatus(user);
        assertEquals(expResult, result);
    }

    /**
     * Test of login method, of class DAOAccount.
     */
    @Test
    public void testLogin() {
        System.out.println("login");
        String user = "mana01";
        String pass = "mana001";
        DAOAccount instance = new DAOAccount();
        assertEquals("account{profile_id=MA007, user=mana01, pass=mana001, isAdmin=false, isManager=true}", instance.login(user, pass).toString());
    }

    /**
     * Test of addAMAccount method, of class DAOAccount.
     */
    @Test
    public void testAddAMAccount() {
        System.out.println("addAMAccount");
        String profile_id = "TT006";
        String username = "mana03";
        String password = "mana003";
        int isA = 0;
        int isM = 1;
        DAOAccount instance = new DAOAccount();
        boolean expResult = true;
        boolean result = instance.addAMAccount(profile_id, username, password, isA, isM);
        assertEquals(expResult, result);
    }

    /**
     * Test of editAMAccount method, of class DAOAccount.
     */
    @Test
    public void testEditAMAccount() {
        System.out.println("editAMAccount");
        String profile_id = "MA005";
        String username = "";
        String password = "";
        int isA = 0;
        int isM = 1;
        int Status = 0;
        DAOAccount instance = new DAOAccount();
        boolean expResult = true;
        boolean result = instance.editAMAccount(profile_id, username, password, isA, isM, Status);
        assertEquals(expResult, result);
    }

    /**
     * Test of deleteAccount method, of class DAOAccount.
     */
    @Test
    public void testDeleteAccount() {
        System.out.println("deleteAccount");
        String profile_id = "MA005";
        DAOAccount instance = new DAOAccount();
        boolean expResult = true;
        boolean result = instance.deleteAccount(profile_id);
        assertEquals(expResult, result);
    }

    /**
     * Test of getProfileId method, of class DAOAccount.
     */
    @Test
    public void testGetProfileId() {
        System.out.println("getProfileId");
        String email = "hieuphanh001@gmail.com";
        DAOAccount instance = new DAOAccount();
        String expResult = "HP001";
        String result = instance.getProfileId(email);
        assertEquals(expResult, result);
    }

    /**
     * Test of GetNewPassword method, of class DAOAccount.
     */
    @Test
    public void testGetNewPassword() {
        System.out.println("GetNewPassword");
        String password = "phanh0212";
        String profile_id = "HP001";
        DAOAccount instance = new DAOAccount();
        boolean expResult = true;
        boolean result = instance.GetNewPassword(password, profile_id);
        assertEquals(expResult, result);
    }
    
}
