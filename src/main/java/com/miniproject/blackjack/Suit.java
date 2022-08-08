package com.miniproject.blackjack;

public enum Suit {
  CLUBS('\u2663'),
  DIAMONDS('\u2662'),
  HEARTS('\u2661'),
  SPADES('\u2660');

  private final char symbol;

  Suit(char symbol) {
    this.symbol = symbol;
  }

}
