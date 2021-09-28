package com.company.cardGame.blackJack;

import com.company.cardGame.actor.Dealer;
import com.company.cardGame.actor.Player;
import com.company.cardGame.deck.Deck;
import com.company.cardGame.deck.StandardDeck;

public class Table {
    Hand player = new Hand(new Player("player"));
    Hand dealer = new Hand(new Dealer());
    Deck deck;

    public void playRound() {
        deck = new StandardDeck();
        deck.shuffle();
        /*
        0. take bets
        1. deal cards
        b2. see who won
        a2. players turn
        a3. dealers turn
        a4. see who one
         */
        deal();
        displayTable();
        turn(player);
        turn(dealer);
        determineWinner();
    }

    private void displayTable() {
        StringBuilder output = new StringBuilder();
        output.append("Dealer: ").append(dealer.displayHand()).append("\n");
        output.append("Player: ").append(player.displayHand());
        System.out.println(output);
    }

    private void deal() {
        for (int count = 0; count < 2; count++) {
            // list of hands
            dealer.addCard(deck.draw());
            player.addCard(deck.draw());
        }
    }

    private void determineWinner() {
        if (player.getValue() > dealer.getValue()) {
            System.out.println("Player Wins");
            return;
        }
        if (player.getValue() == dealer.getValue()) {
            System.out.println("Push");
            return;
        }
        System.out.println("Dealer Wins");
    }

    private void turn(Hand activeHand) {
        System.out.println("Dealer: " + dealer.displayHand());
        byte action = activeHand.getAction();
        switch (action) {
            case 0 -> System.out.println("Quiting");
            case 1 -> System.out.println("Hit me");
            case 2 -> System.out.println("Waves Hand");
            case 3 -> System.out.println("Double Down");
            case 4 -> System.out.println("two hands");
            default -> System.out.println("ERROR bad action " + action);
        }
    }

    private void hit(Hand activeHand) {
        // TODO: hit
    }

    private void stand(Hand activeHand) {
        // TODO: stand
    }

    private void doubleDown(Hand activeHand) {
        // TODO: double
    }

    private void split(Hand activeHand) {
        doubleDown(activeHand);
    }
}
