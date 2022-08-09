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
      try {
        System.out.println("Press (1) to Hit or (2) to Stand.");
        decision = input.nextInt();
        inputNum = false;

      } catch (InputMismatchException e) {
        input.next();
      }
      if (decision == 1) {
        hit(deck, discard);
        if (getHand().getScore() < 21) {
          System.out.println("You have hit: new value - " + getHand().getScore());
          this.hitOrStand(deck, discard);
        }

        break;
      }
      else if (decision == 2){
        System.out.println("You have chosen to Stand.");
      }
      else {
        System.out.println("Invalid entry");
        throw new InputMismatchException();

      }
    }
  }
}
