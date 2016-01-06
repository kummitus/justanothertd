/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.kumpulatd.ui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 * The frame for the game, handles all the elements
 *
 * @author antti
 */
public class Window implements Runnable {

    private JFrame frame;
    private GameView game;
    private List<String> selectedList;

    /**
     * Constructor for Window
     */
    public Window() {
    }

    @Override
    public void run() {

        frame = new JFrame("Menu");
        frame.setPreferredSize(new Dimension(1200, 800));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);

    }

    public void createComponents(Container contentPane) {
        game = new GameView(this, selectedList);
        contentPane.setLayout(new BorderLayout());
        contentPane.add(createMapList(), BorderLayout.CENTER);
        contentPane.add(createMenu(), BorderLayout.SOUTH);
    }

    /**
     *
     * @return
     */
    public JFrame getFrame() {
        return frame;
    }

    private Component createMenu() {
        JButton newgame = new JButton("New Game");
        JButton exit = new JButton("Exit");

        ActionListenerGame gamelist = new ActionListenerGame(frame, game);
        ActionListenerExit exitlist = new ActionListenerExit();

        newgame.addActionListener(gamelist);
        exit.addActionListener(exitlist);

        ButtonGroup buttons = new ButtonGroup();
        buttons.add(newgame);
        buttons.add(exit);

        JPanel menu = new JPanel(new GridLayout(1, 2));

        menu.add(newgame);
        menu.add(exit);
        return menu;
    }

    /**
     * Closes the game and returns to the main menu
     */
    public void restartMenu() {
        if (Objects.equals(frame, null)) {
            frame = new JFrame("Menu");
            createComponents(frame.getContentPane());
            frame.validate();
        } else {
            frame.getContentPane().removeAll();
            createComponents(frame.getContentPane());
            frame.validate();

        }
    }

    private Component createMapList() {
        File file = null;
        Scanner reader;
        List<String> maplist = new ArrayList<>();
        List<JButton> buttonlist = new ArrayList<>();
        try {
            file = new File("src/maplist.txt");
            reader = new Scanner(file);
            while (reader.hasNextLine()) {
                maplist.add(reader.nextLine());
            }
        } catch (Exception e) {
            new WarningMessage();
        }

        for (String map : maplist) {
            JButton button = new JButton(map);
            buttonlist.add(button);
        }
        int i = 0;
        for (JButton button : buttonlist) {
            button.addActionListener(new MapListListener(maplist.get(i)));
            i++;
        }

        JPanel menu = new JPanel(new GridLayout(maplist.size(), 1));
        
        ButtonGroup buttons = new ButtonGroup();
        for (JButton button : buttonlist) {
            buttons.add(button);
            menu.add(button);
        }
        
        
        
        
        return menu;
    }
}
