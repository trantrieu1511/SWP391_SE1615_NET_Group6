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

    //INSERT
    public int addManager(profile pro) {
        int n = 0;
        String sql = "insert into [profile](profile_id,first_name,last_name,email,phone_number,hire_date,job_id,salary,department_id,username,[password])\n"
                + "values ("
                + "'" + pro.getProfile_id() + "', "
                + "'" + pro.getFirst_name() + "', "
                + "'" + pro.getLast_name() + "', "
                + "'" + pro.getEmail() + "', "
                + "'" + pro.getPhone_number() + "', "
                + "'" + pro.getHire_date() + "', "
                + "" + pro.getJob_id() + ", "
                + "" + pro.getSalary() + ", "
                + "" + pro.getDepartment_id() + ", "
                + "'" + pro.getUsername() + "', "
                + "'" + pro.getPassword() + "' "
                + ")";
        try {
            Statement state = conn.createStatement();
            n = state.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }

    public int addStaff(profile pro) {
        int n = 0;
        String sql = "insert into [profile](profile_id,first_name,last_name,email,phone_number,hire_date,job_id,salary,ReportsTo,department_id,username,[password])\n"
                + "values ("
                + "'" + pro.getProfile_id() + "', "
                + "'" + pro.getFirst_name() + "', "
                + "'" + pro.getLast_name() + "', "
                + "'" + pro.getEmail() + "', "
                + "'" + pro.getPhone_number() + "', "
                + "'" + pro.getHire_date() + "', "
                + "" + pro.getJob_id() + ", "
                + "" + pro.getSalary() + ", "
                + "'" + pro.getReportto() + "', "
                + "" + pro.getDepartment_id() + ", "
                + "'" + pro.getUsername() + "', "
                + "'" + pro.getPassword() + "' "
                + ")";
        try {
            Statement state = conn.createStatement();
            n = state.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }

    public void editStaff(profile pro, String id) {
        String sql = "update [Profile] set "
                + "profile_id = ?, "
                + "first_name = ?, "
                + "last_name = ?, "
                + "email = ?, "
                + "phone_number = ?, "
                + "hire_date = ?, "
                + "job_id = ?, "
                + "salary = ?, "
                + "ReportsTo = ?, "
                + "department_id = ?, "
                + "username = ?, "
                + "[password] = ? "
                + "where profile_id = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, pro.getProfile_id());
            pre.setString(2, pro.getFirst_name());
            pre.setString(3, pro.getLast_name());
            pre.setString(4, pro.getEmail());
            pre.setString(5, pro.getPhone_number());
            pre.setString(6, pro.getHire_date());
            pre.setInt(7, pro.getJob_id());
            pre.setDouble(8, pro.getSalary());
            pre.setString(9, pro.getReportto());
            pre.setInt(10, pro.getDepartment_id());
            pre.setString(11, pro.getUsername());
            pre.setString(12, pro.getPassword());
            pre.setString(13, id);
            pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public List<profile> listAllProfile(String id) {
        String sql = "select p.profile_id, p.first_name, p.last_name, p.email, p.phone_number, \n"
                + "	p.hire_date, j.job_title, p.salary, p.ReportsTo, p.isadmin, d.department_name,\n"
                + "	p.username, p.[password]\n"
                + "	from [Profile] p, departments d, jobs j\n"
                + "	where p.job_id = j.job_id and p.department_id = d.department_id\n"
                + "     and ReportsTo = '" + id + "'";
        List<profile> list = new ArrayList<>();
        ResultSet rs = getData(sql);
        try {
            while (rs.next()) {
                list.add(new profile(
                        rs.getString(1), //employee_id
                        rs.getString(2), //first_name
                        rs.getString(3), //last_name
                        rs.getString(4), //email
                        rs.getString(5), //phone_number
                        rs.getString(6), //hire_date
                        rs.getString(7), //job_title
                        rs.getDouble(8), //salary
                        rs.getString(9), //ReportsTo
                        rs.getBoolean(10), //isadmin
                        rs.getString(11), //department_name
                        rs.getString(12), //username
                        rs.getString(13)));
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
                return new profile(rs.getString(1), //employee_id
                        rs.getString(2), //first_name
                        rs.getString(3), //last_name
                        rs.getString(4), //email
                        rs.getString(5), //phone_number
                        rs.getString(6), //hire_date
                        rs.getInt(7), //job_id
                        rs.getDouble(8), //salary
                        rs.getString(9), //ReportsTo
                        rs.getBoolean(10), //isadmin
                        rs.getInt(11), //department_id
                        rs.getString(12), //username
                        rs.getString(13));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        DAOProfile dao = new DAOProfile();
        List<profile> list = dao.listAllProfile("12345");
        for (profile o : list) {
            System.out.println(o.getReportto());
        }
    }

}
