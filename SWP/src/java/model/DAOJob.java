/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Jobs;
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
public class DAOJob extends DBConnect {

    Connection conn = null;
    PreparedStatement state = null;
    ResultSet rs = null;

    public List<Jobs> listAllJob() {
        List<Jobs> list = new ArrayList<>();
        String sql = "select * from [jobs]";
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            rs = state.executeQuery();
            while (rs.next()) {
                list.add(new Jobs(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getDouble(3),
                        rs.getDouble(4)));
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

    public Jobs getJobByTitle(String title) {
        String sql = "select * from jobs where [job_title] = ?";
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            state.setString(1, title);
            rs = state.executeQuery();
            while (rs.next()) {
                return new Jobs(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getDouble(3),
                        rs.getDouble(4));
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

    public Jobs getJobById(int id) {
        String sql = "select * from jobs where [job_id] = ?";
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            state.setInt(1, id);
            rs = state.executeQuery();
            while (rs.next()) {
                return new Jobs(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getDouble(3),
                        rs.getDouble(4));
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

    public List<Jobs> getJobBySalary(double min, double max) {
        String sql = "select * from jobs where min_salary = ? and max_salary = ?";
        List<Jobs> listJ = new ArrayList<>();
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql); 
            state.setDouble(1, min);
            state.setDouble(2, max);
            rs = state.executeQuery();
            while (rs.next()) {
                listJ.add(new Jobs(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getDouble(3),
                        rs.getDouble(4)));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            closeResultSet(rs);
            closePrepareStatement(state);
            closeConnection(conn);
        }
        return listJ;
    }
    
    public boolean addJob(String title, double min, double max) {
        String sql = "insert into jobs(job_title, min_salary, max_salary)"
                + "values(?, ?, ?)";
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            state.setString(1, title);
            state.setDouble(2, min);
            state.setDouble(2, max);
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
    
    public boolean deleteJob(int id) {
        String sql = "delete from jobs where job_id = ?";
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            state.setInt(1, id);
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
    
    public static void main(String[] args) {
        DAOJob dao = new DAOJob();
        List<Jobs> list = dao.listAllJob();
        System.err.println(dao.getJobByTitle("IOS Developer"));
    }

    public boolean editJob(int id, String title, double min, double max) {
        String sql = "update jobs set job_title=?, min_salary=?, max_salary=? where job_id=?";
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            state.setString(1, title);
            state.setDouble(2,min);
            state.setDouble(3,max);
            state.setInt(4, id);
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
}
