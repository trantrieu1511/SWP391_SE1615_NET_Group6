/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Task;
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
    
    public Task getById(int id) {
        String sql = "select * from task where id = ?";
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            state.setInt(1, id);
            rs = state.executeQuery();
            while (rs.next()) {
                return new Task(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7));
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
    
    public List<Task> list(int status) {
        List<Task> list = new ArrayList<>();
        String sql = "select * from task where status = ?";
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            state.setInt(1, status);
            rs = state.executeQuery();
            while (rs.next()) {
                list.add(new Task(rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7)));
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
    
    public List<Task> listAllTask() {
        List<Task> list = new ArrayList<>();
        String sql = "select * from task";
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            rs = state.executeQuery();
            while (rs.next()) {
                list.add(new Task(rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7)));
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
    
    public List<Task> listProjectTask(String title) {
        List<Task> list = new ArrayList<>();
        String sql = "select * from task where project like ?";
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            state.setString(1, "%" + title + "%");
            rs = state.executeQuery();
            while (rs.next()) {
                list.add(new Task(rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7)));
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
    
    public List<Task> listProjectTask(int status, String title) {
        List<Task> list = new ArrayList<>();
        String sql = "select * from task where status = ? and project like ?";
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            state.setInt(1, status);
            state.setString(2, "%" + title + "%");
            rs = state.executeQuery();
            while (rs.next()) {
                list.add(new Task(rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7)));
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
    
    public List<Task> listTaskAssignedTo(String profile_id) {
        List<Task> list = new ArrayList<>();
        String sql = "select * from task where assigned = ?";
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            state.setString(1, profile_id);
            rs = state.executeQuery();
            while (rs.next()) {
                list.add(new Task(rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7)));
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
    
    public List<Task> listTaskAssignedTo(String profile_id, int status) {
        List<Task> list = new ArrayList<>();
        String sql = "select * from task where assigned = ? and status = ?";
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            state.setString(1, profile_id);
            state.setInt(2, status);
            rs = state.executeQuery();
            while (rs.next()) {
                list.add(new Task(rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7)));
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
    
    public boolean updateStatus(int status, int id) {
        String sql = "update task set status = ? where id = ?";
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            state.setInt(1, status);
            state.setInt(2, id);
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
    
    public boolean deleteTask(int id) {
        String sql = "delete from task where id = ?";
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            state.setInt(1, id);
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
        System.out.println(dao.listProjectTask(0, "Test"));
    }
}
