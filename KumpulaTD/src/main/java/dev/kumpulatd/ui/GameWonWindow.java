/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.kumpulatd.ui;

import javax.swing.JOptionPane;

/**
 * The end game window, initiates refreshing of the window
 * @author antti
 */
public class GameWonWindow {

    /**
     * 
     * @param view Gets the frame to be refreshed and shows message and clears the screen
     */
    public void invokeWarning(GameView view) {
        JOptionPane.showOptionDialog(null,
                "You won the game!",
                "Bleh",
                JOptionPane.PLAIN_MESSAGE,
                JOptionPane.PLAIN_MESSAGE, null, null, null);

        view.returnMenu();

    }
}