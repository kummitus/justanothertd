/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kumpulatd.logic;

import kumpulatd.ui.GameLostWindow;

/**
 *
 * @author antti
 */
public class TestingHelper {

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

    public static void testForRemainingLives(int lives) {
        if (lives <= 0) {

            new GameLostWindow().invokeWarning();

        }
    }

}
