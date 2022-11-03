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
        
        play();
    }

    public int calcValue(ArrayList<Card> hand) {
        int x = 0;
        for (int i = 0; i < hand.size(); i++) {
            x += hand.get(i).getValue();
        }
        return x;
    }

    public void changeAceValue(ArrayList<Card> hand, int value) {
        for (int i = 0; i < hand.size(); i++) {
            if (hand.get(i).getName().equals("Ace") && hand.get(i).getValue() == 11) {
                hand.get(i).setValue(1);
            }
        }
    }

    public boolean over21(int value) {
        return value > 21;
    }

    public boolean hasBlackjack(int value) {
        return value == 21;
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
        boolean playerBlackjack = false;
        boolean dealerBlackjack = false;
        Card dealerFlip;
        
        playerHand.add(draw());
        dealerFlip = draw();
        playerHand.add(draw());
        dealerHand.add(draw());
        
        System.out.println("Player Hand: ");
        for(int i = 0; i < playerHand.size(); i++) {
            System.out.println(playerHand.get(i).toString());
        }
        
        System.out.println("\nDealer Hand: ");
        for(int i = 0; i < dealerHand.size(); i++) {
            System.out.println(dealerHand.get(i).toString());
        }

        playerBlackjack = hasBlackjack(calcValue(playerHand));
        dealerBlackjack = hasBlackjack(calcValue(dealerHand));
        

    }
}
