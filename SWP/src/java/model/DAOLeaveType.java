/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.LeaveType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class DAOLeaveType extends DBConnect {

    Connection conn = null;
    PreparedStatement state = null;
    ResultSet rs = null;

    public List<LeaveType> listAllLeaveType() {
        String sql = "select * from [leaveType]";
        List<LeaveType> list = new ArrayList<>();
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            rs = state.executeQuery();
            while (rs.next()) {
                list.add(new LeaveType(
                        rs.getInt(1),
                        rs.getString(2))
                );
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

    public LeaveType getLeaveTypeByID(String id) {
        String sql = "select * from [leaveType] where [id] = ?";
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            state.setString(1, id);
            rs = state.executeQuery();
            while (rs.next()) {
                return new LeaveType(
                        rs.getInt(1),
                        rs.getString(2));
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
        DAOLeaveType dao = new DAOLeaveType();
        List<LeaveType> list = dao.listAllLeaveType();
        for (LeaveType leaveType : list) {
            System.out.println(leaveType.toString());
        }
    }
}
