/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.kumpulatd.logic;

import dev.kumpulatd.ui.GameView;

/**
 *
 * @author kummi
 */
public class CommandHandler {

    /**
     *
     * @param nextCommand
     * @param currentTower
     * @param game
     * @param view
     */
    public static void handleCommand(char nextCommand, int currentTower, Game game, GameView view) {
        if (nextCommand != ' ') {

            if (nextCommand == 'a') {
                game.buyTower(currentTower, "Tutor");
                view.resetCommand();
            } else if (nextCommand == 's') {
                game.sellTower(currentTower, "Tutor");
                view.resetCommand();
            } else if (nextCommand == 'd') {
                game.upgradeTower(currentTower, "Tutor");
                view.resetCommand();
            } else if (nextCommand == 'q') {
                game.buyTower(currentTower, "Professor");
                view.resetCommand();
            } else if (nextCommand == 'w') {
                game.sellTower(currentTower, "Professor");
                view.resetCommand();
            } else if (nextCommand == 'e') {
                game.upgradeTower(currentTower, "Professor");
                view.resetCommand();
            }
        }
        view.resetCommand();
    }
}
