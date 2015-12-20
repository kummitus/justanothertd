/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kumpulatd.ui;

import java.util.Scanner;
import kumpulatd.logic.Game;

/**
 *
 * @author antti
 */
public class Menu {

    private Scanner reader;

    public Menu() {
        reader = new Scanner(System.in);

        menuLoop();
    }

    private void menuLoop() {
        System.out.println("Select:");
        while (true) {
            System.out.println("  1: New Game"
                    + "\n  2: Quit");
            String choice = reader.nextLine();
            if(choice.equals("1")){
                Game game = new Game();
                game.init();
            } else if(choice.equals("2")){
                break;
            }
        }
    }
}
