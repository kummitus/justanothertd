/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kumpulatd.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 *
 * @author kummi
 */
public class ActionListenerGame implements ActionListener {

    private JFrame frame;
    private GameView game;

    ActionListenerGame(JFrame frame, GameView game) {
        this.frame = frame;
        this.game = game;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        frame.getContentPane().removeAll();
        frame.getContentPane().add(game);
        KeyListenerGame keylist = new KeyListenerGame(game);
        frame.addKeyListener(keylist);
        frame.requestFocusInWindow();
        frame.validate();
    }

}
