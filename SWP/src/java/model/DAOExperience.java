/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Experience;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class DAOExperience extends DBConnect {

    Connection conn = null;
    PreparedStatement state = null;
    ResultSet rs = null;

    public List<Experience> listIndividualExperience(String profile_id) {
        List<Experience> elist = new ArrayList<>();
        String sql = "select * from [experience] where profile_id = ?";
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            state.setString(1, profile_id);
            rs = state.executeQuery();
            while (rs.next()) {
                elist.add(new Experience(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4)));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            closeResultSet(rs);
            closePrepareStatement(state);
            closeConnection(conn);
        }
        return elist;
    }

    public boolean addExperience(Experience exp) {
        boolean status = false;
        String sql = "insert into [experience] values (?,?,?,?)";
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            state.setString(1, exp.getProfile_id());
            state.setString(2, exp.getRole());
            state.setString(3, exp.getStart_date());
            state.setString(4, exp.getEnd_date());
            status = true;
            state.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
            status = false;
        } finally {
            closePrepareStatement(state);
            closeConnection(conn);
        }
        return status;
    }

    public boolean editExperience(Experience exp, String cur_role) {
        String sql = "update [experience]\n"
                + "set\n"
                + "[role] = ?,\n"
                + "[start_date] = ?,\n"
                + "[end_date] = ?\n"
                + "where profile_id = ?\n"
                + "and [role] = ?";
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            state.setString(1, exp.getRole());
            state.setString(2, exp.getStart_date());
            state.setString(3, exp.getEnd_date());
            state.setString(4, exp.getProfile_id());
            state.setString(5, cur_role);
            state.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        } finally {
            closePrepareStatement(state);
            closeConnection(conn);
        }
        return true;
    }

    public boolean deleteExperience(String profile_id, String role) {
        String sql = "delete from [experience] where [profile_id] = ? and [role] = ?";
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            state.setString(1, profile_id);
            state.setString(2, role);
            state.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        } finally {
            closePrepareStatement(state);
            closeConnection(conn);
        }
        return true;
    }

    public boolean deleteAllExperience(String profile_id) {
        String sql = "delete from [experience] where [profile_id] = ?";
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            state.setString(1, profile_id);
            state.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        } finally {
            closePrepareStatement(state);
            closeConnection(conn);
        }
        return true;
    }

    public static void main(String[] args) {
        DAOExperience daoexp = new DAOExperience();
//        List<experience> list = dao.listIndividualExperience("ABCDE");
//        for (Experience exp : list) {
//            System.out.println(exp.toString());
//        }
//        String profile_id = "MRNEW";
//        Experience exp = new Experience(profile_id, "Enterrole", "GETDATE()",
//                "GETDATE()");
//        boolean statusexp = daoexp.addExperience(exp);
//        if (statusexp) {
//            System.out.println("Successfully added new Experience for Staff with profile_id = " + profile_id);
//        } else {
//            System.out.println("Fail to added new Experience for Staff with profile_id = " + profile_id);
//        }

    }

}
