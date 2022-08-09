package com.miniproject.blackjack;

public class Main {

  public static final String ANSI_RESET = "\u001B[0m";
  public static final String ANSI_GREEN = "\u001B[32m";

  public static void main(String[] args) {

    System.out.println();
    System.out.println(ANSI_GREEN + "Welcome to Blackjack!" + ANSI_RESET);
    Game game = new Game();

    game.startRound();


  }
}
