package com.company.game;

import com.company.players.Alien;
import com.company.players.Human;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {
    Human human;
    Alien alien;
    Game newGame;

    @BeforeEach
    public void initialTest() throws Exception {
        newGame = new Game();
        human = new Human("human_test");
        alien = new Alien("alien_test");
        newGame.players[0] = human;
        newGame.players[1] = alien;
    }

     @Test
     public void testChooseName() {
         String result =  newGame.chooseName(Game.Creatures.human, new Scanner("Cat"));
         assertEquals(result, "Cat");
     }

    @Test
    public void testGetNameFromHuman() {
        String result =  newGame.getNameFromUser(Game.Creatures.human, new Scanner("buzz lightyear"), 1);
        assertEquals(result, "buzz lightyear");
    }

    @Test
    public void testOfferDefaultNameNoDefaultName() {
        String result = newGame.offerDefaultName(new Scanner("0"),  "defaultName");
        assertNull(result);
    }

    @Test
    public void testOfferDefaultNameYesDefaultName() {
        String result = newGame.offerDefaultName(new Scanner("1"),  "defaultName");
        assertEquals(result, "defaultName");
    }

    @Test
    public void chooseHittingPlayer() {
        newGame.chooseHittingPlayer(0);
        assertEquals(newGame.movingPlayer, human);
        assertEquals(newGame.hitPlayer, alien);
    }

    @Test
    public void testSetMoves() {
        human.setMoves();
        assertEquals(human.getMoves(), 1);
    }

    @Test
    public void testGetDamage() {
        alien.getDamage(10);
        assertEquals(human.getHealth(), 100);
    }

    @Test
    public void testEndOfGame() throws InterruptedException {
        human.getDamage(100);
        alien.getDamage(110);
        boolean ifEnds = newGame.play(new Scanner("test"));
        assertFalse(ifEnds);
    }
}