package com.miniproject.blackjack;

import java.util.ArrayList;

public class Hand {


  private ArrayList<Card> hand;

   private int score;

// Constructor
  public Hand(){
    hand = new ArrayList<>();
    score = 0;
  }

// Business methods
  public boolean addToHand(Card card){
    boolean cardAdded = hand.add(card);
    score += card.getValue();
    return cardAdded;
  }

  public Card getCard(int i) {
    return hand.get(i);
  }

  public void discardHand(Deck discardDeck){
    ArrayList<Card> currDiscardDeck = discardDeck.getDeck();
    currDiscardDeck.addAll(getHand());
    discardDeck.setDeck(currDiscardDeck);
    setHand(new ArrayList<>());
    setScore(0);
  }

// Accessors
  public ArrayList<Card> getHand() {
    return hand;
  }

  public void setHand(ArrayList<Card> hand) {
    this.hand = hand;
  }

  public int getScore() {
    return score;
  }

  public void setScore(int score) {
    this.score = score;
  }

  @Override
  public String toString() {
    return hand.toString();
  }
}
