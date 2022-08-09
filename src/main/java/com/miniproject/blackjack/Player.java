package com.miniproject.blackjack;

import java.util.Scanner;

public class Player extends Person {

  Scanner input = new Scanner(System.in);
//  private int bank;
//
//  private int bet;

  private Hand hand = new Hand();


  public Player() {
    super.setName("Player");
    hand = new Hand();
  }

  public void hitOrStand(Deck deck, Deck discard) {
    int decision = 0;
    boolean inputNum = true;

    while (inputNum) {
      try {
        System.out.println("Press (1) to Hit or (2) to Stand.");
        decision = input.nextInt();
        inputNum = false;

      } catch (IllegalArgumentException e) {
        System.out.println("Invalid entry");
        input.next();
      }
      if (decision == 1) {
        hand.addToHand(deck.draw());
        if (hand.getScore() > 21) {
          return;
        }
        else {
          this.hitOrStand(deck, discard);
        }
        } else {
        System.out.println("You have chosen to Stand.");
        }
      }
    }
  }
