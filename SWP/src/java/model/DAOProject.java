/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.projects;
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
public class DAOProject extends DBConnect {

    Connection conn = null;
    PreparedStatement state = null;
    ResultSet rs = null;

    public List<projects> getProject(String profile_id) {
        List<projects> list = new ArrayList<>();
        String sql = "select * from projects where manager_id = '" + profile_id + "'";
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            rs = state.executeQuery();
            while (rs.next()) {
                list.add(new projects(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getDouble(5),
                        rs.getString(6),
                        rs.getString(7)));
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

    public projects getP(String title) {
        String sql = "select * from projects where title = '" + title + "'";
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            rs = state.executeQuery();
            while (rs.next()) {
                return new projects(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getDouble(5),
                        rs.getString(6),
                        rs.getString(7));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closeResultSet(rs);
            closePrepareStatement(state);
            closeConnection(conn);
        }
        return null;
    }

    public boolean addProject(String title, String client_id, String start_date,
            String end_date, double rate, String manager_id, String desc) {
        String sql = "insert into projects(title, client_id, start_date, "
                + "end_date, rate, manager_id, description) values('" + title
                + "', '" + client_id + "', '" + start_date + "', '" + end_date
                + "', " + rate + ", '" + manager_id + "', '" + desc + "')";
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            state.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally {
            closePrepareStatement(state);
            closeConnection(conn);
        }
        return true;
    }

    public boolean deleteProject(String title) {
        String sql = "delete from projects where title = '" + title + "'";
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            state.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally {
            closePrepareStatement(state);
            closeConnection(conn);
        }
        return true;
    }

    public boolean updateProject(String title, String client_id, String start_date,
            String end_date, double rate, String manager_id, String desc) {
        String sql = "update projects set client_id = ?, start_date = ?"
                + ", end_date = ?, rate = ?, manager_id = ?, description = ? where title = ?";
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            state.setString(1, client_id);
            state.setString(2, start_date);
            state.setString(3, end_date);
            state.setDouble(4, rate);
            state.setString(5, manager_id);
            state.setString(6, desc);
            state.setString(7, title);
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

    public List<projects> search(String title, String id) {
        List<projects> list = new ArrayList<>();
        String sql = "select * from projects where title like '%" + title + "%'"
                + " and manager_id = '" + id + "'";
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            rs = state.executeQuery();
            while (rs.next()) {
                list.add(new projects(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getDouble(5),
                        rs.getString(6),
                        rs.getString(7)));
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

    public static void main(String[] args) {
        DAOProject dao = new DAOProject();
        System.out.println(dao.search("pro", "ABCDE"));
    }
}
