/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.projects;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Khanh
 */
public class DAOProject extends DBConnect {

    public List<projects> getProject(String profile_id) {
        List<projects> list = new ArrayList<>();
        String sql = "select * from projects where manager_id = '" + profile_id + "'";
        ResultSet rs = getData(sql);
        try {
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
        }
        return list;
    }

    public projects getP(String title) {
        String sql = "select * from projects where title = '" + title + "'";
        ResultSet rs = getData(sql);
        try {
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
            Statement state = conn.createStatement();
            state.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean deleteProject(String title) {
        String sql = "delete from projects where title = '" + title + "'";
        try {
            Statement state = conn.createStatement();
            state.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean updateProject(String title, String client_id, String start_date,
            String end_date, double rate, String manager_id, String desc) {
        String sql = "update projects set client_id = ?, start_date = ?"
                + ", end_date = ?, rate = ?, manager_id = ?, description = ? where title = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, client_id);
            pre.setString(2, start_date);
            pre.setString(3, end_date);
            pre.setDouble(4, rate);
            pre.setString(5, manager_id);
            pre.setString(6, desc);
            pre.setString(7, title);
            pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
