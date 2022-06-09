/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.departments;
import entity.profile;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class DAOProfile extends DBConnent {

    public boolean addManager(profile pro) {
        String sql = "insert into [profile](profile_id,full_name,email,phone_number,hire_date,department_id,job_id,salary)\n"
                + "values ("
                + "'" + pro.getProfile_id() + "', "
                + "'" + pro.getFull_name() + "', "
                + "'" + pro.getEmail() + "', "
                + "'" + pro.getPhone_number() + "', "
                + "'" + pro.getHire_date() + "', "
                + "" + pro.getDepartment_id() + ", "
                + "" + pro.getJob_id() + ", "
                + "" + pro.getSalary() + ", "
                + ")";
        try {
            Statement state = conn.createStatement();
            state.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean addStaff(profile pro) {
        String sql = "insert into [profile](profile_id,full_name,email,"
                + "phone_number,hire_date,department_id,job_id,salary,report_to,) values ("
                + "'" + pro.getProfile_id() + "', "
                + "'" + pro.getFull_name() + "', "
                + "'" + pro.getEmail() + "', "
                + "'" + pro.getPhone_number() + "', "
                + "'" + pro.getHire_date() + "', "
                + "" + pro.getDepartment_id() + ", "
                + "" + pro.getJob_id() + ", "
                + "" + pro.getSalary() + ", "
                + "'" + pro.getReportto() + "', "
                + ")";
        try {
            Statement state = conn.createStatement();
            state.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean editStaff(String profile_id, String full_name, String email,
            String phone_number, String hire_date, int department_id, int job_id,
            double salary, String reportto) {
        String sql = "update [Profile] set "
                + "full_name = ?, "
                + "email = ?, "
                + "phone_number = ?, "
                + "hire_date = ?, "
                + "department_id = ?, "
                + "job_id = ?, "
                + "salary = ?, "
                + "report_to = ?, "
                + "where profile_id = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, full_name);
            pre.setString(2, email);
            pre.setString(3, phone_number);
            pre.setString(4, hire_date);
            pre.setInt(5, job_id);
            pre.setInt(6, department_id);
            pre.setDouble(7, salary);
            pre.setString(8, reportto);
            pre.setString(9, profile_id);
            pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    public List<profile> listAllStaff(String id) {
        String sql = "select * from [profile] where profile_id = '" + id + "'";
        List<profile> list = new ArrayList<>();
        ResultSet rs = getData(sql);
        try {
            while (rs.next()) {
                list.add(new profile(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getDouble(8),
                        rs.getString(9)));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public profile getByUser(String user) {
        String sql = "select * from [profile] where [username] = '" + user + "'";
        ResultSet rs = getData(sql);
        try {
            while (rs.next()) {
                return new profile(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getDouble(8),
                        rs.getString(9));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public profile getByID(String profile_id) {
        String sql = "select * from [profile] where [profile_id] = '" + profile_id + "'";
        ResultSet rs = getData(sql);
        try {
            while (rs.next()) {
                return new profile(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getDouble(8),
                        rs.getString(9));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public boolean deleteProfile(String profile_id) {
        String sql = "delete from [profile] where [profile_id] = '" + profile_id + "'";
        try {
            Statement state = conn.createStatement();
            state.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
    }

}
