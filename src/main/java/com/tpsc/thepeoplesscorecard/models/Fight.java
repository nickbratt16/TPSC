package com.tpsc.thepeoplesscorecard.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Fight {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String headliner1;
    private String headliner2;
    private String location;
    private String date;

    public Fight() { }

    public Fight(String headliner1, String headliner2, Boolean onPPV, String location, String date) {
        this.headliner1 = headliner1;
        this.headliner2 = headliner2;
        this.location = location;
        this.date = date;
    }

    public long getId() {
        return this.id;
    }

    public String getHeadliner1() {
        return headliner1;
    }

    public void setHeadliner1(String headliner1) {
        this.headliner1 = headliner1;
    }

    public String getHeadliner2() {
        return headliner2;
    }

    public void setHeadliner2(String headliner2) {
        this.headliner2 = headliner2;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return this.headliner1 + " vs. " + this.headliner2 + " on " + this.date + " in " + this.location;
    }
}
