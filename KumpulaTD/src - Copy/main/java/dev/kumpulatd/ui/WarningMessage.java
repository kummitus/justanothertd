/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.kumpulatd.ui;

import javax.swing.JOptionPane;

/**
 * Warning message window
 *
 * @author antti
 */
public class WarningMessage {

    /**
     * Invokes warning message if some files are not found
     */
    public void invokeWarning() {
        JOptionPane.showOptionDialog(null,
                "Some sources files are lost and might affect game experience",
                "Something happened",
                JOptionPane.PLAIN_MESSAGE,
                JOptionPane.PLAIN_MESSAGE, null, null, null);

    }

    public void invokeWarning(GameView view, Window window) {
        JOptionPane.showOptionDialog(null,
                "Map files are not found",
                "Something happened",
                JOptionPane.PLAIN_MESSAGE,
                JOptionPane.PLAIN_MESSAGE, null, null, null);
        window.stop();
        view.iniatitenewWindow();

    }

    public void invokeWarning(String text) {
        JOptionPane.showOptionDialog(null,
                "Some sources files are lost and might affect game experience\n" + text,
                "Something happened",
                JOptionPane.PLAIN_MESSAGE,
                JOptionPane.PLAIN_MESSAGE, null, null, null);
    }

}
