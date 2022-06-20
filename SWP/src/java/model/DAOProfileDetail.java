/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.profileDetail;
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
    PreparedStatement pre = null;
    Statement state = null;
    ResultSet rs = null;

    public List<profileDetail> getIndividualProfileDetail(String profile_id) {
        List<profileDetail> pdlist = new ArrayList<profileDetail>();
        String sql = "select * from [profileDetail] where profile_id = '" + profile_id + "'";
        try {
            conn = getConnection();
            pre = conn.prepareStatement(sql);
            rs = pre.executeQuery();
            while (rs.next()) {
                pdlist.add(new profileDetail(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getBoolean(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getBoolean(7),
                        rs.getInt(8),
                        rs.getString(9),
                        rs.getString(10)));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            closeResultSet(rs);
            closeStatement(state);
            closeConnection(conn);
        }
        return pdlist;
    }

    public boolean addProfileDetail(profileDetail pd) {
        boolean status = false;
        String sql = "insert into [profileDetail]\n"
                + "values ("
                + "'" + pd.getProfile_id() + "', "
                + "" + pd.getDob() + ", "
                + "'" + pd.getAddress() + "', "
                + "'" + pd.isGender() + "', "
                + "'" + pd.getCountry() + "', "
                + "'" + pd.getReligion() + "', "
                + "'" + pd.isIsMarried() + "', "
                + "" + pd.getChildren() + ", "
                + "'" + pd.getBank_name() + "', "
                + "'" + pd.getBank_number() + "')";
        try {
            conn = getConnection();
            pre = conn.prepareStatement(sql);
            pre.executeUpdate();
            status = true;
        } catch (Exception ex) {
            ex.printStackTrace();
            status = false;
        } finally {
            closePrepareStatement(pre);
            closeConnection(conn);
        }
        return status;
    }

    public boolean editProfileInfo(profileDetail pd) {
        boolean status = false;
        String sql = "update [profileDetail]\n"
                + "set \n"
                + "dob = '" + pd.getDob() + "',\n"
                + "address = '" + pd.getAddress() + "',\n"
                + "gender = '" + pd.isGender() + "'"
                + "where profile_id = '" + pd.getProfile_id() + "'";
        try {
            conn = getConnection();
            state = conn.createStatement();
            state.executeUpdate(sql);
            status = true;
        } catch (Exception ex) {
            ex.printStackTrace();
            status = false;
        } finally {
            closeStatement(state);
            closeConnection(conn);
        }
        return status;
    }

    public boolean editPersonalInfo(profileDetail pd) {
        boolean status = false;
        String sql = "update [profileDetail]\n"
                + "set \n"
                + "country = '" + pd.getCountry() + "',\n"
                + "religion = '" + pd.getReligion() + "',\n"
                + "isMarried = '" + pd.isIsMarried() + "',\n"
                + "children = " + pd.getChildren() + ",\n"
                + "bank_name = '" + pd.getBank_name() + "',\n"
                + "bank_number = '" + pd.getBank_number() + "'\n"
                + "where profile_id = '" + pd.getProfile_id() + "'";
        try {
            conn = getConnection();
            state = conn.createStatement();
            state.executeUpdate(sql);
            status = true;
        } catch (Exception ex) {
            ex.printStackTrace();
            status = false;
        } finally {
            closeStatement(state);
            closeConnection(conn);
        }
        return status;
    }

    public boolean deleteProfileDetail(String profile_id) {
        String sql = "delete from [profileDetail] where [profile_id] = '" + profile_id + "'";
        try {
            conn = getConnection();
            state = conn.createStatement();
            state.executeUpdate(sql);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        } finally {
            closeStatement(state);
            closeConnection(conn);
        }
        return true;
    }

    public static void main(String[] args) {
        DAOProfileDetail daopd = new DAOProfileDetail();
//        List<profileDetail> list = dao.getIndividualProfileDetail("ABCDE");
//        for (profileDetail pdetail : list) {
//            System.out.println(pdetail.toString());
//        }
//        String profile_id = "MRNEW";
//        profileDetail pd = new profileDetail(profile_id, "GETDATE()",
//                "N/A", true, "N/A", "N/A", false, 0, "N/A", "N/A");
//        boolean statusPd = daopd.addProfileDetail(pd);
//        if (statusPd) {
//            System.out.println("Successfully added new profileDetail for Staff with profile_id = " + profile_id);
//        } else {
//            System.out.println("Fail to added new profileDetail for Staff with profile_id = " + profile_id);
//        }
    }
}
