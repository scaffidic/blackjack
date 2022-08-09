package com.miniproject.blackjack;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Player extends Person {

  Scanner input = new Scanner(System.in);

  private int bet;

  public Player() {
    super.setName("Player");
  }

  public void hitOrStand(Deck deck, Deck discard) {
    int decision = 0;
    boolean inputNum = true;

    while (inputNum) {
      printHand();
      try {
        System.out.println("Press (1) to Hit or (2) to Stand.");
        decision = input.nextInt();
      } catch (InputMismatchException e) {
        System.out.println("Invalid entry");
        input.next();
      }

      if (decision == 1) {
        hit(deck, discard);
        if (this.getHand().getScore() > 20){
          return;
        }
      }
      else {
        System.out.println("You have chosen to Stand.");
        inputNum = false;
      }
    }
  }
}
