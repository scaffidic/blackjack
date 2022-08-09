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

  public void printHand(){
//    System.out.println(this.getName() + "'s hand is" + this.getHand + " valued at " + this.getHand.getValue);
  }

  //Check if Player or Dealer imhas Blackjack
  public boolean isBlackjack() {
    return hand.getScore() == 21;
  }

  public void hit(Deck deck, Deck discard) {
    if (!deck.getDeck().isEmpty()) {
      hand.addToHand(deck.draw());
      //implement draw from deck or discard deck
    }
  }


  //add hit and stand

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
    System.out.println(this.getName() + "'s hand is " + this.hand + " valued at " + this.getHand().getScore());
  }
}
