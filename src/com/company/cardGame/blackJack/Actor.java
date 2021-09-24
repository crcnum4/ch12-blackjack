package com.company.cardGame.blackJack;

public interface Actor {
    byte HIT = 1;
    byte STAND = 2;
    byte DOUBLE = 3;
    byte SPLIT = 4;
    byte QUIT = 0;

    String getName();
    int getBalance();
    int getBet();
    byte getAction(Hand hand);
    //byte getAcion(Hand hand, List<Cards> cards) -> card counter version
}
