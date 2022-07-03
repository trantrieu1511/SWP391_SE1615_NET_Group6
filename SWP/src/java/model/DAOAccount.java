/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Account;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Khanh
 */
public class DAOAccount extends DBConnect {

    Connection conn = null;
    PreparedStatement state = null;
    ResultSet rs = null;

    public Account login(String user, String pass) {
        String sql = "select * from [account] where [username] = ? and [password] = ?";
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            state.setString(1, user);
            state.setString(2, pass);
            rs = state.executeQuery();
            while (rs.next()) {
                return new Account(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getBoolean(4),
                        rs.getBoolean(5));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            closeResultSet(rs);
            closePrepareStatement(state);
            closeConnection(conn);
        }
        return null;
    }

    public Account getAccount(String profile_id) {
        String sql = "select * from [account] where profile_id = ?";
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            state.setString(1, profile_id);
            rs = state.executeQuery();
            while (rs.next()) {
                return new Account(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getBoolean(4),
                        rs.getBoolean(5));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            closeResultSet(rs);
            closePrepareStatement(state);
            closeConnection(conn);
        }
        return null;
    }

//    public List<Account> getAccountwithList(String profile_id) {
//        List<Account> list = new ArrayList<>();
//        String sql = "select * from [account] where profile_id = ?";
//        try {
//            conn = getConnection();
//            state = conn.prepareStatement(sql);
//            state.setString(1, profile_id);
//            rs = state.executeQuery();
//            while (rs.next()) {
//                list.add(new Account(
//                        rs.getString(1),
//                        rs.getString(2),
//                        rs.getString(3),
//                        rs.getBoolean(4),
//                        rs.getBoolean(5)));
//            }
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        } finally {
//            closeResultSet(rs);
//            closePrepareStatement(state);
//            closeConnection(conn);
//        }
//        return list;
//    }

    public boolean addAccount(String profile_id, String username, String password) {
        String sql = "insert into account(profile_id, username, password, isadmin, ismanager)"
                + "values(?,?,?,?,?)";
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            state.setString(1, profile_id);
            state.setString(2, username);
            state.setString(3, password);
            state.setInt(4, 0);
            state.setInt(5, 0);
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

    public boolean editAccount(String profile_id, String username, String password) {
        String sql = "update account set username=?, password=? where profile_id=?";
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            state.setString(1, username);
            state.setString(2, password);
            state.setString(3, profile_id);
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

    public boolean deleteAccount(String profile_id) {
        String sql = "delete from account where profile_id = ?";
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            state.setString(1, profile_id);
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
        DAOAccount dao = new DAOAccount();
        System.out.println(dao.login("manager", "khanhcnn49"));
    }

}
