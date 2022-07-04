/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Clients;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Khanh
 */
public class DAOClients extends DBConnect {

    Connection conn = null;
    PreparedStatement state = null;
    ResultSet rs = null;

    public List<Clients> listAllClients() {
        List<Clients> list = new ArrayList<>();
        String sql = "select client_id, first_name, last_name, email,"
                + " phone_number, company_id, company_name from clients join "
                + "company on clients.company = company.company_id";
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            rs = state.executeQuery();
            while (rs.next()) {
                list.add(new Clients(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getString(7)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResultSet(rs);
            closePrepareStatement(state);
            closeConnection(conn);
        }
        return list;
    }

    public Clients getIndividualClientProfile(String client_id) {
        String sql = "select * from clients where client_id = ?";
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            state.setString(1, client_id);
            rs = state.executeQuery();
            while (rs.next()) {
                return new Clients(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResultSet(rs);
            closePrepareStatement(state);
            closeConnection(conn);
        }
        return null;
    }

    public List<Clients> searchClient1(String id, String name) {
        String sql = "select * from [clients] where client_id like ? "
                + "and first_name + last_name like ?";
        List<Clients> list = new ArrayList<>();
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            state.setString(1, "%" + id + "%");
            state.setString(2, "%" + name + "%");
            rs = state.executeQuery();
            while (rs.next()) {
                list.add(new Clients(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6)));
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

    public List<Clients> searchClient2(String id, String name, String company_id) {
        String sql = "select * from [clients] where client_id like ? "
                + "and company_id = ? and first_name + last_name like ?";
        List<Clients> list = new ArrayList<>();
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            state.setString(1, "%" + id + "%");
            state.setString(2, company_id);
            state.setString(3, "%" + name + "%");
            rs = state.executeQuery();
            while (rs.next()) {
                list.add(new Clients(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6)));
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

    public boolean addClient(Clients client) {
        String sql = "insert into [clients]"
                + " values (?,?,?,?,?,?)";
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            state.setString(1, client.getClient_id());
            state.setString(2, client.getFirst_name());
            state.setString(3, client.getLast_name());
            state.setString(4, client.getEmail());
            state.setString(5, client.getPhone_number());
            state.setInt(6, client.getCompany_id());
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

    public boolean editClient(Clients client) {
        String sql = "update [clients]\n"
                + "set\n"
                + "first_name = ?,\n"
                + "last_name = ?,\n"
                + "email = ?,\n"
                + "phone_number = ?,\n"
                + "company_id = ?\n"
                + "where client_id = ?";
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            state.setString(1, client.getFirst_name());
            state.setString(2, client.getLast_name());
            state.setString(3, client.getEmail());
            state.setString(4, client.getPhone_number());
            state.setInt(5, client.getCompany_id());
            state.setString(6, client.getClient_id());
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

    public boolean deleteClient(String client_id) {
        String sql = "delete from [clients]"
                + "where client_id = ?";
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            state.setString(1, client_id);
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

    public static void main(String[] args) {
        DAOClients daoCl = new DAOClients();
        List<Clients> list = daoCl.listAllClients();
//        List<Clients> list = daoCl.getIndividualClientProfile("CL001");
        for (Clients clients : list) {
            System.out.println(clients.toString());
        }
//        System.out.println(daoCl.listAllClients());
    }
}
