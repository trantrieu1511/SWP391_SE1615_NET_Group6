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
public class Projects {
    String title;
    String client;
    String period;
    double rate;
    String manager;
    String description;

    public Projects() {
    }

    public Projects(String title, String client, String period, double rate, String manager, String description) {
        this.title = title;
        this.client = client;
        this.period = period;
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

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
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
        return "projects{" + "title=" + title + ", client=" + client + ", period=" + period + ", rate=" + rate + ", manager=" + manager + ", description=" + description + '}';
    }
    
}
