/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Profile;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

    public boolean addManager(Profile pro) {
        String sql = "insert into [profile](profile_id, first_name, last_name, "
                + "email ,phone_number, hire_date, department_id, job_id, salary)"
                + "values (?,?,?,?,?,?,?,?,?)";
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            state.setString(1, pro.getProfile_id());
            state.setString(2, pro.getFirst_name());
            state.setString(3, pro.getLast_name());
            state.setString(4, pro.getEmail());
            state.setString(5, pro.getPhone_number());
            state.setString(6, pro.getHire_date());
            state.setInt(7, pro.getDepartment_id());
            state.setInt(8, pro.getJob_id());
            state.setDouble(9, pro.getSalary());
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

    public boolean addStaff(Profile pro) {
        String sql = "insert into [profile](profile_id,first_name,last_name,email,"
                + "phone_number,hire_date,department_id,job_id,salary,report_to)"
                + " values (?,?,?,?,?,?,?,?,?,?)";
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            state.setString(1, pro.getProfile_id());
            state.setString(2, pro.getFirst_name());
            state.setString(3, pro.getLast_name());
            state.setString(4, pro.getEmail());
            state.setString(5, pro.getPhone_number());
            state.setString(6, pro.getHire_date());
            state.setInt(7, pro.getDepartment_id());
            state.setInt(8, pro.getJob_id());
            state.setDouble(9, pro.getSalary());
            state.setString(10, pro.getReportto());
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

    public boolean editStaff(Profile pro) {
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

    public List<Profile> listAllStaff(String id) {
        String sql = "select * from [profile] where report_to = ? order by profile_id asc";
        List<Profile> list = new ArrayList<>();
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            state.setString(1, id);
            rs = state.executeQuery();
            while (rs.next()) {
                list.add(new Profile(rs.getString(1),
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

    public List<Profile> getProfile(String id) {
        String sql = "select * from [profile] where profile_id = ?";
        List<Profile> list = new ArrayList<>();
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            state.setString(1, id);
            rs = state.executeQuery();
            while (rs.next()) {
                list.add(new Profile(
                        rs.getString(1),
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

    public Profile getByID(String profile_id) {
        String sql = "select * from [profile] where [profile_id] = ?";
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            state.setString(1, profile_id);
            rs = state.executeQuery();
            while (rs.next()) {
                return new Profile(
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
        String sql = "delete from [profile] where [profile_id] = ?";
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            state.setString(1, profile_id);
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

    public List<Profile> searchStaff1(String profile_id, String name) {
        String sql = "select * from profile where profile_id like ? and "
                + "first_name + last_name like ? and report_to is not null";
        List<Profile> list = new ArrayList<>();
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            state.setString(1, "%" + profile_id + "%");
            state.setString(2, "%" + name + "%");
            rs = state.executeQuery();
            while (rs.next()) {
                list.add(new Profile(rs.getString(1),
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

    public List<Profile> searchStaff2(String profile_id, String name, String job_id) {
        String sql = "select * from [profile] where profile_id like ? and job_id"
                + " = ? and first_name + last_name like ? and report_to is not null";
        List<Profile> list = new ArrayList<>();
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            state.setString(1, "%" + profile_id + "%");
            state.setString(2, job_id);
            state.setString(3, "%" + name + "%");
            rs = state.executeQuery();
            while (rs.next()) {
                list.add(new Profile(
                        rs.getString(1),
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
    
    public List<Profile> searchStaff3(String name, String profile_id) {
        String sql = "select * from profile where first_name + last_name like "
                + "? and report_to = ?";
        List<Profile> list = new ArrayList<>();
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            state.setString(1, "%" + name + "%");
            state.setString(2, profile_id);
            rs = state.executeQuery();
            while (rs.next()) {
                list.add(new Profile(rs.getString(1),
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
    
    public List<Profile> searchStaff4(String name, int department, String profile_id) {
        String sql = "select * from profile where first_name + last_name like "
                + "? and report_to = ? and department_id = ?";
        List<Profile> list = new ArrayList<>();
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            state.setString(1, "%" + name + "%");
            state.setString(2, profile_id);
            state.setInt(3, department);
            rs = state.executeQuery();
            while (rs.next()) {
                list.add(new Profile(rs.getString(1),
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
        List<Profile> list = dao.searchStaff1("s", "");
        for (Profile object : list) {
            System.out.println(object.toString());
        }
//        Profile pro = new Profile("QYYTA", "demo", "demo", "demo", "demo", "demo", 1, 1, 1, "ABCDE");
//        dao.addStaff(pro);
//        List<profile> staff = dao.searchStaff1("QWER", "");
//        for (Profile object : staff) {
//            System.out.println(object.toString());
//        }
//        String StringA = "      Nguyen Van A  ";
//        String StringB = "BBBB";
//        System.out.println(StringB+StringA.trim());
    } 
}
