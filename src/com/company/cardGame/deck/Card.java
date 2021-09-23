package com.company.cardGame.deck;

public class Card {
    private int value;
    private String suit;

    public Card(int value, String suit) {
        this.value = value;
        this.suit = suit;
    }

    public int getValue() {return value;}

    public String display() {
        String output = "";
        switch(value) {
            case 1 -> output = "AC";
            case 11 -> output = "JA";
            case 12 -> output = "QU";
            case 13 -> output = "KI";
//            case 0 -> output = "JR"; //joker
            default -> output = value == 10 ? Integer.toString(value) : " " + value;
        }
        return output + suit;
    }
}
