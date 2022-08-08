package com.miniproject.blackjack;

import java.util.ArrayList;

public class Hand {
  private ArrayList<Card> hand;
  private int score;

// Constructor
  public Hand(){
    hand = new ArrayList<>();
    score = 0;
  }

// Business methods
  public boolean addToHand(Card card){
    boolean cardAdded = hand.add(card);
    return cardAdded;
  }

// Accessors
  public ArrayList<Card> getHand() {
    return hand;
  }

  public int getScore() {
    return score;
  }
}
