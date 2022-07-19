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
public class Leave extends Profile {

    int id;
    String profile_id;
    int leave_type;
    String leave_name;
    String from, to;
    String number_of_days;
    String reason;
    int status;

    public Leave() {
    }

    //myLeave list constructor
    public Leave(String reportto, int annual_leave, int id, String profile_id, int leave_type, String from, String to, String number_of_days, String reason, int status) {
        super(reportto, annual_leave);
        this.id = id;
        this.profile_id = profile_id;
        this.leave_type = leave_type;
        this.from = from;
        this.to = to;
        this.number_of_days = number_of_days;
        this.reason = reason;
        this.status = status;
    }

    //checkLeave list constructor
    public Leave(String first_name, String last_name, int job_id, int annual_leave, int id, String profile_id, int leave_type, String from, String to, String number_of_days, String reason, int status) {
        super(first_name, last_name, job_id, annual_leave);
        this.id = id;
        this.profile_id = profile_id;
        this.leave_type = leave_type;
        this.from = from;
        this.to = to;
        this.number_of_days = number_of_days;
        this.reason = reason;
        this.status = status;
    }

    //getLeave by profile_id constructor
    public Leave(int id, String profile_id, int leave_type, String from, String to, String number_of_days, String reason, int status) {
        this.id = id;
        this.profile_id = profile_id;
        this.leave_type = leave_type;
        this.from = from;
        this.to = to;
        this.number_of_days = number_of_days;
        this.reason = reason;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProfile_id() {
        return profile_id;
    }

    public void setProfile_id(String profile_id) {
        this.profile_id = profile_id;
    }

    public int getLeave_type() {
        return leave_type;
    }

    public void setLeave_type(int leave_type) {
        this.leave_type = leave_type;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getNumber_of_days() {
        return number_of_days;
    }

    public void setNumber_of_days(String number_of_days) {
        this.number_of_days = number_of_days;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getLeave_name() {
        return leave_name;
    }

    public void setLeave_name(String leave_name) {
        this.leave_name = leave_name;
    }

    @Override
    public String toString() {
        return "profile{" + "first_name=" + super.getFirst_name() + ", last_name=" + super.getLast_name() + ", job_id=" + super.getJob_id() + ", reportto=" + super.getReportto() + ", annual_leave=" + super.getAnnual_leave() + "} " + "Leave{" + "id=" + id + ", profile_id=" + profile_id + ", leave_type=" + leave_type + ", from=" + from + ", to=" + to + ", number_of_days=" + number_of_days + ", reason=" + reason + ", status=" + status + '}';
    }

}
