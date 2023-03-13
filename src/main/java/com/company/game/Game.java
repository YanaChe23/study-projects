package com.company.game;

import com.company.players.Player;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Game {

    public Player[] players = new Player[2];
    public Player movingPlayer;
    public Player hitPlayer;
    private Scanner scanner;


    public Game(Player player1, Player player2) {
        this.players[0] = player1;
        this.players[1] = player2;
    }

    public void start() throws InterruptedException {
        showGreetings();
        scanner = new Scanner(System.in);
        scanner.hasNext();
        play();
    }


    private void play() throws InterruptedException {
        while (true) {
            chooseHittingPlayer();
            makeAMove(this.movingPlayer, this.hitPlayer);
            if ((this.players[0].getHealth() > 0 && this.players[1].getHealth() > 0 )) {
                Thread.sleep(2000);
                System.out.println("Press any key to make next move.");
                scanner = new Scanner(System.in);
                scanner.hasNext();
            } else {
                System.out.println("Game is over! " + movingPlayer.getName() + " is a winner!");
                System.exit(0);
            }
        }

    }

    public void chooseHittingPlayer() {
        if (players[0].getMoves() == 0 && players[1].getMoves() == 0) {
            movingPlayer = chooseWhoStarts();
            int ind = 0;
            if (Arrays.asList(players).indexOf(movingPlayer) == 0) ind = 1;
            hitPlayer = players[ind];
            System.out.println(movingPlayer.getName() + " makes the first move.");
        } else {
            Player temp = movingPlayer;
            movingPlayer = hitPlayer;
            hitPlayer = temp;
            System.out.println("Wait for " + movingPlayer.getName() + "'s move.");
        }
    }
    public void showGreetings() throws InterruptedException {
        System.out.println("Welcome to our 'Human vs Aliens' not PS game!" );
        Thread.sleep(2000);
        System.out.println("Today are playing: " + players[0].getName() + " from " + players[0].getCreature()
                + " race. Another player is " + players[1].getName() + " from " + players[1].getCreature());
        Thread.sleep(1000);
        System.out.println("Press any key to continue!");
    }

    public Player chooseWhoStarts() {
        int playerRandomIndex = new Random().nextInt(2);
        return this.players[playerRandomIndex];
    }

    public int throwDice() {
        return new Random().nextInt(6) + 1;
    }

    public void makeAMove(Player<?> movingPlayer, Player<?> hitPlayer) throws InterruptedException {
        int hits = throwDice();
        System.out.println("Throwing dice...");
        Thread.sleep(3000);
        String msgAboutHits;
        if (hits == 1) {
            msgAboutHits = "1 point!";
        } else {
            msgAboutHits = hits + " points!";
        }
        System.out.println(msgAboutHits);
        int damageFromHit = movingPlayer.amountOfMadeDamage() * hits;
        int gotDamage = hitPlayer.getDamage(damageFromHit);
        movingPlayer.setMoves();
        System.out.println(movingPlayer.getName() + " makes " + gotDamage + " of damage to " + hitPlayer.getName()
                + ".\n " + hitPlayer.getName() + "'s health is " + hitPlayer.getHealth());
    }
}
