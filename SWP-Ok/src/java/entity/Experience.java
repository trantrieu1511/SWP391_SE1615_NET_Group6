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
public class Experience {
    String profile_id, role, start_date, end_date;

    public Experience() {
    }

    public Experience(String profile_id, String role, String start_date, String end_date) {
        this.profile_id = profile_id;
        this.role = role;
        this.start_date = start_date;
        this.end_date = end_date;
    }

    public String getProfile_id() {
        return profile_id;
    }

    public void setProfile_id(String profile_id) {
        this.profile_id = profile_id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    @Override
    public String toString() {
        return "experience{" + "profile_id=" + profile_id + ", role=" + role + ", start_date=" + start_date + ", end_date=" + end_date + '}';
    }
    
    
}
