/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Salary;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
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

    public List<Salary> listAllStaffAndManagerSalary() {
        String sql = "select p.id, p.profile_id,p.first_name,p.last_name,p.email,p.phone_number,p.hire_date,p.job_id,p.department_id,p.report_to, s.basic_salary, s.DA, s.HRA, s.conveyance, s.allowance, s.medical_allowance,\n"
                + "s.TDS, s.ESI, s.PF, s.leave, s.loan, s.professional_tax, ((basic_salary+DA+HRA+conveyance+allowance+medical_allowance)-(TDS+ESI+PF+leave+loan+professional_tax)) as net_salary,\n"
                + "s.create_date\n"
                + "from [profile] p full outer join [account] a\n"
                + "on p.profile_id = a.profile_id \n"
                + "full outer join [salary] s\n"
                + "on p.profile_id = s.profile_id\n"
                + "where a.isadmin = 0\n"
                + "order by p.profile_id asc";
        List<Salary> list = new ArrayList<>();
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            rs = state.executeQuery();
            while (rs.next()) {
                list.add(new Salary(
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
                        rs.getDouble(23),
                        rs.getString(24)
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

    //ham cho report cua Khanh
    public List<Salary> listAllStaffSalary(String profile_id) {
        String sql = "select p.profile_id, ((basic_salary+DA+HRA+conveyance+allowance+medical_allowance)-(TDS+ESI+PF+leave+loan+professional_tax)) as net_salary\n"
                + "from [profile] p full outer join [account] a \n"
                + "on p.profile_id = a.profile_id \n"
                + "full outer join [salary] s\n"
                + "on p.profile_id = s.profile_id\n"
                + "where a.isadmin = 0\n"
                + "and report_to = ?\n"
                + "order by p.profile_id asc";
        List<Salary> list = new ArrayList<>();
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            state.setString(1, profile_id);
            rs = state.executeQuery();
            while (rs.next()) {
                list.add(new Salary(
                        rs.getString(1),
                        rs.getDouble(2)));
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

    public Salary getIndividualSalaryAndProfile(String profile_id) {
        String sql = "select p.id, p.profile_id,p.first_name,p.last_name,p.email,p.phone_number,p.hire_date,p.job_id,p.department_id,p.report_to, s.basic_salary, s.DA, s.HRA, s.conveyance, s.allowance, s.medical_allowance,\n"
                + "s.TDS, s.ESI, s.PF, s.leave, s.loan, s.professional_tax, ((basic_salary+DA+HRA+conveyance+allowance+medical_allowance)-(TDS+ESI+PF+leave+loan+professional_tax)) as net_salary,\n"
                + "s.create_date\n"
                + "from [profile] p full outer join [account] a\n"
                + "on p.profile_id = a.profile_id \n"
                + "full outer join [salary] s\n"
                + "on p.profile_id = s.profile_id\n"
                + "where a.isadmin = 0\n"
                + "and p.profile_id = ?\n"
                + "order by p.profile_id asc";
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            state.setString(1, profile_id);
            rs = state.executeQuery();
            while (rs.next()) {
                return new Salary(
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
                        rs.getDouble(23),
                        rs.getString(24)
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

    public Salary getIndividualSalaryAndProfileInPayslip(String profile_id) {
        String sql = "select p.id, p.profile_id,p.first_name,p.last_name,p.email,p.phone_number,p.hire_date,p.job_id,p.department_id,p.report_to, s.payslip_number, s.basic_salary, s.DA, s.HRA, s.conveyance, s.allowance, s.medical_allowance,\n"
                + "s.TDS, s.ESI, s.PF, s.leave, s.loan, s.professional_tax, ((basic_salary+DA+HRA+conveyance+allowance+medical_allowance)-(TDS+ESI+PF+leave+loan+professional_tax)) as net_salary,\n"
                + "s.create_date\n"
                + "from [profile] p full outer join [account] a \n"
                + "on p.profile_id = a.profile_id \n"
                + "full outer join [salary] s\n"
                + "on p.profile_id = s.profile_id\n"
                + "where a.isadmin = 0\n"
                + "and p.profile_id = ?\n"
                + "order by p.profile_id asc";
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            state.setString(1, profile_id);
            rs = state.executeQuery();
            while (rs.next()) {
                return new Salary(
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
                        rs.getInt(11),
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
                        rs.getDouble(23),
                        rs.getDouble(24),
                        rs.getString(25)
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

    public List<Salary> listStaffNeedSalary() {
        String sql = "select p.profile_id, p.first_name, p.last_name, s.basic_salary\n"
                + "from [profile] p full outer join [account] a \n"
                + "on p.profile_id = a.profile_id \n"
                + "full outer join [salary] s\n"
                + "on p.profile_id = s.profile_id\n"
                + "where a.isadmin = 0 \n"
                + "and s.basic_salary is null\n"
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
                        rs.getDouble(4))
                );
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
        String sql = "select p.id, p.profile_id,p.first_name,p.last_name,p.email,p.phone_number,p.hire_date,p.job_id,p.department_id,p.report_to, s.basic_salary, s.DA, s.HRA, s.conveyance, s.allowance, s.medical_allowance,\n"
                + "s.TDS, s.ESI, s.PF, s.leave, s.loan, s.professional_tax, ((basic_salary+DA+HRA+conveyance+allowance+medical_allowance)-(TDS+ESI+PF+leave+loan+professional_tax)) as net_salary,\n"
                + "s.create_date\n"
                + "from [profile] p full outer join [account] a \n"
                + "on p.profile_id = a.profile_id \n"
                + "full outer join [salary] s\n"
                + "on p.profile_id = s.profile_id\n"
                + "where a.isadmin = 0\n"
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
                        rs.getDouble(23),
                        rs.getString(24)
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
        String sql = "select p.id, p.profile_id,p.first_name,p.last_name,p.email,p.phone_number,p.hire_date,p.job_id,p.department_id,p.report_to, s.basic_salary, s.DA, s.HRA, s.conveyance, s.allowance, s.medical_allowance,\n"
                + "s.TDS, s.ESI, s.PF, s.leave, s.loan, s.professional_tax, ((basic_salary+DA+HRA+conveyance+allowance+medical_allowance)-(TDS+ESI+PF+leave+loan+professional_tax)) as net_salary,\n"
                + "s.create_date\n"
                + "from [profile] p full outer join [account] a \n"
                + "on p.profile_id = a.profile_id \n"
                + "full outer join [salary] s\n"
                + "on p.profile_id = s.profile_id\n"
                + "where a.isadmin = 0\n"
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
                        rs.getDouble(23),
                        rs.getString(24)
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

    public List<Salary> searchEmployeeSalaryWithCreateDate2(String ename, String from, String to) {
        List<Salary> list = new ArrayList<>();
        String sql = "select p.id, p.profile_id,p.first_name,p.last_name,p.email,p.phone_number,p.hire_date,p.job_id,p.department_id,p.report_to, s.basic_salary, s.DA, s.HRA, s.conveyance, s.allowance, s.medical_allowance,\n"
                + "s.TDS, s.ESI, s.PF, s.leave, s.loan, s.professional_tax, ((basic_salary+DA+HRA+conveyance+allowance+medical_allowance)-(TDS+ESI+PF+leave+loan+professional_tax)) as net_salary,\n"
                + "s.create_date\n"
                + "from [profile] p full outer join [account] a \n"
                + "on p.profile_id = a.profile_id \n"
                + "full outer join [salary] s\n"
                + "on p.profile_id = s.profile_id\n"
                + "where a.isadmin = 0\n"
                + "and p.first_name + p.last_name like ?\n"
                + "and s.create_date BETWEEN ? and ?";
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            state.setString(1, "%" + ename + "%");
            state.setString(2, from);
            state.setString(3, to);
            rs = state.executeQuery();
            while (rs.next()) {
                list.add(new Salary(
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
                        rs.getDouble(23),
                        rs.getString(24)
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

    public List<Salary> searchEmployeeSalaryWithCreateDate3(String erole, String ename, String from) {
        List<Salary> list = new ArrayList<>();
        String sql = "select p.id, p.profile_id,p.first_name,p.last_name,p.email,p.phone_number,p.hire_date,p.job_id,p.department_id,p.report_to, s.basic_salary, s.DA, s.HRA, s.conveyance, s.allowance, s.medical_allowance,\n"
                + "s.TDS, s.ESI, s.PF, s.leave, s.loan, s.professional_tax, ((basic_salary+DA+HRA+conveyance+allowance+medical_allowance)-(TDS+ESI+PF+leave+loan+professional_tax)) as net_salary,\n"
                + "s.create_date\n"
                + "from [profile] p full outer join [account] a \n"
                + "on p.profile_id = a.profile_id \n"
                + "full outer join [salary] s\n"
                + "on p.profile_id = s.profile_id\n"
                + "where a.isadmin = 0\n"
                + "and a.ismanager = ?\n"
                + "and p.first_name + p.last_name like ?\n"
                + "and s.create_date >= ?";
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            state.setString(1, erole);
            state.setString(2, "%" + ename + "%");
            state.setString(3, from);
            rs = state.executeQuery();
            while (rs.next()) {
                list.add(new Salary(
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
                        rs.getDouble(23),
                        rs.getString(24)
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

    public List<Salary> searchEmployeeSalaryWithCreateDate4(String from, String to) {
        List<Salary> list = new ArrayList<>();
        String sql = "select p.id, p.profile_id,p.first_name,p.last_name,p.email,p.phone_number,p.hire_date,p.job_id,p.department_id,p.report_to, s.basic_salary, s.DA, s.HRA, s.conveyance, s.allowance, s.medical_allowance,\n"
                + "s.TDS, s.ESI, s.PF, s.leave, s.loan, s.professional_tax, ((basic_salary+DA+HRA+conveyance+allowance+medical_allowance)-(TDS+ESI+PF+leave+loan+professional_tax)) as net_salary,\n"
                + "s.create_date\n"
                + "from [profile] p full outer join [account] a \n"
                + "on p.profile_id = a.profile_id \n"
                + "full outer join [salary] s\n"
                + "on p.profile_id = s.profile_id\n"
                + "where a.isadmin = 0\n"
                + "and s.create_date BETWEEN ? and ?";
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            state.setString(1, from);
            state.setString(2, to);
            rs = state.executeQuery();
            while (rs.next()) {
                list.add(new Salary(
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
                        rs.getDouble(23),
                        rs.getString(24)
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

    public List<Salary> searchEmployeeSalaryWithCreateDate5(String erole, String from, String to) {
        List<Salary> list = new ArrayList<>();
        String sql = "select p.id, p.profile_id,p.first_name,p.last_name,p.email,p.phone_number,p.hire_date,p.job_id,p.department_id,p.report_to, s.basic_salary, s.DA, s.HRA, s.conveyance, s.allowance, s.medical_allowance,\n"
                + "s.TDS, s.ESI, s.PF, s.leave, s.loan, s.professional_tax, ((basic_salary+DA+HRA+conveyance+allowance+medical_allowance)-(TDS+ESI+PF+leave+loan+professional_tax)) as net_salary,\n"
                + "s.create_date\n"
                + "from [profile] p full outer join [account] a \n"
                + "on p.profile_id = a.profile_id \n"
                + "full outer join [salary] s\n"
                + "on p.profile_id = s.profile_id\n"
                + "where a.isadmin = 0\n"
                + "and a.ismanager = ?\n"
                + "and s.create_date BETWEEN ? and ?";
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            state.setString(1, erole);
            state.setString(2, from);
            state.setString(3, to);
            rs = state.executeQuery();
            while (rs.next()) {
                list.add(new Salary(
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
                        rs.getDouble(23),
                        rs.getString(24)
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

    public List<Salary> searchEmployeeSalaryWithCreateDate6(String erole, String from) {
        List<Salary> list = new ArrayList<>();
        String sql = "select p.id, p.profile_id,p.first_name,p.last_name,p.email,p.phone_number,p.hire_date,p.job_id,p.department_id,p.report_to, s.basic_salary, s.DA, s.HRA, s.conveyance, s.allowance, s.medical_allowance,\n"
                + "s.TDS, s.ESI, s.PF, s.leave, s.loan, s.professional_tax, ((basic_salary+DA+HRA+conveyance+allowance+medical_allowance)-(TDS+ESI+PF+leave+loan+professional_tax)) as net_salary,\n"
                + "s.create_date\n"
                + "from [profile] p full outer join [account] a \n"
                + "on p.profile_id = a.profile_id \n"
                + "full outer join [salary] s\n"
                + "on p.profile_id = s.profile_id\n"
                + "where a.isadmin = 0\n"
                + "and a.ismanager = ?\n"
                + "and s.create_date >= ?";
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            state.setString(1, erole);
            state.setString(2, from);
            rs = state.executeQuery();
            while (rs.next()) {
                list.add(new Salary(
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
                        rs.getDouble(23),
                        rs.getString(24)
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

    public List<Salary> searchEmployeeSalaryWithCreateDate7(String ename, String from) {
        List<Salary> list = new ArrayList<>();
        String sql = "select p.id, p.profile_id,p.first_name,p.last_name,p.email,p.phone_number,p.hire_date,p.job_id,p.department_id,p.report_to, s.basic_salary, s.DA, s.HRA, s.conveyance, s.allowance, s.medical_allowance,\n"
                + "s.TDS, s.ESI, s.PF, s.leave, s.loan, s.professional_tax, ((basic_salary+DA+HRA+conveyance+allowance+medical_allowance)-(TDS+ESI+PF+leave+loan+professional_tax)) as net_salary,\n"
                + "s.create_date\n"
                + "from [profile] p full outer join [account] a \n"
                + "on p.profile_id = a.profile_id \n"
                + "full outer join [salary] s\n"
                + "on p.profile_id = s.profile_id\n"
                + "where a.isadmin = 0\n"
                + "and p.first_name + p.last_name like ?\n"
                + "and s.create_date >= ?";
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            state.setString(1, "%" + ename + "%");
            state.setString(2, from);
            rs = state.executeQuery();
            while (rs.next()) {
                list.add(new Salary(
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
                        rs.getDouble(23),
                        rs.getString(24)
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

    public List<Salary> searchEmployeeSalaryWithFromOnly(String from) {
        List<Salary> list = new ArrayList<>();
        String sql = "select p.id, p.profile_id,p.first_name,p.last_name,p.email,p.phone_number,p.hire_date,p.job_id,p.department_id,p.report_to, s.basic_salary, s.DA, s.HRA, s.conveyance, s.allowance, s.medical_allowance,\n"
                + "s.TDS, s.ESI, s.PF, s.leave, s.loan, s.professional_tax, ((basic_salary+DA+HRA+conveyance+allowance+medical_allowance)-(TDS+ESI+PF+leave+loan+professional_tax)) as net_salary,\n"
                + "s.create_date\n"
                + "from [profile] p full outer join [account] a \n"
                + "on p.profile_id = a.profile_id \n"
                + "full outer join [salary] s\n"
                + "on p.profile_id = s.profile_id\n"
                + "where a.isadmin = 0\n"
                + "and s.create_date >= ?";
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            state.setString(1, from);
            rs = state.executeQuery();
            while (rs.next()) {
                list.add(new Salary(
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
                        rs.getDouble(23),
                        rs.getString(24)
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
        String sql = "select p.id, p.profile_id,p.first_name,p.last_name,p.email,p.phone_number,p.hire_date,p.job_id,p.department_id,p.report_to, s.basic_salary, s.DA, s.HRA, s.conveyance, s.allowance, s.medical_allowance,\n"
                + "s.TDS, s.ESI, s.PF, s.leave, s.loan, s.professional_tax, ((basic_salary+DA+HRA+conveyance+allowance+medical_allowance)-(TDS+ESI+PF+leave+loan+professional_tax)) as net_salary,\n"
                + "s.create_date\n"
                + "from [profile] p full outer join [account] a \n"
                + "on p.profile_id = a.profile_id \n"
                + "full outer join [salary] s\n"
                + "on p.profile_id = s.profile_id\n"
                + "where a.isadmin = 0\n"
                + "and p.first_name + p.last_name like ?";
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            state.setString(1, "%" + ename + "%");
            rs = state.executeQuery();
            while (rs.next()) {
                list.add(new Salary(
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
                        rs.getDouble(23),
                        rs.getString(24)
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
        String sql = "select p.id, p.profile_id,p.first_name,p.last_name,p.email,p.phone_number,p.hire_date,p.job_id,p.department_id,p.report_to, s.basic_salary, s.DA, s.HRA, s.conveyance, s.allowance, s.medical_allowance,\n"
                + "s.TDS, s.ESI, s.PF, s.leave, s.loan, s.professional_tax, ((basic_salary+DA+HRA+conveyance+allowance+medical_allowance)-(TDS+ESI+PF+leave+loan+professional_tax)) as net_salary,\n"
                + "s.create_date\n"
                + "from [profile] p full outer join [account] a \n"
                + "on p.profile_id = a.profile_id \n"
                + "full outer join [salary] s\n"
                + "on p.profile_id = s.profile_id\n"
                + "where a.isadmin = 0\n"
                + "and a.ismanager = ?";
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            state.setString(1, erole);
            rs = state.executeQuery();
            while (rs.next()) {
                list.add(new Salary(
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
                        rs.getDouble(23),
                        rs.getString(24)
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

    //string type array for one digit numbers     
    public static final String[] twodigits = {"", " Ten", " Twenty", " Thirty", " Forty", " Fifty", " Sixty", " Seventy", " Eighty", " Ninety"};
//string type array for two digits numbers   
    public static final String[] onedigit = {"", " One", " Two", " Three", " Four", " Five", " Six", " Seven", " Eight", " Nine", " Ten", " Eleven", " Twelve", " Thirteen", " Fourteen", " Fifteen", " Sixteen", " Seventeen", " Eighteen", " Nineteen"};

//user-defined method that converts a number to words (up to 1000)  
    public static String convertUptoThousand(int number) {
        String soFar;
        if (number % 100 < 20) {
            soFar = onedigit[number % 100];
            number = number / 100;
        } else {
            soFar = onedigit[number % 10];
            number = number / 10;
            soFar = twodigits[number % 10] + soFar;
            number = number / 10;
        }
        if (number == 0) {
            return soFar;
        }
        return onedigit[number] + " Hundred " + soFar;
    }
//user-defined method that converts a long number (0 to 999999999) to string    

    public static String convertNumberToWord(long number) {
//checks whether the number is zero or not  
        if (number == 0) {
//if the given number is zero it returns zero  
            return "zero";
        }
//the toString() method returns a String object that represents the specified long  
        String num = Long.toString(number);
//for creating a mask padding with "0"   
        String pattern = "000000000000";
//creates a DecimalFormat using the specified pattern and also provides the symbols for the default locale  
        DecimalFormat decimalFormat = new DecimalFormat(pattern);
//format a number of the DecimalFormat instance  
        num = decimalFormat.format(number);
//format: XXXnnnnnnnnn  
//the subString() method returns a new string that is a substring of this string  
//the substring begins at the specified beginIndex and extends to the character at index endIndex - 1  
//the parseInt() method converts the string into integer  
        int billions = Integer.parseInt(num.substring(0, 3));
//format: nnnXXXnnnnnn  
        int millions = Integer.parseInt(num.substring(3, 6));
//format: nnnnnnXXXnnn  
        int hundredThousands = Integer.parseInt(num.substring(6, 9));
//format: nnnnnnnnnXXX  
        int thousands = Integer.parseInt(num.substring(9, 12));
        String tradBillions;
        switch (billions) {
            case 0:
                tradBillions = "";
                break;
            case 1:
                tradBillions = convertUptoThousand(billions) + " Billion ";
                break;
            default:
                tradBillions = convertUptoThousand(billions) + " Billion ";
        }
        String result = tradBillions;
        String tradMillions;
        switch (millions) {
            case 0:
                tradMillions = "";
                break;
            case 1:
                tradMillions = convertUptoThousand(millions) + " Million ";
                break;
            default:
                tradMillions = convertUptoThousand(millions) + " Million ";
        }
        result = result + tradMillions;
        String tradHundredThousands;
        switch (hundredThousands) {
            case 0:
                tradHundredThousands = "";
                break;
            case 1:
                tradHundredThousands = "One Thousand ";
                break;
            default:
                tradHundredThousands = convertUptoThousand(hundredThousands) + " Thousand ";
        }
        result = result + tradHundredThousands;
        String tradThousand;
        tradThousand = convertUptoThousand(thousands);
        result = result + tradThousand;
//removing extra space if any  
        return result.replaceAll("^\\s+", "").replaceAll("\\b\\s{2,}\\b", " ");
    }

    public static void main(String[] args) {
        DAOSalary daoSalary = new DAOSalary();
        List<Salary> list = daoSalary.listAllStaffSalary("ABCDE");

//        String name = "a";
//        String role = "a";
//        String from = "";
//        String to = "";
//        if (!name.equals("") && role.equals("")) {
//            System.out.println("dung r");
//        } else if (!name.equals("") && !role.equals("")){
//            System.out.println("vao truong hop khac roi");
//        }
//        Random rand = new java.util.Random();
//        int num = rand.nextInt(100000);
//        System.out.println(num);
//        String num = "100.0";
//        System.out.println(Math.round(100.52));
//        System.out.println(convertNumberToWord(2));
//        System.out.println(convertNumberToWord(99));
//        System.out.println(convertNumberToWord(456));
//        System.out.println(convertNumberToWord(1101));
//        System.out.println(convertNumberToWord(19812));
//        System.out.println(convertNumberToWord(674319));
//        System.out.println(convertNumberToWord(909087531));
//        System.out.println(convertNumberToWord(1000000000));
//        System.out.println(convertNumberToWord(359999999));
//        System.out.println(convertNumberToWord(1213000000L));
//        System.out.println(convertNumberToWord(1000000));
//        System.out.println(convertNumberToWord(1111111111));
//        System.out.println(convertNumberToWord(3000200));
//        System.out.println(convertNumberToWord(700000));
//        System.out.println(convertNumberToWord(9000000));
//        List<Salary> list = daoSalary.listIndividualSalaryAndProfileInPayslip("ABCDE");
        System.out.println(list);
    }
}
