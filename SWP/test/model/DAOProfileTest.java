/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Profile;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Khanh
 */
public class DAOProfileTest {
    
    DAOProfile dao = new DAOProfile();
    
    public DAOProfileTest() {
    }

    /**
     * Test of addManager method, of class DAOProfile.
     */
    @Test
    public void testAddManager() {
//        assertTrue(dao.addManager(new Profile("ABCDE", "Nguyen", "Khanh",
//                "namkhanhnd0811@gmail.com", "0385326593", "08/11/2020", 1, 1, "")));       
    }

    /**
     * Test of addStaff method, of class DAOProfile.
     */
    @Test
    public void testAddStaff() {
        //assertTrue(dao.addStaff(new Profile("YOINY", "Joestar", "Jonathan", 
        //        "phantom@blood.com", "0897654321", "01/01/1867", 1, 1, "ABCDE")));
    }

    /**
     * Test of editStaff method, of class DAOProfile.
     */
    @Test
    public void testEditStaff() {
        assertTrue(dao.editStaff(new Profile("YOINY", "Joestar", "Jonathan", 
                "phantom@blood.com", "0897654321", "04/04/1868", 1, 1, "ABCDE")));
    }

    /**
     * Test of listAllStaff method, of class DAOProfile.
     */
    @Test
    public void testListAllStaff() {
        assertEquals("[profile{profile_id=KUGHY, first_name=Joestar, "
                + "last_name=Johnny, email=sbr@gmail.com, phone_number=0897654321,"
                + " hire_date=01/01/1867, job_id=1, job_title=null, "
                + "department_id=1, department_name=null, reportto=ABCDE}]",
                dao.listAllStaff("ABCDE").toString());
    }
    
    /**
     * Test of getByID method, of class DAOProfile.
     */
    @Test
    public void testGetByID() {
        assertEquals("[profile{profile_id=ABCDE, first_name=Nguyen, "
                + "last_name=Khanh, email=namkhanhnd0811@gmail.com, "
                + "phone_number=0385326593, hire_date=08/11/2020, "
                + "job_id=1, job_title=null, department_id=1, department_name=null, "
                + "reportto=null}]", dao.getByID("ABCDE").toString());
    }

    /**
     * Test of deleteProfile method, of class DAOProfile.
     */
    @Test
    public void testDeleteProfile() {
        assertTrue(dao.deleteProfile("YOINY"));
    }

    /**
     * Test of searchStaff1 method, of class DAOProfile.
     */
    @Test
    public void testSearchStaff1() {
    }

    /**
     * Test of searchStaff2 method, of class DAOProfile.
     */
    @Test
    public void testSearchStaff2() {
    }

    /**
     * Test of searchStaff3 method, of class DAOProfile.
     */
    @Test
    public void testSearchStaff3() {
    }

    /**
     * Test of searchStaff4 method, of class DAOProfile.
     */
    @Test
    public void testSearchStaff4() {
    }

}
