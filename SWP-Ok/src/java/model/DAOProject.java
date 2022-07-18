/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Projects;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Khanh
 */
public class DAOProject extends DBConnect {
    
    Connection conn = null;
    PreparedStatement state = null;
    ResultSet rs = null;
    
    public List<Projects> listProject() {
        List<Projects> list = new ArrayList<>();
        String sql = "select * from projects";
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            rs = state.executeQuery();
            while (rs.next()) {
                list.add(new Projects(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7)));
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
    
    public Projects getProject(String title) {
        String sql = "select * from projects where title = ?";
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            state.setString(1, title);
            rs = state.executeQuery();
            while (rs.next()) {
                return new Projects(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7));
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
    
    public boolean addProject(String title, String client_id, String period,
            double rate, String manager_id, String desc) {
        String sql = "insert into projects(title, client_id, period, "
                + "rate, manager_id, description, status) values(?,?,?,?,?,?,?)";
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            state.setString(1, title);
            state.setString(2, client_id);
            state.setString(3, period);
            state.setDouble(4, rate);
            state.setString(5, manager_id);
            state.setString(6, desc);
            state.setInt(7, 0);
            state.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        } finally {
            closePrepareStatement(state);
            closeConnection(conn);
        }
        return true;
    }
    
    public boolean deleteProject(String title) {
        String sql = "delete from projects where title = ?";
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            state.setString(1, title);
            state.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        } finally {
            closePrepareStatement(state);
            closeConnection(conn);
        }
        return true;
    }
    
    public boolean updateProject(String title, String newTitle, String client_id,
            String period, double rate, String manager_id, String desc, int status) {
        String sql = "update projects set title = ?, client_id = ?, period = ?"
                + ", rate = ?, manager_id = ?, description = ?, status = ? where title = ?";
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            state.setString(1, newTitle);
            state.setString(2, client_id);
            state.setString(3, period);
            state.setDouble(4, rate);
            state.setString(5, manager_id);
            state.setString(6, desc);
            state.setInt(7, status);
            state.setString(8, title);          
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
    
    public List<Projects> search(String title) {
        List<Projects> list = new ArrayList<>();
        String sql = "select * from projects where title like ?";
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            state.setString(1, "%" + title + "%");
            rs = state.executeQuery();
            while (rs.next()) {
                list.add(new Projects(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7)));
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
        DAOProject dao = new DAOProject();
        DAOClients daoc = new DAOClients();
        System.out.println(dao.updateProject("Test", "Test 1", "BUKFS", "30/06/2022 - 17/8/2022", 10000, "ABCDE", "demo", 1));
    }
}
