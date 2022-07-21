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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

    SimpleDateFormat myFormat = new SimpleDateFormat("dd/MM/yyyy");
    SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd");

    public boolean addLeave(Leave leave) {
        String sql = "insert into leave(profile_id, leave_type, [from], [to], number_of_days, reason)\n"
                + "values(?, ?, ?, ?, DATEDIFF(DAY,?,?), ?)";
        String from = leave.getFrom();
        String to = leave.getTo();
        try {
            Date from_date = myFormat.parse(from);
            Date to_date = myFormat.parse(to);
            from = df2.format(from_date);
            to = df2.format(to_date);
            conn = getConnection();
            state = conn.prepareStatement(sql);
            state.setString(1, leave.getProfile_id());
            state.setInt(2, leave.getLeave_type());
            state.setString(3, leave.getFrom());
            state.setString(4, leave.getTo());
            state.setString(5, from);
            state.setString(6, to);
            state.setString(7, leave.getReason());
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

    public boolean editLeave(Leave leave) {
        String sql = "update leave\n"
                + "set\n"
                + "leave_type = ?,\n"
                + "[from] = ?,\n"
                + "[to] = ?,\n"
                + "number_of_days = DATEDIFF(DAY,?,?),\n"
                + "reason = ?\n"
                + "where id = ?";
        String from = leave.getFrom();
        String to = leave.getTo();
        try {
            Date from_date = myFormat.parse(from);
            Date to_date = myFormat.parse(to);
            from = df2.format(from_date);
            to = df2.format(to_date);
            conn = getConnection();
            state = conn.prepareStatement(sql);
            state.setInt(1, leave.getLeave_type());
            state.setString(2, leave.getFrom());
            state.setString(3, leave.getTo());
            state.setString(4, from);
            state.setString(5, to);
            state.setString(6, leave.getReason());
            state.setInt(7, leave.getId());
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

    public boolean deleteLeave(int id) {
        String sql = "delete from leave where id = ?";
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            state.setInt(1, id);
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

    public boolean DecrementAnnualLeave(String profile_id) {
        String sql = "update [profile]\n"
                + "set [annual_leave] -= 1 --add\n"
                + "where profile_id = ?";
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

    public boolean IncrementAnnualLeave(String profile_id) {
        String sql = "update [profile]\n"
                + "set [annual_leave] += 1 --delete\n"
                + "where profile_id = ?";
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
        DAOLeave dao = new DAOLeave();
//        List<Leave> list = dao.listAllCheckLeaveManager("TT002");
//        for (Leave leave : list) {
//            System.out.println(leave.toString());
//        }
//        System.out.println(dao.getLeaveByID("TT002"));

    }
}
