package com.miniproject.blackjack;

import static org.junit.jupiter.api.Assertions.*;

import com.miniproject.blackjack.controller.Player;
import com.miniproject.blackjack.model.Deck;
import java.util.InputMismatchException;
import org.junit.jupiter.api.Test;

class PlayerTest {

  Player player = new Player();
  Deck deck = new Deck();
  Deck discard = new Deck();

  @Test
  public void testException() {
    Exception e = assertThrows(InputMismatchException.class, () -> player.hitOrStand(deck, discard));
        assertEquals("An exception was thrown", e.getMessage());
  }

  @Test
  void hitOrStand() {
  }
}