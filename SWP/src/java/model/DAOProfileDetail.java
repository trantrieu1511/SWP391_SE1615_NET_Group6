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
import java.sql.SQLException;
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

    public List<profileDetail> getIndividualProfileDetail(String profile_id) {
        List<profileDetail> pdlist = new ArrayList<profileDetail>();
        String sql = "select * from [profileDetail] where profile_id = '" + profile_id + "'";
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            rs = state.executeQuery();
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
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closeResultSet(rs);
            closePrepareStatement(state);
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
            state = conn.prepareStatement(sql);
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

    public static void main(String[] args) {
        DAOProfileDetail daopd = new DAOProfileDetail();
//        List<profileDetail> list = dao.getIndividualProfileDetail("ABCDE");
//        for (profileDetail pdetail : list) {
//            System.out.println(pdetail.toString());
//        }
        String profile_id = "MRNEW";
        profileDetail pd = new profileDetail(profile_id, "GETDATE()",
                "N/A", true, "N/A", "N/A", false, 0, "N/A", "N/A");
        boolean statusPd = daopd.addProfileDetail(pd);
        if (statusPd) {
            System.out.println("Successfully added new profileDetail for Staff with profile_id = " + profile_id);
        } else {
            System.out.println("Fail to added new profileDetail for Staff with profile_id = " + profile_id);
        }
    }

    public boolean deleteProfileDetail(String profile_id) {
        String sql = "delete from [profileDetail] where [profile_id] = '" + profile_id + "'";
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            state.executeQuery();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        } finally {
            closePrepareStatement(state);
            closeConnection(conn);
        }
        return true;
    }
}
