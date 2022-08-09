package com.miniproject.blackjack;

public class Dealer extends Person {

  private boolean dealerHandVisible = false;

  public Dealer () {
    setName("Dealer");
  }

  public void printFirstHand() {
    System.out.println("The dealer's hand: ");
    System.out.println(super.getHand().getCard(0));
    System.out.println("The second card is hidden.");
  }

  public void dealerPlay(Deck deck, Deck discardDeck) {

    while (super.getHand().getScore() <= 16) {
      System.out.println("Dealer has " + getHand().getScore() + " and hits.");
      deck.draw(this, discardDeck);
    }
    if (getHand().getScore() > 21) {
      System.out.println("Dealer busts. You win!");
    } else {
      System.out.println("Dealer stands.");
    }
  }

}





























