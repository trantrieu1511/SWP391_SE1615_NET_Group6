/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.profile;
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
                + "'" + pro.getReportsTo() + "', "
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

    //SELECT
    public List<profile> listAllProfile() {
        String sql = "select * from [profile]";
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
                        rs.getInt(7), //job_id
                        rs.getDouble(8), //salary
                        rs.getString(9), //ReportsTo
                        rs.getBoolean(10), //isadmin
                        rs.getInt(11), //department_id
                        rs.getString(12), //username
                        rs.getString(13) //password
                ));
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
        List<profile> list = dao.listAllProfile();
        System.out.println(list);
    }

}
