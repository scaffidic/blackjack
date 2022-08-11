package com.miniproject.blackjack.model;

import com.miniproject.blackjack.view.Colors;

/**
 * An implementation of a dealer object which extends {@link Person}.
 */
public class Dealer extends Person {

  /**
   * Sets dealer's hand so that the first card in their {@link Hand} is face down.
   */
  private boolean dealerHandVisible = false;

  // Constructor

  /**
   * Constructs an instance of {@link Dealer}.
   */
  public Dealer() {
    setName("Dealer");
  }

  /**
   * Sets dealer's hand so that both cards are visible.
   * @param dealerHandVisible
   */
  public void setDealerHandVisible(boolean dealerHandVisible) {
    this.dealerHandVisible = dealerHandVisible;
  }

// Business methods

  /**
   * Dealer's logic whether to hit or stand.
   * @param deck
   */
  public void dealerPlay(Deck deck) {
    while (super.getHand().totalValue() <= 16) {
      System.out.printf(
         Colors.PURPLE + "%s's hand - " + this.getHand().getHand() + Colors.RESET + " - has %d points. Dealer hits.\n" ,
          this.getName(), getHand().totalValue());
      getHand().addToHand(deck.draw());
    }
  }

  // toString()
  /**
   * toString method
   * @return returns the {@link Dealer}, toString implementation.
   */
  @Override
  public String toString() {
    return dealerHandVisible
        ? getHand().toString()
        : String.format(Colors.PURPLE + "%s's hand - [%s, \uD83C\uDCA0]" + Colors.RESET,
            getName(), getHand().getHand().get(0));
  }

}





























