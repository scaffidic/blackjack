package com.miniproject.blackjack;

public class Dealer extends Person {


  private boolean dealerHandVisible = false;

  public Dealer() {
    setName("Dealer");
  }


  public void printDealerHand() {
//    System.out.println("Dealer has " + super.getHand().getCard(0));
  }

  public void dealerPlay() {
// if value < 17 hit, else stand
  }

  public boolean isDealerHandVisible() {
    return dealerHandVisible;
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
}
