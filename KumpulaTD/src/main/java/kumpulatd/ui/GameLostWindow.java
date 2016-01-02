/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kumpulatd.ui;

import javax.swing.JOptionPane;

/**
 *
 * @author antti
 */
public class GameLostWindow {

    /**
     * 
     * @param view Gets the frame to be refreshed and shows message and clears the screen
     */
    public void invokeWarning(GameView view) {
        JOptionPane.showOptionDialog(null,
                "You lose the game",
                "Haa haa",
                JOptionPane.PLAIN_MESSAGE,
                JOptionPane.PLAIN_MESSAGE, null, null, null);

        view.returnMenu();

    }
}
