/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.kumpulatd.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;
import dev.kumpulatd.objects.Ammunition;
import dev.kumpulatd.objects.Enemy;
import dev.kumpulatd.logic.Game;
import dev.kumpulatd.objects.Tower;
import dev.kumpulatd.objects.TowerLocation;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Handles the drawing of the game currentWindow
 *
 * @author antti
 */
public class GameView extends JPanel implements ActionListener {

    private Game game;
    private int frame;
    private char nextCommand;
    private int currentTower;
    private Timer timer;
    private Window currentWindow;
    private List<String> mapData;
    private BufferedImage img;

    /**
     *
     * @param window When game is started, the application passes the frame
     * forward for the game logic to be manipulated by the game view
     * @param map Gives the name of the map that is to be loaded
     */
    public GameView(Window window, String map) {
        this.currentWindow = window;
        List<String> list = new ArrayList<>();
        File file = null;
        Scanner reader = null;
        map = "assets/" + map;
        try {
            file = new File(map);
            reader = new Scanner(file);
        } catch (Exception e) {
            new WarningMessage().invokeWarning(this, window);

        }

        if (file.exists()) {
            while (reader.hasNextLine()) {
                list.add(reader.nextLine());
            }

            game = new Game(list);
            mapData = list;
            frame = 0;
            currentTower = 1;
            nextCommand = ' ';
            timer = new Timer(16, this);
            timer.start();
            game.update(frame, this);

            String imageLocation = list.get(0);
            try {
                img = ImageIO.read(new File(imageLocation));
            } catch (Exception e) {
                new WarningMessage().invokeWarning("Map not found");
                img = null;
            }

        } else {
            game = new Game();
            mapData = list;
            frame = 0;
            currentTower = 1;
            nextCommand = ' ';
            timer = new Timer(200, this);
            timer.start();
            img = null;

            game.update(frame, this);
        }

    }

    /**
     * Used to stop game view from refreshing itself
     */
    public void stopTimer() {
        timer.stop();
        timer.removeActionListener(this);

    }

    /**
     *
     * @param command Passes the game view the key press from keyboard to be
     * processed
     */
    public void setNextCommand(char command) {
        nextCommand = command;
        String commandint = command + "";
        try {
            currentTower = Integer.parseInt(commandint);
        } catch (Exception e) {

        }
        game.runCommand(this);
    }

    /**
     *
     * @return Returns the game object the view is associated with.
     */
    public Game getGame() {
        return game;
    }

    @Override
    public void paint(Graphics g) {
        boolean test = true;
        Graphics2D g2d = (Graphics2D) g;

        try {
            Drawer.drawBackGround(g2d, img);
        } catch (Exception e) {
            test = false;
            new WarningMessage().invokeWarning(this, currentWindow);

        }

        if (test) {
            if (mapData.isEmpty()) {
                game.update(this);
            } else {
                game.update(frame, this);
            }

            Drawer.drawDrawables(game.getTowerLocations(), game.getEnemies(), game.getTowers(), game.getAmmunition(), g2d);

            drawFrameCounter(g2d);

            Drawer.infoDraw(g2d, game, currentTower, nextCommand);

            Drawer.drawGoal(g2d, game.getGoal());
        }
    }

    /**
     *
     * @param g2d The graphics element to which background is drawn on is passed
     * as parameter.
     */
    /**
     *
     * @param g2d The graphics element to which background is drawn on is passed
     * as parameter. Utility for development phase to measure performance of the
     * game.
     */
    public void drawFrameCounter(Graphics2D g2d) {
        //String frametostring = "" + frame;
        //g2d.drawString(frametostring, 10, 10);
        frame++;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    /**
     * Changes the view back to opening menu
     */
    public void returnMenu() {

        currentWindow.restartMenu();
    }

    /**
     * Reruns the window
     */
    public void iniatitenewWindow() {

        currentWindow.run();
    }

    /**
     *
     * @return
     */
    public int getCurrentTower() {
        return currentTower;
    }

    /**
     *
     * @return
     */
    public char getCurrentCommand() {
        return nextCommand;
    }

    /**
     * Clears the current command
     */
    public void resetCommand() {
        nextCommand = ' ';
    }

}
