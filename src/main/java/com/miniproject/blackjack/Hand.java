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

  public void discardHand(Deck discardDeck){
    ArrayList<Card> currDiscardDeck = discardDeck.getDeck();
    currDiscardDeck.addAll(getHand());
    discardDeck.setDeck(currDiscardDeck);
    setHand(new ArrayList<>());
    setScore(0);
  }

  public int totalValue() {
    int value = 0;
    int numAce = 0;

    for(Card card: hand) {
      value += card.getValue();
      if (card.getValue() == 11) {
        numAce++;
      }
    }
    if (value > 21 && numAce > 0) {
      while(numAce > 0 && value > 21) {
        numAce--;
        value -= 10;
      }
    }
    return value;
  }

// Accessors
  public ArrayList<Card> getHand() {
    return hand;
  }

  public void setHand(ArrayList<Card> hand) {
    this.hand = hand;
  }

  public void setScore(int score) {
    this.score = score;
  }

  @Override
  public String toString() {
    return hand.toString();
  }
}
