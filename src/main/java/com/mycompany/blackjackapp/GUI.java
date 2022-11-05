package com.mycompany.blackjackapp;

public class GUI {

    protected int points;
    private BlackjackApp round;

    public GUI() {
        points = 1000;
        
        newRound();
    }

    private void newRound() {
        round = new BlackjackApp(points);
    }

}
