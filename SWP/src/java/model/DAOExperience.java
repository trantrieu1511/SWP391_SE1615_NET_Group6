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
        } catch (Exception ex) {
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
                + "'" + exp.getRole() + "', "
                + "'" + exp.getStart_date() + "', "
                + "'" + exp.getEnd_date() + "')";
        try {
            conn = getConnection();
            state = conn.createStatement();
            state.executeUpdate(sql);
            status = true;
        } catch (Exception ex) {
            ex.printStackTrace();
            status = false;
        } finally {
            closeStatement(state);
            closeConnection(conn);
        }
        return status;
    }

    public boolean editExperience(experience exp, String cur_role) {
        String sql = "update [experience]\n"
                + "set\n"
                + "[role] = ?,\n"
                + "[start_date] = ?,\n"
                + "[end_date] = ?\n"
                + "where profile_id = ?\n"
                + "and [role] = ?";
        conn = getConnection();
        try {
            pre = conn.prepareStatement(sql);
            pre.setString(1, exp.getRole());
            pre.setString(2, exp.getStart_date());
            pre.setString(3, exp.getEnd_date());
            pre.setString(4, exp.getProfile_id());
            pre.setString(5, cur_role);
            pre.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        } finally {
            closePrepareStatement(pre);
            closeConnection(conn);
        }
        return true;
    }

    public boolean deleteExperience(String profile_id, String role) {
        String sql = "delete from [experience] where "
                + "[profile_id] = '" + profile_id + "' "
                + "and [role] = '" + role + "'";
        try {
            conn = getConnection();
            state = conn.createStatement();
            state.executeUpdate(sql);
        } catch (Exception ex) {
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
