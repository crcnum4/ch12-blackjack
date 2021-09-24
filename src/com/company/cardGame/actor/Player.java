package com.company.cardGame.actor;

import com.company.Utils.Console;
import com.company.cardGame.blackJack.Actor;
import com.company.cardGame.blackJack.Hand;

public class Player implements Actor {
    private final String name;
    private int balance = 1000;

    public Player(String name) {
        this.name = name;
    }

    public Player(String name, int startingBalance) {
        this.name = name;
        balance = startingBalance;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getBalance() {
        return balance;
    }

    @Override
    public int getBet() {
        return Console.getInt(
                1,
                balance,
                "Enter a bet between 1 and " + balance,
                "invalid bet"
        );
    }

    private String getAvailableActions() {
        StringBuilder output = new StringBuilder();
        output.append("0. Quit\n1. Hit\n2. Stand");
        // TODO: add logic for double
        // TODO: 1. confirm first turn
        // TODO: 2. Confirm has enough funds.
        // TODO: add logic for split
        // TODO: 3. add logic for split detect pair.
        return output.toString();
    }

    @Override
    public byte getAction(Hand hand) {
        //display hand and value
        System.out.println(hand.displayHand());
        System.out.println(hand.getValue());
        return (byte) Console.getInt(0, 2, getAvailableActions(), "invalid action");
    }
}
