package com.company.cardGame.deck;

import java.util.*;

public class StandardDeck implements Deck {
    private List<Card> cards = new ArrayList<Card>();;
    final private int[] VALUES = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
    final private String[] SUITS = {"\u2664", "\u2665", "\u2666", "\u2667"};

    public StandardDeck() {
        for (String suit : SUITS) {
            for (int val : VALUES) {
                cards.add(new PlayingCard(val, suit));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card draw() {
        return cards.remove(cards.size() - 1);
    }

    @Override
    public Card flipDraw() {
        Card card = draw();
        card.flip();
        return card;
    }
}
