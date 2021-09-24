package com.company;

import com.company.Utils.Console;
import com.company.cardGame.actor.Dealer;
import com.company.cardGame.actor.Player;
import com.company.cardGame.blackJack.Actor;
import com.company.cardGame.blackJack.Hand;
import com.company.cardGame.deck.Deck;
import com.company.cardGame.deck.RiggedDeck;
import com.company.cardGame.deck.StandardDeck;
import com.sun.tools.jconsole.JConsoleContext;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Deck deck = new StandardDeck();
        deck.shuffle();
        Actor dealer = new Player(Console.getString("Player name?", true));
        Hand myHand = new Hand(dealer);
        myHand.addCard(deck.draw());
        myHand.addCard(deck.draw());
        while (myHand.getAction() == Actor.HIT) {
            myHand.addCard(deck.draw());
            System.out.println("HIT");
        }
        System.out.println("Done");
    }
}
