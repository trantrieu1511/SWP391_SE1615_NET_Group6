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
public class ProfileDetail {
    String profile_id, dob, address;
    boolean gender;
    String country, religion;
    boolean isMarried;
    int children;
    String bank_name, bank_number;

    public ProfileDetail() {
        
    }
    
    //profile information
    public ProfileDetail(String profile_id, String dob, String address, boolean gender) {
        this.profile_id = profile_id;
        this.dob = dob;
        this.address = address;
        this.gender = gender;
    }
    
    //personal information
    public ProfileDetail(String profile_id, String country, String religion, boolean isMarried, int children, String bank_name, String bank_number) {
        this.profile_id = profile_id;
        this.country = country;
        this.religion = religion;
        this.isMarried = isMarried;
        this.children = children;
        this.bank_name = bank_name;
        this.bank_number = bank_number;
    }

    public ProfileDetail(String profile_id, String dob, String address, boolean gender, String country, String religion, boolean isMarried, int children, String bank_name, String bank_number) {
        this.profile_id = profile_id;
        this.dob = dob;
        this.address = address;
        this.gender = gender;
        this.country = country;
        this.religion = religion;
        this.isMarried = isMarried;
        this.children = children;
        this.bank_name = bank_name;
        this.bank_number = bank_number;
    }

    public String getProfile_id() {
        return profile_id;
    }

    public void setProfile_id(String profile_id) {
        this.profile_id = profile_id;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public boolean isIsMarried() {
        return isMarried;
    }

    public void setIsMarried(boolean isMarried) {
        this.isMarried = isMarried;
    }

    public int getChildren() {
        return children;
    }

    public void setChildren(int children) {
        this.children = children;
    }

    public String getBank_name() {
        return bank_name;
    }

    public void setBank_name(String bank_name) {
        this.bank_name = bank_name;
    }

    public String getBank_number() {
        return bank_number;
    }

    public void setBank_number(String bank_number) {
        this.bank_number = bank_number;
    }

    @Override
    public String toString() {
        return "profileDetail{" + "profile_id=" + profile_id + ", dob=" + dob + ", address=" + address + ", gender=" + gender + ", country=" + country + ", religion=" + religion + ", isMarried=" + isMarried + ", children=" + children + ", bank_name=" + bank_name + ", bank_number=" + bank_number + '}';
    }
    
    
}
