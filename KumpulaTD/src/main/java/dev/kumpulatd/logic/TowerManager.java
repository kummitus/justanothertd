/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.kumpulatd.logic;

import dev.kumpulatd.objects.Professor;
import dev.kumpulatd.objects.Tower;
import dev.kumpulatd.objects.TowerLocation;
import dev.kumpulatd.objects.Tutor;
import java.awt.image.BufferedImage;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author kummi
 */
public class TowerManager {

    /**
     *
     * @param currentTower Gives the tower location to be manipulated to the
     * logic and tries to perform action on it
     * @param tow
     * @param money
     * @param towerlocations
     * @param towers
     * @param imagelist
     * @param game
     */
    public static void buyTower(int currentTower, String tow, int money, List<TowerLocation> towerlocations, List<Tower> towers, List<BufferedImage> imagelist, Game game) {
        boolean test = true;

        if (currentTower - 1 < towerlocations.size() && currentTower > 0) {
            for (Tower tower : towers) {
                if (tower.getLocation() == towerlocations.get(currentTower - 1)) {
                    test = false;
                }
            }
            if (test) {
                if (money >= 75) {
                    if (tow.equals("Tutor")) {
                        money -= 75;
                        towers.add(new Tutor(towerlocations.get(currentTower - 1), imagelist.get(2)));
                    }
                }

                if (money >= 125) {
                    if (tow.equals("Professor")) {
                        money -= 125;
                        towers.add(new Professor(towerlocations.get(currentTower - 1), imagelist.get(3)));
                    }
                }
            }
        }
        game.setMoney(money);
    }

    /**
     *
     * @param currentTower Gives the tower location to be manipulated to the
     * logic and tries to perform action on it
     * @param tow Towertype to be sold
     * @param money
     * @param towerlocations
     * @param towers
     * @param game
     */
    public static void sellTower(int currentTower, String tow, int money, List<TowerLocation> towerlocations, List<Tower> towers, Game game) {
        boolean test = false;
        if (currentTower - 1 < towerlocations.size() && currentTower > 0) {
            for (Tower tower : towers) {
                if (tower.getLocation() == towerlocations.get(currentTower - 1)) {
                    test = true;
                }
            }
            if (test) {
                if (tow.equals("Tutor")) {
                    money += 38;
                } else if (tow.equals("Professor")) {
                    money += 63;
                }
                Iterator itr = towers.iterator();
                while (itr.hasNext()) {
                    Tower lct = (Tower) itr.next();
                    if (towerlocations.get(currentTower - 1).equals(lct.getLocation())) {
                        itr.remove();
                    }
                }
            }
        }
        game.setMoney(money);
    }

    /**
     *
     * @param currentTower Gives the method tower on which upgrade is attempted
     * @param tow Gives the towers type
     * @param money
     * @param towerlocations
     * @param towers
     * @param game
     */
    public static void upgradeTower(int currentTower, String tow, int money, List<TowerLocation> towerlocations, List<Tower> towers, Game game) {
        boolean test = false;
        if (money >= 200) {
            if (currentTower - 1 < towerlocations.size() && currentTower > 0) {
                for (Tower tower : towers) {
                    if (tower.getLocation() == towerlocations.get(currentTower - 1)) {
                        test = true;
                    }
                }
                if (test) {
                    money -= 200;
                    for (Tower lct : towers) {
                        if (towerlocations.get(currentTower - 1).equals(lct.getLocation())) {
                            lct.upgrade();
                        }
                    }
                }
            }
        }
        game.setMoney(money);
    }

}
