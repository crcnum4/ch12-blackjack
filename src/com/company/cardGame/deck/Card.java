package com.company.cardGame.deck;

public abstract class Card {
    protected int rank;
    protected String suit;
    protected boolean isFaceDown = true;

    public Card(int rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public int getRank() {return rank;}
    public String getSuit() {return suit;}
    public boolean getIsFaceDown() {return isFaceDown;}
    public abstract String display();

    public void flip() {
        isFaceDown = !isFaceDown;
    }
}
