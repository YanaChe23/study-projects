package com.company;

import com.company.game.Game;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Game newGame = new Game();
        newGame.start(new Scanner(System.in));
    }
}
