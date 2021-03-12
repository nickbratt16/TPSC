package com.tpsc.thepeoplesscorecard.models;

public class Scores {

    private String fighter1;
    private String fighter2;
    private int round1Score1;
    private int round1Score2;
    private int round2Score1;
    private int round2Score2;
    private int round3Score1;
    private int round3Score2;
    private int total1;
    private int total2;

    public Scores() {    }

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

    public int getTotal1() { return getRound1Score1() + getRound2Score1() + getRound3Score1(); }

    public int getTotal2() { return getRound1Score2() + getRound2Score2() + getRound3Score2(); }

}
