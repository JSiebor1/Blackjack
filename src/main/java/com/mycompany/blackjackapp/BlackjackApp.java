package com.mycompany.blackjackapp;

import java.util.ArrayList;

public class BlackjackApp {

    private Deck deckClass;
    private Card[] deck;
    private int playerValue;
    private int dealerValue;
    private int count;
    private ArrayList<Card> playerHand;
    private ArrayList<Card> dealerHand;

    public BlackjackApp(int points) {
        deckClass = new Deck();
        deck = deckClass.getDeck();

        playerValue = 0;
        dealerValue = 0;

        count = 0;

        playerHand = new ArrayList<Card>();
        dealerHand = new ArrayList<Card>();
    }

    public void calcValue(int x, boolean isPlayer) {
        if (isPlayer) {
            playerValue += x;
        } else {
            dealerValue += x;
        }
    }
    
    public void changeAceValue(ArrayList<Card> hand, int value) {
        for(int i = 0; i < hand.size(); i++) {
            if(hand.get(i).getName().equals("Ace") && hand.get(i).getValue() == 11) {
                hand.get(i).setValue(1);
            }
        }
    }

    public boolean over21(int value) {
        return value > 21;
    }

    public Card draw() {
        count++;
        return deck[count - 1];
    }

    public void playerTurn(String str) {

    }

    // draw and add card to playerHand
    public void hit() {
        playerHand.add(draw());
    }

    public void dealerTurn() {

    }

    public void play() {
        playerHand.add(draw());
        dealerHand.add(draw());
        playerHand.add(draw());
        dealerHand.add(draw());
        
        

    }
}
