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
    public void testAdd() {
        //assertTrue(dao.checkIn("02/07/2022", "8:30", "11:30", "3:00", "WRYYY"));
    }

    /**
     * Test of getLastestAttendance method, of class DAOAttendance.
     */
    @Test
    public void testGetLastest() {
        assertEquals("attendance{id=11, date=02/07/2022, time_in=8:30,"
                + " time_out=11:30, production_time=3:00, employee_id=WRYYY, "
                + "reportto=null}", dao.getLastestAttendance("WRYYY").toString());
    }

    /**
     * Test of checkOut method, of class DAOAttendance.
     */
    @Test
    public void testUpdate() {
        assertTrue(dao.checkOut(1, "6:00", "5:51", "QWERT"));
    }

    /**
     * Test of listAllAttendance method, of class DAOAttendance.
     */
    @Test
    public void testListAll() {
        assertEquals("[attendance{id=6, date=19/06/2022, time_in=05:23,"
                + " time_out=05:23, production_time=00:00, employee_id=WRYYY, "
                + "reportto=ABCDE}, attendance{id=7, date=21/06/2022, "
                + "time_in=01:07, time_out=01:07, production_time=00:00, "
                + "employee_id=WRYYY, reportto=ABCDE}, attendance{id=11, "
                + "date=02/07/2022, time_in=8:30, time_out=11:30, "
                + "production_time=3:00, employee_id=WRYYY, reportto=ABCDE}]", 
                dao.listAllAttendance("ABCDE").toString());
    }

    /**
     * Test of listAllAttendanceofAnEmployee method, of class DAOAttendance.
     */
    @Test
    public void testListAllAttendanceofAnEmployee() {
        assertEquals("[attendance{id=1, date=17/06/2022, time_in=01:09, "
                + "time_out=6:00, production_time=5:51, employee_id=QWERT, "
                + "reportto=null}, attendance{id=4, date=01/01/2022, "
                + "time_in=9:00, time_out=10:00, production_time=1:00, "
                + "employee_id=QWERT, reportto=null}]", 
                dao.listAllAttendanceofAnEmployee("QWERT").toString());
    }

    /**
     * Test of search method, of class DAOAttendance.
     */
    @Test
    public void testSearch() {
        assertEquals("[attendance{id=11, date=02/07/2022, time_in=8:30,"
                + " time_out=11:30, production_time=3:00, employee_id=WRYYY, "
                + "reportto=null}]", dao.search("02/07/2022", "WRYYY").toString());
    }

    /**
     * Test of search method, of class DAOAttendance.
     */
    @Test
    public void testSearch2() {
        assertEquals("[attendance{id=11, date=02/07/2022, time_in=8:30, "
                + "time_out=11:30, production_time=3:00, employee_id=WRYYY, "
                + "reportto=ABCDE}]",
                dao.search("02/07/2022", "Gior", "ABCDE").toString());
    }

    /**
     * Test of todayAttendance method, of class DAOAttendance.
     */
    @Test
    public void testTodayAttendance() {
        assertEquals("[attendance{id=0, date=null, time_in=null, time_out=null, "
                + "production_time=null, employee_id=WRYYY, reportto=null}]",
                dao.todayAttendance("02/07/2022").toString());
    }   
}
