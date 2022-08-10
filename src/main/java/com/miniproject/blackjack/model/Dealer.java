package com.miniproject.blackjack.model;

import com.miniproject.blackjack.view.Colors;

public class Dealer extends Person {

  private boolean dealerHandVisible = false;

  // Constructor
  public Dealer() {
    setName("Dealer");
  }

  public void setDealerHandVisible(boolean dealerHandVisible) {
    this.dealerHandVisible = dealerHandVisible;
  }

// Business methods
  public void dealerPlay(Deck deck) {
    while (super.getHand().totalValue() <= 16) {
      System.out.printf(
          "%s's hand - " + this.getHand().getHand() + " - has %d points. Dealer hits.\n",
          this.getName(), getHand().totalValue());
      getHand().addToHand(deck.draw());
    }
  }

  // toString()
  @Override
  public String toString() {
    return dealerHandVisible
        ? getHand().toString()
        : String.format(Colors.PURPLE + "%s's hand - [%s, \uD83C\uDCA0]" + Colors.RESET,
            getName(), getHand().getHand().get(0));
  }

}





























