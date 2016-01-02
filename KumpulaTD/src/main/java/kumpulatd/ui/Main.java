/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kumpulatd.ui;

import javax.swing.SwingUtilities;

/**
 * Main class
 * @author kummi
 */
public class Main {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
            Window window = new Window();
            SwingUtilities.invokeLater(window);
        }
}
