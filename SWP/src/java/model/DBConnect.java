/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Khanh
 */
public class DBConnect {

    //  public Connection conn = null;
//    public DBConnect(String URL, String userName, String password) {
//        try {
//            // URL: connection string: address, port, database of server
//            // call drivers
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            // connection
//            Connection conn = DriverManager.getConnection(URL, userName, password);
//            System.out.println("connected");
//        } catch (ClassNotFoundException ex) {
//            ex.printStackTrace();
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//    }
    public Connection getConnection() {
        Connection conn = null;
        try {
            // URL: connection string: address, port, database of server
            // call drivers
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // connection
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=SWP_HRMS_GRP6_3", "sa", "12345678");
            System.out.println("connected");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return conn;
    }

//    public DBConnect() {
//        this("jdbc:sqlserver://localhost:1433;databaseName=SWP_HRMS_GRP6_3", "sa", "12345678");
//    }
    public ResultSet getData(String sql) throws Exception {
        try {
            Statement state = getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = state.executeQuery(sql);
            return rs;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public void closeConnection(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (Exception ex) {
        }
    }
    
    public void closePrepareStatement(PreparedStatement pre) {
        try {
            if (pre != null) {
                pre.close();
            }
        } catch (Exception e) {
        }
    }
    
    public void closeResultSet(ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) {
        new DBConnect().getConnection();
    }
}
