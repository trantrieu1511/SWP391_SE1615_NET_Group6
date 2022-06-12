/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.experience;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class DAOExperience extends DBConnect{
    public List<experience> listIndividualExperience(String profile_id){
        List<experience> elist = new ArrayList<>();
        String sql = "select * from [experience]";
        ResultSet rs = getData(sql);
        try {
            while(rs.next()){
                elist.add(new experience(
                        rs.getString(1), 
                        rs.getString(2), 
                        rs.getString(3), 
                        rs.getString(4)));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return elist;
    }
    
    public static void main(String[] args) {
        DAOExperience dao = new DAOExperience();
        List<experience> list = dao.listIndividualExperience("AAAAA");
        for (experience exp : list) {
            System.out.println(exp.toString());
        }
    }
}
