/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Attendance;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Khanh
 */
public class DAOAttendance extends DBConnect {
    
    Connection conn = null;
    PreparedStatement state = null;
    ResultSet rs = null;
    
    public boolean add(String date, String time_in, String time_out, String production_time,
            String employee_id) {
        String sql = "insert into attendance(date, time_in, time_out, "
                + "production_time, employee_id) values(?,?,?,?,?)";
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            state.setString(1, date);
            state.setString(2, time_in);
            state.setString(3, time_out);
            state.setString(4, production_time);
            state.setString(5, employee_id);
            state.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        } finally {
            closePrepareStatement(state);
            closeConnection(conn);
        }
        return true;
    }
    
    public Attendance getLastest(String employee_id) {
        String sql = "  select top 1 [shift_id], [date], [time_in], [time_out], "
                + "[production_time], [employee_id] from attendance where "
                + "[employee_id] = ? order by shift_id desc";
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            state.setString(1, employee_id);
            rs = state.executeQuery();
            while (rs.next()) {
                return new Attendance(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResultSet(rs);
            closePrepareStatement(state);
            closeConnection(conn);
        }
        return null;
    }
    
    public boolean update(int id, String time_out, String production_time, String employee_id) {
        String sql = "update attendance set [time_out]=?, [production_time]=?"
                + " where [shift_id]=? and [employee_id]=?";
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            state.setString(1, time_out);
            state.setString(2, production_time);
            state.setInt(3, id);
            state.setString(4, employee_id);
            state.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        } finally {
            closePrepareStatement(state);
            closeConnection(conn);
        }
        return true;
    }
    
    public List<Attendance> listAll(String id) {
        List<Attendance> list = new ArrayList<>();
        String sql = "select [shift_id], [date], [time_in], [time_out],"
                + " [production_time], [employee_id], [report_to] "
                + "from attendance join profile on attendance.employee_id = "
                + "profile.profile_id where [report_to] = ?";
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            state.setString(1, id);
            rs = state.executeQuery();
            while (rs.next()) {
                list.add(new Attendance(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResultSet(rs);
            closePrepareStatement(state);
            closeConnection(conn);
        }
        return list;
    }
    
    public List<Attendance> listAllAttendanceofAnEmployee(String employee_id) {
        List<Attendance> list = new ArrayList<>();
        String sql = "select * from attendance where [employee_id]=?";
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            state.setString(1, employee_id);
            rs = state.executeQuery();
            while (rs.next()) {
                list.add(new Attendance(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResultSet(rs);
            closePrepareStatement(state);
            closeConnection(conn);
        }
        return list;
    }
    
    public List<Attendance> search(String date, String profile_id) {
        List<Attendance> list = new ArrayList<>();
        String sql = "select * from attendance where employee_id like ? and date = ?";
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            state.setString(1, "%" + profile_id + "%");
            state.setString(2, date);
            rs = state.executeQuery();
            while (rs.next()) {
                list.add(new Attendance(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResultSet(rs);
            closePrepareStatement(state);
            closeConnection(conn);
        }
        return list;
    }
    
    public List<Attendance> search2(String date, String name, String reportto) {
        List<Attendance> list = new ArrayList<>();
        String sql = "select shift_id, date, time_in, time_out, production_time,"
                + " employee_id, report_to from attendance join "
                + "profile on attendance.employee_id = profile.profile_id where "
                + "date like ? and first_name + last_name like ? and report_to = ?";
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            state.setString(1, "%" + date + "%");
            state.setString(2, "%" + name + "%");
            state.setString(3, reportto);
            rs = state.executeQuery();
            while (rs.next()) {
                list.add(new Attendance(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResultSet(rs);
            closePrepareStatement(state);
            closeConnection(conn);
        }
        return list;
    }
    
    public List<Attendance> todayAttendance(String date) {
        List<Attendance> list = new ArrayList<>();
        String sql = "select distinct employee_id from attendance where date = ?";
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            state.setString(1, date);
            rs = state.executeQuery();
            while (rs.next()) {
                list.add(new Attendance(
                        rs.getString(1)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResultSet(rs);
            closePrepareStatement(state);
            closeConnection(conn);
        }
        return list;
    }
    
    public static void main(String[] args) {
        DAOAttendance dao = new DAOAttendance();
        DAOProfile daoPf = new DAOProfile();
//        List<Attendance> list = dao.search2("", "gio", "ABCDE");
//        for (Attendance a : list) {
//            a.setEmployee_id(daoPf.getByID(a.getEmployee_id()).getFirst_name() + " " + daoPf.getByID(a.getEmployee_id()).getLast_name());
//        }
//        System.out.println(list);
        System.out.println(dao.listAllAttendanceofAnEmployee("QWERT"));
    }
}
