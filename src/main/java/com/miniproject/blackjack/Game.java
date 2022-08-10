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

  public boolean startRound() {
    dealer.setDealerHandVisible(false);
    discardHands();
    System.out.println("----------------------------------------");
    System.out.printf("| $100 Bets. Current Bank Value: $%d |\n", getMoney());
    System.out.println("----------------------------------------");

    if (getMoney() <= 0){
      System.out.println("You are out of money. GAME IS OVER!");
      return false;
    }

    deck.draw(player, discardDeck);
    deck.draw(dealer, discardDeck);
    deck.draw(player, discardDeck);
    deck.draw(dealer, discardDeck);

    System.out.println();

    if(player.isBlackjack() && dealer.isBlackjack()){
      // invoke push method

      return true;
    } else if (player.isBlackjack()) {
      // player wins
      System.out.println("Player hit blackjack! You win!");
      printAllHands();
      setMoney(getMoney() + 100);

      return true;
    } else if (dealer.isBlackjack()) {
      // dealer wins
      System.out.println("Dealer hit blackjack!");
      printAllHands();
      setMoney(getMoney() - 100);
      return true;
    }
    dealer.printHand();
//    player.printHand();

    player.hitOrStand(deck, discardDeck);

    int playerScore = player.getHand().totalValue();

    if (playerScore > 21){
      System.out.println("Player busted. You lose!");
      printAllHands();
      setMoney(getMoney() - 100);
      return true;
    }

    dealer.dealerPlay(deck, discardDeck);
    dealer.setDealerHandVisible(true);
    dealer.printHand();
    int dealerScore = dealer.getHand().totalValue();

    if (dealerScore > 21){
      System.out.println("Dealer busted. You win!\n");
      printAllHands();
      setMoney(getMoney() + 100);
      return true;
    } else if (dealerScore > playerScore){
      System.out.println("Dealer wins! You lose!\n");
      printAllHands();
      setMoney(getMoney() - 100);
      return true;
    } else if (dealerScore < playerScore){
      System.out.println("You win!\n");
      printAllHands();
      setMoney(getMoney() + 100);
      return true;
    } else {
      System.out.println("Push!\n");
      printAllHands();
      return true;
    }
  }

  private void printAllHands() {
    dealer.setDealerHandVisible(true);
    System.out.println("\tFinal:");
    dealer.printHand();
    player.printHand();
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

  public int getMoney() {
    return money;
  }

  public void setMoney(int money) {
    this.money = money;
  }

}
