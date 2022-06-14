/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Khanh
 */
public class account {
    String profile_id;
    String user;
    String pass;
    boolean isAdmin;
    boolean isManager;

    public account() {
    }

    public account(String profile_id, String user, String pass, boolean isAdmin, boolean isManager) {
        this.profile_id = profile_id;
        this.user = user;
        this.pass = pass;
        this.isAdmin = isAdmin;
        this.isManager = isManager;
    }

    public String getProfile_id() {
        return profile_id;
    }

    public void setProfile_id(String profile_id) {
        this.profile_id = profile_id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public boolean isIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public boolean isIsManager() {
        return isManager;
    }

    public void setIsManager(boolean isManager) {
        this.isManager = isManager;
    }

    @Override
    public String toString() {
        return "account{" + "profile_id=" + profile_id + ", user=" + user + ", pass=" + pass + ", isAdmin=" + isAdmin + ", isManager=" + isManager + '}';
    }
    
}
