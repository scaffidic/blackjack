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
  private Deck discardDeck;
  private final String playerName;

  public Game() {
    money = 1000;
    deck = new Deck(true);
    deck.shuffle();
    discardDeck = new Deck();
    dealer = new Dealer();
    player = new Player();
    System.out.println(Colors.YELLOW + "What is your name?\n" + Colors.RESET);
    Scanner input = new Scanner(System.in);
    String name = input.nextLine();
    playerName = name;
    player.setName(Colors.BLUE + playerName);
  }

  public boolean startRound() {
    dealer.setDealerHandVisible(false);
    discardHands();
    displayBank();

    if (getMoney() <= 0){
      System.out.println(Colors.RED + "\nYou are out of money. GAME IS OVER!" + Colors.RESET);
      return false;
    }

    deck.draw(player, discardDeck);
    deck.draw(dealer, discardDeck);
    deck.draw(player, discardDeck);
    deck.draw(dealer, discardDeck);

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

    player.hitOrStand(deck, discardDeck);

    int playerScore = player.getHand().totalValue();

    boolean playOrNot;
    if (playerScore > 21){
      System.out.println(Colors.RED + "\nPlayer busted. You lose!" + Colors.RESET);
      printAllHands();
      setMoney(getMoney() - 100);
      playOrNot = keepPlayingOrNot();
      return playOrNot;
    }

    dealer.dealerPlay(deck, discardDeck);
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
    dealer.printHand();
    System.out.print(Colors.RESET);
  }

  private void displayBank() {
    System.out.println(Colors.CYAN + "\n----------------------------------------");
    System.out.printf("| " + Colors.RESET + "$100 Bets. Current Bank Value: " + Colors.GREEN + "$%d " + Colors.CYAN + "|\n", getMoney());
    System.out.println("----------------------------------------" + Colors.RESET);
  }

  private void printAllHands() {
    dealer.setDealerHandVisible(true);
    System.out.print(Colors.BLACK + Colors.WHITE_BACKGROUND);
    System.out.println("\tFinal:" + Colors.RESET);
    System.out.print(Colors.PURPLE);
    dealer.printHand();
    System.out.print(Colors.BLUE);
    player.printHand();
    System.out.print(Colors.RESET);
  }

  public void discardHands(){
    dealer.getHand().discardHand(discardDeck);
    player.getHand().discardHand(discardDeck);
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

  public Deck getDeck() {
    return deck;
  }

  public void setDeck(Deck deck) {
    this.deck = deck;
  }

  public Deck getDiscardDeck() {
    return discardDeck;
  }

  public void setDiscardDeck(Deck discardDeck) {
    this.discardDeck = discardDeck;
  }

  public int getMoney() {
    return money;
  }

  public void setMoney(int money) {
    this.money = money;
  }

}
