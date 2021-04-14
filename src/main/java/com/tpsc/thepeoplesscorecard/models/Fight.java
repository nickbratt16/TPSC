package com.tpsc.thepeoplesscorecard.models;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Fight {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String headliner1;
    private String headliner2;
    private String location;
    private String date;

    @ManyToMany(mappedBy = "fights")
    private Set<Scores> scores;

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

    @Override
    public boolean equals(Object o) {
        if(!(o instanceof Fight))
                return false;

        Fight f = (Fight) o;
        return this.headliner1.equals(f.headliner1) && this.headliner2.equals(f.headliner2) && this.location.equals(f.location)
                && this.date.equals(f.date);
    }

    @Override
    public int hashCode() {
        return this.headliner1.hashCode();
    }
}
