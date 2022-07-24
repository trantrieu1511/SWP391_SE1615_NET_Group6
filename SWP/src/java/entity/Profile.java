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
public class Profile {

    int id;
    String profile_id, first_name, last_name, email, phone_number;
    String hire_date;
    int job_id;
    String job_title;
    int department_id;
    String department_name;
    String reportto;
    String reportto_name;
    String user_display;
    String pass_display;
    String isadmin_d;
    String ismanager_d;
    String status_d;
    int annual_leave;

    public Profile() {
    }

    public Profile(int id, String profile_id, String first_name, String last_name, String email, String phone_number, String hire_date, int job_id, int department_id, String reportto) {
        this.id = id;
        this.profile_id = profile_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.phone_number = phone_number;
        this.hire_date = hire_date;
        this.job_id = job_id;
        this.department_id = department_id;
        this.reportto = reportto;
    }

    //add Staff constructor
    public Profile(String first_name, String last_name, String email, String phone_number, String hire_date, int job_id, int department_id, String reportto) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.phone_number = phone_number;
        this.hire_date = hire_date;
        this.job_id = job_id;
        this.department_id = department_id;
        this.reportto = reportto;
    }

    public Profile(String profile_id, String first_name, String last_name, String email, String phone_number, String hire_date, int job_id, String job_title, int department_id, String department_name, String reportto) {
        this.profile_id = profile_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.phone_number = phone_number;
        this.hire_date = hire_date;
        this.job_id = job_id;
        this.job_title = job_title;
        this.department_id = department_id;
        this.department_name = department_name;
        this.reportto = reportto;
    }

    public Profile(String profile_id, String first_name, String last_name, String email, String phone_number, String hire_date, String user_display, String pass_display, String isadmin_d, String ismanager_d, String status_d) {
        this.profile_id = profile_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.phone_number = phone_number;
        this.hire_date = hire_date;
        this.user_display = user_display;
        this.pass_display = pass_display;
        this.isadmin_d = isadmin_d;
        this.ismanager_d = ismanager_d;
        this.status_d = status_d;
    }

    public Profile(String profile_id, String first_name, String last_name, String email, String phone_number, String hire_date, int job_id, int department_id, String reportto) {
        this.profile_id = profile_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.phone_number = phone_number;
        this.hire_date = hire_date;
        this.job_id = job_id;
        this.department_id = department_id;
        this.reportto = reportto;
    }
    
    public Profile(String first_name, String last_name, String email, String phone_number, String hire_date) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.phone_number = phone_number;
        this.hire_date = hire_date;
    }


    //constructor for choose staff option in add Salary
    public Profile(String profile_id, String first_name, String last_name) {
        this.profile_id = profile_id;
        this.first_name = first_name;
        this.last_name = last_name;
    }

    //constructor for myLeave list
    public Profile(String reportto, int annual_leave) {
        this.reportto = reportto;
        this.annual_leave = annual_leave;
    }

    //constructor for checkLeave list
    public Profile(String first_name, String last_name, int job_id, int annual_leave) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.job_id = job_id;
        this.annual_leave = annual_leave;
    }

    //constructor to get employee's AnnualLeave
    public Profile(int id, String profile_id, String first_name, String last_name, String email, String phone_number, String hire_date, int job_id, int department_id, String reportto, int annual_leave) {
        this.id = id;
        this.profile_id = profile_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.phone_number = phone_number;
        this.hire_date = hire_date;
        this.job_id = job_id;
        this.department_id = department_id;
        this.reportto = reportto;
        this.annual_leave = annual_leave;
    }

    public Profile(String profile_id, String first_name, String last_name, String phone_number) {
        this.profile_id = profile_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone_number = phone_number;
    }
    
    public String getStatus_d() {
        return status_d;
    }

    public void setStatus_d(String status_d) {
        this.status_d = status_d;
    }

    public String getProfile_id() {
        return profile_id;
    }

    public void setProfile_id(String profile_id) {
        this.profile_id = profile_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getHire_date() {
        return hire_date;
    }

    public void setHire_date(String hire_date) {
        this.hire_date = hire_date;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public int getJob_id() {
        return job_id;
    }

    public void setJob_id(int job_id) {
        this.job_id = job_id;
    }

    public String getJob_title() {
        return job_title;
    }

    public void setJob_title(String job_title) {
        this.job_title = job_title;
    }

    public String getReportto() {
        return reportto;
    }

    public void setReportto(String reportto) {
        this.reportto = reportto;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

    public String getUser_display() {
        return user_display;
    }

    public void setUser_display(String user_display) {
        this.user_display = user_display;
    }

    public String getPass_display() {
        return pass_display;
    }

    public void setPass_display(String pass_display) {
        this.pass_display = pass_display;
    }

    public String getIsadmin_d() {
        return isadmin_d;
    }

    public void setIsadmin_d(String isadmin_d) {
        this.isadmin_d = isadmin_d;
    }

    public String getIsmanager_d() {
        return ismanager_d;
    }

    public void setIsmanager_d(String ismanager_d) {
        this.ismanager_d = ismanager_d;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReportto_name() {
        return reportto_name;
    }

    public void setReportto_name(String reportto_name) {
        this.reportto_name = reportto_name;
    }

    public int getAnnual_leave() {
        return annual_leave;
    }

    public void setAnnual_leave(int annual_leave) {
        this.annual_leave = annual_leave;
    }

    @Override
    public String toString() {
        return "profile{" + "profile_id=" + profile_id + ", first_name=" + first_name + ", last_name=" + last_name + ", email=" + email + ", phone_number=" + phone_number + ", hire_date=" + hire_date + ", job_id=" + job_id + ", job_title=" + job_title + ", department_id=" + department_id + ", department_name=" + department_name + ", reportto=" + reportto + '}';
    }

}
