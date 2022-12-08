package com.mycompany.blackjackapp;

import javafx.scene.image.Image;

public class Card {

    private String suit;
    private int value;
    private String name;
    private Image image;

    public Card() {
        suit = "";
        value = 0;
        name = "";
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
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

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return getName() + "_of_" + getSuit() + ".png";
    }
}
