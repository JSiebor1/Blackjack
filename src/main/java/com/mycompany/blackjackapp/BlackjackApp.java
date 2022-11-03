package com.mycompany.blackjackapp;

public class BlackjackApp {

    private Deck deckClass;
    private Card[] deck;
    private int playerValue;
    private int dealerValue;
    private int points;
    private int count;

    public BlackjackApp(int points) {
        deckClass = new Deck();
        deck = deckClass.getDeck();

        playerValue = 0;
        dealerValue = 0;

        this.points = points;
        int count = 0;

        draw();
    }

    public void calcValue(int x, boolean isPlayer) {
        if (isPlayer) {
            playerValue += x;
        } else {
            dealerValue += x;
        }
    }

    public boolean isAce(Card c) {
        return c.getName().equals("Ace");
    }

    public Card draw() {
        count++;
        return deck[count - 1];
    }

    public void playerTurn(String str) {

    }

    public void dealerTurn() {

    }

    public void play() {

    }
}
