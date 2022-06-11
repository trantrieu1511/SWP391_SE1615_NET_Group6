/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.task;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Khanh
 */
public class DAOTask extends DBConnect {

    public boolean add(String name, int priority, String deadline, int status, String assigned) {
        String sql = "insert into task(name, priority, deadline, status, assigned)"
                + " values('" + name + "', " + priority + ", '" + deadline + "', "
                + status + ", '" + assigned + "')";
        try {
            Statement state = conn.createStatement();
            state.executeUpdate(sql);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    public List<task> list(int status) {
        List<task> list = new ArrayList<>();
        String sql = "select * from task where status = " + status;
        ResultSet rs = getData(sql);
        try {
            while (rs.next()) {
                list.add(new task(rs.getString(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
