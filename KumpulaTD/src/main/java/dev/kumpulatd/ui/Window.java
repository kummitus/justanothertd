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
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
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

    /**
     * Constructor for Window
     */
    public Window() {
    }

    @Override
    public void run() {
        frame = new JFrame("KumpulaTD");
        frame.setPreferredSize(new Dimension(1100, 710));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().removeAll();
        createComponents(frame.getContentPane());
        frame.requestFocusInWindow();
        frame.pack();
        frame.setVisible(true);

    }

    /**
     *
     * @param contentPane
     */
    public void createComponents(Container contentPane) {

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
        JButton exit = new JButton("Exit");

        ActionListenerExit exitlist = new ActionListenerExit();

        exit.addActionListener(exitlist);

        ButtonGroup buttons = new ButtonGroup();
        buttons.add(exit);

        JPanel menu = new JPanel(new GridLayout(1, 2));

        menu.add(exit);
        return menu;
    }

    /**
     * Closes the game and returns to the main menu
     */
    public void restartMenu() {
        if (Objects.equals(frame, null)) {
            frame = new JFrame("KumpulaTD");
            createComponents(frame.getContentPane());
            frame.revalidate();
            frame.validate();
            frame.requestFocusInWindow();
        } else {
            frame.getContentPane().removeAll();
            createComponents(frame.getContentPane());
            frame.revalidate();
            frame.validate();
            frame.requestFocusInWindow();
        }
    }

    private Component createMapList() {
        File file = null;
        Scanner reader;
        List<String> maplist = new ArrayList<>();
        List<JButton> buttonlist = new ArrayList<>();
        try {
            //ClassLoader classLoader = getClass().getClassLoader();
            //file = new File(classLoader.getResource("/assets/maplist.txt").getFile());
            file = new File("assets/maplist.txt");
            reader = new Scanner(file);

            while (reader.hasNextLine()) {
                maplist.add(reader.nextLine());
            }
        } catch (Exception e) {
            new WarningMessage().invokeWarning();
        }
        ButtonGroup buttons = new ButtonGroup();
        JPanel menu = new JPanel(new GridLayout(maplist.size(), 1));
        for (String map : maplist) {
            JButton button = new JButton(map);
            buttonlist.add(button);
            button.addActionListener(new MapListListener(frame, map, this));
            buttons.add(button);
            menu.add(button);
        }
        return menu;
    }

    /**
     * Disposes crashed frame
     */
    public void stop() {
        frame.dispose();
    }
}
