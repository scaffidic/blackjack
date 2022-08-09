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

    dealer.printFirstHand();
    player.printHand();

    if (dealer.isBlackjack()) {
      // invoke push method
      dealer.printHand();
      if (player.isBlackjack()) {
        // player wins
        System.out.println("Player and dealer have blackjack - Push");
        discardHands();
        startRound();
      } else {
        // dealer wins
        System.out.println("Dealer hit blackjack! You lose!");
        dealer.printHand();
        discardHands();
        startRound();
      }
    }
//    System.out.println("Discard deck: " + discardDeck);
//    dealer.printHand();
//    player.printHand();

////    player.hit(deck, discardDeck);
//    dealer.dealerPlay(deck, discardDeck);
//    dealer.printHand();
//
//    player.printHand();

    player.hitOrStand(deck, discardDeck);

    if (player.getHand().getScore() > 21) {
      System.out.println("You have busted.");
      discardHands();
      startRound();
    }

    dealer.printHand();

    if(dealer.getHand().getScore() > 21) {
      System.out.println("Dealer busts.");
    }
    else if (dealer.getHand().getScore() > player.getHand().getScore()) {
      System.out.println("Player loses.");
    }
    else if (player.getHand().getScore() > dealer.getHand().getScore()) {
      System.out.println("Player wins.");
    }
    else {
      System.out.println("It's a tie.");
    }
    discardHands();
    startRound();

  }

    public void discardHands () {
      dealer.getHand().discardHand(discardDeck);
      player.getHand().discardHand(discardDeck);
    }

    public Deck getDeck () {
      return deck;
    }

    public void setDeck (Deck deck){
      this.deck = deck;
    }

    public Deck getDiscardDeck () {
      return discardDeck;
    }

    public void setDiscardDeck (Deck discardDeck){
      this.discardDeck = discardDeck;
    }
  }

