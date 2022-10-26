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
        for (int i = 0; i < deckSize; i++) {
            deck[i] = new Card();
        }

        // initializes values 1-13
        for (int i = 0, n = 1; i < deckSize; i++, n++) {
            if (n > deckSize / 4)
                n = 1;
            deck[i].setValue(n);
        }

        // assigns suits
        String suite = "Hearts";
        for (int i = 0; i < deckSize; i++) {
            if (i / (deckSize / 4) == 1)
                suite = "Clubs";
            else if (i / (deckSize / 4) == 2)
                suite = "Spades";
            else if (i / (deckSize / 4) == 3)
                suite = "Diamonds";
            deck[i].setSuite(suite);
        }

        /*
         * 1=ace
         * jack=10 (11)
         * queen=10 (12)
         * king=10 (13)
         */

        // assigns names based on values
        for (int i = 0; i < deckSize; i++) {
            if (deck[i].getValue() == 1)
                deck[i].setName("Ace");
            else if (deck[i].getValue() == 2)
                deck[i].setName("Two");
            else if (deck[i].getValue() == 3)
                deck[i].setName("Three");
            else if (deck[i].getValue() == 4)
                deck[i].setName("Four");
            else if (deck[i].getValue() == 5)
                deck[i].setName("Five");
            else if (deck[i].getValue() == 6)
                deck[i].setName("Six");
            else if (deck[i].getValue() == 7)
                deck[i].setName("Seven");
            else if (deck[i].getValue() == 8)
                deck[i].setName("Eight");
            else if (deck[i].getValue() == 9)
                deck[i].setName("Nine");
            else if (deck[i].getValue() == 10)
                deck[i].setName("Ten");
            else if (deck[i].getValue() == 11)
                deck[i].setName("Jack");
            else if (deck[i].getValue() == 12)
                deck[i].setName("Queen");
            else if (deck[i].getValue() == 13)
                deck[i].setName("King");
        }

        // set courts to 10
        for(int i = 0; i < deckSize; i++) {
            if(deck[i].getValue() > 10)
                deck[i].setValue(10);
        }

        setDeck(shuffle(deck));

        for (int i = 0; i < deckSize; i++)
            System.out.println(deck[i].toString());
    }

    public Card[] shuffle(Card[] deck) {
        Card temp = new Card();
        for (int i = 0; i < deckSize * 10; i++) {
            int x = genRand(0, deckSize - 1);
            int y = genRand(0, deckSize - 1);

            temp = deck[x];
            deck[x] = deck[y];
            deck[y] = temp;

        }

        return deck;
    }
}
