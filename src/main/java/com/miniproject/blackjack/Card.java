package com.miniproject.blackjack;

public class Card {

  //fields
  private final Rank rank;
  private final Suit suit;
  private final int value;

  //constructor
  public Card(Rank rank, Suit suit) {
    this.suit = suit;
    this.rank = rank;
    value = rank.getValue();
  }

  //accessors
  public Rank getRank() {
    return rank;
  }

  public Suit getSuit() {
    return suit;
  }

  public int getValue() {
    return value;
  }

  @Override
  public String toString() {
    return rank.getSymbol() + suit.getSymbol();
  }

}
