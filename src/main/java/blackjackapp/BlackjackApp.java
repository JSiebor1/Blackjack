package blackjackapp;

import java.util.ArrayList;
import java.util.Scanner;

public class BlackjackApp {

    private Card[] deck;
    private int playerValue;
    private int dealerValue;
    private int count;
    private ArrayList<Card> playerHand;
    private ArrayList<Card> dealerHand;
    private int wager;
    private int credits;
    private Scanner scnr;

    public BlackjackApp() {
        deck = new Deck().getDeck();

        playerValue = 0;
        dealerValue = 0;

        count = 0;

        playerHand = new ArrayList<Card>();
        dealerHand = new ArrayList<Card>();

        wager = 0;
        credits = 2500;

        scnr = new Scanner(System.in);

        newGame();
    }

    private int calcValue(ArrayList<Card> hand) {
        int x = 0;
        for (int i = 0; i < hand.size(); i++) {
            x += hand.get(i).getValue();
        }
        return x;
    }

    private boolean hasSoftAce(ArrayList<Card> hand) {
        for (int i = 0; i < hand.size(); i++) {
            if (hand.get(i).getName().equals("ace") && hand.get(i).getValue() == 11) {
                return true;
            }
        }
        return false;
    }

    private void changeAceValue(ArrayList<Card> hand) {
        for (int i = 0; i < hand.size(); i++) {
            if (hand.get(i).getName().equals("ace") && hand.get(i).getValue() == 11) {
                hand.get(i).setValue(1);
            }
        }
    }

    private boolean over21(int value) {
        return value > 21;
    }

    private boolean over16(int value) {
        return value > 16;
    }

    private boolean hasBlackjack(int value) {
        return value == 21;
    }

    private Card draw() {
        count++;
        return deck[count - 1];
    }

    private void hit(ArrayList<Card> hand) {
        hand.add(draw());
    }

    private boolean stand() {
        return true;
    }

    private void printHand(String who, ArrayList<Card> hand) {
        System.out.println(who + "'s hand");
        for (int i = 0; i < hand.size(); i++) {
            System.out.println(hand.get(i).toString());
        }
    }

    private void printHands() {
        printHand("Player", playerHand);
        System.out.println();
        printHand("Dealer", dealerHand);
    }

    private void printCredits() {
        System.out.println("Available credits: " + credits);
    }

    private void inputWager() {
        while (wager < 100 || wager > credits) {
            System.out.print("Input a wager: " + '\n' + "> ");
            wager = scnr.nextInt();
        }
    }

    private void playRound() {
        boolean playerBlackjack = false;
        boolean playerBust = false;
        boolean playerStand = false;

        boolean dealerBlackjack = false;
        boolean dealerBust = false;
        Card dealerFlip;

        String input;

        playerHand.add(draw());
        dealerFlip = draw();
        playerHand.add(draw());
        dealerHand.add(draw());

        printHands();

        playerBlackjack = hasBlackjack(calcValue(playerHand));

        // player's turn
        while (!playerBust && !playerStand && !playerBlackjack) {
            System.out.print("> ");
            input = scnr.next().toLowerCase();

            if (input.equals("hit")) {
                hit(playerHand);
                if (hasSoftAce(playerHand) && over21(calcValue(playerHand))) {
                    changeAceValue(playerHand);
                }
                playerBust = over21(calcValue(playerHand));
            }
            if(input.equals("stand")) {
                playerStand = stand();
            }

            System.out.println();
            printHands();
        }

        // dealer
        dealerHand.add(dealerFlip);
        System.out.println();
        printHands();
        dealerBlackjack = hasBlackjack(calcValue(dealerHand));
        if (dealerBlackjack) {
            System.out.println('\n' + "Dealer has blackjack");
        }

        if (!playerBust && !playerBlackjack || playerStand) {
            System.out.println();
            printHands();
            while (!over16(calcValue(dealerHand)) && !dealerBlackjack) {
                hit(dealerHand);

                if (hasSoftAce(dealerHand) && over21(calcValue(dealerHand))) {
                    changeAceValue(dealerHand);
                }
                dealerBust = over21(calcValue(dealerHand));

                System.out.println();
                printHands();
            }
        }

        if (dealerBust || !playerBust && calcValue(playerHand) > calcValue(dealerHand)) {
            System.out.println('\n' + "Player wins");
            credits += wager;
        } else if (calcValue(playerHand) == calcValue(dealerHand)) {
            System.out.println('\n' + "Push");
            credits += 0;
        } else {
            System.out.println('\n' + "Dealer wins");
            credits -= wager;
        }
    }

    private void newGame() {
        System.out.println("Minimum bet is 100 credits.");
        while (credits > 0) {
            printCredits();
            inputWager();
            System.out.println();
            playRound();

            wager = 0;

            deck = new Deck().getDeck();

            playerHand.clear();
            dealerHand.clear();
        }
        System.out.println("Out of credits.");
    }
}
