/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.departments;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Khanh
 */
public class DAODepartment extends DBConnect {

    Connection conn = null;
    PreparedStatement state = null;
    ResultSet rs = null;

    public List<departments> listAllDepartment() {
        List<departments> list = new ArrayList<>();
        String sql = "select * from [departments]";
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            rs = state.executeQuery();
            while (rs.next()) {
                list.add(new departments(
                        rs.getInt(1),
                        rs.getString(2)));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closeResultSet(rs);
            closePrepareStatement(state);
            closeConnection(conn);
        }
        return list;
    }

    public departments getDepartmentByName(String name) {
        String sql = "select * from departments where [department_name] = '" + name + "'";
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            rs = state.executeQuery();
            while (rs.next()) {
                return new departments(
                        rs.getInt(1),
                        rs.getString(2));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closeResultSet(rs);
            closePrepareStatement(state);
            closeConnection(conn);
        }
        return null;
    }

    public departments getDepartmentByID(int id) {
        String sql = "select * from departments where [department_id] = " + id;
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            rs = state.executeQuery();
            while (rs.next()) {
                return new departments(
                        rs.getInt(1),
                        rs.getString(2));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closeResultSet(rs);
            closePrepareStatement(state);
            closeConnection(conn);
        }
        return null;
    }

    public static void main(String[] args) {
        DAODepartment dao = new DAODepartment();
//        List<departments> list = dao.listAllDepartment();
//        for (departments a : list) {
//            System.err.println(a.getName());
//        }
        departments department = dao.getDepartmentByID(1);
        System.out.println(department.toString());
    }
}
