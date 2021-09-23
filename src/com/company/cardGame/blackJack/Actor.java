package com.company.cardGame.blackJack;

public interface Actor {
    String getName();
    int getBalance();
    int getBet(int wallet);
    byte getAction(Hand hand);
    //byte getAcion(Hand hand, List<Cards> cards) -> card counter version
}
