package com.miniproject.blackjack;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Deck {


  private ArrayList<Card> deck;

  public Deck(){
    deck = new ArrayList<Card>();
  }


  // TODO finish Deck constructor
  public Deck(boolean mainDeck) {
    // loop through Rank enum values
    // nested loop through Suit enum values
    // create new Card(Rank, Suit)
    // add created Card to Array list

     Suit[] suits = {}; // Suit.values()
     Rank[] ranks = {} ; // Rank.values()

    for (Suit suit: suits) {
      for (Rank rank: ranks){
//        Card card = new Card(rank, suit);
//          deck.add(card);
      }
    }
  }

// Business methods

  // DONE create shuffle method
  public void shuffle() {
    Random rng = new SecureRandom();
    Collections.shuffle(deck, rng);
  }

  // TODO finish draw() method
  public Card draw() {
    Card nextCard;
    if (!deck.isEmpty()) {
      nextCard = deck.remove(0);
      deck.iterator();
      return nextCard;
    } else {
      // figure out what to do if deck is empty
      return null;
    }
  }

  // Accessor methods
  public ArrayList<Card> getDeck() {
    return deck;
  }
}
