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
public class projects {
    String title;
    String client;
    String start_date;
    String end_date;
    double rate;
    String manager;
    String description;

    public projects() {
    }

    public projects(String title, String client, String start_date, String end_date, double rate, String manager, String description) {
        this.title = title;
        this.client = client;
        this.start_date = start_date;
        this.end_date = end_date;
        this.rate = rate;
        this.manager = manager;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
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

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "projects{" + "title=" + title + ", client=" + client + ", start_date=" + start_date + ", end_date=" + end_date + ", rate=" + rate + ", manager=" + manager + ", description=" + description + '}';
    }
    
}
