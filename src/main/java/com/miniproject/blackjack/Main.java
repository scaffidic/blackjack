package com.miniproject.blackjack;


import java.util.Scanner;

/**
 * Demonstrates the simple console-mode Blackjack gameplay.
 */

public class Main {

  /**
   * Creates an instance of {@link Game}, in order to keep playing until the
   * false boolean is returned.
   *
   * @param args Command-line arguments
   */

  public static final String ANSI_RESET = "\u001B[0m";
  public static final String ANSI_GREEN = "\u001B[32m";


  public static void main(String[] args) {

    System.out.println();
    System.out.println(Colors.GREEN + "Welcome to Blackjack!\n" + Colors.RESET);

    Game game = new Game();

    boolean keepPlaying = true;

    while(keepPlaying){
    keepPlaying = game.startRound();
    }
  }
}
