package com.mycompany.blackjackapp;

import java.util.ArrayList;
import java.util.Scanner;

public class BlackjackApp {

    public Card[] deck;

    private int playerValue;
    private int dealerValue;
    private int count;

    public ArrayList<Card> playerHand;
    public ArrayList<Card> dealerHand;

    public Card dealerFlipped;

    public int wager;
    public int credits;

    public boolean playerStand;
    public boolean playerBlackjack;
    public boolean playerBust;

    public boolean dealerBlackjack;
    public boolean dealerBust;

    public int winner;

    public BlackjackApp() {
        deck = new Deck().getDeck();

        playerValue = 0;
        dealerValue = 0;
        count = 0;

        playerHand = new ArrayList<Card>();
        dealerHand = new ArrayList<Card>();

        wager = 0;
        credits = 2500;

        playerStand = false;
        playerBlackjack = false;
        playerBust = false;

        dealerBlackjack = false;
        dealerBust = false;

        winner = 0;
    }

    public int calcValue(ArrayList<Card> hand) {
        int x = 0;
        for (int i = 0; i < hand.size(); i++) {
            x += hand.get(i).getValue();
        }
        return x;
    }

    public boolean hasSoftAce(ArrayList<Card> hand) {
        for (int i = 0; i < hand.size(); i++) {
            if (hand.get(i).getName().equals("ace") && hand.get(i).getValue() == 11) {
                return true;
            }
        }
        return false;
    }

    public void changeAceValue(ArrayList<Card> hand) {
        for (int i = 0; i < hand.size(); i++) {
            if (hand.get(i).getName().equals("ace") && hand.get(i).getValue() == 11) {
                hand.get(i).setValue(1);
            }
        }
    }

    public boolean over21(int value) {
        return value > 21;
    }

    public boolean over16(int value) {
        return value > 16;
    }

    public boolean hasBlackjack(int value) {
        return value == 21;
    }

    private Card draw() {
        count++;
        return deck[count - 1];
    }

    public void hit(ArrayList<Card> hand) {
        hand.add(draw());
    }

    public boolean stand() {
        return true;
    }

    public void deal() {
        playerHand.add(draw());

        dealerFlipped = draw();
        dealerHand.add(dealerFlipped);

        playerHand.add(draw());
        dealerHand.add(draw());
    }

    public void calcWinner() {
        if (dealerBust || !playerBust && calcValue(playerHand) > calcValue(dealerHand)) {
            credits += 2 * wager;
            winner = 1;
        } else if (calcValue(playerHand) == calcValue(dealerHand)) {
            credits += wager;
            winner = 2;
        } else {
            credits -= 0;
            winner = 3;
        }
    }

    public void newGame() {
        playerStand = false;
        playerBlackjack = false;
        playerBust = false;

        dealerBlackjack = false;
        dealerBust = false;

        winner = 0;

        wager = 0;

        deck = new Deck().getDeck();

        playerHand.clear();
        dealerHand.clear();

    }

    public String toString(String player, ArrayList<Card> hand) {
        String str = "";
        str += player + "'s hand" + '\n';
        for (int i = 0; i < hand.size(); i++) {
            str += hand.get(i).toString() + '\n';
        }
        return str;
    }
}
