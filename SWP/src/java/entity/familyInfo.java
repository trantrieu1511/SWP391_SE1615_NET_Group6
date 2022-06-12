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
public class familyInfo {
    String profile_id, name, relationship, dob, phone;

    public familyInfo() {
    }

    public familyInfo(String profile_id, String name, String relationship, String dob, String phone) {
        this.profile_id = profile_id;
        this.name = name;
        this.relationship = relationship;
        this.dob = dob;
        this.phone = phone;
    }

    public String getProfile_id() {
        return profile_id;
    }

    public void setProfile_id(String profile_id) {
        this.profile_id = profile_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "familyInfo{" + "profile_id=" + profile_id + ", name=" + name + ", relationship=" + relationship + ", dob=" + dob + ", phone=" + phone + '}';
    }
    
}
