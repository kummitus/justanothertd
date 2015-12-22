/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kumpulatd.ui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 *
 * @author antti
 */
public class Menu implements Runnable {

    private JFrame frame;
    private GameView game;

    public Menu() {
    }

    @Override
    public void run() {
        
        frame = new JFrame("Menu");
        frame.setPreferredSize(new Dimension(800, 800));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);

        
    }

    private void createComponents(Container contentPane) {
        game = new GameView();
        contentPane.setLayout(new BorderLayout());
        
        contentPane.add(createMenu(), BorderLayout.SOUTH);

    }

    public JFrame getFrame() {
        return frame;
    }

    private Component createMenu() {
        JButton newgame = new JButton("New Game");
        JButton exit = new JButton("Exit");
        ButtonGroup buttons = new ButtonGroup();
        buttons.add(newgame);
        ActionListenerGame gamelist = new ActionListenerGame(frame, game);
        newgame.addActionListener(gamelist);
        buttons.add(exit);
        ActionListenerExit exitlist = new ActionListenerExit();
        exit.addActionListener(exitlist);
        JPanel menu = new JPanel(new GridLayout(1, 2));
        menu.add(newgame);
        menu.add(exit);
        return menu;
    }
}
