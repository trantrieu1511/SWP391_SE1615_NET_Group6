/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.jobs;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Khanh
 */
public class DAOJob extends DBConnect {
    
    public List<jobs> listAllJob() {
        List<jobs> list = new ArrayList<>();
        String sql = "select * from [jobs]";
        ResultSet rs = getData(sql);
        try {
            while (rs.next()) {
                list.add(new jobs(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getDouble(3),
                        rs.getDouble(4)));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }
    
    public jobs getJobByTitle(String title) {
        String sql = "select * from jobs where [job_title] = '" + title + "'";
        ResultSet rs = getData(sql);
        try {
            while (rs.next()) {
                return new jobs(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getDouble(3),
                        rs.getDouble(4));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public jobs getJobById(int id) {
        String sql = "select * from jobs where [job_id] = " + id;
        ResultSet rs = getData(sql);
        try {
            while (rs.next()) {
                return new jobs(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getDouble(3),
                        rs.getDouble(4));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public static void main(String[] args) {
        DAOJob dao = new DAOJob();
        List<jobs> list = dao.listAllJob();
        System.err.println(list);
    }
}
