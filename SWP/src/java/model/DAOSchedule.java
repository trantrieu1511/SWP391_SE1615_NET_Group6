/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.schedule;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Khanh
 */
public class DAOSchedule extends DBConnect {

    Connection conn = null;
    PreparedStatement state = null;
    ResultSet rs = null;

    public boolean addSchedule(String profile_id, String shift_name) {
        String sql = "insert into schedule(profile_id, shift_name) values(?,?)";
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            state.setString(1, profile_id);
            state.setString(2, shift_name);
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

    public boolean checkExist(String profile_id) {
        List<schedule> list = new ArrayList<>();
        String sql = "select * from schedule where profile_id=?";
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            state.setString(1, profile_id);
            rs = state.executeQuery();
            while (rs.next()) {
                list.add(new schedule(
                        rs.getString(1),
                        rs.getString(2)));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            closePrepareStatement(state);
            closeConnection(conn);
        }
        if (list.isEmpty()) {
            return false;
        } else return true;
    }
    
    public boolean countSchedule(String profile_id) {
        List<schedule> list = new ArrayList<>();
        String sql = "select * from schedule where profile_id=?";
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            state.setString(1, profile_id);
            rs = state.executeQuery();
            while (rs.next()) {
                list.add(new schedule(
                        rs.getString(1),
                        rs.getString(2)));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            closePrepareStatement(state);
            closeConnection(conn);
        }
        if (list.size() < 3) {
            return false;
        } else return true;
    }
    
    public List<schedule> listAllScheduleOfStaff() {
        List<schedule> list = new ArrayList<>();
        String sql = "select * from schedule";
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            rs = state.executeQuery();
            while (rs.next()) {
                list.add(new schedule(
                        rs.getString(1),
                        rs.getString(2)));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            closePrepareStatement(state);
            closeConnection(conn);
        }
        return list;
    }
}
