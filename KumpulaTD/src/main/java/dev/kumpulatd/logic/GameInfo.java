/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.kumpulatd.logic;

import dev.kumpulatd.objects.Enemy;
import dev.kumpulatd.objects.Tower;
import dev.kumpulatd.objects.TowerLocation;
import java.util.ArrayList;
import java.util.List;

/**
 * Generates game info object from the information Game class has
 * @author kummi
 */
public class GameInfo {

    private List<Enemy> enemies;
    private PathFinding path;
    private int lives;
    private int money;

    /**
     *
     * @param enemies
     * @param path
     * @param lives
     */
    public GameInfo(List<Enemy> enemies, PathFinding path, int lives) {
        this.enemies = enemies;
        this.path = path;
        this.lives = lives;
    }

    /**
     *
     * @param enemies
     * @param money
     */
    public GameInfo(List<Enemy> enemies, int money) {
        this.enemies = enemies;
        this.money = money;
    }

    /**
     *
     * @return
     */
    public List<Enemy> getEnemies() {
        return enemies;
    }

    /**
     *
     * @return
     */
    public PathFinding getPath() {
        return path;
    }

    /**
     *
     * @return
     */
    public int getLives() {
        return lives;
    }

    /**
     *
     * @param i
     */
    public void setLives(int i) {
        lives = i;
    }

    /**
     * Gives player money when invoked within game info call
     */
    public void IncreaseMoney() {
        money++;
    }

    /**
     *
     * @return
     */
    public int getMoney() {
        return money;
    }

    /**
     * infoBuilder is used to generate List<String> object from game data that is sent for game view to be drawn for the player
     * @param towerlocations
     * @param towers
     * @param eenemies
     * @param money
     * @param lives
     * @return
     */
    public static List<String> infoBuilder(List<TowerLocation> towerlocations, List<Tower> towers, List<Enemy> eenemies, int money, int lives) {
        StringBuilder str;
        List<String> list = new ArrayList<>();
        int i = 1;
        int j = 0;
        str = new StringBuilder();
        str.append("Money: ");
        str.append(money);
        list.add(str.toString());
        str = new StringBuilder();
        str.append("Remaining lives: ");
        str.append(lives);
        list.add(str.toString());
        for (TowerLocation location : towerlocations) {
            str = new StringBuilder();
            str.append("Tower ").append(i).append(": ");
            for (Tower tower : towers) {
                if (tower.getLocation().equals(location)) {
                    str.append(tower.getName());
                    j++;
                }
            }
            if (j == 0) {
                str.append("empty");
            }
            list.add(str.toString());
            i++;
        }
        list = setInfo(str, list, towerlocations, towers, eenemies);
        return list;
    }
    
    private static List<String> setInfo(StringBuilder str, List<String> list, List<TowerLocation> towerlocations, List<Tower> towers, List<Enemy> eenemies) {
        
        list.add("");
        list.add("Press number key to select tower");
        list.add("Press 'a' to buy Tutor tower, costs 75");
        list.add("Press 's' to sell Tutor tower, sells for 38");
        list.add("Press 'd' to upgrade Tutor, costs 200");
        list.add("");
        list.add("Press 'q' to buy Professor tower, costs 125");
        list.add("Press 'w' to sell Professor tower, sells for 63");
        list.add("Press 'e' to upgrade Professor, costs 200");
        str = new StringBuilder();
        str.append("");
        list.add(str.toString());
        list = generateTowerInfo(list, str, towerlocations, towers);
        list = generateEnemyInfo(list, str, eenemies);

        return list;
    }

    private static List<String> generateTowerInfo(List<String> list, StringBuilder str, List<TowerLocation> towerlocations, List<Tower> towers) {

        for (Tower tower : towers) {
            int i = 0;
            for (TowerLocation lct : towerlocations) {
                if (lct.equals(tower.getLocation())) {
                    break;
                }
                i++;
            }
            str = new StringBuilder();
            str.append("Tower: ").append(i + 1);
            list.add(str.toString());
            str = new StringBuilder();
            str.append("Damage: ").append(tower.damage());
            list.add(str.toString());
            str = new StringBuilder();
            str.append("Range: ").append(tower.range());
            list.add(str.toString());
            str = new StringBuilder();
            str.append("Type: ").append(tower.damageType());
            list.add(str.toString());
        }
        return list;
    }

    private static List<String> generateEnemyInfo(List<String> list, StringBuilder str, List<Enemy> eenemies) {
        str = new StringBuilder();
        str.append("");
        list.add(str.toString());
        str = new StringBuilder();
        str.append("Enemies: ");
        list.add(str.toString());
        for (Enemy e : eenemies) {
            //for (Enemy ee : e.getMembers()) {

                str = new StringBuilder();
                str.append("Type: ").append(e.getName()).append(" HP: ").append(e.getHP());
                list.add(str.toString());
            //}
        }
        return list;
    }

}
