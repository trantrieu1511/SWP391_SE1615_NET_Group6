/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.account;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Khanh
 */
public class DAOAccount extends DBConnent {

    public account login(String user, String pass) {
        String sql = "select * from [account] where [username] = '" + user
                + "' and [password] = '" + pass + "'";
        try {
            ResultSet rs = getData(sql);
            while (rs.next()) {
                return new account(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getBoolean((4)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public account getAccount(String profile_id) {
        String sql = "select * from [account] where profile_id = '" + profile_id + "'";
        try {
            ResultSet rs = getData(sql);
            while (rs.next()) {
                return new account(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getBoolean((4)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean addAccount(String profile_id, String username, String password) {
        String sql = "insert into account(profile_id, username, password, isAdmin)"
                + "values('" + profile_id + "', '" + username + "', '" + password
                + "', " + 0 + ")";
        try {
            Statement state = conn.createStatement();
            state.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean editAccount(String profile_id, String username, String password) {
        String sql = "update account set username=?, password=? where profile_id=?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, username);
            pre.setString(2, password);
            pre.setString(3, profile_id);
            pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }
    
    public boolean deleteAccount(String profile_id) {
        String sql = "delete from account where profile_id = '" + profile_id + "'";
        try {
            Statement state = conn.createStatement();
            state.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        DAOAccount dao = new DAOAccount();
        dao.addAccount("12345", "1", "1");
    }
}
