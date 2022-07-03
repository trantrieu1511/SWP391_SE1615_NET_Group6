/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.ProfileDetail;
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
public class DAOProfileDetail extends DBConnect {

    Connection conn = null;
    PreparedStatement state = null;
    ResultSet rs = null;

    public ProfileDetail getIndividualProfileDetail(String profile_id) {
        String sql = "select * from [profileDetail] where profile_id = ?";
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            state.setString(1, profile_id);
            rs = state.executeQuery();
            while (rs.next()) {
                return new ProfileDetail(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getBoolean(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getBoolean(7),
                        rs.getInt(8),
                        rs.getString(9),
                        rs.getString(10));
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

    public boolean addProfileDetail(ProfileDetail pd) {
        String sql = "insert into [profileDetail] values (?,?,?,?,?,?,?,?,?,?)";
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            state.setString(1, pd.getProfile_id());
            state.setString(2, pd.getDob());
            state.setString(3, pd.getAddress());
            state.setBoolean(4, pd.isGender());
            state.setString(5, pd.getCountry());
            state.setString(6, pd.getReligion());
            state.setBoolean(7, pd.isIsMarried());
            state.setInt(8, pd.getChildren());
            state.setString(9, pd.getBank_name());
            state.setString(10, pd.getBank_number());
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

    public boolean editProfileInfo(ProfileDetail pd) {
        boolean status = false;
        String sql = "update [profileDetail]\n"
                + "set \n"
                + "dob = ?,\n"
                + "address = ?,\n"
                + "gender = '" + pd.isGender() + "'"
                + "where profile_id = ?";
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            state.setString(1, pd.getDob());
            state.setString(2, pd.getAddress());
            state.setString(3, pd.getProfile_id());
            state.executeUpdate();
            status = true;
        } catch (Exception ex) {
            ex.printStackTrace();
            status = false;
        } finally {
            closePrepareStatement(state);
            closeConnection(conn);
        }
        return status;
    }

    public boolean editPersonalInfo(ProfileDetail pd) {
        boolean status = false;
        String sql = "update [profileDetail] set \n"
                + "country = ?,\n"
                + "religion = ?,\n"
                + "isMarried = ?,\n"
                + "children = ?,\n"
                + "bank_name = ?,\n"
                + "bank_number = ?\n"
                + "where profile_id = ?";
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            state.setString(1, pd.getCountry());
            state.setString(2, pd.getReligion());
            state.setBoolean(3, pd.isIsMarried());
            state.setInt(4, pd.getChildren());
            state.setString(5, pd.getBank_name());
            state.setString(6, pd.getBank_number());
            state.setString(7, pd.getProfile_id());
            state.executeUpdate();
            status = true;
        } catch (Exception ex) {
            ex.printStackTrace();
            status = false;
        } finally {
            closePrepareStatement(state);
            closeConnection(conn);
        }
        return status;
    }

    public boolean deleteProfileDetail(String profile_id) {
        String sql = "delete from [profileDetail] where [profile_id] = ?";
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
        DAOProfileDetail daopd = new DAOProfileDetail();
        ProfileDetail pd = daopd.getIndividualProfileDetail("ABCDE");
        System.out.println(pd.toString());
//        List<profileDetail> list = dao.getIndividualProfileDetail("ABCDE");
//        for (ProfileDetail pdetail : list) {
//            System.out.println(pdetail.toString());
//        }
//        String profile_id = "MRNEW";
//        ProfileDetail pd = new ProfileDetail(profile_id, "GETDATE()",
//                "N/A", true, "N/A", "N/A", false, 0, "N/A", "N/A");
//        boolean statusPd = daopd.addProfileDetail(pd);
//        if (statusPd) {
//            System.out.println("Successfully added new ProfileDetail for Staff with profile_id = " + profile_id);
//        } else {
//            System.out.println("Fail to added new ProfileDetail for Staff with profile_id = " + profile_id);
//        }
    }
}
