package com.miniproject.blackjack;

import java.util.ArrayList;

public abstract class Person {

  //Fields
  private String name;
  private Hand hand;


  //Constructors
  public Person () {
    this.hand = new Hand();
    this.name = "";
  }

  //Check if Player or Dealer has Blackjack
  public boolean isBlackjack(){
    return hand.getScore() == 21;
  }

  //add hit and stand
//  abstract public void hit();
//  abstract public void stand();

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
