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
public class DAOAttendanceTest {
    
    DAOAttendance dao = new DAOAttendance();
    
    public DAOAttendanceTest() {
        
    }

    /**
     * Test of checkIn method, of class DAOAttendance.
     */
    @Test
    public void testCheckIn() {
        //assertTrue(dao.checkIn("02/07/2022", "8:30", " ", " ", "GG007"));
    }

    /**
     * Test of getLastestAttendance method, of class DAOAttendance.
     */
    @Test
    public void testGetLastestAttendance() {
        assertEquals("attendance{id=1, date=02/07/2022, time_in=8:30, time_out=11:30, "
                + "production_time=3:00, employee_id=GG007, note=null}", 
                dao.getLastestAttendance("GG007").toString());
    }

    /**
     * Test of checkOut method, of class DAOAttendance.
     */
    @Test
    public void testCheckOut() {
        //assertTrue(dao.checkOut(1, "11:30", "3:00", "GG007"));
    }

    /**
     * Test of listAllAttendance method, of class DAOAttendance.
     */
    @Test
    public void testListAllAttendance() {
        assertEquals("[attendance{id=1, date=02/07/2022, time_in=8:30, time_out=11:30,"
                + " production_time=3:00, employee_id=GG007, note=null}]", 
                dao.listAllAttendance("NK006").toString());
    }

    /**
     * Test of listAllAttendanceofAnEmployee method, of class DAOAttendance.
     */
    @Test
    public void testListAllAttendanceofAnEmployee() {
        assertEquals("[attendance{id=1, date=02/07/2022, time_in=8:30, time_out=11:30,"
                + " production_time=3:00, employee_id=GG007, note=null}]",
                dao.listAllAttendanceofAnEmployee("GG007").toString());
    }

    /**
     * Test of todayAttendance method, of class DAOAttendance.
     */
    @Test
    public void testTodayAttendance() {
        assertEquals("[attendance{id=0, date=null, time_in=null, time_out=null, "
                + "production_time=null, employee_id=GG007, note=null}]",
                dao.todayAttendance("02/07/2022").toString());
    }   

    /**
     * Test of searchAttendance method, of class DAOAttendance.
     */
    @Test
    public void testSearchAttendance_String_String() {
        assertEquals("[attendance{id=1, date=02/07/2022, time_in=8:30, time_out=11:30,"
                + " production_time=3:00, employee_id=GG007, note=null}]",
                dao.searchAttendance("02/07/2022", "GG007").toString());
    }

    /**
     * Test of searchAttendance method, of class DAOAttendance.
     */
    @Test
    public void testSearchAttendance_3args() {
        assertEquals("[attendance{id=1, date=02/07/2022, time_in=8:30, time_out=11:30, "
                + "production_time=3:00, employee_id=GG007, note=NK006}]",
                dao.searchAttendance("02/07/2022", "Gio", "NK006").toString());
    }

}
