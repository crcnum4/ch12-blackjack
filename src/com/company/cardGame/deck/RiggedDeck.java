package com.company.cardGame.deck;

import com.company.Utils.Console;

public class RiggedDeck implements Deck {
    final private String[] SUITS = {"\u2664", "\u2665", "\u2666", "\u2667"};

    @Override
    public void shuffle() {
        return;
    }

    @Override
    public Card draw() {
        int value = Console.getInt("enter number 1-13", 1, 13, "invalid entry");
        int suit = Console.getInt("1. \u2664 | 2. \u2665 | 3. \u2666 | 4. \u2667", 1, 4, "Invalid entry");
        return new Card(value, SUITS[suit - 1]);
    }
}
