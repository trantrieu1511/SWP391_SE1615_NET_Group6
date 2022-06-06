/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.attendance;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Khanh
 */
public class DAOAttendance extends DBConnent {
    
    public boolean add(String date, String time_in, String time_out, String production_time,
            String employee_id) {
        String sql = "insert into attendance(date, time_in, time_out,"
                + " production_time, employee_id) values('" + date + "', '" + time_in
                + "', '" + time_out + "', '" + production_time + "', '" + employee_id
                + "')";
        try {
            Statement state = conn.createStatement();
            state.executeUpdate(sql);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }
    
    public attendance getLastest(String employee_id) {
        String sql = "  select top 1 [shift_id], [date], [time_in], [time_out], "
                + "[production_time], [employee_id] from attendance where "
                + "[employee_id] = '" + employee_id + "' order by shift_id desc";
        ResultSet rs = getData(sql);
        try {
            while (rs.next()) {
                return new attendance(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public boolean update(int id, String time_out, String production_time, String employee_id) {
        String sql = "update attendance set [time_out]=?, [production_time]=?"
                + " where [shift_id]=? and [employee_id]=?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, time_out);
            pre.setString(2, production_time);
            pre.setInt(3, id);
            pre.setString(4, employee_id);
            pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }
    
    public List<attendance> listAll(String id) {
        List<attendance> list = new ArrayList<>();
        String sql = "select [shift_id], [date], [time_in], [time_out],"
                + " [production_time], [employee_id], [ReportsTo] "
                + "from attendance join profile on attendance.employee_id = "
                + "profile.profile_id where [ReportsTo] = '" + id + "'";
        ResultSet rs = getData(sql);
        try {
            while (rs.next()) {
                list.add(new attendance(
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
        }
        return list;
    }
    
    public List<attendance> listAllAttendanceofAnEmployee(String employee_id) {
        List<attendance> list = new ArrayList<>();
        String sql = "select * from attendance where [employee_id]='"
                + employee_id + "'";
        ResultSet rs = getData(sql);
        try {
            while (rs.next()) {
                list.add(new attendance(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void main(String[] args) {
        DAOAttendance dao = new DAOAttendance();
//        List<attendance> list = dao.listAll("12345");
//        for (attendance a : list) {
//            System.out.println(a);
//        }
//        System.out.println(dao.getLastest("12345"));
//        System.out.println(dao.listAllAttendanceofAnEmployee("12345"));
    }
}
