/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Departments;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

    public List<Departments> listAllDepartment() {
        List<Departments> list = new ArrayList<>();
        String sql = "select * from [departments]";
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            rs = state.executeQuery();
            while (rs.next()) {
                list.add(new Departments(
                        rs.getInt(1),
                        rs.getString(2)));
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

    public Departments getDepartmentByName(String name) {
        String sql = "select * from departments where [department_name] = ?";
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            state.setString(1, name);
            rs = state.executeQuery();
            while (rs.next()) {
                return new Departments(
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

    public Departments getDepartmentByID(int id) {
        String sql = "select * from departments where [department_id] = ?";
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            state.setInt(1, id);
            rs = state.executeQuery();
            while (rs.next()) {
                return new Departments(
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
        DAODepartment dao = new DAODepartment();
//        List<departments> list = dao.listAllDepartment();
//        for (Departments a : list) {
//            System.err.println(a.getName());
//        }
        Departments department = dao.getDepartmentByID(1);
        System.out.println(department.toString());
    }
}
