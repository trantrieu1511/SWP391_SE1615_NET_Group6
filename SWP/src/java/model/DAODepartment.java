/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.departments;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Khanh
 */
public class DAODepartment extends DBConnent {

    public List<departments> listAllDepartment() {
        List<departments> list = new ArrayList<>();
        String sql = "select * from [departments]";
        ResultSet rs = getData(sql);
        try {
            while (rs.next()) {
                list.add(new departments(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3)));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }
    
    public departments getDepartmentByName(String name) {
        String sql = "select * from departments where [department_name] = '" + name + "'";
        ResultSet rs = getData(sql);
        try {
            while (rs.next()) {
                return new departments(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public static void main(String[] args) {
        DAODepartment dao = new DAODepartment();
        List<departments> list = dao.listAllDepartment();
        for (departments a : list) {
            System.err.println(a.getName());
        }
    }
}
