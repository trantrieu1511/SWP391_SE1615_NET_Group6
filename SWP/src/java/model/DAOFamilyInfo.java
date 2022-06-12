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
public class DAOFamilyInfo extends DBConnect{
    
    public List<familyInfo> listIndividualFamilyInfo(String profile_id){
        List<familyInfo> flist = new ArrayList<>();
        String sql = "select * from [familyInfo]";
        ResultSet rs = getData(sql);
        try {
            while(rs.next()){
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
    
    public static void main(String[] args) {
        DAOFamilyInfo dao = new DAOFamilyInfo();
        List<familyInfo> list = dao.listIndividualFamilyInfo("AAAAA");
        for (familyInfo finfo : list) {
            System.out.println(finfo.toString());
        }
    }
}
