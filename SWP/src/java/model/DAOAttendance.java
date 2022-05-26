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
public class DAOAttendance extends ConnectDB {
    
    public void add(String date, String time_in, String time_out, String production_time,
            String employee_id) {
        String sql = "insert into attendance(date, time_in, time_out, production_time,"
                + "employee_id) values(" + date + ", " + time_in + ", "
                + time_out + ", " + production_time + ", " + employee_id + ")";
        try {
            Statement state = conn.createStatement();
            state.executeUpdate(sql);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public attendance getLastest() {
        String sql = "select top 1 from attendance order by shift_id desc";
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
    
    public void update(int id, String time_out, String production_time) {
        String sql = "update attendance set [time_out]=?, [production_time]=?,"
                + " where [shift_id]=?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(4, time_out);
            pre.setString(5, production_time);            
            pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public List<attendance> listAll() {
        List<attendance> list = new ArrayList<>();
        String sql = "select * from attendance";
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
}
