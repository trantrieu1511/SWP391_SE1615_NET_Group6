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
     * Test of add method, of class DAOAttendance.
     */
    @Test
    public void testAdd() {
//        assertTrue(dao.add("22/12/2022", "9:00", "10:00", "1:00", "12345"));
    }

    /**
     * Test of getLastest method, of class DAOAttendance.
     */
    @Test
    public void testGetLastest() {
        assertEquals("attendance{id=15, date=22/12/2022, time_in=9:00,"
                + " time_out=10:30, production_time=1:30, "
                + "employee_id=12345, reportto=null}", dao.getLastest("12345").toString());
    }
    
    @Test
    public void testGetLastest2() {
        assertNull(dao.getLastest("50989"));
    }

    /**
     * Test of update method, of class DAOAttendance.
     */
    @Test
    public void testUpdate() {
        assertTrue(dao.update(15, "10:30", "1:30", "12345"));
   }

    /**
     * Test of listAll method, of class DAOAttendance.
     */
    @Test
    public void testListAll() {
        String list = "[attendance{id=11, date=02/06/2022, time_in=07:10,"
                + " time_out=07:10, production_time=00:00, employee_id=23456, "
                + "reportto=12345}, attendance{id=12, date=02/06/2022, "
                + "time_in=08:02, time_out=08:02, production_time=00:00,"
                + " employee_id=23456, reportto=12345}]";
        assertEquals(list, dao.listAll("12345").toString());
    }
    
    @Test
    public void testListAll2() {       
        assertNull(dao.listAll("10658"));
    }

    /**
     * Test of listAllAttendanceofAnEmployee method, of class DAOAttendance.
     */
    @Test
    public void testListAllAttendanceofAnEmployee() {
        String list = "[attendance{id=1, date=31/05/2022, time_in=02:16, "
                + "time_out=, production_time=, employee_id=12345, "
                + "reportto=null}, attendance{id=2, date=31/05/2022, "
                + "time_in=02:18, time_out=, production_time=, employee_id=12345,"
                + " reportto=null}, attendance{id=3, date=31/05/2022, "
                + "time_in=02:23, time_out=, production_time=, employee_id=12345,"
                + " reportto=null}, attendance{id=4, date=31/05/2022, time_in=02:24, "
                + "time_out=, production_time=, employee_id=12345, reportto=null},"
                + " attendance{id=5, date=31/05/2022, time_in=02:25, time_out=02:25, "
                + "production_time=00:00, employee_id=12345, reportto=null}, "
                + "attendance{id=6, date=01/06/2022, time_in=01:21, time_out=, "
                + "production_time=, employee_id=12345, reportto=null}, "
                + "attendance{id=7, date=01/06/2022, time_in=01:22, time_out=, "
                + "production_time=, employee_id=12345, reportto=null}, "
                + "attendance{id=8, date=01/06/2022, time_in=01:30, time_out=, "
                + "production_time=, employee_id=12345, reportto=null}, "
                + "attendance{id=9, date=01/06/2022, time_in=01:30, time_out=01:31,"
                + " production_time=00:01, employee_id=12345, reportto=null},"
                + " attendance{id=10, date=01/06/2022, time_in=01:31, time_out=01:32,"
                + " production_time=00:01, employee_id=12345, reportto=null}, "
                + "attendance{id=13, date=22/12/2022, time_in=9:00, time_out=10:00,"
                + " production_time=1:00, employee_id=12345, reportto=null}, "
                + "attendance{id=14, date=22/12/2022, time_in=9:00, time_out=10:00,"
                + " production_time=1:00, employee_id=12345, reportto=null},"
                + " attendance{id=15, date=22/12/2022, time_in=9:00, time_out=10:30, "
                + "production_time=1:30, employee_id=12345, reportto=null}]";
        assertEquals(list, dao.listAllAttendanceofAnEmployee("12345").toString());
    }
    
    @Test
    public void testListAllAttendanceofAnEmployee2() {
        assertNull(dao.listAllAttendanceofAnEmployee("87659"));
    }

    /**
     * Test of listAllToday method, of class DAOAttendance.
     */
    @Test
    public void testListAllToday() {
        String list = "[attendance{id=11, date=02/06/2022, time_in=07:10, "
                + "time_out=07:10, production_time=00:00, employee_id=23456, "
                + "reportto=null}, attendance{id=12, date=02/06/2022, time_in=08:02,"
                + " time_out=08:02, production_time=00:00, employee_id=23456, reportto=null}]";
        assertEquals(list, dao.listAllToday("02/06/2022", "23456").toString());
    }
    
    @Test
    public void testListAllToday2() {
        assertNull(dao.listAllToday("08/06/2022", "23456"));
    }
}
