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
        map = "src/main/resources/" + map;
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

        } else {
            game = new Game();
            mapData = list;
            frame = 0;
            currentTower = 1;
            nextCommand = ' ';
            timer = new Timer(16, this);
            timer.start();

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
            drawBackGround(g2d);
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

            List<Enemy> enemies = game.getEnemies();
            List<Tower> towers = game.getTowers();
            List<Ammunition> ammunition = game.getAmmunition();
            List<TowerLocation> towerlocations = game.getTowerLocations();

            drawDrawables(towerlocations, enemies, towers, ammunition, g2d);

            drawFrameCounter(g2d);

            infoDraw(g2d);

            drawGoal(g2d);
        }
    }

    /**
     *
     * @param g2d The graphics element to which background is drawn on is passed
     * as parameter.
     */
    public void drawBackGround(Graphics2D g2d) {
        BufferedImage img = null;
        try {
            String imageLocation = mapData.get(0);
            img = ImageIO.read(new File(imageLocation));
            g2d.drawImage(img, null, 0, 0);
            g2d.setBackground(Color.white);
            g2d.setColor(Color.white);
            g2d.fillRect(800, 0, 400, 800);
            g2d.setColor(Color.black);
        } catch (IOException e) {
        }
    }

    /**
     *
     * @param g2d The graphics element to which background is drawn on is passed
     * as parameter. Utility for development phase to measure performance of the
     * game.
     */
    public void drawFrameCounter(Graphics2D g2d) {
        String frametostring = "" + frame;
        g2d.drawString(frametostring, 10, 10);
        frame++;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    private void drawDrawables(List<TowerLocation> towerlocations, List<Enemy> enemies, List<Tower> towers, List<Ammunition> ammunition, Graphics2D g2d) {
        List<TowerLocation> used = new ArrayList<>();

        for (Enemy e : enemies) {
            for (Enemy ee : e.getMembers()) {
                g2d.drawImage(ee.getImg(), null, ee.getX(), ee.getY());
            }
        }

        for (Tower e : towers) {
            g2d.drawImage(e.getImg(), null, e.getLocation().getX(), e.getLocation().getY());
            used.add(e.getLocation());
        }

        for (Ammunition e : ammunition) {
            g2d.drawImage(e.getImg(), null, e.getX(), e.getY());
            if (e.onTarget()) {
                e.IncreaseCounter();
            }
        }

        for (TowerLocation location : towerlocations) {
            if (!used.contains(location)) {
                g2d.drawImage(location.getImg(), null, location.getX(), location.getY());
            }
        }

    }

    private void infoDraw(Graphics2D g2d) {
        int x = 825;
        int y = 50;
        for (String row : game.getInfoString()) {
            g2d.drawString(row, x, y);
            y += 12;
        }
        try {
            currentTower = Integer.parseInt(nextCommand + "");
        } catch (Exception e) {

        }

        if (nextCommand != ' ') {
            if (currentTower == '1' || currentTower == '2' || currentTower == '3' || currentTower == '4') {
                drawSelectedTower(currentTower, g2d, x, y);
                nextCommand = ' ';
            } else if (nextCommand == 'a') {
                game.buyTower(currentTower, "Tutor");
                nextCommand = ' ';
            } else if (nextCommand == 's') {
                game.sellTower(currentTower, "Tutor");
                nextCommand = ' ';
            } else if (nextCommand == 'd') {
                game.upgradeTower(currentTower, "Tutor");
                nextCommand = ' ';
            } else if (nextCommand == 'q') {
                game.buyTower(currentTower, "Professor");
                nextCommand = ' ';
            } else if (nextCommand == 'w') {
                game.sellTower(currentTower, "Professor");
                nextCommand = ' ';
            } else if (nextCommand == 'e') {
                game.upgradeTower(currentTower, "Professor");
                nextCommand = ' ';
            }
        }
    }

    private void drawSelectedTower(int currentTower, Graphics2D g2d, int x, int y) {
        y += 24;

        if (currentTower == 1 && !game.getTowers().isEmpty()) {
            g2d.drawImage(game.getTowers().get(0).getImg(), null, x, y);
            g2d.drawString(game.getTowers().get(0).getName(), x, y);
            y += 12;
            g2d.drawString(game.getTowers().get(0).damage() + "", x, y);
            y += 12;
            g2d.drawString(currentTower + " ", x, y);
        }

        if (currentTower == 2 && game.getTowers().size() >= 2) {
            g2d.drawImage(game.getTowers().get(0).getImg(), null, x, y);
            g2d.drawString(game.getTowers().get(1).getName(), x, y);
            y += 12;
            g2d.drawString(game.getTowers().get(1).damage() + "", x, y);
        }

        if (currentTower == 3 && game.getTowers().size() >= 3) {
            g2d.drawImage(game.getTowers().get(0).getImg(), null, x, y);
            g2d.drawString(game.getTowers().get(2).getName(), x, y);
            y += 12;
            g2d.drawString(game.getTowers().get(2).damage() + "", x, y);
        }

        if (currentTower == 4 && game.getTowers().size() >= 4) {
            g2d.drawImage(game.getTowers().get(0).getImg(), null, x, y);
            g2d.drawString(game.getTowers().get(3).getName(), x, y);
            y += 12;
            g2d.drawString(game.getTowers().get(3).damage() + "", x, y);
        }

    }

    private void drawGoal(Graphics2D g2d) {
        g2d.drawImage(game.getGoal().getImg(), null, game.getGoal().getX() - 40, game.getGoal().getY() - 40);
    }

    /**
     * Changes the view back to opening menu
     */
    public void returnMenu() {
        currentWindow.restartMenu();
    }

    public void iniatitenewWindow() {
        currentWindow.run();
    }

}
