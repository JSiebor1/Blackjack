package com.mycompany.blackjackapp;

import java.util.concurrent.ThreadLocalRandom;

public final class Deck {

    private final int deckSize = 52;
    private Card[] deck;

    public Deck() {
        deck = new Card[deckSize];
        genDeck(deck);
    }

    public Card[] getDeck() {
        return deck;
    }

    public void setDeck(Card[] deck) {
        this.deck = deck;
    }

    public int genRand(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public Card[] genSuit(Card[] deck) {
        String suit = "Hearts";
        for (int i = 0; i < deck.length; i++) {
            switch (i / (deck.length / 4)) {
                case 1:
                    suit = "Clubs";
                    break;
                case 2:
                    suit = "Spades";
                    break;
                case 3:
                    suit = "Diamonds";
                    break;
                default:
                    break;
            }
            deck[i].setSuit(suit);
        }
        return deck;
    }

    // initializes values 1-13
    public Card[] genValue(Card[] deck, boolean ten) {
        if (!ten) {
            for (int i = 0, n = 1; i < deck.length; i++, n++) {
                if (n > deck.length / 4) {
                    n = 1;
                }
                deck[i].setValue(n);
            }
        } else {
            for (Card deck1 : deck) {
                if (deck1.getValue() > 10) {
                    deck1.setValue(10);
                }
            }
        }

        return deck;
    }

    // sets value of Aces to 11
    public Card[] genValue(Card[] deck) {
        for (Card deck1 : deck) {
            if (deck1.getValue() == 1) {
                deck1.setValue(11);
            }
        }

        return deck;
    }

    /*
     * 1=ace
     * jack=10 (11)
     * queen=10 (12)
     * king=10 (13)
     */
    public Card[] genName(Card[] deck) {
        for (Card deck1 : deck) {
            switch (deck1.getValue()) {
                case 1:
                    deck1.setName("Ace");
                    break;
                case 2:
                    deck1.setName("Two");
                    break;
                case 3:
                    deck1.setName("Three");
                    break;
                case 4:
                    deck1.setName("Four");
                    break;
                case 5:
                    deck1.setName("Five");
                    break;
                case 6:
                    deck1.setName("Six");
                    break;
                case 7:
                    deck1.setName("Seven");
                    break;
                case 8:
                    deck1.setName("Eight");
                    break;
                case 9:
                    deck1.setName("Nine");
                    break;
                case 10:
                    deck1.setName("Ten");
                    break;
                case 11:
                    deck1.setName("Jack");
                    break;
                case 12:
                    deck1.setName("Queen");
                    break;
                case 13:
                    deck1.setName("King");
                    break;
            }
        }
        return deck;
    }

    public Card[] shuffle(Card[] deck) {
        Card temp;
        for (int i = 0; i < deck.length * 10; i++) {
            int x = genRand(0, deck.length - 1);
            int y = genRand(0, deck.length - 1);

            temp = deck[x];
            deck[x] = deck[y];
            deck[y] = temp;
        }

        return deck;
    }

    public void genDeck(Card[] deck) {
        for (int i = 0; i < deck.length; i++) {
            deck[i] = new Card();
        }

        setDeck(shuffle(genValue(genValue(genSuit(genName(genValue(deck, false))), true))));
    }

}
