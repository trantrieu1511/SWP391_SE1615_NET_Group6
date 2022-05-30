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
public class DAOLogin extends DBConnent {
    
    public account login(String user, String pass) {
        String sql = "select * from [profile] where [username] = '" + user
                + "' and [password] = '" + pass + "'";
        try {
            ResultSet rs = getData(sql);
            while (rs.next()) {
                return new account(
                        rs.getString(12),
                        rs.getString(13),
                        rs.getString(9),
                        rs.getBoolean((10)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
