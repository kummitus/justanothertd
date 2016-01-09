/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.kumpulatd.logic;

import dev.kumpulatd.objects.Enemy;
import dev.kumpulatd.objects.GoalLocation;
import java.util.List;
import static dev.kumpulatd.logic.TestingHelper.testIfClose;
import dev.kumpulatd.objects.Ammunition;

/**
 * Pathfinder, moves the enemies according to PathFinding class
 *
 * @author antti
 */
public class PathFinder {

    /**
     * Pathfinder, moves the ammunition according to PathFinding class
     *
     * 
     * @param ammunition
     */
    public static void moveAmmo(List<Ammunition> ammunition) {
        for (Ammunition ammo : ammunition) {
            if (Math.abs(ammo.getEnemy().getX() - ammo.getX()) >= Math.abs(ammo.getEnemy().getY() - ammo.getY())) {
                if (ammo.getEnemy().getX() >= ammo.getX()) {
                    int i = ammo.getX() + 4;
                    if (i > 0) {
                        ammo.setX(4);
                    } else {
                        ammo.setX(ammo.getEnemy().getX());
                    }
                } else {
                    int i = ammo.getX() - 4;
                    if (i > 0) {
                        ammo.setX(-4);
                    } else {
                        ammo.setX(ammo.getEnemy().getX());
                    }
                }
            } else if (ammo.getEnemy().getY() >= ammo.getY()) {
                int i = ammo.getY() + 4;
                if (i > 0) {
                    ammo.setY(4);
                } else {
                    ammo.setY(ammo.getEnemy().getX());
                }
            } else {
                int i = ammo.getY() - 4;
                if (i > 0) {
                    ammo.setY(-4);
                } else {
                    ammo.setY(ammo.getEnemy().getX());
                }
            }
            if(Math.abs(ammo.getX()-ammo.getEnemy().getX()) < 10 && Math.abs(ammo.getY()-ammo.getEnemy().getY()) < 10){
                ammo.setOnTarget();
            }
        }
    }

    /**
     * Used to move the enemies around the map.
     *
     * @param enemies Enemies to be moved
     * @param goal Goal location
     * @param path Path location
     * @return Return the moved enemies
     */
    public List<Enemy> testForPathFinding(List<Enemy> enemies, GoalLocation goal, PathFinding path) {
        for (Enemy e : enemies) {
            //for (Enemy ee : e.getMembers()) {
                if (e.currentTarget() < path.getSize()) {

                    if (testIfClose(e, path)) {
                        e.increaseTarget();
                    }

                    moveEnemies(e, path);
                }
            //}
        }
        return enemies;
    }

    private void moveEnemies(Enemy ee, PathFinding path) {
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
