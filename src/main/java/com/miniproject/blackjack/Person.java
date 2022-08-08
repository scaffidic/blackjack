package com.miniproject.blackjack;

public abstract class Person {

  //Fields
  private String name;
//  private Hand hand;

  //Constructor
  public Person () {
//    this.hand = new Hand();
    this.name = "";

  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
