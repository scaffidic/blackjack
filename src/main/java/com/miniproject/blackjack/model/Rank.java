package com.miniproject.blackjack.model;

/**
 * Enum that represents all the possible values for a standard {@link Deck} of cards.
 */
public enum Rank {
  DEUCE("2", 2),
  THREE("3", 3),
  FOUR("4", 4),
  FIVE("5", 5),
  SIX("6", 6),
  SEVEN("7", 7),
  EIGHT("8", 8),
  NINE("9", 9),
  TEN("10", 10),
  JACK("J", 10),
  QUEEN("Q", 10),
  KING("K", 10),
  ACE("A", 11);

  private final String symbol;

  private final int value;

  /**
   * Constructor that assigns a symbol-value to an instance of a card.
   *
   * @param symbol the symbol that a single card holds.
   * @param value  the value that is stored within a single card.
   */
  Rank(String symbol, int value) {
    this.symbol = symbol;
    this.value = value;
  }

  public int getValue() {
    return value;
  }

  public String getSymbol() {
    return symbol;
  }

}
