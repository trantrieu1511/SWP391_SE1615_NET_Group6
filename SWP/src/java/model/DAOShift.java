/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.shift;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Khanh
 */
public class DAOShift extends DBConnect {
    public List<shift> listShift() {
        List<shift> list = new ArrayList<>();
        String sql ="select * from shift";
        ResultSet rs = getData(sql);
        try {
            while (rs.next()) {
                list.add(new shift(
                        rs.getString(1), 
                        rs.getString(2),
                        rs.getString(3)));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }
}
