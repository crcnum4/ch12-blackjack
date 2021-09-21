package com.company;

import com.company.cardGame.Deck;
import com.company.cardGame.RiggedDeck;
import com.company.cardGame.StandardDeck;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Deck deck = new RiggedDeck();
        deck.shuffle();
        System.out.println(deck.draw().display());
        System.out.println(deck.draw().display());
        System.out.println(deck.draw().display());

    }
}
