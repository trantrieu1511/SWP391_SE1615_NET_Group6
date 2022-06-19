/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.shift;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Khanh
 */
public class DAOShift extends DBConnect {
    
    Connection conn = null;
    PreparedStatement state = null;
    ResultSet rs = null;
    
    public List<shift> listShift() {
        List<shift> list = new ArrayList<>();
        String sql ="select * from shift";
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            rs = state.executeQuery();
            while (rs.next()) {
                list.add(new shift(
                        rs.getString(1), 
                        rs.getString(2),
                        rs.getString(3)));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closeResultSet(rs);
            closePrepareStatement(state);
            closeConnection(conn);
        }
        return list;
    }
    
    public boolean add(String name, String start, String end) {
        String sql = "insert into shift(name, start_time, end_time)values(?,?,?)";
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            state.setString(1, name);
            state.setString(2, start);
            state.setString(3, end);
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
    
    public static void main(String[] args) {
        DAOShift dao = new DAOShift();
        System.out.println(dao.listShift());
    }
}
