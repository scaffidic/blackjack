package com.miniproject.blackjack.controller;

import com.miniproject.blackjack.model.Deck;
import com.miniproject.blackjack.view.Colors;
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
        System.out.println(Colors.YELLOW + "\nPress (1) to Hit or (2) to Stand.\n" + Colors.RESET);
        decision = input.nextInt();

        if (decision > 2 || decision < 1) {
          throw new InputMismatchException();
        }

      } catch (InputMismatchException e) {
        System.out.println(Colors.RED + "Invalid entry\n" + Colors.RESET);
        input.nextLine();
        continue;
      }

      if (decision == 1) {
        hit(deck, discard);
        if (this.getHand().totalValue() > 20) {
          return;
        }
      } else {
        System.out.println(Colors.YELLOW + "You stand.\n" + Colors.RESET);
        inputNum = false;
      }
    }
  }
}
