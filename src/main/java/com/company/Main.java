package com.company;

import com.company.players.Alien;
import com.company.players.Human;
import com.company.game.Game;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Human human = new Human("Sam");
        Alien  alien = new Alien("1@3344__2|");
        Game newGame = new Game(human, alien);

        newGame.start(new Scanner(System.in));
    }
}
