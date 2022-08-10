package com.miniproject.blackjack;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * An implementation of a deck of cards.
 */
public class Deck {

  /**
   * The ArrayList of cards in the deck, where the top card is at index[0].
   */
  private ArrayList<Card> deck;

  /**
   * Default constructor for creating instance of Deck.
   */
  public Deck(){
    deck = new ArrayList<Card>();
  }

  /**
   * Constructor that takes a boolean parameter.
   * @param mainDeck
   */
  // TODO finish Deck constructor
  public Deck(boolean mainDeck) {

    deck = new ArrayList<>();

     Suit[] suits = Suit.values();
     Rank[] ranks = Rank.values();

    for (Suit suit: suits) {
      for (Rank rank: ranks){
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
    Random rng = new SecureRandom();
    Collections.shuffle(deck, rng);
  }

  /**
   * Removes first card from the top of the deck and adds the player or dealer's hand.
   * If the deck is empty, then remove first card from the top of the discard deck and adds the player or dealer's hand.
   * @param dealerOrPlayer
   * @param discardDeck
   */
  // TODO finish draw() method
  public void draw(Person dealerOrPlayer, Deck discardDeck) {
    Card nextCard;
    if (!deck.isEmpty()) {
      nextCard = deck.remove(0);
      dealerOrPlayer.getHand().addToHand(nextCard);
//      deck.iterator();
    } else {
      // take all cards from discard deck, add to shoe deck, then shuffle shoe;
      deck.addAll(discardDeck.getDeck());
      discardDeck.setDeck(new ArrayList<>());
      shuffle();
      draw(dealerOrPlayer, discardDeck);
    }
  }

  // Accessor methods
  public ArrayList<Card> getDeck() {
    return deck;
  }

  public void setDeck(ArrayList<Card> deck) {
    this.deck = deck;
  }

  // toString()
  @Override
  public String toString() {
    return deck.toString();
  }
}
