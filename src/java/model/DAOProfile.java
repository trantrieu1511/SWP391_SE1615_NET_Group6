/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Employees;
import entity.Profile;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class DAOProfile extends ConnectDB {

    //INSERT
    public int addManager(Profile pro) {
        int n = 0;
        String sql = "insert into [Profile](profile_id,first_name,last_name,email,phone_number,hire_date,job_id,salary,department_id,username,[password])\n"
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

    public int addStaff(Profile pro) {
        int n = 0;
        String sql = "insert into [Profile](profile_id,first_name,last_name,email,phone_number,hire_date,job_id,salary,ReportsTo,department_id,username,[password])\n"
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
    public Vector<Profile> listAllProfile() {
        String sql = "select p.profile_id, p.first_name, p.last_name, p.email, p.phone_number, \n"
                + "	p.hire_date, j.job_title, p.salary, p.ReportsTo, p.isadmin, d.department_name,\n"
                + "	p.username, p.[password]\n"
                + "	from [Profile] p, departments d, jobs j\n"
                + "	where p.job_id = j.job_id and p.department_id = d.department_id";
        Vector<Profile> vector = new Vector<>();
        ResultSet rs = getData(sql);
        try {
            while (rs.next()) {
                vector.add(new Profile(
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
                        rs.getString(13) //password
                ));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vector;
    }

    public static void main(String[] args) {
        DAOProfile dao = new DAOProfile();
        Vector<Profile> vector = dao.listAllProfile();
        for (Profile profile : vector) {
            System.out.println(profile.toString());
        }
    }

}
