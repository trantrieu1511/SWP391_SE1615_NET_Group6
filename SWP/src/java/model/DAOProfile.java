/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.profile;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class DAOProfile extends DBConnect {

    Connection conn = null;
    PreparedStatement state = null;
    ResultSet rs = null;

    public boolean addManager(profile pro) {
        String sql = "insert into [profile](profile_id,first_name,last_name,email,phone_number,hire_date,department_id,job_id,salary)\n"
                + "values ("
                + "'" + pro.getProfile_id() + "', "
                + "'" + pro.getFirst_name() + "', "
                + "'" + pro.getLast_name() + "', "
                + "'" + pro.getEmail() + "', "
                + "'" + pro.getPhone_number() + "', "
                + "'" + pro.getHire_date() + "', "
                + "" + pro.getDepartment_id() + ", "
                + "" + pro.getJob_id() + ", "
                + "" + pro.getSalary() + ", "
                + ")";
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            state.executeQuery();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        } finally {
            closePrepareStatement(state);
            closeConnection(conn);
        }
        return true;
    }

    public boolean addStaff(profile pro) {
        String sql = "insert into [profile](profile_id,first_name,last_name,email,"
                + "phone_number,hire_date,department_id,job_id,salary,report_to) values ("
                + "'" + pro.getProfile_id() + "', "
                + "'" + pro.getFirst_name() + "', "
                + "'" + pro.getLast_name() + "', "
                + "'" + pro.getEmail() + "', "
                + "'" + pro.getPhone_number() + "', "
                + "'" + pro.getHire_date() + "', "
                + "" + pro.getDepartment_id() + ", "
                + "" + pro.getJob_id() + ", "
                + "" + pro.getSalary() + ", "
                + "'" + pro.getReportto() + "')";
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            state.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        } finally {
            closePrepareStatement(state);
            closeConnection(conn);
        }
        return true;
    }

    public boolean editStaff(profile pro) {
        String sql = "update [profile] set "
                + "first_name = ?, "
                + "last_name = ?, "
                + "email = ?, "
                + "phone_number = ?, "
                + "hire_date = ?, "
                + "department_id = ?, "
                + "job_id = ?, "
                + "salary = ?, "
                + "report_to = ? "
                + "where profile_id = ?";
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            state.setString(1, pro.getFirst_name());
            state.setString(2, pro.getLast_name());
            state.setString(3, pro.getEmail());
            state.setString(4, pro.getPhone_number());
            state.setString(5, pro.getHire_date());
            state.setInt(6, pro.getDepartment_id());
            state.setInt(7, pro.getJob_id());
            state.setDouble(8, pro.getSalary());
            state.setString(9, pro.getReportto());
            state.setString(10, pro.getProfile_id());
            state.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        } finally {
            closePrepareStatement(state);
            closeConnection(conn);
        }
        return true;
    }

    public List<profile> listAllStaff(String id) {
        String sql = "select * from [profile] where report_to = '" + id + "'";
        List<profile> list = new ArrayList<>();
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            rs = state.executeQuery();
            while (rs.next()) {
                list.add(new profile(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getDouble(9),
                        rs.getString(10)));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            closeResultSet(rs);
            closePrepareStatement(state);
            closeConnection(conn);
        }
        return list;
    }

    public List<profile> getProfile(String id) {
        String sql = "select * from [profile] where profile_id = '" + id + "'";
        List<profile> list = new ArrayList<>();
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            rs = state.executeQuery();
            while (rs.next()) {
                list.add(new profile(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getDouble(9),
                        rs.getString(10)));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            closeResultSet(rs);
            closePrepareStatement(state);
            closeConnection(conn);
        }
        return list;
    }

    public profile getByID(String profile_id) {
        String sql = "select * from [profile] where [profile_id] = '" + profile_id + "'";
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            rs = state.executeQuery();
            while (rs.next()) {
                return new profile(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getDouble(9),
                        rs.getString(10));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            closeResultSet(rs);
            closePrepareStatement(state);
            closeConnection(conn);
        }
        return null;
    }

    public boolean deleteProfile(String profile_id) {
        String sql = "delete from [profile] where [profile_id] = '" + profile_id + "'";
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            state.executeQuery();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        } finally {
            closePrepareStatement(state);
            closeConnection(conn);
        }
        return true;
    }

    public List<profile> searchStaff1(String profile_id, String name) {
        String sql = "select * from profile where profile_id like '%" + profile_id
                + "%' and first_name + last_name like '%" + name + "%'"
                + " and report_to is not null";
        List<profile> list = new ArrayList<>();
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            rs = state.executeQuery();
            while (rs.next()) {
                list.add(new profile(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getDouble(9),
                        rs.getString(10)));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            closeResultSet(rs);
            closePrepareStatement(state);
            closeConnection(conn);
        }
        return list;
    }

    public List<profile> searchStaff2(String profile_id, String name, String job_id) {
        String sql = "select * from [profile] where profile_id like '%" + profile_id + "%'"
                + " and job_id = " + job_id + " and first_name + last_name like '%" + name + "%' "
                + "and report_to is not null";
        List<profile> list = new ArrayList<>();
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            rs = state.executeQuery();
            while (rs.next()) {
                list.add(new profile(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getDouble(9),
                        rs.getString(10)));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            closeResultSet(rs);
            closePrepareStatement(state);
            closeConnection(conn);
        }
        return list;
    }

    public static void main(String[] args) {
        DAOProfile dao = new DAOProfile();
        List<profile> staff = dao.searchStaff1("QWER", "");
        for (profile object : staff) {
            System.out.println(object.toString());
        }
    }
}
