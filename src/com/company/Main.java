package com.company;

import com.company.Utils.Console;
import com.company.cardGame.actor.Dealer;
import com.company.cardGame.actor.Player;
import com.company.cardGame.blackJack.Actor;
import com.company.cardGame.blackJack.Hand;
import com.company.cardGame.blackJack.Table;
import com.company.cardGame.deck.Deck;
import com.company.cardGame.deck.RiggedDeck;
import com.company.cardGame.deck.StandardDeck;
import com.sun.tools.jconsole.JConsoleContext;

public class Main {

    public static void main(String[] args) {
        Table table = new Table();

        table.playGame();
    }
}
