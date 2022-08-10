package com.miniproject.blackjack.controller;

import com.miniproject.blackjack.model.Deck;

public class Dealer extends Person {

  private boolean dealerHandVisible = false;

  public Dealer() {
    setName("Dealer");
  }

  public void setDealerHandVisible(boolean dealerHandVisible) {
    this.dealerHandVisible = dealerHandVisible;
  }

  @Override
  public void printHand() {
    if (dealerHandVisible) {
      super.printHand();
    } else {
      System.out.printf("%s's hand - [%s, \uD83C\uDCA0]%n",
          getName(), getHand().getHand().get(0));
    }
  }

  public void dealerPlay(Deck deck, Deck discardDeck) {
    while (super.getHand().totalValue() <= 16) {
      System.out.printf("%s's hand - " + this.getHand().getHand() + " - has %d points. Dealer hits.\n",
          this.getName(), getHand().totalValue());
      deck.draw(this, discardDeck);
    }
  }

}





























