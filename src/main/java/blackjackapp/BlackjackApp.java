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
    private Scanner scnr;
    private int wager;
    private int credits;

    public BlackjackApp() {
        deck = new Deck().getDeck();

        playerValue = 0;
        dealerValue = 0;

        count = 0;

        playerHand = new ArrayList<Card>();
        dealerHand = new ArrayList<Card>();

        scnr = new Scanner(System.in);
        wager = 0;
        credits = 2500;

        System.out.println("Minimum bet is 100 credits.");
        newGame();
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

    public Card draw() {
        count++;
        return deck[count - 1];
    }

    public void hit(ArrayList<Card> hand) {
        hand.add(draw());
    }

    public boolean stand() {
        return true;
    }

    public void printHand(String who, ArrayList<Card> hand) {
        System.out.println(who + "'s hand");
        for (int i = 0; i < hand.size(); i++) {
            System.out.println(hand.get(i).toString());
        }
    }

    public void printHands() {
        printHand("Player", playerHand);
        System.out.println();
        printHand("Dealer", dealerHand);
    }

    public void printCredits() {
        System.out.println("Available credits: " + credits);
    }

    public void inputWager() {
        while (wager < 100 && wager > credits) {
            System.out.print("Input a wager: " + '\n' + "> ");
            wager = scnr.nextInt();
        }
    }

    public void play() {
        boolean playerBlackjack = false;
        boolean playerBust = false;
        boolean stand = false;

        boolean dealerBlackjack = false;
        boolean dealerBust = false;
        Card dealerFlip;

        String input;
        Scanner scnr = new Scanner(System.in);

        playerHand.add(draw());
        dealerFlip = draw();
        playerHand.add(draw());
        dealerHand.add(draw());

        printHands();

        playerBlackjack = hasBlackjack(calcValue(playerHand));
        if (playerBlackjack) {
            System.out.println('\n' + "Player has blackjack");
        }

        while (!playerBust && !stand && !playerBlackjack) {
            System.out.print("> ");

            input = scnr.nextLine().toLowerCase();

            if (input.equals("hit")) {
                hit(playerHand);
                if (hasSoftAce(playerHand) && over21(calcValue(playerHand))) {
                    changeAceValue(playerHand);
                }
                playerBust = over21(calcValue(playerHand));
            }

            if (input.equals("stand")) {
                stand = stand();
            }

            System.out.println();
            printHands();

            if (playerBust) {
                System.out.println('\n' + "Player busts");
            }
        }

        dealerHand.add(dealerFlip);
        dealerBlackjack = hasBlackjack(calcValue(dealerHand));
        if (dealerBlackjack) {
            System.out.println('\n' + "Dealer has blackjack");
        }

        if (!playerBust && !playerBlackjack) {
            System.out.println();
            printHands();
            while (!over16(calcValue(dealerHand)) && !dealerBlackjack) {
                hit(dealerHand);

                if (hasSoftAce(dealerHand) && over21(calcValue(dealerHand))) {
                    changeAceValue(dealerHand);
                }
                dealerBust = over21(calcValue(dealerHand));

                if (dealerBust) {
                    System.out.println('\n' + "Dealer busts");
                }

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

    public void newGame() {
        while (credits > 0) {
            printCredits();
            inputWager();
            System.out.println();
            play();

            wager = 0;

            deck = new Deck().getDeck();

            playerHand.clear();
            dealerHand.clear();
        }
        System.out.println("Out of credits.");
    }
}
