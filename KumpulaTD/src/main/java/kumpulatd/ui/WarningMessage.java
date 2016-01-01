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
public class WarningMessage {

    public void invokeWarning() {
        JOptionPane.showMessageDialog(null,
                "You lost.",
                "No image of Fuksi was found",
                JOptionPane.ERROR_MESSAGE);
        System.exit(0);
    }
}
