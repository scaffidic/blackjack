package com.miniproject.blackjack.model;

/**
 * An implementation of a card type.
 */
public class Card {

  //fields
  /**
   * The rank of a specific card.
   */
  private final Rank rank;

  /**
   * The suit of the card: Clubs, Diamonds, Hearts, Spades.
   */
  private final Suit suit;

  /**
   * The value of a specific card.
   */
  private final int value;

  //constructor

  /**
   * Constructs an instance of {@link Card} using its rank and suit.
   * @param rank
   * @param suit
   */
  public Card(Rank rank, Suit suit) {
    this.suit = suit;
    this.rank = rank;
    value = rank.getValue();
  }

  //Accessors
  public int getValue() {
    return value;
  }

  /**
   * toString method.
   * @return returns the {@link Card}, toString implementation.
   */
  @Override
  public String toString() {
    return rank.getSymbol() + suit.getSymbol();
  }

}
