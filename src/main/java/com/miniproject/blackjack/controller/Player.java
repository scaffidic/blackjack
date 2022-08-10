package com.miniproject.blackjack.controller;

import com.miniproject.blackjack.model.Deck;
import com.miniproject.blackjack.model.Person;
import com.miniproject.blackjack.view.Colors;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Player extends Person {

  private double bet;

  private double money;

  Scanner input = new Scanner(System.in);

  // Constructor
  public Player() {
    super.setName("Player");
    money = 1000;
  }

  // Business methods
  public void hitOrStand(Deck deck) {
    int decision = 0;
    boolean inputNum = true;

    while (inputNum) {

      int upperLimit = 2;
      try {
        System.out.println(Colors.YELLOW + "\nPress:\n(1) to Hit \n(2) to Stand" + Colors.RESET);
        if (getMoney() >= getBet() * 2){
        System.out.println(Colors.YELLOW + "(3) to Double down" + Colors.RESET);
        upperLimit = 3;
        }

        decision = input.nextInt();

        if (decision > upperLimit || decision < 1) {
          throw new InputMismatchException();
        }

      } catch (InputMismatchException e) {
        System.out.println(Colors.RED + "Invalid entry\n" + Colors.RESET);
        input.nextLine();
        continue;
      }

      if (decision == 1) {
        hit(deck);
        if (this.getHand().totalValue() > 20) {
          return;
        }
        System.out.println(this.toString());
      } else if (decision == 3) {
        System.out.println(Colors.YELLOW + "You doubled down.\n" + Colors.RESET);

        setBet(getBet() * 2);
        hit(deck);
        return;
      } else {
        System.out.println(Colors.YELLOW + "You stand.\n" + Colors.RESET);
        inputNum = false;
      }
    }
  }

  // Accessors
  public double getBet() {
    return bet;
  }

  public void setBet(double bet) {
    this.bet = bet;
  }

  public double getMoney() {
    return money;
  }

  public void setMoney(double money) {
    this.money = money;
  }

}
