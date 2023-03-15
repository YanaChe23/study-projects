package com.company.game;

import com.company.players.Player;

import com.company.players.Alien;
import com.company.players.Human;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Game {

    enum Creatures {
        alien,
        human
    }
    public Player[] players = new Player[2];
    public Player movingPlayer;
    public Player hitPlayer;

    public void start() throws Exception {
        greetings(new Scanner(System.in));
        System.out.println("It's time to give names to our players.");
        players[0] = new Human(chooseName(Creatures.human));
        players[1] = new Alien(chooseName(Creatures.alien));
        while(true) {
            boolean ifStop = play(new Scanner(System.in));
            if (ifStop == false) {
                System.exit(0);
            }
        }
    }

    public void greetings(Scanner scanner) throws InterruptedException {
        System.out.println("Welcome to our 'Human vs Aliens' any key game!");
        Thread.sleep(2000);
        System.out.println("Press any key to continue!");
        scanner.hasNext();
    }

    public String chooseName(Creatures creatureType) {
        String playerName = null;
        int getNameCounter = 0;
        while(playerName == null) {
            getNameCounter++;
            playerName = getNameFromUser(creatureType, new Scanner(System.in), getNameCounter);
        }
        return playerName;
    }

    public String getNameFromUser(Creatures creatureType, Scanner scanner, int counter) {
        String name = null;
        String defaultName = "Killer 3000";

            switch(creatureType) {
                case human:
                    System.out.println("Type in a name for an human player:");
                    defaultName = "Agent K";
                    break;

                case alien:
                    System.out.println("Now, type in a name for a alien player:");
                    defaultName = "Jack Jeebs";
                    break;
            }

            String userInputName = scanner.nextLine();
            if(userInputName.isEmpty()) {
                System.out.println("You haven 't provided a name. If you want me to set up a default name, press 1." +
                        " To offer a name  for  player, press  0");
                while(true) {
                    if (scanner.hasNextInt()) {
                        int userInputNum = scanner.nextInt();
                        if (userInputNum  == 0) {
                            break;
                        } else if (userInputNum == 1) {
                            name = defaultName;
                            break;
                        } else {
                            System.out.println("Press 1 if you want to set default name for the player. Press 0 if you" +
                                    " want to type a name.");
                        }
                    }  else {
                        System.out.println("Press 1 if you want to set default name for the player. Press 0 if you" +
                                " want to type a name.");
                    }
                }
            } else {
                name = userInputName;
            }

            if(name == null && counter > 5) {
                System.out.println("Choosing a name is not so easy. But no worries, I will use a default name for the " +
                        "player to continue the game.");
                name = defaultName;
            }
        System.out.println(name +  " is a name of the player from " + creatureType + "'s side." );
        return name;
    }

    protected boolean play(Scanner scanner) throws InterruptedException {
         /* The random index is used to choose the player who makes the first move
         We pass it as a parameter to ensure that Junit tests can be run */
         int randomInd  = returnRandomInt(2);
         chooseHittingPlayer(randomInd);
         makeAMove(this.movingPlayer, this.hitPlayer);
         if ((this.players[0].getHealth() > 0 && this.players[1].getHealth() > 0 )) {
             Thread.sleep(2000);
             System.out.println("Press any key to make the next move.");
             scanner.hasNext();
         } else {
             System.out.println("Game is over! " + movingPlayer.getName() + " is a winner! Hooray to "
                     + movingPlayer.getCreatureType() + "s race!");
             return false;
         }
        return true;
    }

    public void chooseHittingPlayer(int randomIndex) {
        if (players[0].getMoves() == 0 && players[1].getMoves() == 0) {
            movingPlayer = this.players[randomIndex];
            int indOfHitPlayer = 0;
            if (Arrays.asList(players).indexOf(movingPlayer) == 0) indOfHitPlayer = 1;
            hitPlayer = players[indOfHitPlayer];
            System.out.println(movingPlayer.getName() + " makes the first move.");
        } else {
            Player temp = movingPlayer;
            movingPlayer = hitPlayer;
            hitPlayer = temp;
            System.out.println("Wait for " + movingPlayer.getName() + "'s move.");
        }
    }

    public int throwDice() {
        return returnRandomInt(6) + 1;
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
                + ".");
        if (hitPlayer.getHealth() > 0) {
            System.out.println(hitPlayer.getName() + "'s health is " + hitPlayer.getHealth());
        } else {
            System.out.println(hitPlayer.getName() + " is dead.");
        }
    }

    public int returnRandomInt(int  bound) {
        return new Random().nextInt(bound);
    }
}
