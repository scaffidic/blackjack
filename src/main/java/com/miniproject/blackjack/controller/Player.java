package com.miniproject.blackjack.controller;

import com.miniproject.blackjack.model.Deck;
import com.miniproject.blackjack.model.Person;
import com.miniproject.blackjack.view.Colors;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * An implementation of a player object which extends {@link Person}.
 */
public class Player extends Person {

  /**
   * The amount of money a player is betting expressed as a double.
   */
  private double bet;
  /**
   * The amount of money a player currently has.
   */
  private double money;

  Scanner input = new Scanner(System.in);

  // Constructor
  /**
   * Constructs an instance of {@link Player}.
   */
  public Player() {
    super.setName("Player");
    money = 1000;
  }

  // Business methods
  /**
   * Offers the player an option to either hit or stand before dealer's play.
   * <p>If the total amount of money that a player has is more than twice their bet amount,
   * the player is given an additional option to double down.</p>
   * @param deck
   */
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

        System.out.println();
        decision = input.nextInt();

        if (decision > upperLimit || decision < 1) {
          throw new InputMismatchException();
        }

      } catch (InputMismatchException e) {
        System.out.println(Colors.RED + "\nInvalid entry\n" + Colors.RESET);
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
        System.out.println(Colors.YELLOW + "\nYou doubled down.\n" + Colors.RESET);

        setBet(getBet() * 2);
        hit(deck);
        return;
      } else {
        System.out.println(Colors.YELLOW + "\nYou stand.\n" + Colors.RESET);
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
