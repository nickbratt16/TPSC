package com.tpsc.thepeoplesscorecard.models;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
public class Scores {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @NotBlank(message = "Fighter #1 is required")
    @Size(min = 2, message = "Fighter #1 must have a name more than 2 characters")
    private String fighter1;

    @NotBlank(message = "Fighter #2 is required")
    @Size(min = 2, message = "Fighter #2 must have a name more than 2 characters")
    private String fighter2;

    @Min(value = 8, message = "Minimum score is 8")
    @Max(value = 10, message = "Max score is 10")
    private int round1Score1;

    @Min(value = 8, message = "Minimum score is 8")
    @Max(value = 10, message = "Max score is 10")
    private int round1Score2;

    @Min(value = 8, message = "Minimum score is 8")
    @Max(value = 10, message = "Max score is 10")
    private int round2Score1;

    @Min(value = 8, message = "Minimum score is 8")
    @Max(value = 10, message = "Max score is 10")
    private int round2Score2;

    @Min(value = 8, message = "Minimum score is 8")
    @Max(value = 10, message = "Max score is 10")
    private int round3Score1;

    @Min(value = 8, message = "Minimum score is 8")
    @Max(value = 10, message = "Max score is 10")
    private int round3Score2;

    private LocalDateTime created;
    private LocalDateTime modified;

    public Scores() {
        this.fighter1 = "";
        this.fighter2 = "";
    }

    public Scores(String fighter1, String fighter2) {
        this.fighter1 = fighter1;
        this.fighter2 = fighter2;
    }

    public long getId() {
        return this.id;
    }

    public String getFighter1() { return fighter1; }

    public void setFighter1(String fighter1) { this.fighter1 = fighter1; }

    public String getFighter2() { return fighter2; }

    public void setFighter2(String fighter2) { this.fighter2 = fighter2; }

    public int getRound1Score1() { return round1Score1; }

    public void setRound1Score1(int round1Score1) { this.round1Score1 = round1Score1; }

    public int getRound1Score2() { return round1Score2; }

    public void setRound1Score2(int round1Score2) { this.round1Score2 = round1Score2; }

    public int getRound2Score1() { return round2Score1; }

    public void setRound2Score1(int round2Score1) { this.round2Score1 = round2Score1; }

    public int getRound2Score2() { return round2Score2; }

    public void setRound2Score2(int round2Score2) { this.round2Score2 = round2Score2; }

    public int getRound3Score1() { return round3Score1; }

    public void setRound3Score1(int round3Score1) { this.round3Score1 = round3Score1; }

    public int getRound3Score2() { return round3Score2; }

    public void setRound3Score2(int round3Score2) { this.round3Score2 = round3Score2; }

    @Override
    public String toString() {
        return  this.fighter1 + " vs. " + this.fighter2;
    }

    public LocalDateTime getCreated() { return created; }

    public void setCreated(LocalDateTime created) { this.created = created; }

    public LocalDateTime getModified() { return modified; }

    public void setModified(LocalDateTime modified) { this.modified = modified; }

    @PrePersist
    public void onCreate() {
        this.setCreated(LocalDateTime.now());
        this.setModified(LocalDateTime.now());
    }

    @PreUpdate
    public void onUpdate() {
        this.setModified(LocalDateTime.now());
    }
}
