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
public class Attendance {
    int id;
    String date;
    String time_in;
    String time_out;
    String production_time;
    String employee_id;
    String note;

    public Attendance() {
    }
    
    public Attendance(String employee_id) {
        this.employee_id = employee_id;
    }

    public Attendance(int id, String date, String time_in, String time_out, String production_time, String employee_id, String reportto) {
        this.id = id;
        this.date = date;
        this.time_in = time_in;
        this.time_out = time_out;
        this.production_time = production_time;
        this.employee_id = employee_id;
        this.note = reportto;
    }

    public Attendance(int id, String date, String time_in, String time_out, String production_time, String employee_id) {
        this.id = id;
        this.date = date;
        this.time_in = time_in;
        this.time_out = time_out;
        this.production_time = production_time;
        this.employee_id = employee_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime_in() {
        return time_in;
    }

    public void setTime_in(String time_in) {
        this.time_in = time_in;
    }

    public String getTime_out() {
        return time_out;
    }

    public void setTime_out(String time_out) {
        this.time_out = time_out;
    }

    public String getProduction_time() {
        return production_time;
    }

    public void setProduction_time(String production_time) {
        this.production_time = production_time;
    }

    public String getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(String employee_id) {
        this.employee_id = employee_id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "attendance{" + "id=" + id + ", date=" + date + ", time_in=" + time_in + ", time_out=" + time_out + ", production_time=" + production_time + ", employee_id=" + employee_id + ", note=" + note + '}';
    }

}
