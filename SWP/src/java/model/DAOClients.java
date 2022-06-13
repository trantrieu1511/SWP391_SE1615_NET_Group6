/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.clients;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Khanh
 */
public class DAOClients extends DBConnect {
    public List<clients> listAllClients() {
        List<clients> list = new ArrayList<>();
        String sql = "select * from clients";
        ResultSet rs = getData(sql);
        try {
            while (rs.next()) {
                list.add(new clients(
                        rs.getString(1), 
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
