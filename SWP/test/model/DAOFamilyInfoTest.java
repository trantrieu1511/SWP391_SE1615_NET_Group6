/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.FamilyInfo;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Khanh
 */
public class DAOFamilyInfoTest {
    
    DAOFamilyInfo dao = new DAOFamilyInfo();
    
    public DAOFamilyInfoTest() {
    }

    /**
     * Test of getIndividualFamilyInfo method, of class DAOFamilyInfo.
     */
    @Test
    public void testGetIndividualFamilyInfo() {
        assertEquals("[]", dao.getIndividualFamilyInfo("QWERT").toString());
    }

    /**
     * Test of addFamilyInfo method, of class DAOFamilyInfo.
     */
    @Test
    public void testAddFamilyInfo() {
        assertTrue(dao.addFamilyInfo(new FamilyInfo("WRYYY", "Dio Brando", "Father", "01/01/1867", "0000000000")));
    }

    /**
     * Test of deleteFamilyInfo method, of class DAOFamilyInfo.
     */
    @Test
    public void testDeleteFamilyInfo() {
        assertTrue(dao.deleteFamilyInfo("WRYYY", "Dio Brando"));
    }

    /**
     * Test of deleteAllFamilyInfo method, of class DAOFamilyInfo.
     */
    @Test
    public void testDeleteAllFamilyInfo() {
        assertTrue(dao.deleteAllFamilyInfo("WRYYY"));
    }

    /**
     * Test of editFamilyInfo method, of class DAOFamilyInfo.
     */
    @Test
    public void testEditFamilyInfo() {
        assertTrue(dao.editFamilyInfo(new FamilyInfo("WRYYY", "Dio Brando",
                "Father", "12/12/1867", "0000000000"), "Dio Brando"));
    }
    
}
