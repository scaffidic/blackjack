package com.miniproject.blackjack;

public class Player extends Person {


  private int bank;

  private int bet;

  private Hand hand;


  public Player() {
    super.setName("Player");
    hand = new Hand();
  }


}