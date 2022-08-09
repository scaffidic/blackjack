package com.miniproject.blackjack;

import java.util.ArrayList;

public class Dealer extends Person {

  Hand hand = new Hand();

  public Dealer () {
    setName("Dealer");
  }

  public void printDealerHand() { // need a getter for card
//    System.out.println("Dealer is showing:" + super.getHand().getCard(0));
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
