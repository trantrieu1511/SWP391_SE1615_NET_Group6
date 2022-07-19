/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Leave;
import entity.Profile;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class DAOLeave extends DBConnect {

    Connection conn = null;
    PreparedStatement state = null;
    ResultSet rs = null;

    public List<Leave> listAllMyLeave(String id) {
        String sql = "select p.report_to, p.annual_leave, l.* \n"
                + "from leave l join [profile] p\n"
                + "on l.profile_id = p.profile_id\n"
                + "where l.profile_id = ?";
        List<Leave> list = new ArrayList<>();
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            state.setString(1, id);
            rs = state.executeQuery();
            while (rs.next()) {
                list.add(new Leave(
                        rs.getString(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getInt(10)
                ));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            closeResultSet(rs);
            closePrepareStatement(state);
            closeConnection(conn);
        }
        return list;
    }

    public List<Leave> listAllCheckLeaveAdmin() {
        String sql = "select p.first_name, p.last_name, p.job_id, p.annual_leave, l.* \n"
                + "from leave l join [profile] p\n"
                + "on l.profile_id = p.profile_id\n"
                + "join account a\n"
                + "on l.profile_id = a.profile_id\n"
                + "where a.isadmin = 0 and p.report_to is null";
        List<Leave> list = new ArrayList<>();
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            rs = state.executeQuery();
            while (rs.next()) {
                list.add(new Leave(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getInt(12)
                ));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            closeResultSet(rs);
            closePrepareStatement(state);
            closeConnection(conn);
        }
        return list;
    }

    public List<Leave> listAllCheckLeaveManager(String id) {
        String sql = "select p.first_name, p.last_name, p.job_id, p.annual_leave, l.* \n"
                + "from leave l join [profile] p\n"
                + "on l.profile_id = p.profile_id\n"
                + "where p.report_to = ?";
        List<Leave> list = new ArrayList<>();
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            state.setString(1, id);
            rs = state.executeQuery();
            while (rs.next()) {
                list.add(new Leave(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getInt(12)
                ));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            closeResultSet(rs);
            closePrepareStatement(state);
            closeConnection(conn);
        }
        return list;
    }

    public Leave getLeaveByID(String profile_id) {
        String sql = "select * from [leave] where [profile_id] = ?";
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            state.setString(1, profile_id);
            rs = state.executeQuery();
            while (rs.next()) {
                return new Leave(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getInt(8));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            closeResultSet(rs);
            closePrepareStatement(state);
            closeConnection(conn);
        }
        return null;
    }

    public static void main(String[] args) {
        DAOLeave dao = new DAOLeave();
        List<Leave> list = dao.listAllCheckLeaveManager("TT002");
        for (Leave leave : list) {
            System.out.println(leave.toString());
        }
//        System.out.println(dao.getLeaveByID("TT002"));
    }
}
