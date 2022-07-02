/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Profile;
import entity.Salary;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class DAOSalary extends DBConnect {

    Connection conn = null;
    PreparedStatement state = null;
    ResultSet rs = null;

    public List<Salary> listAllStaffAndManagerProfile() {
        String sql = "select p.*, s.basic_salary, s.DA, s.HRA, s.conveyance, s.allowance, s.medical_allowance,\n"
                + "s.TDS, s.ESI, s.PF, s.leave, s.loan, s.professional_tax, ((basic_salary+DA+HRA+conveyance+allowance+medical_allowance)-(TDS+ESI+PF+leave+loan+professional_tax)) as net_salary,\n"
                + "s.create_date\n"
                + "from [profile] p full outer join [account] a \n"
                + "on p.profile_id = a.profile_id \n"
                + "full outer join [salary] s\n"
                + "on p.profile_id = s.profile_id\n"
                + "where a.isadmin != 1"
                + "order by p.profile_id asc";
        List<Salary> list = new ArrayList<>();
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            rs = state.executeQuery();
            while (rs.next()) {
                list.add(new Salary(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getString(8),
                        rs.getDouble(10),
                        rs.getDouble(11),
                        rs.getDouble(12),
                        rs.getDouble(13),
                        rs.getDouble(14),
                        rs.getDouble(15),
                        rs.getDouble(16),
                        rs.getDouble(17),
                        rs.getDouble(18),
                        rs.getDouble(19),
                        rs.getDouble(20),
                        rs.getDouble(21),
                        rs.getDouble(22),
                        rs.getString(23)
                ));
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

    public List<Salary> searchEmployeeSalaryWithoutCreateDate(String erole, String ename) {
        List<Salary> list = new ArrayList<>();
        String sql = "select p.*, s.basic_salary, s.DA, s.HRA, s.conveyance, s.allowance, s.medical_allowance,\n"
                + "s.TDS, s.ESI, s.PF, s.leave, s.loan, s.professional_tax, ((basic_salary+DA+HRA+conveyance+allowance+medical_allowance)-(TDS+ESI+PF+leave+loan+professional_tax)) as net_salary,\n"
                + "s.create_date\n"
                + "from [profile] p full outer join [account] a \n"
                + "on p.profile_id = a.profile_id \n"
                + "full outer join [salary] s\n"
                + "on p.profile_id = s.profile_id\n"
                + "where a.isadmin != 1\n"
                + "and a.ismanager = ?\n"
                + "and p.first_name + p.last_name like ?";
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            state.setString(1, erole);
            state.setString(2, "%" + ename + "%");
            rs = state.executeQuery();
            while (rs.next()) {
                list.add(new Salary(
                        rs.getString(1),
                        rs.getDouble(2),
                        rs.getDouble(3),
                        rs.getDouble(4),
                        rs.getDouble(5),
                        rs.getDouble(6),
                        rs.getDouble(7),
                        rs.getDouble(8),
                        rs.getDouble(9),
                        rs.getDouble(10),
                        rs.getDouble(11),
                        rs.getDouble(12),
                        rs.getDouble(13),
                        rs.getDouble(14),
                        rs.getString(15)
                ));
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

    public List<Salary> searchEmployeeSalaryWithCreateDate(String erole, String ename, String from, String to) {
        List<Salary> list = new ArrayList<>();
        String sql = "select p.*, s.basic_salary, s.DA, s.HRA, s.conveyance, s.allowance, s.medical_allowance,\n"
                + "s.TDS, s.ESI, s.PF, s.leave, s.loan, s.professional_tax, ((basic_salary+DA+HRA+conveyance+allowance+medical_allowance)-(TDS+ESI+PF+leave+loan+professional_tax)) as net_salary,\n"
                + "s.create_date\n"
                + "from [profile] p full outer join [account] a \n"
                + "on p.profile_id = a.profile_id \n"
                + "full outer join [salary] s\n"
                + "on p.profile_id = s.profile_id\n"
                + "where a.isadmin != 1\n"
                + "and a.ismanager = ?\n"
                + "and p.first_name + p.last_name like ?\n"
                + "and s.create_date BETWEEN ? and ?";
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            state.setString(1, erole);
            state.setString(2, "%" + ename + "%");
            state.setString(3, from);
            state.setString(4, to);
            rs = state.executeQuery();
            while (rs.next()) {
                list.add(new Salary(
                        rs.getString(1),
                        rs.getDouble(2),
                        rs.getDouble(3),
                        rs.getDouble(4),
                        rs.getDouble(5),
                        rs.getDouble(6),
                        rs.getDouble(7),
                        rs.getDouble(8),
                        rs.getDouble(9),
                        rs.getDouble(10),
                        rs.getDouble(11),
                        rs.getDouble(12),
                        rs.getDouble(13),
                        rs.getDouble(14),
                        rs.getString(15)
                ));
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

    public List<Salary> searchEmployeeSalaryWithNameOnly(String ename) {
        List<Salary> list = new ArrayList<>();
        String sql = "select p.*, s.basic_salary, s.DA, s.HRA, s.conveyance, s.allowance, s.medical_allowance,\n"
                + "s.TDS, s.ESI, s.PF, s.leave, s.loan, s.professional_tax, ((basic_salary+DA+HRA+conveyance+allowance+medical_allowance)-(TDS+ESI+PF+leave+loan+professional_tax)) as net_salary,\n"
                + "s.create_date\n"
                + "from [profile] p full outer join [account] a \n"
                + "on p.profile_id = a.profile_id \n"
                + "full outer join [salary] s\n"
                + "on p.profile_id = s.profile_id\n"
                + "where a.isadmin != 1\n"
                + "and p.first_name + p.last_name like ?\n";
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            state.setString(1, "%" + ename + "%");
            rs = state.executeQuery();
            while (rs.next()) {
                list.add(new Salary(
                        rs.getString(1),
                        rs.getDouble(2),
                        rs.getDouble(3),
                        rs.getDouble(4),
                        rs.getDouble(5),
                        rs.getDouble(6),
                        rs.getDouble(7),
                        rs.getDouble(8),
                        rs.getDouble(9),
                        rs.getDouble(10),
                        rs.getDouble(11),
                        rs.getDouble(12),
                        rs.getDouble(13),
                        rs.getDouble(14),
                        rs.getString(15)
                ));
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

    public List<Salary> searchEmployeeSalaryWithRoleOnly(String erole) {
        List<Salary> list = new ArrayList<>();
        String sql = "select p.*, s.basic_salary, s.DA, s.HRA, s.conveyance, s.allowance, s.medical_allowance,\n"
                + "s.TDS, s.ESI, s.PF, s.leave, s.loan, s.professional_tax, ((basic_salary+DA+HRA+conveyance+allowance+medical_allowance)-(TDS+ESI+PF+leave+loan+professional_tax)) as net_salary,\n"
                + "s.create_date\n"
                + "from [profile] p full outer join [account] a \n"
                + "on p.profile_id = a.profile_id \n"
                + "full outer join [salary] s\n"
                + "on p.profile_id = s.profile_id\n"
                + "where a.isadmin != 1\n"
                + "and p.first_name + p.last_name like ?\n";
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            state.setString(1, "%" + erole + "%");
            rs = state.executeQuery();
            while (rs.next()) {
                list.add(new Salary(
                        rs.getString(1),
                        rs.getDouble(2),
                        rs.getDouble(3),
                        rs.getDouble(4),
                        rs.getDouble(5),
                        rs.getDouble(6),
                        rs.getDouble(7),
                        rs.getDouble(8),
                        rs.getDouble(9),
                        rs.getDouble(10),
                        rs.getDouble(11),
                        rs.getDouble(12),
                        rs.getDouble(13),
                        rs.getDouble(14),
                        rs.getString(15)
                ));
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

    public Salary getIndividualEmployeeSalary(String profile_id) {
        String sql = "select s.*, ((basic_salary+HRA+conveyance+allowance+medical_allowance)-(TDS+ESI+PF+leave+loan+professional_tax)) as net_salary from salary s\n"
                + "where profile_id = ?";
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            state.setString(1, profile_id);
            rs = state.executeQuery();
            while (rs.next()) {
                return new Salary(
                        rs.getString(1),
                        rs.getDouble(2),
                        rs.getDouble(3),
                        rs.getDouble(4),
                        rs.getDouble(5),
                        rs.getDouble(6),
                        rs.getDouble(7),
                        rs.getDouble(8),
                        rs.getDouble(9),
                        rs.getDouble(10),
                        rs.getDouble(11),
                        rs.getDouble(12),
                        rs.getDouble(13),
                        rs.getDouble(14),
                        rs.getString(15)
                );
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

    public boolean addEmployeeSalary(Salary salary) {
        String sql = "insert into salary "
                + "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            state.setString(1, salary.getProfile_id2());
            state.setDouble(2, salary.getBasic_salary());
            state.setDouble(3, salary.getDA());
            state.setDouble(4, salary.getHRA());
            state.setDouble(5, salary.getConveyance());
            state.setDouble(6, salary.getAllowance());
            state.setDouble(7, salary.getMedical_allowance());
            state.setDouble(8, salary.getTDS());
            state.setDouble(9, salary.getESI());
            state.setDouble(10, salary.getPF());
            state.setDouble(11, salary.getLeave());
            state.setDouble(12, salary.getLoan());
            state.setDouble(13, salary.getProfessional_tax());
            state.setString(14, salary.getCreate_date());
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

    public int editEmployeeSalary(Salary salary) {
        int n = 0;
        String sql = "update [salary]\n"
                + "set\n"
                + "basic_salary = ?,\n"
                + "DA = ?,\n"
                + "HRA = ?,\n"
                + "conveyance = ?,\n"
                + "allowance = ?,\n"
                + "medical_allowance = ?,\n"
                + "TDS = ?,\n"
                + "ESI = ?,\n"
                + "PF = ?,\n"
                + "leave = ?,\n"
                + "loan = ?,\n"
                + "professional_tax = ?\n"
                + "where profile_id = ?";
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            state.setDouble(1, salary.getBasic_salary());
            state.setDouble(2, salary.getDA());
            state.setDouble(3, salary.getHRA());
            state.setDouble(4, salary.getConveyance());
            state.setDouble(5, salary.getAllowance());
            state.setDouble(6, salary.getMedical_allowance());
            state.setDouble(7, salary.getTDS());
            state.setDouble(8, salary.getESI());
            state.setDouble(9, salary.getPF());
            state.setDouble(10, salary.getLeave());
            state.setDouble(11, salary.getLoan());
            state.setDouble(12, salary.getProfessional_tax());
            state.setString(13, salary.getProfile_id2());
            n = state.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            closePrepareStatement(state);
            closeConnection(conn);
        }
        return n;
    }

    public int deleteEmployeeSalary(String profile_id) {
        int n = 0;
        String sql = "delete from salary where profile_id = ?";
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            state.setString(1, profile_id);
            n = state.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            closePrepareStatement(state);
            closeConnection(conn);
        }
        return n;
    }

}
