/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.kumpulatd.logic;

import dev.kumpulatd.objects.Enemy;
import dev.kumpulatd.ui.GameLostWindow;
import dev.kumpulatd.ui.GameWonWindow;
import dev.kumpulatd.ui.GameView;
import dev.kumpulatd.ui.WarningMessage;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.imageio.ImageIO;

/**
 * Helper class to include various tests used in the game
 *
 * @author antti
 */
public class TestingHelper {

    /**
     * Tests if the enemy is close and increases the target
     *
     * @param ee
     * @param path
     * @return
     */
    public static boolean testIfClose(Enemy ee, PathFinding path) {
        if (ee.getX() == path.getPoint(ee.currentTarget()).getX() && ee.getY() == path.getPoint(ee.currentTarget()).getY()) {
            return true;
        }
        if (ee.getX() - 1 == path.getPoint(ee.currentTarget()).getX() && ee.getY() == path.getPoint(ee.currentTarget()).getY()) {
            return true;
        }
        if (ee.getX() == path.getPoint(ee.currentTarget()).getX() && ee.getY() - 1 == path.getPoint(ee.currentTarget()).getY()) {
            return true;
        }
        if (ee.getX() + 1 == path.getPoint(ee.currentTarget()).getX() && ee.getY() == path.getPoint(ee.currentTarget()).getY()) {
            return true;
        }
        if (ee.getX() == path.getPoint(ee.currentTarget()).getX() && ee.getY() + 1 == path.getPoint(ee.currentTarget()).getY()) {
            return true;
        }
        if (ee.getX() - 1 == path.getPoint(ee.currentTarget()).getX() && ee.getY() - 1 == path.getPoint(ee.currentTarget()).getY()) {
            return true;
        }
        if (ee.getX() + 1 == path.getPoint(ee.currentTarget()).getX() && ee.getY() + 1 == path.getPoint(ee.currentTarget()).getY()) {
            return true;
        }
        return false;
    }

    /**
     * Tests for remaining lives and invokes end game screen
     *
     * @param lives
     * @param view
     */
    public static void testForRemainingLives(int lives, GameView view) {
        if (lives <= 0) {

            new GameLostWindow().invokeWarning(view);

        }
    }

    /**
     * Invokes the screen to show player has won the game
     *
     * @param view
     */
    public static void winGame(GameView view) {
        new GameWonWindow().invokeWarning(view);
    }

    public static void testForGenericFiles() {
        
        BufferedImage img = null;
        
        try {
            img = ImageIO.read(new File("src/main/resources/professor.png"));
        } catch (IOException e) {
            new WarningMessage().invokeWarning("Tower Image not Found");
        }
        img = null;
        try {
            img = ImageIO.read(new File("src/main/resources/tutor.png"));
        } catch (IOException e) {
            new WarningMessage().invokeWarning("Tower Image not Found");
        }
        img = null;
        try {
            img = ImageIO.read(new File("src/main/resources/freshman.png"));
        } catch (IOException e) {
            new WarningMessage().invokeWarning("Enemy Image not Found");
        }

    }

}
