package com.miniproject.blackjack;

public class Dealer extends Person {

  Hand hand = new Hand();

  public Dealer () {
    setName("Dealer");
  }

  public void printDealerHand() {
//    System.out.println("Dealer has " + super.getHand().getCard(0));
  }

  public void dealerPlay(Deck deck) {
    while (hand.getScore() <= 16) {
      System.out.println("Dealer has " + hand.getScore() + " and hits.");
      hand.addToHand(deck.draw());
    }
    if (hand.getScore() > 21) {
      System.out.println("Dealer busts. You win!");
    } else {
      System.out.println("Dealer stands.");
    }
  }
}

