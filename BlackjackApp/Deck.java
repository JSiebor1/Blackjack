package BlackjackApp;

import java.util.concurrent.ThreadLocalRandom;

public class Deck {
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

    public void genDeck(Card[] deck) {
        // creates an array of cards
        for (int i = 0; i < deck.length; i++) {
            deck[i] = new Card();
        }

        // initializes values 1-13
        for (int i = 0, n = 1; i < deck.length; i++, n++) {
            if (n > deck.length / 4)
                n = 1;
            deck[i].setValue(n);
        }

        // assigns suits
        String suit = "Hearts";
        for (int i = 0; i < deck.length; i++) {
            if (i / (deck.length / 4) == 1)
                suit = "Clubs";
            else if (i / (deck.length / 4) == 2)
                suit = "Spades";
            else if (i / (deck.length / 4) == 3)
                suit = "Diamonds";
            deck[i].setSuit(suit);
        }

        /*
         * 1=ace
         * jack=10 (11)
         * queen=10 (12)
         * king=10 (13)
         */

        // assigns names
        for (int i = 0; i < deck.length; i++) {
            switch (deck[i].getValue()) {
                case 1:
                    deck[i].setName("Ace");
                    break;
                case 2:
                    deck[i].setName("Two");
                    break;
                case 3:
                    deck[i].setName("Three");
                    break;
                case 4:
                    deck[i].setName("Four");
                    break;
                case 5:
                    deck[i].setName("Five");
                    break;
                case 6:
                    deck[i].setName("Six");
                    break;
                case 7:
                    deck[i].setName("Seven");
                    break;
                case 8:
                    deck[i].setName("Eight");
                    break;
                case 9:
                    deck[i].setName("Nine");
                    break;
                case 10:
                    deck[i].setName("Ten");
                    break;
                case 11:
                    deck[i].setName("Jack");
                    break;
                case 12:
                    deck[i].setName("Queen");
                    break;
                case 13:
                    deck[i].setName("King");
                    break;
            }
        }

        // set courts to 10
        for (int i = 0; i < deck.length; i++) {
            if (deck[i].getValue() > 10)
                deck[i].setValue(10);
        }

        setDeck(shuffle(deck));
    }

    public Card[] shuffle(Card[] deck) {
        Card temp = new Card();
        for (int i = 0; i < deck.length * 10; i++) {
            int x = genRand(0, deck.length - 1);
            int y = genRand(0, deck.length - 1);

            temp = deck[x];
            deck[x] = deck[y];
            deck[y] = temp;
        }

        return deck;
    }

}
