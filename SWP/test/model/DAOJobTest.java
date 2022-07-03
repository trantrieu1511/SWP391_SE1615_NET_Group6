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
public class DAOJobTest {
    
    DAOJob dao = new DAOJob();
    
    public DAOJobTest() {
    }

    /**
     * Test of listAllJob method, of class DAOJob.
     */
    @Test
    public void testListAllJob() {
        assertEquals("[jobs{id=1, title=IOS Developer, min=10000.0, max=15000.0}]", 
                dao.listAllJob().toString());
    }

    /**
     * Test of getJobByTitle method, of class DAOJob.
     */
    @Test
    public void testGetJobByTitle() {
        assertEquals("jobs{id=1, title=IOS Developer, min=10000.0, max=15000.0}"
                , dao.getJobByTitle("IOS Developer").toString());
    }

    /**
     * Test of getJobById method, of class DAOJob.
     */
    @Test
    public void testGetJobById() {
        assertEquals("jobs{id=1, title=IOS Developer, min=10000.0, max=15000.0}"
                , dao.getJobById(1).toString());
    }
    
}
