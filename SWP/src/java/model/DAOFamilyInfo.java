/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.familyInfo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class DAOFamilyInfo extends DBConnect {

    public List<familyInfo> getIndividualFamilyInfo(String profile_id) {
        List<familyInfo> flist = new ArrayList<>();
        String sql = "select * from [familyInfo] where profile_id = '" + profile_id + "'";
        ResultSet rs = getData(sql);
        try {
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
            Statement state = conn.createStatement();
            state.executeUpdate(sql);
            status = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            status = false;
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

}
