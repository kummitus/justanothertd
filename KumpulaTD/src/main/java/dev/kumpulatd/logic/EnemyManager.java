/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.kumpulatd.logic;

import dev.kumpulatd.objects.Ammunition;
import dev.kumpulatd.objects.Enemy;
import dev.kumpulatd.objects.Freshman;
import dev.kumpulatd.objects.ProfessorAmmo;
import dev.kumpulatd.objects.SpawnLocation;
import dev.kumpulatd.objects.Tower;
import dev.kumpulatd.objects.TowerLocation;
import dev.kumpulatd.objects.TutorAmmo;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * Manages enemies actions
 *
 * @author kummi
 */
public class EnemyManager {

    /**
     *
     * @param info Game gives the manager the game info
     * @return returns modified game info
     */
    public static GameInfo removeDeadEnemies(GameInfo info) {
        Iterator itr = info.getEnemies().iterator();
//        while (itr.hasNext()) {
//            Enemy group = (Enemy) itr.next();
//            List<Enemy> grouplist = group.getMembers();
//            Iterator finalitr = grouplist.iterator();
        while (itr.hasNext()) {
            Enemy enemy = (Enemy) itr.next();
            if (enemy.getHP() <= 0) {
                info.IncreaseMoney();
                itr.remove();
            }

//            if (group.getMembers().isEmpty()) {
//                itr.remove();
        }

        return info;
    }

    /**
     *
     * @param info Game gives the manager the game info
     * @return returns modified game info
     */
    public static GameInfo removeSurvivedEnemies(GameInfo info) {
        Iterator itr = info.getEnemies().iterator();
        while (itr.hasNext()) {
            //Enemy group = (Enemy) itr.next();
            //List<Enemy> grouplist = group.getMembers();
            //Iterator finalitr = grouplist.iterator();
            //while (finalitr.hasNext()) {
            Enemy enemy = (Enemy) itr.next();
            if (enemy.currentTarget() > info.getPath().getSize() - 1) {
                itr.remove();
                info.setLives(info.getLives() - 1);
            }
            //}
//            if (group.getMembers().isEmpty()) {
//                itr.remove();
//            }
        }

        return info;
    }

    /**
     *
     * @param frame
     * @param spawns
     * @param imagelist
     * @param enemies
     */
    public static void spawnEnemies1(int frame, List<Enemy> enemies, List<BufferedImage> imagelist, List<SpawnLocation> spawns) {
        if (frame % 45 == 0 && frame < 2500) {
            int random = new Random().nextInt(2);
            int x = spawns.get(random).getX();
            int y = spawns.get(random).getY();
            enemies.add(new Freshman(x, y, imagelist.get(new Random().nextInt(2))));
        }
        if (frame % 35 == 0 && frame > 2500 && frame < 4000) {
            int random = new Random().nextInt(2);
            int x = spawns.get(random).getX();
            int y = spawns.get(random).getY();
            enemies.add(new Freshman(x, y, imagelist.get(new Random().nextInt(2))));
            enemies.add(new Freshman(x - new Random().nextInt(15), y + new Random().nextInt(15), imagelist.get(new Random().nextInt(2))));
        }
        if (frame % 25 == 0 && frame > 4000 && frame < 8000) {
            int random = new Random().nextInt(2);
            int x = spawns.get(random).getX();
            int y = spawns.get(random).getY();
            enemies.add(new Freshman(x, y, imagelist.get(new Random().nextInt(2))));
            enemies.add(new Freshman(x - new Random().nextInt(15), y + new Random().nextInt(15), imagelist.get(new Random().nextInt(2))));
            enemies.add(new Freshman(x + new Random().nextInt(15), y - new Random().nextInt(15), imagelist.get(new Random().nextInt(2))));
            enemies.add(new Freshman(x - new Random().nextInt(30), y + new Random().nextInt(30), imagelist.get(new Random().nextInt(2))));
        }
        if (frame % 20 == 0 && frame > 8000) {
            int random = new Random().nextInt(2);
            int x = spawns.get(random).getX();
            int y = spawns.get(random).getY();
            enemies.add(new Freshman(x, y, imagelist.get(new Random().nextInt(2))));
            enemies.add(new Freshman(x - new Random().nextInt(15), y + new Random().nextInt(15), imagelist.get(new Random().nextInt(2))));
            enemies.add(new Freshman(x + new Random().nextInt(15), y - new Random().nextInt(15), imagelist.get(new Random().nextInt(2))));
            enemies.add(new Freshman(x - new Random().nextInt(35), y + new Random().nextInt(35), imagelist.get(new Random().nextInt(2))));
            enemies.add(new Freshman(x + new Random().nextInt(35), y - new Random().nextInt(35), imagelist.get(new Random().nextInt(2))));
            enemies.add(new Freshman(x - new Random().nextInt(55), y + new Random().nextInt(55), imagelist.get(new Random().nextInt(2))));
            enemies.add(new Freshman(x + new Random().nextInt(55), y - new Random().nextInt(55), imagelist.get(new Random().nextInt(2))));
        }
    }

    /**
     *
     * @param ammunition
     * @param enemies
     */
    public static void damageEnemies(List<Ammunition> ammunition, List<Enemy> enemies) {
        Iterator itr = ammunition.iterator();
        List<Enemy> damaged = new ArrayList<>();
        while (itr.hasNext()) {
            Ammunition ammo = (Ammunition) itr.next();
            if (ammo.getCounter() > 0) {
                if (ammo.getType() == 1) {
                    ammo.getEnemy().damage(ammo.getType(), ammo.getAmount());
                    damaged.add(ammo.getEnemy());
                } else if (ammo.getType() == 2) {
                    for (Enemy ee : enemies) {
                        if (isClose(ee.getX(), ee.getY(), new TowerLocation(ammo.getX(), ammo.getY()), ammo.getRadius())) {
                            if (damaged.contains(ee)) {

                            } else {
                                ee.damage(ammo.getType(), ammo.getAmount());
                                damaged.add(ee);
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     *
     * @param frame
     * @param towers
     * @param enemies
     * @param ammunition
     * @param imagelist
     */
    public static void targetEnemies(int frame, List<Tower> towers, List<Enemy> enemies, List<Ammunition> ammunition, List<BufferedImage> imagelist) {
        if (frame % 4 == 0) {
            for (Tower tower : towers) {
                if (tower.getName().equals("Tutor")) {
                    Enemy e = getClosestEnemey(tower, enemies);
                    try {
                        ammunition.add(new TutorAmmo(tower.getLocation().getX(), tower.getLocation().getY(), e, tower.damage(), tower.damageType(), imagelist.get(4)));
                    } catch (Exception ex) {

                    }
                }
            }
        }
        if (frame % 8 == 0) {
            for (Tower tower : towers) {
                if (tower.getName().equals("Professor")) {
                    Enemy e = getClosestEnemey(tower, enemies);
                    ammunition.add(new ProfessorAmmo(tower.getLocation().getX(), tower.getLocation().getY(), e, tower.damage(), tower.damageType(), imagelist.get(5), tower.getRadius()));
                }
            }
        }
    }

    /**
     *
     * @param tower
     * @param enemies
     * @return
     */
    public static Enemy getClosestEnemey(Tower tower, List<Enemy> enemies) {
        for (Enemy e : enemies) {
            if (isClose(e.getX(), e.getY(), tower.getLocation(), tower.range())) {
                return e;
            }
        }
        return null;
    }

    /**
     *
     * @param x
     * @param y
     * @param location
     * @param range
     * @return
     */
    public static boolean isClose(int x, int y, TowerLocation location, int range) {
        int dx = Math.abs(x - location.getX());
        int dy = Math.abs(y - location.getY());
        if (Math.sqrt(dx * dx + dy * dy) < range) {
            return true;
        }
        return false;
    }
}
