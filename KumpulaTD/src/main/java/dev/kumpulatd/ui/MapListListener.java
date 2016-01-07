/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.kumpulatd.ui;

import static dev.kumpulatd.logic.TestingHelper.testForGenericFiles;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 * MapListListener reads the user input that which map is to be played and initiates game start
 * @author antti
 */
public class MapListListener implements ActionListener {

    private String map;
    private JFrame frame;
    private GameView game;
    private Window window;

    public MapListListener(JFrame frame, String map, Window window) {
        this.map = map;
        this.frame = frame;
        this.window = window;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        testForGenericFiles();
        game = new GameView(window, map);
        frame.getContentPane().removeAll();
        frame.getContentPane().add(game);
        KeyListenerGame keylist = new KeyListenerGame(game);
        frame.addKeyListener(keylist);
        frame.requestFocusInWindow();
        frame.validate();
    }

}
