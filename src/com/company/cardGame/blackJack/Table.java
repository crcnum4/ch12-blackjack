package com.company.cardGame.blackJack;

import com.company.Utils.Console;
import com.company.cardGame.actor.Dealer;
import com.company.cardGame.actor.Player;
import com.company.cardGame.deck.Deck;
import com.company.cardGame.deck.StandardDeck;

import java.util.ArrayList;
import java.util.List;

public class Table {
    // TODO: remove this item.
//    private Hand player = new Hand(new Player("player"));
    // TODO: try to implement multiple hands.
    private List<Hand> hands = new ArrayList<>(); // 1, 2, 3, 4, 5, 6
    // TODO: more comfortable -> try to accomplish without the players list.
    private Hand dealer = new Hand(new Dealer());
    private Deck deck;
    private int playerCount = 0; //6
    public static final int BUST_VALUE = 21;

    public Table() {
        playerCount = Console.getInt("How many players?", 1, 6, "invalid player selection");
        for (int count = 0; count < playerCount; count++) {
            Player newPlayer = new Player("Player " + (count + 1));
            hands.add(new Hand(newPlayer));
        }
    }

    /* handle split
        remove player when 0 or quit
     */

    public void playGame() {
        while(true) {
            playRound();
        }
    }

    public void playRound() {
        deck = new StandardDeck();
//        deck = new RiggedDeck();
        deck.shuffle();
        getBets();
        deal();
        displayTable();
        playerTurns();
        dealer.revealHand();
        while (turn(dealer));
        displayTable();
        endRound();
    }

    private void getBets() {
        for(Hand player : hands) {
            player.placeBet();
        }
    }

    private void playerTurns() {
        for (int count = 0; count < hands.size(); count++){
            Hand player = hands.get(count);
            player.revealHand();
            while(true) {
                if(!turn(player)) break;
            }
            System.out.println(player.displayHand());
            Console.getString("Enter to start next turn", false);
        }
    }
    private void endRound() {
        for (Hand player : hands) {
            determineWinner(player);
            System.out.println(player.getBalance());
            player.discardHand();
        }
        dealer.discardHand();
        while ( hands.size() > playerCount) {
            hands.remove(hands.size() - 1);
        }
    }

    private void displayTable() {
        StringBuilder output = new StringBuilder();
        output.append(dealer.getName()).append(" ").append(dealer.displayHand()).append("\n");
        for (Hand player : hands) {
            output.append(player.getName()).append(" ").append(player.displayHand()).append(" | ");
        }
        System.out.println(output);
    }

    private void deal() {
        for (int count = 0; count < 2; count++) {
            // list of hands
            dealer.addCard(count == 0 ? deck.draw() : deck.flipDraw());
            for (Hand player : hands) {
//                if (count == 0) {
//                    player.addCard(deck.draw());
//                } else {
//                    Card card = deck.draw();
//                    card.flip();
//                    player.addCard(card);
//                }
                player.addCard(count == 0 ? deck.draw() : deck.flipDraw());
            }
        }
    }

    private void determineWinner(Hand player) {
        if (player.getValue() > BUST_VALUE) {
            System.out.println("Player Busted");
            return;
        }
        if (player.getValue() > dealer.getValue() || dealer.getValue() > BUST_VALUE) {
            System.out.println("Player Wins");
            player.payout(Hand.NORMALPAY);
            return;
        }
        if (player.getValue() == dealer.getValue()) {
            System.out.println("Push");
            player.payout(Hand.PUSHPAY);
            return;
        }
        System.out.println("Dealer Wins");
    }

    private boolean turn(Hand activeHand) {
        System.out.println(dealer.getName() + " " + dealer.displayHand());
        System.out.println(activeHand.getName());
        byte action = activeHand.getAction(dealer.getShownRank());
        return switch (action) {
            case Actor.QUIT -> quit();
            case Actor.HIT -> hit(activeHand);
            case Actor.STAND -> stand(activeHand);
            case Actor.DOUBLE -> doubleDown(activeHand);
            case Actor.SPLIT -> split(activeHand);
            default -> false;
        };
    }

    private boolean quit() {
        System.exit(0);
        return false;
    }

    private boolean hit(Hand activeHand) {
        // TODO: hit
        activeHand.addCard(deck.flipDraw());
        System.out.println("Hit");
        if (activeHand.getValue() > BUST_VALUE){
            System.out.println("Busted");
            return false;
        }
        return true;
    }

    private boolean stand(Hand activeHand) {
        // TODO: stand
        System.out.println("Stand");
        return false;
    }

    private boolean doubleDown(Hand activeHand) {
        // TODO: double
        activeHand.doubleBet();
        System.out.println("Bet Doubled");
        hit(activeHand);
        return false;
    }

    private boolean split(Hand activeHand) {
        /*
        take card
        make a second hand
        match the bet.
        draw 1 card for each hand
         */
        activeHand.doubleBet();
        Hand newHand = activeHand.splitHand();
        activeHand.addCard(deck.flipDraw());
        newHand.addCard(deck.flipDraw());
        hands.add(newHand);

        return true;
    }
}
