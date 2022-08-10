package com.miniproject.blackjack.model;

import com.miniproject.blackjack.model.Hand;
import com.miniproject.blackjack.model.Deck;
import com.miniproject.blackjack.view.Colors;

public abstract class Person {

  //Fields
  private String name;
  private Hand hand;

  //Constructor
  public Person() {
    this.hand = new Hand();
    this.name = "";

  }

  // Business methods
  public boolean isBlackjack() {
    return hand.totalValue() == 21;
  }

  public void hit(Deck deck) {
    hand.addToHand(deck.draw());
  }

  // Accessors and mutators
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Hand getHand() {
    return hand;
  }

  // toString()
  @Override
  public String toString() {
    return this.getName() + "'s hand - " + this.hand + Colors.RESET + " - valued at "
        + this.getHand().totalValue();
  }
}
