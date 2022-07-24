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
public class Schedule {
    String profile;
    String shift;

    public Schedule() {
    }

    public Schedule(String profile, String shift) {
        this.profile = profile;
        this.shift = shift;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    @Override
    public String toString() {
        return "Schedule{" + "profile=" + profile + ", shift=" + shift + '}';
    }
    
}
