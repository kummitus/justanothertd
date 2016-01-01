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

    public void invokeWarning() {
        JOptionPane.showMessageDialog(null,
                "Game integrity is not up to standards, some sources files are lost",
                "Something happened",
                JOptionPane.PLAIN_MESSAGE);

    }
}
