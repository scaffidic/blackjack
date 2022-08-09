package com.miniproject.blackjack;

import java.util.Arrays;

public class Game {

  private int money;
  private final Dealer dealer;
  private final Player player;
  private Deck deck;
  private Deck discardDeck;

  public Game() {
    money = 1000;
    deck = new Deck(true);
    deck.shuffle();
    discardDeck = new Deck();
    dealer = new Dealer();
    player = new Player();
  }

  public void startRound() {

    deck.draw(player, discardDeck);
    deck.draw(dealer, discardDeck);
    deck.draw(player, discardDeck);
    deck.draw(dealer, discardDeck);

    System.out.println();

    // TODO if-else statement
    if(player.isBlackjack() && dealer.isBlackjack()){
      // invoke push method
      discardHands();
    } else if (player.isBlackjack()) {
      // player wins
      System.out.println("PLayer hit blackjack!");
      discardHands();
    } else if (dealer.isBlackjack()) {
      // dealer wins
      System.out.println("Dealer hit blackjack!");
      discardHands();
    }
    System.out.println("Discard deck: " + discardDeck);
    dealer.printHand();
    player.printHand();

    System.out.println("Deck size before hit" + deck.getDeck().size());
    player.hit(deck, discardDeck);

    System.out.println("Hit!!!");
    player.printHand();
    System.out.println("Deck size after hit" + deck.getDeck().size());
  }

  public void discardHands(){
    dealer.getHand().discardHand(discardDeck);
    player.getHand().discardHand(discardDeck);
  }

  public Deck getDeck() {
    return deck;
  }

  public void setDeck(Deck deck) {
    this.deck = deck;
  }

  public Deck getDiscardDeck() {
    return discardDeck;
  }

  public void setDiscardDeck(Deck discardDeck) {
    this.discardDeck = discardDeck;
  }

}
