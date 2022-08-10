package com.miniproject.blackjack;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Player extends Person {

  Scanner input = new Scanner(System.in);

  public Player() {
    super.setName("Player");
  }

  public void hitOrStand(Deck deck, Deck discard) {
    int decision = 0;
    boolean inputNum = true;

    while (inputNum) {
      printHand();
      try {
        System.out.println("\n\tPress (1) to Hit or (2) to Stand.");
        decision = input.nextInt();

        if (decision > 2 || decision < 1){
          throw new InputMismatchException();
        }

      } catch (InputMismatchException e) {
        System.out.println("Invalid entry");
        input.nextLine();
        continue;
      }

      if (decision == 1) {
        hit(deck, discard);
        if (this.getHand().totalValue() > 20){
          return;
        }
      }
      else {
        System.out.println("You stand.");
        inputNum = false;
      }
    }
  }
}
