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

    public List<Projects> getProject(String profile_id) {
        List<Projects> list = new ArrayList<>();
        String sql = "select * from projects where manager_id = ?";
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            state.setString(1, profile_id);
            rs = state.executeQuery();
            while (rs.next()) {
                list.add(new Projects(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6)));
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

    public Projects getP(String title) {
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
                        rs.getString(6));
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
                + "rate, manager_id, description) values(?,?,?,?,?,?)";
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            state.setString(1, title);
            state.setString(2, client_id);
            state.setString(3, period);
            state.setDouble(4, rate);
            state.setString(5, manager_id);
            state.setString(6, desc);
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
            String period, double rate, String manager_id, String desc) {
        String sql = "update projects set title = ?, client_id = ?, period = ?"
                + ", rate = ?, manager_id = ?, description = ? where title = ?";
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            state.setString(1, newTitle);
            state.setString(2, client_id);
            state.setString(3, period);
            state.setDouble(4, rate);
            state.setString(5, manager_id);
            state.setString(6, desc);
            state.setString(7, title);
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

    public List<Projects> search(String title, String id) {
        List<Projects> list = new ArrayList<>();
        String sql = "select * from projects where title like ?"
                + " and manager_id = ?";
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            state.setString(1, "%" + title + "%");
            state.setString(2, id);
            rs = state.executeQuery();
            while (rs.next()) {
                list.add(new Projects(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6)));
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
        System.out.println(dao.deleteProject("Project demo"));
    }
}
