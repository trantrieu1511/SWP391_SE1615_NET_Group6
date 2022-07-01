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
    public void testAdd1() {
        //assertTrue(dao.add("01/01/2022", "9:00", "10:00", "1:00", "QWERT"));
    }
    
    @Test
    public void testAdd2() {
        //assertTrue(dao.add("01/01/2022", "9:00", "", "", "QWERT"));
    }

    /**
     * Test of getLastest method, of class DAOAttendance.
     */
    @Test
    public void testGetLastest1() {
        assertEquals("attendance{id=5, date=01/01/2022, time_in=9:00, time_out=,"
                + " production_time=, employee_id=QWERT, reportto=null}", 
                dao.getLastest("QWERT").toString());
    }
    
    @Test
    public void testGetLastest2() {
        assertNull(dao.getLastest("12341"));
    }

    /**
     * Test of update method, of class DAOAttendance.
     */
    @Test
    public void testUpdate1() {
        assertTrue(dao.update(1, "3:09", "2:00", "QWERT"));
    }

    /**
     * Test of listAll method, of class DAOAttendance.
     */
    @Test
    public void testListAll1() {
        assertEquals("[attendance{id=1, date=17/06/2022, time_in=01:09, "
                + "time_out=3:09, production_time=2:00, employee_id=QWERT, "
                + "reportto=ABCDE}, attendance{id=2, date=17/06/2022, "
                + "time_in=01:09, time_out=, production_time=, employee_id=QWERT,"
                + " reportto=ABCDE}, attendance{id=3, date=17/06/2022, time_in=01:09, "
                + "time_out=, production_time=, employee_id=QWERT, reportto=ABCDE}, "
                + "attendance{id=4, date=01/01/2022, time_in=9:00, time_out=10:00,"
                + " production_time=1:00, employee_id=QWERT, reportto=ABCDE},"
                + " attendance{id=5, date=01/01/2022, time_in=9:00, time_out=, "
                + "production_time=, employee_id=QWERT, reportto=ABCDE}]", 
                dao.listAll("ABCDE").toString());
    }
    
    @Test
    public void testListAll2() {
        assertEquals("[]", dao.listAll("08921").toString());
    }

    /**
     * Test of listAllAttendanceofAnEmployee method, of class DAOAttendance.
     */
    @Test
    public void testListAllAttendanceofAnEmployee1() {
        assertEquals("[attendance{id=1, date=17/06/2022, time_in=01:09, time_out=3:09, "
                + "production_time=2:00, employee_id=QWERT, reportto=null}, "
                + "attendance{id=2, date=17/06/2022, time_in=01:09, time_out=,"
                + " production_time=, employee_id=QWERT, reportto=null}, "
                + "attendance{id=3, date=17/06/2022, time_in=01:09, time_out=, "
                + "production_time=, employee_id=QWERT, reportto=null}, "
                + "attendance{id=4, date=01/01/2022, time_in=9:00, time_out=10:00, "
                + "production_time=1:00, employee_id=QWERT, reportto=null}, "
                + "attendance{id=5, date=01/01/2022, time_in=9:00, time_out=, "
                + "production_time=, employee_id=QWERT, reportto=null}]", 
                dao.listAllAttendanceofAnEmployee("QWERT").toString());
    }
    
    @Test
    public void testListAllAttendanceofAnEmployee2() {
        assertEquals("[]",dao.listAllAttendanceofAnEmployee("12220").toString());
    }

    /**
     * Test of search method, of class DAOAttendance.
     */
    @Test
    public void testSearch1() {
        assertEquals("[attendance{id=1, date=17/06/2022, time_in=01:09, time_out=3:09, "
                + "production_time=2:00, employee_id=QWERT, reportto=null}, "
                + "attendance{id=2, date=17/06/2022, time_in=01:09, time_out=, "
                + "production_time=, employee_id=QWERT, reportto=null}, "
                + "attendance{id=3, date=17/06/2022, time_in=01:09, time_out=, "
                + "production_time=, employee_id=QWERT, reportto=null}]", 
                dao.search("17/06/2022", "QWERT").toString());
    }
    
    @Test
    public void testSearch2() {
        assertEquals("[]", dao.search("00/00/0000", "00000").toString());
    }

    /**
     * Test of add method, of class DAOAttendance.
     */
    @Test
    public void testAdd() {
    }

    /**
     * Test of getLastest method, of class DAOAttendance.
     */
    @Test
    public void testGetLastest() {
    }

    /**
     * Test of update method, of class DAOAttendance.
     */
    @Test
    public void testUpdate() {
    }

    /**
     * Test of listAll method, of class DAOAttendance.
     */
    @Test
    public void testListAll() {
    }

    /**
     * Test of listAllAttendanceofAnEmployee method, of class DAOAttendance.
     */
    @Test
    public void testListAllAttendanceofAnEmployee() {
    }

    /**
     * Test of search method, of class DAOAttendance.
     */
    @Test
    public void testSearch() {
    }

    /**
     * Test of todayAttendance method, of class DAOAttendance.
     */
    @Test
    public void testTodayAttendance() {
    }

    /**
     * Test of main method, of class DAOAttendance.
     */
    @Test
    public void testMain() {
    }
}
