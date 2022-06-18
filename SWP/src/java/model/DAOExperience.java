/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.experience;
import java.sql.Connection;
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
public class DAOExperience extends DBConnect {

    Connection conn = null;
    PreparedStatement pre = null;
    Statement state = null;
    ResultSet rs = null;

    public List<experience> listIndividualExperience(String profile_id) {
        List<experience> elist = new ArrayList<>();
        String sql = "select * from [experience] where profile_id = '" + profile_id + "'";
        try {
            conn = getConnection();
            pre = conn.prepareStatement(sql);
            rs = pre.executeQuery();
            while (rs.next()) {
                elist.add(new experience(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4)));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closeResultSet(rs);
            closePrepareStatement(pre);
            closeConnection(conn);
        }
        return elist;
    }

    public boolean addExperience(experience exp) {
        boolean status = false;
        String sql = "insert into [experience]\n"
                + "values ("
                + "'" + exp.getProfile_id() + "', "
                + "'" + exp.getRole() + "',"
                + "" + exp.getStart_date() + ","
                + "" + exp.getEnd_date() + ")";
        try {
            conn = getConnection();
            state = conn.createStatement();
            state.executeUpdate(sql);
            status = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            status = false;
        } finally {
            closeStatement(state);
            closeConnection(conn);
        }
        return status;
    }

    public boolean editExperience(experience exp) {
        boolean status = false;
        String sql = "update [experience]\n"
                + "set\n"
                + "[role] = '" + exp.getRole() + "',\n"
                + "[start_date] = '" + exp.getStart_date() + "',\n"
                + "[end_date] = '" + exp.getEnd_date() + "'\n"
                + "where profile_id = '" + exp.getProfile_id() + "'";
        conn = getConnection();
        try {
            state = conn.createStatement();
            state.executeUpdate(sql);
            status = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            status = false;
        } finally {
            closeStatement(state);
            closeConnection(conn);
        }
        return status;
    }

    public boolean deleteExperience(String profile_id) {
        String sql = "delete from [experience] where [profile_id] = '" + profile_id + "'";
        try {
            conn = getConnection();
            state = conn.createStatement();
            state.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally {
            closeStatement(state);
            closeConnection(conn);
        }
        return true;
    }

    public static void main(String[] args) {
        DAOExperience daoexp = new DAOExperience();
//        List<experience> list = dao.listIndividualExperience("ABCDE");
//        for (experience exp : list) {
//            System.out.println(exp.toString());
//        }
//        String profile_id = "MRNEW";
//        experience exp = new experience(profile_id, "Enterrole", "GETDATE()",
//                "GETDATE()");
//        boolean statusexp = daoexp.addExperience(exp);
//        if (statusexp) {
//            System.out.println("Successfully added new experience for Staff with profile_id = " + profile_id);
//        } else {
//            System.out.println("Fail to added new experience for Staff with profile_id = " + profile_id);
//        }

    }

}
