/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.kumpulatd.ui;

import dev.kumpulatd.logic.Game;
import dev.kumpulatd.objects.Ammunition;
import dev.kumpulatd.objects.Enemy;
import dev.kumpulatd.objects.GoalLocation;
import dev.kumpulatd.objects.Tower;
import dev.kumpulatd.objects.TowerLocation;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kummi
 */
public class Drawer {

    /**
     *
     * @param g2d
     * @param img
     */
    public static void drawBackGround(Graphics2D g2d, BufferedImage img) {

        g2d.drawImage(img, null, 0, 0);
        g2d.setBackground(Color.white);
        g2d.setColor(Color.white);
        g2d.fillRect(800, 0, 400, 800);
        g2d.setColor(Color.black);
    }

    /**
     *
     * @param towerlocations
     * @param enemies
     * @param towers
     * @param ammunition
     * @param g2d
     */
    public static void drawDrawables(List<TowerLocation> towerlocations, List<Enemy> enemies, List<Tower> towers, List<Ammunition> ammunition, Graphics2D g2d) {
        List<TowerLocation> used = new ArrayList<>();

        for (Enemy e : enemies) {
            g2d.drawImage(e.getImg(), null, e.getX(), e.getY());
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

    /**
     *
     * @param g2d
     * @param game
     * @param currentTower
     * @param nextCommand
     */
    public static void infoDraw(Graphics2D g2d, Game game, int currentTower, char nextCommand) {
        int x = 825;
        int y = 50;
        g2d.drawString("Selected tower: " + currentTower, x, y);
        drawSelectedTower(currentTower, g2d, x, y, game);
        y += 150;
        for (String row : game.getInfoString()) {
            g2d.drawString(row, x, y);
            y += 12;
        }
        try {
            currentTower = Integer.parseInt(nextCommand + "");
        } catch (Exception e) {

        }

    }

    /**
     *
     * @param currentTower
     * @param g2d
     * @param x
     * @param y
     * @param game
     */
    public static void drawSelectedTower(int currentTower, Graphics2D g2d, int x, int y, Game game) {
        y += 24;

//        if (currentTower == 1 && !game.getTowers().isEmpty()) {
//            g2d.drawString("Type: " + game.getTowers().get(0).getName(), x, y);
//            y += 12;
//            g2d.drawString("Damage: " + game.getTowers().get(0).damage() + "", x, y);
//            y += 12;
//            if (game.getTowers().get(0).getRadius() > 20) {
//                g2d.drawString("Radius: " + game.getTowers().get(0).damage() + "", x, y);
//                y += 12;
//            }
//            g2d.drawImage(game.getTowers().get(0).getImg(), null, x, y);
//        }
        int i = 0;
        for (Tower tower : game.getTowers()) {
            TowerLocation lct = game.getTowerLocations().get(currentTower - 1);
            if (tower.getLocation() == lct) {
                g2d.drawString("Type: " + tower.getName(), x, y);
                y += 12;
                g2d.drawString("Damage: " + tower.damage() + "", x, y);
                y += 12;
                if (tower.getRadius() > 20) {
                    g2d.drawString("Radius: " + tower.getRadius() + "", x, y);
                    y += 12;
                }
                g2d.drawImage(tower.getImg(), null, x, y);
            }

            i++;
        }

    }

    /**
     *
     * @param g2d
     * @param goal
     */
    public static void drawGoal(Graphics2D g2d, GoalLocation goal) {
        g2d.drawImage(goal.getImg(), null, goal.getX() - 40, goal.getY() - 40);
    }
}
