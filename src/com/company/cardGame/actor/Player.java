package com.company.cardGame.actor;

import com.company.Utils.Console;
import com.company.cardGame.blackJack.Actor;
import com.company.cardGame.blackJack.Hand;

public class Player implements Actor {
    private final String name;
    private int balance = 1000;
    private int actionsCount;

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
                "Enter a bet between 1 and " + balance, 1,
                balance,
                "invalid bet"
        );
    }

    private String getAvailableActions(Hand hand) {
        actionsCount = 2;
        StringBuilder output = new StringBuilder();
        output.append("0. Quit\n1. Hit\n2. Stand");
        if (hand.size() == 2 && balance >= hand.getBet()) {
            output.append("\n3. Double");
            actionsCount++;
            if (hand.canSplit()) {
                output.append("\n4. Split");
                actionsCount++;
            }
        }
        return output.toString();
    }

    @Override
    public byte getAction(Hand hand) {
        //display hand and value
        System.out.println(hand.displayHand());
        System.out.println(hand.getValue());
        return (byte) Console.getInt(getAvailableActions(hand), 0, actionsCount, "invalid action");
    }
}
