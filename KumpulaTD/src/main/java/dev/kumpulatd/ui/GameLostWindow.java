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
public class GameLostWindow {

    /**
     * 
     * @param view Gets the frame to be refreshed and shows message and clears the screen
     */
    public void invokeWarning(GameView view) {
        JOptionPane.showMessageDialog(null,
                "You lose the game",
                "Haa haa",
                JOptionPane.PLAIN_MESSAGE);

        view.returnMenu();

    }
}
