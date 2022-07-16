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
import java.sql.SQLException;
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
                        rs.getBoolean(5),
                        rs.getBoolean(6));
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

    public boolean addAMAccount(String profile_id, String username, String password, int isA, int isM) {
        String sql = "insert into account(profile_id, username, password, isadmin, ismanager, status)"
                + "values('" + profile_id + "', '" + username + "', '" + password
                + "', " + isA + ", " + isM + ", " + 1 + ")";
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
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
                        rs.getBoolean(5),
                        rs.getBoolean(6));
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

    public String getProfileId(String email) {
        String sql = "select * from [profile] where [email] = '" + email + "'";
        try {
            ResultSet rs = getData(sql);
            rs.next();
            return rs.getString(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public boolean GetNewPassword(String password, String profile_id) {
        String sql = "update account set password=? where profile_id=?";
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            state.setString(1, password);
            state.setString(2, profile_id);
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
    
    public List<Account> getADandMNAccount() {
        String sql = " SELECT account.*"
                + "  FROM [account], [profile] \n"
                + "  WHERE account.profile_id = profile.profile_id and "
                + "  report_to is NULL";
        List<Account> list = new ArrayList<>();
        try {
            ResultSet rs = getData(sql);
            while (rs.next()) {
                list.add(new Account(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getBoolean(4),
                        rs.getBoolean(5),
                        rs.getBoolean(6)));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            closeResultSet(rs);
            closePrepareStatement(state);
            closeConnection(conn);
        }
        return list;
    }
    
    public static void main(String[] args) {
        DAOAccount dao = new DAOAccount();
        System.out.println(dao.login("mana01", "mana001"));
    }

}
