/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Experience;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Khanh
 */
public class DAOExperienceTest {
    
    DAOExperience dao = new DAOExperience();
    
    public DAOExperienceTest() {
    }

    /**
     * Test of listIndividualExperience method, of class DAOExperience.
     */
    @Test
    public void testListIndividualExperience() {
        assertEquals("[]", dao.listIndividualExperience("QWERT").toString());
    }

    /**
     * Test of addExperience method, of class DAOExperience.
     */
    @Test
    public void testAddExperience() {
        assertTrue(dao.addExperience(new Experience("WRYYY", "Stand User", "01/01/2010", "30/06/2022")));
    }

    /**
     * Test of editExperience method, of class DAOExperience.
     */
    @Test
    public void testEditExperience() {
        assertTrue(dao.editExperience(new Experience("WRYYY", "standotsukai", "01/01/2010", "02/07/2022"), "Stand User"));
    }

    /**
     * Test of deleteExperience method, of class DAOExperience.
     */
    @Test
    public void testDeleteExperience() {
        assertTrue(dao.deleteExperience("WRYYY", "standotsukai"));
    }

    /**
     * Test of deleteAllExperience method, of class DAOExperience.
     */
    @Test
    public void testDeleteAllExperience() {
        assertTrue(dao.deleteAllExperience("WRYYY"));
    }

}
