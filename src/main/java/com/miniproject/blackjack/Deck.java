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

  // DONE create shuffle method
  public void shuffle() {
    Random rng = new SecureRandom();
    Collections.shuffle(deck, rng);
  }

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
