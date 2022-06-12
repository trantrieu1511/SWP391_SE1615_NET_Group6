/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.profileDetail;
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
public class DAOProfileDetail extends DBConnect {

    public List<profileDetail> getIndividualProfileDetail(String profile_id) {
        List<profileDetail> pdlist = new ArrayList<profileDetail>();
        String sql = "select * from [profileDetail] where profile_id = '" + profile_id + "'";
        ResultSet rs = getData(sql);
        try {
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
        }
        return pdlist;
    }

    public boolean addProfileDetail(profileDetail pd) {
        boolean status = false;
        String sql = "insert into profileDetail\n"
                + "values ("
                + "'" + pd.getProfile_id() + "', "
                + "'" + pd.getDob() + "', "
                + "'" + pd.getAddress() + "', "
                + "" + pd.isGender() + ", "
                + "'" + pd.getCountry() + "', "
                + "'" + pd.getReligion() + "', "
                + "" + pd.isIsMarried() + ", "
                + "" + pd.getChildren() + ", "
                + "'" + pd.getBank_name() + "', "
                + "'" + pd.getBank_number() + "')";
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
        DAOProfileDetail dao = new DAOProfileDetail();
        List<profileDetail> list = dao.getIndividualProfileDetail("ABCDE");
        for (profileDetail pdetail : list) {
            System.out.println(pdetail.toString());
        }
    }
}
