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
public class profile {
    String profile_id, first_name, last_name, email, phone_number;
    String hire_date;
    int job_id;
    String job_title;
    double salary;
    String reportto;
    boolean isadmin;
    int department_id;
    String department_name;
    String username;
    String password;

    public profile() {
    }

    public profile(String profile_id, String first_name, String last_name, String email, String phone_number, String hire_date, String job_title, double salary, String reportto, boolean isadmin, String department_name, String username, String password) {
        this.profile_id = profile_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.phone_number = phone_number;
        this.hire_date = hire_date;
        this.job_title = job_title;
        this.salary = salary;
        this.reportto = reportto;
        this.isadmin = isadmin;
        this.department_name = department_name;
        this.username = username;
        this.password = password;
    }

    public String getJob_title() {
        return job_title;
    }

    public void setJob_title(String job_title) {
        this.job_title = job_title;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

    //add Staff constructor
    public profile(String profile_id, String first_name, String last_name, String email, String phone_number, String hire_date, int job_id, double salary, String reportto, int department_id, String username, String password) {
        this.profile_id = profile_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.phone_number = phone_number;
        this.hire_date = hire_date;
        this.job_id = job_id;
        this.salary = salary;
        this.reportto = reportto;
        this.department_id = department_id;
        this.username = username;
        this.password = password;
    }
    
    //add Manager constructor
    public profile(String profile_id, String first_name, String last_name, String email, String phone_number, String hire_date, int job_id, double salary, int department_id, String username, String password) {
        this.profile_id = profile_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.phone_number = phone_number;
        this.hire_date = hire_date;
        this.job_id = job_id;
        this.salary = salary;
        this.department_id = department_id;
        this.username = username;
        this.password = password;
    }
    
    //add Admin constructor
    public profile(String profile_id, String first_name, String last_name, String email, String phone_number, String hire_date, int job_id, double salary, String reportto, boolean isadmin, int department_id, String username, String password) {
        this.profile_id = profile_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.phone_number = phone_number;
        this.hire_date = hire_date;
        this.job_id = job_id;
        this.salary = salary;
        this.reportto = reportto;
        this.isadmin = isadmin;
        this.department_id = department_id;
        this.username = username;
        this.password = password;
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

    public int getJob_id() {
        return job_id;
    }

    public void setJob_id(int job_id) {
        this.job_id = job_id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getReportto() {
        return reportto;
    }

    public void setReportto(String reportto) {
        this.reportto = reportto;
    }

    public boolean isIsadmin() {
        return isadmin;
    }

    public void setIsadmin(boolean isadmin) {
        this.isadmin = isadmin;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Profile{" + "profile_id=" + profile_id + ", first_name=" + first_name + ", last_name=" + last_name + ", email=" + email + ", phone_number=" + phone_number + ", hire_date=" + hire_date + ", job_id=" + job_id + ", job_title=" + job_title + ", salary=" + salary + ", reportto=" + reportto + ", isadmin=" + isadmin + ", department_id=" + department_id + ", department_name=" + department_name + ", username=" + username + ", password=" + password + '}';
    }
    
}