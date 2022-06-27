/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.familyInfo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class DAOFamilyInfo extends DBConnect {

    Connection conn = null;
    PreparedStatement state = null;
    ResultSet rs = null;

    public List<familyInfo> getIndividualFamilyInfo(String profile_id) {
        List<familyInfo> flist = new ArrayList<>();
        String sql = "select * from [familyInfo] where profile_id = ?";
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            state.setString(1, profile_id);
            rs = state.executeQuery();
            while (rs.next()) {
                flist.add(new familyInfo(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5)));

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            closeResultSet(rs);
            closePrepareStatement(state);
            closeConnection(conn);
        }
        return flist;
    }

    public boolean addFamilyInfo(familyInfo f) {
        String sql = "insert into [familyInfo]\n"
                + "values (?,?,?,?,?)";
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            state.setString(1, f.getProfile_id());
            state.setString(2, f.getName());
            state.setString(3, f.getRelationship());
            state.setString(4, f.getDob());
            state.setString(5, f.getPhone());     
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

    public boolean deleteFamilyInfo(String profile_id, String name) {
        String sql = "delete from [familyInfo]\n"
                + "where profile_id = ?\n "
                + "and [name] = ?";
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            state.setString(1, profile_id);
            state.setString(2, name);
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
    
    public boolean deleteAllFamilyInfo(String profile_id) {
        String sql = "delete from [familyInfo]\n"
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

    public boolean editFamilyInfo(familyInfo familyInfo, String cur_name) {
        String sql = "update [familyInfo]\n"
                + "set\n"
                + "[name] = ?,\n"
                + "relationship = ?,\n"
                + "dob = ?,\n"
                + "phone = ?\n"
                + "where profile_id = ?\n"
                + "and [name] = ?";       
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            state.setString(1, familyInfo.getName());
            state.setString(2, familyInfo.getRelationship());
            state.setString(3, familyInfo.getDob());
            state.setString(4, familyInfo.getPhone());
            state.setString(5, familyInfo.getProfile_id());
            state.setString(6, cur_name);
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
        DAOFamilyInfo dao = new DAOFamilyInfo();
//        List<familyInfo> list = dao.getIndividualFamilyInfo("ABCDE");
//        for (familyInfo finfo : list) {
//            System.out.println(finfo.toString());
//        }
//        String profile_id = "MRNEW";
//        familyInfo f = new familyInfo(profile_id, "mrold", "father", "GETDATE()",
//                "012345678");
//        boolean statusf = dao.addFamilyInfo(f);
//        if (statusf) {
//            System.out.println("Successfully added new familyInfo for Staff with profile_id = " + profile_id);
//        } else {
//            System.out.println("Fail to added new familyInfo for Staff with profile_id = " + profile_id);
//        }
        String name = "Nguyen Thi Oanh";
        String[] parts = name.split(" ");
        System.out.println(parts[0] + parts[1] + parts[2]);

    }

}
