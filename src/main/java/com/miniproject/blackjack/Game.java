package com.miniproject.blackjack;

public class Game {

  private int money;

  // TODO create dealer
    private Dealer dealer;

  // TODO create player
   private Player player;

//  TODO create a deck
  private Deck deck;

  private Deck discardDeck;


  public Game(){
    money = 1000;

     deck = new Deck(true);

     discardDeck = new Deck();

     dealer = new Dealer();
     player = new Player();

  }



}
