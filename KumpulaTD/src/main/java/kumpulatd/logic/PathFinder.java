/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kumpulatd.logic;

import java.util.List;
import static kumpulatd.logic.TestingHelper.testIfClose;

/**
 * Pathfinder, moves the enemies according to PathFinding class
 * @author antti
 */
public class PathFinder {

    /**
     * Used to move the enemies around the map. 
     * @param enemies Enemies to be moved
     * @param goal Goal location
     * @param path Path location
     * @return Return the moved enemies
     */
    public List<Enemy> testForPathFinding(List<Enemy> enemies, GoalLocation goal, PathFinding path) {
        for (Enemy e : enemies) {
            for (Enemy ee : e.getMembers()) {
                if (ee.currentTarget() < path.getSize()) {
                    if (ee.getX() == goal.getX() && ee.getY() == goal.getY()) {

                    }
                    if (testIfClose(ee, path)) {
                        ee.increaseTarget();
                    }
                    
                    if (Math.abs(ee.getX() - path.getPoint(ee.currentTarget()).getX()) >= Math.abs(ee.getY() - path.getPoint(ee.currentTarget()).getY())) {
                        if (ee.getX() >= path.getPoint(ee.currentTarget()).getX()) {
                            ee.setX(ee.getX() - 1);
                        } else {
                            ee.setX(ee.getX() + 1);
                        }
                    } else if (ee.getY() >= path.getPoint(ee.currentTarget()).getY()) {
                        ee.setY(ee.getY() - 1);
                    } else {
                        ee.setY(ee.getY() + 1);
                    }
                }
            }
        }
        return enemies;
    }
}
