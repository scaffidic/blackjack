package com.miniproject.blackjack;

public abstract class Person {

  //Fields
  private String name;
  private Hand hand;

  //Constructor
  public Person () {
    this.hand = new Hand();
    this.name = "";

  }

  //Check if Player or Dealer has Blackjack
  public boolean isBlackjack() {
    return hand.totalValue() == 21;
  }

  public void hit(Deck deck, Deck discardDeck) {
    deck.draw(this, discardDeck);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Hand getHand() {
    return hand;
  }

  public void setHand(Hand hand) {
    this.hand = hand;
  }

  public void printHand(){
    System.out.println(this.getName() + "'s hand is " + this.hand + " valued at " + this.getHand().totalValue());
  }
}
