package com.miniproject.blackjack;

import java.util.Scanner;

public class Main {

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
