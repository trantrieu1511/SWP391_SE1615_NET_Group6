/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.task;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Khanh
 */
public class DAOTask extends DBConnect {
    
    Connection conn = null;
    PreparedStatement state = null;
    ResultSet rs = null;
    
    public boolean add(String name, int priority, String deadline, int status, String assigned, String project) {
        String sql = "insert into task(name, priority, deadline, status, assigned, project)"
                + " values(?,?,?,?,?,?)";
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            state.setString(1, name);
            state.setInt(2, priority);
            state.setString(3, deadline);
            state.setInt(4, status);
            state.setString(5, assigned);
            state.setString(6, project);
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
    
    public task getByName(String name) {
        String sql = "select * from task where name = ?";
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            state.setString(1, name);
            rs = state.executeQuery();
            while (rs.next()) {
                return new task(rs.getString(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6));
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
    
    public List<task> list(int status) {
        List<task> list = new ArrayList<>();
        String sql = "select * from task where status = ?";
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            state.setInt(1, status);
            rs = state.executeQuery();
            while (rs.next()) {
                list.add(new task(rs.getString(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6)));
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
    
    public List<task> listProjectTask(int status, String title) {
        List<task> list = new ArrayList<>();
        String sql = "select * from task where status = ? and project like ?";
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            state.setInt(1, status);
            state.setString(2, "%" + title + "%");
            rs = state.executeQuery();
            while (rs.next()) {
                list.add(new task(rs.getString(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6)));
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
    
    public boolean updateStatus(int status, String name) {
        String sql = "update task set status = ? where name = ?";
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            state.setInt(1, status);
            state.setString(2, name);
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
        DAOTask dao = new DAOTask();
        System.out.println(dao.listProjectTask(0, ""));
    }
}
