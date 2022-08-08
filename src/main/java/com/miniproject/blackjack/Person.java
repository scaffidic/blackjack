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


  //add hit and stand

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
