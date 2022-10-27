package BlackjackApp;

public class Card {
    private String suite;
    private int value;
    private String name;

    public Card() {
        suite = "";
        value = 0;
        name = "";
    }

    public String getSuite() {
        return suite;
    }

    public void setSuite(String suite) {
        this.suite = suite;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return getName() + " of " + getSuite();
    }
}
