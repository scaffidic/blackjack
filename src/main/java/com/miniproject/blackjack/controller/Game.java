package com.miniproject.blackjack.controller;

import com.miniproject.blackjack.model.Dealer;
import com.miniproject.blackjack.model.Deck;
import com.miniproject.blackjack.view.Colors;
import com.miniproject.blackjack.controller.Player;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {

  private final Dealer dealer;
  private final Player player;
  private Deck deck;
  private final String playerName;

  /**
   * Creates an instance of a Blackjack game by setting up a shuffled {@link Deck} and creating
   * instances of {@link Player} and {@link Dealer}.
   */
  public Game() {
    deck = new Deck();
    deck.shuffle();
    dealer = new Dealer();
    player = new Player();
    System.out.println(Colors.YELLOW + "What is your name?\n" + Colors.RESET);
    Scanner input = new Scanner(System.in);
    String name = input.nextLine();
    playerName = name;
    player.setName(Colors.BLUE + playerName);
  }

  /**
   * Initializes game.
   * @return returns the option to keep playing.
   */
  public boolean startRound() {
    dealer.setDealerHandVisible(false);
    player.getHand().clear();
    dealer.getHand().clear();

    displayBank();
    if (player.getMoney() <= 0.0) {
      System.out.println(Colors.RED + "\nYou are out of money. GAME IS OVER!" + Colors.RESET);
      return false;
    } else {
      betMoney();
    }

    player.hit(deck);
    dealer.hit(deck);
    player.hit(deck);
    dealer.hit(deck);

    System.out.println();
    System.out.println(dealer);
    System.out.println(player);

    double currentBet = player.getBet();

    if (player.isBlackjack() && dealer.isBlackjack()) {
      System.out.println(Colors.CYAN + "\nPush!\n" + Colors.RESET);
      printAllHands();
      return keepPlayingOrNot();
    } else if (player.isBlackjack()) {
      // player wins
      System.out.println(Colors.GREEN + playerName + " hit blackjack! You win!" + Colors.RESET);
      printAllHands();
      player.setMoney(player.getMoney() + (currentBet * 1.5));
      return keepPlayingOrNot();
    } else if (dealer.isBlackjack()) {
      // dealer wins
      System.out.println(Colors.RED + "\nDealer hit blackjack!" + Colors.RESET);
      printAllHands();
      player.setMoney(player.getMoney() - currentBet);
      return keepPlayingOrNot();
    }

    showDealerHand();

    player.hitOrStand(deck);
    currentBet = player.getBet();

    int playerScore = player.getHand().totalValue();

    boolean playOrNot;
    if (playerScore > 21) {
      System.out.println(Colors.RED + "\nPlayer busted. You lose!" + Colors.RESET);
      printAllHands();
      player.setMoney(player.getMoney() - currentBet);
      playOrNot = keepPlayingOrNot();
      return playOrNot;
    }

    dealer.dealerPlay(deck);
    dealer.setDealerHandVisible(true);
    showDealerHand();
    int dealerScore = dealer.getHand().totalValue();

    if (dealerScore > 21) {
      System.out.println(Colors.GREEN + "\nDealer busted. You win!\n" + Colors.RESET);
      printAllHands();
      player.setMoney(player.getMoney() + currentBet);
      playOrNot = keepPlayingOrNot();
      return playOrNot;
    } else if (dealerScore > playerScore) {
      System.out.println(Colors.RED + "\nDealer wins! You lose!\n" + Colors.RESET);
      printAllHands();
      player.setMoney(player.getMoney() - currentBet);
      playOrNot = keepPlayingOrNot();
      return playOrNot;
    } else if (dealerScore < playerScore) {
      System.out.println(Colors.GREEN + "\nYou win!\n" + Colors.RESET);
      printAllHands();
      player.setMoney(player.getMoney() + currentBet);
      playOrNot = keepPlayingOrNot();
      return playOrNot;
    } else {
      System.out.println(Colors.CYAN + "\nPush!\n" + Colors.RESET);
      printAllHands();
      playOrNot = keepPlayingOrNot();
      return playOrNot;
    }
  }

  private void showDealerHand() {
    System.out.print(Colors.PURPLE);
    dealer.toString();
    System.out.print(Colors.RESET);
  }

  private void displayBank() {
    System.out.println(Colors.CYAN + "\n--------------------------------------");
    System.out.printf(
        "|    " + Colors.RESET + "Current Bank Value: " + Colors.GREEN + "$%.2f "
            + Colors.CYAN + "   |\n",
        player.getMoney());
    System.out.println("--------------------------------------" + Colors.RESET);
  }

  private void printAllHands() {
    dealer.setDealerHandVisible(true);
    System.out.println();
    System.out.print(Colors.BLACK + Colors.WHITE_BACKGROUND);
    System.out.println("\tFinal:" + Colors.RESET);
    System.out.print(Colors.PURPLE);
    System.out.println(
        dealer.getName() + "'s hand - " + dealer.toString() + Colors.RESET + " - valued at "
            + dealer.getHand().totalValue());
    System.out.print(Colors.BLUE);
    System.out.println(player.toString());
    System.out.print(Colors.RESET);
  }

  public boolean keepPlayingOrNot() {
    displayBank();
    System.out.println(Colors.YELLOW
        + "\n Do you want to keep playing? \n Y - to continue. \n Any other character - to exit\n"
        + Colors.RESET);
    Scanner input = new Scanner(System.in);
    char answer = input.next().toLowerCase().charAt(0);
    if (answer != 'y') {
      System.out.println(
          Colors.CYAN + "\nGoodbye, " + playerName + "! You are leaving with $" + player.getMoney()
              + "."
              + Colors.RESET);
    }
    return answer == 'y';
  }

  public void betMoney() {
    Scanner input = new Scanner(System.in);
    double bet = 0;
    boolean inputNum = true;
    while (inputNum) {
      try {
        System.out.println(
            Colors.YELLOW + "\n Enter the amount you would like to bet: \n" + Colors.RESET);
        bet = input.nextDouble();
        if (bet > player.getMoney()) {
          System.out.println("Please enter an amount no more than: $" + player.getMoney());
          continue;
        }
      } catch (InputMismatchException e) {
        System.out.println(Colors.RED + "Invalid entry\n" + Colors.RESET);
        input.nextLine();
        continue;
      }
      System.out.println("\nYou bet: $" + bet + ". Remaining balance: $" + (player.getMoney() - bet));
      player.setBet(bet);
      inputNum = false;
    }
  }
}
