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
import java.util.Vector;

/**
 *
 * @author DELL
 */
public class DAOProfile extends DBConnent {

    public boolean addManager(profile pro) {
        String sql = "insert into [profile](profile_id,first_name,last_name,email,phone_number,hire_date,department_id,job_id,salary)\n"
                + "values ("
                + "'" + pro.getProfile_id() + "', "
                + "'" + pro.getFirst_name() + "', "
                + "'" + pro.getLast_name() + "', "
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
        String sql = "insert into [profile](profile_id,first_name,last_name,email,"
                + "phone_number,hire_date,department_id,job_id,salary,report_to) values ("
                + "'" + pro.getProfile_id() + "', "
                + "'" + pro.getFirst_name() + "', "
                + "'" + pro.getLast_name() + "', "
                + "'" + pro.getEmail() + "', "
                + "'" + pro.getPhone_number() + "', "
                + "'" + pro.getHire_date() + "', "
                + "" + pro.getDepartment_id() + ", "
                + "" + pro.getJob_id() + ", "
                + "" + pro.getSalary() + ", "
                + "'" + pro.getReportto() + "')";
        try {
            Statement state = conn.createStatement();
            state.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean editStaff(String profile_id, String first_name, String last_name, 
            String email, String phone_number, String hire_date, int department_id, 
            int job_id, double salary, String reportto) {
        String sql = "update [profile] set "
                + "first_name = ?, "
                + "last_name = ?, "
                + "email = ?, "
                + "phone_number = ?, "
                + "hire_date = ?, "
                + "department_id = ?, "
                + "job_id = ?, "
                + "salary = ?, "
                + "report_to = ? "
                + "where profile_id = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, first_name);
            pre.setString(2, last_name);
            pre.setString(3, email);
            pre.setString(4, phone_number);
            pre.setString(5, hire_date);
            pre.setInt(6, job_id);
            pre.setInt(7, department_id);
            pre.setDouble(8, salary);
            pre.setString(9, reportto);
            pre.setString(10, profile_id);
            pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    public List<profile> listAllStaff(String id) {
        String sql = "select * from [profile] where report_to = '" + id + "'";
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
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getDouble(9),
                        rs.getString(10)));
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
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getDouble(9),
                        rs.getString(10));
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
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getDouble(9),
                        rs.getString(10));
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
        DAOProfile dao = new DAOProfile();
        List<profile> staff = dao.listAllStaff("ABCDE");
        for (profile object : staff) {
            System.out.println(object.toString());
        }
    }

}
