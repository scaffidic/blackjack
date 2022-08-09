package com.miniproject.blackjack;

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
      System.out.printf("%s's hand is [%s, \uD83C\uDCA0]%n", getName(), getHand().getHand().get(0));
    }
  }

  public void dealerPlay(Deck deck, Deck discardDeck) {

    while (super.getHand().getScore() <= 16) {
      System.out.println("Dealer has " + getHand().getScore() + " and hits.");
      deck.draw(this, discardDeck);
    }
  }

}





























