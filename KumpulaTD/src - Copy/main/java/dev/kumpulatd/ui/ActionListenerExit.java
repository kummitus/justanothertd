/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.kumpulatd.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Listens for exit call for the program
 * @author kummi
 */
public class ActionListenerExit implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
    
}
