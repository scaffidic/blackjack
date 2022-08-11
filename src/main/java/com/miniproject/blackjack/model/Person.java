package com.miniproject.blackjack.model;

import com.miniproject.blackjack.model.Hand;
import com.miniproject.blackjack.model.Deck;
import com.miniproject.blackjack.view.Colors;

/**
 * An implementation of a person.
 */
public abstract class Person {

  //Fields
  /**
   * Represents the persons name.
   */
  private String name;
  /**
   * Represents the {@link Hand} for each instance of a person.
   */
  private Hand hand;

  //Constructor

  /**
   * Constructs an instance of a {@link Person}.
   */
  public Person() {
    this.hand = new Hand();
    this.name = "";

  }

  // Business methods

  /**
   * Checks if any instance of {@link Person} has a total value of 21 in their hand.
   *
   * @return returns true if {@link Hand} is equal to 21.
   */
  public boolean isBlackjack() {
    return hand.totalValue() == 21;
  }

  /**
   * Draws a card from the {@link Deck} and adds it to the player's or dealer's {@link Hand}.
   *
   * @param deck
   */
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

  /**
   * toString method.
   *
   * @return Returns the {@link Person}, toString implementation.
   */
  @Override
  public String toString() {
    return this.getName() + "'s hand - " + this.hand + Colors.RESET + " - valued at "
        + this.getHand().totalValue();
  }
}
