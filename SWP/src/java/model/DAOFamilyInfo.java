/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.familyInfo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class DAOFamilyInfo extends DBConnect {

    public familyInfo getIndividualFamilyInfo(String profile_id) {
        familyInfo finfo = new familyInfo();
        String sql = "select * from [familyInfo] where profile_id = '" + profile_id + "'";
        ResultSet rs = getData(sql);
        try {
            while (rs.next()) {
                finfo = new familyInfo(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5));

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return finfo;
    }

    public static void main(String[] args) {
        DAOFamilyInfo dao = new DAOFamilyInfo();
        familyInfo finfo = dao.getIndividualFamilyInfo("AAAAA");
        System.out.println(finfo.toString());
    }
}
