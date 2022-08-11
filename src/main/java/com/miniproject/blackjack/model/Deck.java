package com.miniproject.blackjack.model;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * An implementation of a deck of cards.
 */
public class Deck {

  /**
   * The ArrayList of cards in the deck, where the top card is at index[0].
   */
  private final List<Card> deck;
  private final Random rng;
  private Iterator<Card> cardIterator;

  // Constructor
  /**
   * Constructs an instance of a {@link Deck}.
   */
  public Deck() {

    deck = new ArrayList<>();
    rng = new SecureRandom();

    Suit[] suits = Suit.values();
    Rank[] ranks = Rank.values();

    for (Suit suit : suits) {
      for (Rank rank : ranks) {
        Card card = new Card(rank, suit);
        deck.add(card);
      }
    }
  }

// Business methods

  /**
   * Shuffles deck by randomly swapping pairs of cards.
   */
  public void shuffle() {
    Collections.shuffle(deck, rng);
    cardIterator = deck.iterator();
  }

  /**
   * Iterates over the deck of cards.
   * If there are no cards, the shuffle method is implemented.
   */
  public Card draw() {
    Card nextCard;
    if (cardIterator == null || !cardIterator.hasNext()) {
      shuffle();
    }
    return cardIterator.next();
  }

  // toString()

  /**
   * toString method.
   * @return Returns the decks, toString implementation.
   */
  @Override
  public String toString() {
    return deck.toString();
  }
}
