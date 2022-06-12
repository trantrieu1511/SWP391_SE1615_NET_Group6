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
    public experience getIndividualExperience(String profile_id){
        experience exp = new experience();
        String sql = "select * from [experience] where profile_id = '" + profile_id + "'";
        ResultSet rs = getData(sql);
        try {
            while(rs.next()){
                exp = new experience(
                        rs.getString(1), 
                        rs.getString(2), 
                        rs.getString(3), 
                        rs.getString(4));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return exp;
    }
    
    public static void main(String[] args) {
        DAOExperience dao = new DAOExperience();
        experience exp = dao.getIndividualExperience("AAAAA");
        System.out.println(exp.toString());
    }
}
