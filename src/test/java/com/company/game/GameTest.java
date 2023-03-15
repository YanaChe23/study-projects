//package com.company.game;
//
//import com.company.players.Alien;
//import com.company.players.Human;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import java.util.Scanner;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertFalse;
//
//public class GameTest {
//
//    Human human;
//    Alien alien;
//    Game newGame;
//
//    @BeforeEach
//    public void initialTest(){
//        human = new Human("Sam");
//        alien = new Alien("1@3344__2|");
//        newGame = new Game(human, alien);
//    }
//
//    @Test
//    public void chooseHittingPlayer() {
//        newGame.chooseHittingPlayer(0);
//        assertEquals(newGame.movingPlayer, human);
//        assertEquals(newGame.hitPlayer, alien);
//    }
//
//    @Test
//    public void testSetMoves() {
//        human.setMoves();
//        assertEquals(human.getMoves(), 1);
//    }
//
//    @Test
//    public void testGetDamage() {
//        alien.getDamage(10);
//        assertEquals(human.getHealth(), 100);
//    }
//
//    @Test
//    public void testEndOfGame() throws InterruptedException {
//        human.getDamage(100);
//        alien.getDamage(110);
//        boolean ifEnds = newGame.play(new Scanner("test"));
//        assertFalse(ifEnds);
//    }
//}