/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Company;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class DAOCompany extends DBConnect {

    Connection conn = null;
    PreparedStatement state = null;
    ResultSet rs = null;

    public List<Company> listAllCompany() {
        List<Company> list = new ArrayList<>();
        String sql = "select * from [company]";
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            rs = state.executeQuery();
            while (rs.next()) {
                list.add(new Company(
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

    public Company getCompanyByID(int id) {
        String sql = "select * from company where [company_id] = ?";
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            state.setInt(1, id);
            rs = state.executeQuery();
            while (rs.next()) {
                return new Company(
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
        DAOCompany daoCpn = new DAOCompany();
//        Company cpn = daoCpn.getCompanyByID(3);
//        System.out.println(cpn.toString());
//        List<Company> list = daoCpn.listAllCompany();
//        for (Company company : list) {
//            System.out.println(company.toString());
//        }
System.out.println(daoCpn.getCompanyByID(1));
    }
}
