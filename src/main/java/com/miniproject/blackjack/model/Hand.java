package com.miniproject.blackjack.model;

import com.miniproject.blackjack.model.Card;
import com.miniproject.blackjack.model.Deck;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * An implementation of a hand.
 */
public class Hand {

  /**
   * A list of cards that an instance of {@link Person} has and uses.
   */
  private List<Card> hand;

   private int score;

// Constructor
  /**
   * Constructs an instance of {@link Hand}.
   */
  public Hand(){
    hand = new LinkedList<>();
    score = 0;
  }

// Business methods

  /**
   * Takes an instance of {@link Card} and adds it to the hand.
   * @param card
   * @return returns the hand with an additional card.
   */
  public boolean addToHand(Card card){
    return hand.add(card);
  }

  /**
   * Finds the total value of the hand using the value attribute from {@link Rank}.
   * Calculates whether an instance of Ace will be valued high or low.
   * @return
   */
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

  /**
   * Retrieves an instance of {@link Hand}.
   * @return returns an unmodifiable list of the hand.
   */
  public List<Card> getHand() {
    return Collections.unmodifiableList(hand);
  }

  /**
   * Clears hand.
   */
  public void clear() {
    hand.clear();
  }

// toString()

  /**
   * toString method
   * @return returns the {@link Hand} toString implementation.
   */
  @Override
  public String toString() {
    return hand.toString();
  }
}
