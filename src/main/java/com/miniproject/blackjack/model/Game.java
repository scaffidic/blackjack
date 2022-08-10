package com.miniproject.blackjack.model;

import com.miniproject.blackjack.view.Colors;
import com.miniproject.blackjack.controller.Dealer;
import com.miniproject.blackjack.controller.Player;
import java.util.Scanner;

public class Game {
  private int money;
  private final Dealer dealer;
  private final Player player;
  private Deck deck;
  private final String playerName;

  public Game() {
    money = 1000;
    deck = new Deck();
    deck.shuffle();
    dealer = new Dealer();
    player = new Player();
    System.out.println(Colors.YELLOW + "What is your name?\n" + Colors.RESET);
    Scanner input = new Scanner(System.in);
    String name = input.nextLine();
    playerName = name;
    player.setName(Colors.BLUE + playerName);
//    System.out.println("You bet: " + betMoney());
  }

  public boolean startRound() {
    dealer.setDealerHandVisible(false);
//    betMoney();
    displayBank();

    if (getMoney() <= 0){
      System.out.println(Colors.RED + "\nYou are out of money. GAME IS OVER!" + Colors.RESET);
      return false;
    }

      player.hit(deck);
      dealer.hit(deck);

    System.out.println();

    if(player.isBlackjack() && dealer.isBlackjack()){
      System.out.println(Colors.CYAN + "\nPush!\n" + Colors.RESET);
      printAllHands();
      return keepPlayingOrNot();
    } else if (player.isBlackjack()) {
      // player wins
      System.out.println(Colors.GREEN + playerName + " hit blackjack! You win!" + Colors.RESET);
      printAllHands();
      setMoney(getMoney() + 100);
      return keepPlayingOrNot();
    } else if (dealer.isBlackjack()) {
      // dealer wins
      System.out.println(Colors.RED + "\nDealer hit blackjack!" + Colors.RESET);
      printAllHands();
      setMoney(getMoney() - 100);
      return keepPlayingOrNot();
    }

    showDealerHand();

    player.hitOrStand(deck);

    int playerScore = player.getHand().totalValue();

    boolean playOrNot;
    if (playerScore > 21){
      System.out.println(Colors.RED + "\nPlayer busted. You lose!" + Colors.RESET);
      printAllHands();
      setMoney(getMoney() - 100);
      playOrNot = keepPlayingOrNot();
      return playOrNot;
    }

    dealer.dealerPlay(deck);
    dealer.setDealerHandVisible(true);
    showDealerHand();
    int dealerScore = dealer.getHand().totalValue();


    if (dealerScore > 21){
      System.out.println(Colors.GREEN + "\nDealer busted. You win!\n" + Colors.RESET);
      printAllHands();
      setMoney(getMoney() + 100);
      playOrNot = keepPlayingOrNot();
      return playOrNot;
    } else if (dealerScore > playerScore){
      System.out.println(Colors.RED + "\nDealer wins! You lose!\n" + Colors.RESET);
      printAllHands();
      setMoney(getMoney() - 100);
      playOrNot = keepPlayingOrNot();
      return playOrNot;
    } else if (dealerScore < playerScore){
      System.out.println(Colors.GREEN + "\nYou win!\n" + Colors.RESET);
      printAllHands();
      setMoney(getMoney() + 100);
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
    System.out.println(Colors.CYAN + "\n----------------------------------------");
    System.out.printf("| " + Colors.RESET + "Current Bank Value: " + Colors.GREEN + "$%d " + Colors.CYAN + "|\n", getMoney());
    System.out.println("----------------------------------------" + Colors.RESET);
  }

  private void printAllHands() {
    dealer.setDealerHandVisible(true);
    System.out.print(Colors.BLACK + Colors.WHITE_BACKGROUND);
    System.out.println("\tFinal:" + Colors.RESET);
    System.out.print(Colors.PURPLE);
    dealer.toString();
    System.out.print(Colors.BLUE);
    player.toString();
    System.out.print(Colors.RESET);
  }

  public boolean keepPlayingOrNot(){
    displayBank();
    System.out.println(Colors.YELLOW + "\n Do you want to keep playing? \n Y - to continue. \n Any other character - to exit\n" + Colors.RESET);
    Scanner input = new Scanner(System.in);
    char answer = input.next().toLowerCase().charAt(0);
    if (answer != 'y') {
      System.out.println(Colors.CYAN + "\nGoodbye, " + playerName + "! You are leaving with $" + money +"." + Colors.RESET);
    }
    return answer == 'y';
  }

//  public int betMoney() {
//    System.out.println(
//        Colors.YELLOW + "\n Enter the amount you would like to bet: \n" + Colors.RESET);
//    int bet = 1;
//    Scanner input = new Scanner(System.in);
//    if (input.hasNextInt()) {
//      bet = input.nextInt();
//      if (bet > money) {
//        System.out.println("Please enter an amount less than: " + money);
//        input.nextInt();
//      } else {
//        System.out.println("You bet: " + bet +". Remaining balance: " + (money-bet));
//      }
//    }
//    return bet;
//  }

//  public boolean doubleDown() {
//    System.out.println(Colors.YELLOW + "\n double down? \n Y - to double down. "
//        + "\n Any other character - to reject\n" + Colors.RESET);
//    Scanner input = new Scanner(System.in);
//    char response = input.next().toLowerCase().charAt(0);
//    if (response == 'y') {
//
//    }
//  }

  public Deck getDeck() {
    return deck;
  }

  public void setDeck(Deck deck) {
    this.deck = deck;
  }

  public int getMoney() {
    return money;
  }

  public void setMoney(int money) {
    this.money = money;
  }

}
