/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author DELL
 */
public class Company {

    int id;
    String name;
    String pro_id;
    String fname_d;
    String lname_d;
    String address;
    String country;
    String province;
    String city;
    int postal_code;
    String email;
    int phone;
    String pphone_d;
    int fax;
    String url;

    public Company() {
    }

    public Company(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Company(int id, String name, String pro_id, String fname_d, String lname_d, String address, String country, String province, String city, int postal_code, String email, int phone, String pphone_d, int fax, String url) {
        this.id = id;
        this.name = name;
        this.pro_id = pro_id;
        this.fname_d = fname_d;
        this.lname_d = lname_d;
        this.address = address;
        this.country = country;
        this.province = province;
        this.city = city;
        this.postal_code = postal_code;
        this.email = email;
        this.phone = phone;
        this.pphone_d = pphone_d;
        this.fax = fax;
        this.url = url;
    }

    public Company(String name, String pro_id, String address, String country, String province, String city, int postal_code, String email, int phone, int fax, String url) {
        this.name = name;
        this.pro_id = pro_id;
        this.address = address;
        this.country = country;
        this.province = province;
        this.city = city;
        this.postal_code = postal_code;
        this.email = email;
        this.phone = phone;
        this.fax = fax;
        this.url = url;
    }
    
    public Company(String name, String address, String country, String province, String city, int postal_code, String email, int phone, int fax, String url) {
        this.name = name;
        this.address = address;
        this.country = country;
        this.province = province;
        this.city = city;
        this.postal_code = postal_code;
        this.email = email;
        this.phone = phone;
        this.fax = fax;
        this.url = url;
    }
    
    public Company(int id, String name, String email, int phone, String url) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.url = url;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getPro_id() {
        return pro_id;
    }

    public void setPro_id(String pro_id) {
        this.pro_id = pro_id;
    }

    public String getFname_d() {
        return fname_d;
    }

    public void setFname_d(String fname_d) {
        this.fname_d = fname_d;
    }

    public String getLname_d() {
        return lname_d;
    }

    public void setLname_d(String lname_d) {
        this.lname_d = lname_d;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(int postal_code) {
        this.postal_code = postal_code;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getPphone_d() {
        return pphone_d;
    }

    public void setPphone_d(String pphone_d) {
        this.pphone_d = pphone_d;
    }

    public int getFax() {
        return fax;
    }

    public void setFax(int fax) {
        this.fax = fax;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    } 

    @Override
    public String toString() {
        return "Company{" + "id=" + id + ", name=" + name + ", pro_id=" + pro_id + ", fname_d=" + fname_d + ", lname_d=" + lname_d + ", address=" + address + ", country=" + country + ", province=" + province + ", city=" + city + ", postal_code=" + postal_code + ", email=" + email + ", phone=" + phone + ", pphone_d=" + pphone_d + ", fax=" + fax + ", url=" + url + '}';
    }


}
