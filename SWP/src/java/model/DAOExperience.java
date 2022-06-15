/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.experience;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class DAOExperience extends DBConnect {

    public List<experience> listIndividualExperience(String profile_id) {
        List<experience> elist = new ArrayList<>();
        String sql = "select * from [experience] where profile_id = '" + profile_id + "'";
        ResultSet rs = getData(sql);
        try {
            while (rs.next()) {
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

    public boolean addExperience(experience exp) {
        boolean status = false;
        String sql = "insert into [experience]\n"
                + "values ("
                + "'"+exp.getProfile_id()+"', "
                + "'"+exp.getRole()+"',"
                + ""+exp.getStart_date()+","
                + ""+exp.getEnd_date()+")";
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
        DAOExperience daoexp = new DAOExperience();
//        List<experience> list = dao.listIndividualExperience("ABCDE");
//        for (experience exp : list) {
//            System.out.println(exp.toString());
//        }
        String profile_id = "MRNEW";
        experience exp = new experience(profile_id, "Enterrole", "GETDATE()",
                "GETDATE()");
        boolean statusexp = daoexp.addExperience(exp);
        if (statusexp) {
            System.out.println("Successfully added new experience for Staff with profile_id = " + profile_id);
        } else {
            System.out.println("Fail to added new experience for Staff with profile_id = " + profile_id);
        }

    }

    public boolean deleteExperience(String profile_id) {
        String sql = "delete from [experience] where [profile_id] = '" + profile_id + "'";
        try {
            Statement state = conn.createStatement();
            state.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }
}
