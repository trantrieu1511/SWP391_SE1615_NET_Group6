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

    public String getPID(String fname) {
        String sql = "SELECT profile.* FROM [profile] WHERE first_name = '" + fname + "'";
        String s = null;
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            rs = state.executeQuery();
            rs.next();
            s = rs.getString(2);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closeResultSet(rs);
            closePrepareStatement(state);
            closeConnection(conn);
        }
        return s;
    }

    public String getReportTo(String pid) {
        String id = "";
        String sql = "select report_to from [profile]\n"
                + "where profile_id = '" + pid + "'";
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            rs = state.executeQuery();
            if (rs.next()) {
                id = rs.getString(1);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            closeResultSet(rs);
            closePrepareStatement(state);
            closeConnection(conn);
        }
        return id;
    }

    public boolean addManager(Profile pro) {
        String sql = "insert into [profile](first_name, last_name, "
                + "email ,phone_number, hire_date)"
                + "values (?,?,?,?,?)";
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            state.setString(1, pro.getFirst_name());
            state.setString(2, pro.getLast_name());
            state.setString(3, pro.getEmail());
            state.setString(4, pro.getPhone_number());
            state.setString(5, pro.getHire_date());
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

    public boolean addMD(Profile pro) {
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
                + ")";
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            state.executeQuery();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally {
            closePrepareStatement(state);
            closeConnection(conn);
        }
        return true;
    }

    public boolean addStaff(Profile pro) {
        String sql = "insert into [profile](first_name,last_name,email,"
                + "phone_number,hire_date,job_id,department_id,report_to)"
                + " values (?,?,?,?,?,?,?,?)";
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            state.setString(1, pro.getFirst_name());
            state.setString(2, pro.getLast_name());
            state.setString(3, pro.getEmail());
            state.setString(4, pro.getPhone_number());
            state.setString(5, pro.getHire_date());
            state.setInt(6, pro.getJob_id());
            state.setInt(7, pro.getDepartment_id());
            state.setString(8, pro.getReportto());
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
            state.setString(8, pro.getReportto());
            state.setString(9, pro.getProfile_id());
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

    public boolean editJob(int jobid) {
        String sql = "update [profile] set "
                + "job_id = null "
                + "where job_id = ?";
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            state.setInt(1, jobid);
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
    
    public boolean editCompanyCEO(Profile pro) {
        String sql = "update [profile] set "
                + "first_name = ?, "
                + "last_name = ?, "
                + "phone_number = ? "
                + "where profile_id = ?";
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            state.setString(1, pro.getFirst_name());
            state.setString(2, pro.getLast_name());
            state.setString(3, pro.getPhone_number());
            state.setString(4, pro.getProfile_id());
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
                list.add(new Profile(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getInt(8),
                        rs.getInt(9),
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

    //get generated ID when add profile successfully
    public String getGeneratedProfileID() {
        String id = "";
        String sql = "select top 1 profile_id from [profile]\n"
                + "order by id desc";
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            rs = state.executeQuery();
            if (rs.next()) {
                id = rs.getString(1);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            closeResultSet(rs);
            closePrepareStatement(state);
            closeConnection(conn);
        }
        return id;
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
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getInt(8),
                        rs.getInt(9),
                        rs.getString(10),
                        rs.getInt(11));
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
                list.add(new Profile(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getInt(8),
                        rs.getInt(9),
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
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getInt(8),
                        rs.getInt(9),
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
                list.add(new Profile(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getInt(8),
                        rs.getInt(9),
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
                list.add(new Profile(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getInt(8),
                        rs.getInt(9),
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

    public List<Profile> getADandMN() {
        String sql = "SELECT profile.*, account.* FROM [account], [profile] WHERE account.profile_id = profile.profile_id and report_to is NULL";
        List<Profile> list = new ArrayList<>();
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            rs = state.executeQuery();
            while (rs.next()) {
                list.add(new Profile(
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(13),
                        rs.getString(14),
                        rs.getString(15),
                        rs.getString(16),
                        rs.getString(17)));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closeResultSet(rs);
            closePrepareStatement(state);
            closeConnection(conn);
        }
        return list;
    }

    public List<Profile> getMN() {
        String sql = "SELECT profile.*, account.* FROM [account], [profile] WHERE account.profile_id = profile.profile_id and report_to is NULL and isadmin = 0";
        List<Profile> list = new ArrayList<>();
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            rs = state.executeQuery();
            while (rs.next()) {
                list.add(new Profile(
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(13),
                        rs.getString(14),
                        rs.getString(15),
                        rs.getString(16),
                        rs.getString(17)));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closeResultSet(rs);
            closePrepareStatement(state);
            closeConnection(conn);
        }
        return list;
    }
    
    public List<Profile> searchADandMN(String fname, String lname, String email, String pnumber, String user, int isa, int ism, int status) {
        String sql = "SELECT profile.*, account.* FROM [account], [profile] WHERE account.profile_id = profile.profile_id "
                + "and profile.first_name like %?% and profile.last_name like %?% \n"
                + "and email like %?% and profile.phone_number like %?% and account.username like %?% "
                + "and account.isadmin = ? and account.ismanager = ? and account.status = ?";
        List<Profile> list = new ArrayList<>();
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            state.setString(1, fname);
            state.setString(2, lname);
            state.setString(3, email);
            state.setString(4, pnumber);
            state.setString(5, user);
            state.setInt(6, isa);
            state.setInt(7, ism);
            state.setInt(8, status);
            rs = state.executeQuery();
            while (rs.next()) {
                list.add(new Profile(
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getString(14),
                        rs.getString(15),
                        rs.getString(16)));
            }
        } catch (SQLException ex) {
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
        System.out.println(dao.getByID("NK006"));
    }
}
