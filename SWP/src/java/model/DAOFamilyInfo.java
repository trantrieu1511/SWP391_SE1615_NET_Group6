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
import java.sql.SQLException;
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
        String sql = "select * from [familyInfo] where profile_id = '" + profile_id + "'";
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            rs = state.executeQuery();
            while (rs.next()) {
                flist.add(new familyInfo(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5)));

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closeResultSet(rs);
            closePrepareStatement(state);
            closeConnection(conn);
        }
        return flist;
    }

    public boolean addFamilyInfo(familyInfo f) {
        boolean status = false;
        String sql = "insert into [familyInfo]\n"
                + "values ("
                + "'" + f.getProfile_id() + "',"
                + "'" + f.getName() + "',"
                + "'" + f.getRelationship() + "',"
                + "" + f.getDob() + ","
                + "'" + f.getPhone() + "')";
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            state.executeQuery();
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
        DAOFamilyInfo dao = new DAOFamilyInfo();
//        List<familyInfo> list = dao.getIndividualFamilyInfo("ABCDE");
//        for (familyInfo finfo : list) {
//            System.out.println(finfo.toString());
//        }
        String profile_id = "MRNEW";
        familyInfo f = new familyInfo(profile_id, "mrold", "father", "GETDATE()",
                "012345678");
        boolean statusf = dao.addFamilyInfo(f);
        if (statusf) {
            System.out.println("Successfully added new familyInfo for Staff with profile_id = " + profile_id);
        } else {
            System.out.println("Fail to added new familyInfo for Staff with profile_id = " + profile_id);
        }
    }

    public boolean deleteFamilyInfo(String profile_id) {
        String sql = "delete from [familyInfo] where [profile_id] = '" + profile_id + "'";
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
