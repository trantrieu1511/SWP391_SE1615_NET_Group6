/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Clients;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Khanh
 */
public class DAOClientsTest {
    
    DAOClients dao = new DAOClients();
    
    public DAOClientsTest() {
    }

    /**
     * Test of listAllClients method, of class DAOClients.
     */
    @Test
    public void testListAllClients() {
        assertEquals("[Clients{client_id=CIJID, first_name=John, last_name=Doe, "
                + "email=abc@xyz, phone_number=12345678, company_id=1, "
                + "company_name=null}, Clients{client_id=YUKJI, first_name=Barry"
                + ", last_name=Cuda, email=abc@xyz, phone_number=12345678, "
                + "company_id=2, company_name=null}]", 
                dao.listAllClients().toString());
    }

    /**
     * Test of getIndividualClientProfile method, of class DAOClients.
     */
    @Test
    public void testGetIndividualClientProfile() {
        assertEquals("[Clients{client_id=YUKJI, first_name=Barry, last_name=Cuda"
                + ", email=abc@xyz, phone_number=12345678, company_id=2,"
                + " company_name=null}]", dao.getIndividualClientProfile("YUKJI").toString());
    }

    /**
     * Test of searchClient1 method, of class DAOClients.
     */
    @Test
    public void testSearchClient1_1() {
        assertEquals("[Clients{client_id=CIJID, first_name=John, last_name=Doe,"
                + " email=abc@xyz, phone_number=12345678, company_id=1, "
                + "company_name=null}]", dao.searchClient1("C", "John").toString());
    }
    
    @Test
    public void testSearchClient1_2() {
        assertEquals(dao.searchClient1("", "Gio").toString(), "[]");
    }

    /**
     * Test of searchClient2 method, of class DAOClients.
     */
    @Test
    public void testSearchClient2_1() {
        assertEquals("[Clients{client_id=CIJID, first_name=John, last_name=Doe,"
                + " email=abc@xyz, phone_number=12345678, company_id=1, "
                + "company_name=null}]", dao.searchClient2("C", "John", "1").toString());
    }
    
    @Test
    public void testSearchClient2_2() {
        assertEquals(dao.searchClient2("", "", "8").toString(), "[]");
    }

    /**
     * Test of addClient method, of class DAOClients.
     */
    @Test
    public void testAddClient() {
        //assertTrue(dao.addClient(new Clients("YINVD", "sss", "sss", "sss", "sss", 1)));
    }

    /**
     * Test of editClient method, of class DAOClients.
     */
    @Test
    public void testEditClient() {
        //assertTrue(dao.editClient(new Clients("YINVD", "John", "Doe", "abc@xyz.com", "0987676472", 1)));
    }

    /**
     * Test of deleteClient method, of class DAOClients.
     */
    @Test
    public void testDeleteClient() {
        assertTrue(dao.deleteClient("YINVD"));
    }
    
}
