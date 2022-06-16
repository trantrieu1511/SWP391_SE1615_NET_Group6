/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.account;
import java.sql.Connection;
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
public class DAOAccount extends DBConnect {
    
    Connection conn = null;
    PreparedStatement state = null;
    ResultSet rs = null;
    
    public account login(String user, String pass) {
        String sql = "select * from [account] where [username] = '" + user
                + "' and [password] = '" + pass + "'";
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            rs = state.executeQuery();
            while (rs.next()) {
                return new account(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getBoolean(4),
                        rs.getBoolean(5));
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
    
    public account getAccount(String profile_id) {
        String sql = "select * from [account] where profile_id = '" + profile_id + "'";
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            rs = state.executeQuery();
            while (rs.next()) {
                return new account(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getBoolean(4),
                        rs.getBoolean(5));
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
    
    public List<account> getAccountwithList(String profile_id) {
        List<account> list = new ArrayList<>();
        String sql = "select * from [account] where profile_id = '" + profile_id + "'";
        try {
            ResultSet rs = getData(sql);
            while (rs.next()) {
                list.add(new account(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getBoolean(4),
                        rs.getBoolean(5)));
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
    
    public boolean addAccount(String profile_id, String username, String password) {
        String sql = "insert into account(profile_id, username, password, isadmin, ismanager)"
                + "values('" + profile_id + "', '" + username + "', '" + password
                + "', " + 0 + ", " + 0 + ")";
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            state.executeQuery();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally {
            closePrepareStatement(state);
            closeConnection(conn);
        }
        return true;
    }
    
    public boolean editAccount(String profile_id, String username, String password) {
        String sql = "update account set username=?, password=? where profile_id=?";
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            state.executeQuery();
            state.setString(1, username);
            state.setString(2, password);
            state.setString(3, profile_id);
            state.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally {
            closePrepareStatement(state);
            closeConnection(conn);
        }
        return true;
    }
    
    public boolean deleteAccount(String profile_id) {
        String sql = "delete from account where profile_id = '" + profile_id + "'";
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            state.executeQuery();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally {
            closePrepareStatement(state);
            closeConnection(conn);
        }
        return true;
    }
    
    public static void main(String[] args) {
        DAOAccount dao = new DAOAccount();
        dao.addAccount("12345", "1", "1");
    }

}
