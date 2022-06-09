/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.account;
import java.sql.ResultSet;

/**
 *
 * @author Khanh
 */
public class DAOAccount extends DBConnent {
    
    public account login(String user, String pass) {
        String sql = "select * from [account] where [username] = '" + user
                + "' and [password] = '" + pass + "'";
        try {
            ResultSet rs = getData(sql);
            while (rs.next()) {
                return new account(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getBoolean((4)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public account getAccount(String profile_id) {
        String sql = "select * from [account] where profile_id = " + profile_id;
        try {
            ResultSet rs = getData(sql);
            while (rs.next()) {
                return new account(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getBoolean((4)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
