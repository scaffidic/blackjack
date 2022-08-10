package com.miniproject.blackjack.model;

import com.miniproject.blackjack.model.Card;
import com.miniproject.blackjack.model.Deck;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Hand {

  private List<Card> hand;

   private int score;

// Constructor
  public Hand(){
    hand = new LinkedList<>();
    score = 0;
  }

// Business methods
  public boolean addToHand(Card card){
    return hand.add(card);
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
      while(numAce > 0 && value > 21) {
        numAce--;
        value -= 10;
      }
    return value;
  }

// Accessors
  public List<Card> getHand() {
    return Collections.unmodifiableList(hand);
  }

  public void clear() {
    hand.clear();
  }

// toString()
  @Override
  public String toString() {
    return hand.toString();
  }
}
