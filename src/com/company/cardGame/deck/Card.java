package com.company.cardGame.deck;

public class Card {
    private int rank;
    private String suit;

    public Card(int rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public int getRank() {return rank;}

    public String display() {
        String output = "";
        switch(rank) {
            case 1 -> output = "AC";
            case 11 -> output = "JA";
            case 12 -> output = "QU";
            case 13 -> output = "KI";
//            case 0 -> output = "JR"; //joker
            default -> output = rank == 10 ? Integer.toString(rank) : " " + rank;
        }
        return output + suit;
    }
}
