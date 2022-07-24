/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import entity.Account;
import entity.Company;
import entity.Profile;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;

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

    public List<Company> MyCompany(String id) {
        List<Company> list = new ArrayList<>();
        String sql = "select company.*, profile.first_name, profile.last_name, profile.phone_number"
                + " from [company], [profile] where company.profile_id = profile.profile_id"
                + " and profile.profile_id = '"+id+"' ";
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            rs = state.executeQuery();
            while (rs.next()) {
                list.add(new Company(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(13),
                        rs.getString(14),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getInt(8),
                        rs.getString(9),
                        rs.getInt(10),
                        rs.getString(15),
                        rs.getInt(11),
                        rs.getString(12)));
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
    
    public boolean editCompany(Company com, String id) {
        String sql = "update [company] set "
                + "company_name = ?, "
                + "company_address = ?, "
                + "company_country = ?, "
                + "company_province = ?, "
                + "company_city = ?, "
                + "postal_code = ?, "
                + "company_email = ?, "
                + "company_pnumber = ?, "
                + "fax = ? "
                + "website_url = ?"
                + "where profile_id = ?";
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            state.setString(1, com.getName());
            state.setString(2, com.getAddress());
            state.setString(3, com.getCountry());
            state.setString(4, com.getProvince());
            state.setString(5, com.getCity());
            state.setInt(6, com.getPostal_code());
            state.setString(7, com.getEmail());
            state.setInt(8, com.getPhone());
            state.setInt(9, com.getFax());
            state.setString(10, com.getUrl());
            state.setString(11, id);
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
          List<Company> list = daoCpn.MyCompany("HP001");
          for(Company company : list){
              System.out.println(company.toString());
          }
            
    }
}
