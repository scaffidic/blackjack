package com.miniproject.blackjack;

public class Card {

  //fields
  private final Rank rank;
  private final Suit suit;

  //constructor
  public Card(Rank rank, Suit suit) {
    this.suit = suit;
    this.rank = rank;
  }

  //accessors
  public Rank getRank() {
    return rank;
  }

  public Suit getSuit() {
    return suit;
  }

  @Override
  public String toString() {
    return rank.getSymbol() + " " + suit.getSymbol();
  }

}
