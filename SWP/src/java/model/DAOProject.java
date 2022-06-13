/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
 
import entity.projects;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

/**
 *
 * @author Khanh
 */
public class DAOProject extends DBConnect {
    public projects getProject(String profile_id) {
        String sql = "select * from projects where manager_id = '" + profile_id + "'";
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
    
    public boolean addProject(String title, String client_id, Date start_date,
            Date end_date, double rate, String manager_id, String desc) {
        String sql = "insert into projects(title, client_id, start_date, "
                + "end_date, rate, manager_id, description) values('" + title + 
                "', '" + client_id + "', '" + start_date + "', '" + end_date +
                "', " + rate + ", '" + manager_id + "', '" + desc + "')";
        try {
            Statement state = conn.createStatement();
            state.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }
}
