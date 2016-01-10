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
        JOptionPane.showMessageDialog(null,
                "Some sources files are lost and might affect game experience",
                "Something happened",
                JOptionPane.PLAIN_MESSAGE);

    }

    /**
     *
     * @param view
     * @param window
     */
    public void invokeWarning(GameView view, Window window) {
        JOptionPane.showMessageDialog(null,
                "Map files are not found",
                "Something happened",
                JOptionPane.PLAIN_MESSAGE);
        window.stop();
        view.iniatitenewWindow();

    }

    /**
     *
     * @param text
     */
    public void invokeWarning(String text) {
        JOptionPane.showMessageDialog(null,
                "Some sources files are lost and might affect game experience\n" + text,
                "Something happened",
                JOptionPane.PLAIN_MESSAGE);
    }

}
