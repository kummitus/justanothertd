/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.kumpulatd.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 *
 * @author antti
 */
class MapListListener implements ActionListener {

    private String map;
    private JFrame frame;
    private GameView game;
    private Window window;

    MapListListener(JFrame frame, String map, Window window) {
        this.map = map;
        this.frame = frame;
        this.window = window;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        game = new GameView(window, map);
        frame.getContentPane().removeAll();
        frame.getContentPane().add(game);
        KeyListenerGame keylist = new KeyListenerGame(game);
        frame.addKeyListener(keylist);
        frame.requestFocusInWindow();
        frame.validate();
    }

}
