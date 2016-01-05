/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.kumpulatd.logic;

import dev.kumpulatd.objects.Enemy;
import java.util.List;

/**
 *
 * @author kummi
 */
public class GameInfo {

    private List<Enemy> enemies;
    private PathFinding path;
    private int lives;
    private int money;

    public GameInfo(List<Enemy> enemies, PathFinding path, int lives) {
        this.enemies = enemies;
        this.path = path;
        this.lives = lives;
    }

    public GameInfo(List<Enemy> enemies, int money) {
        this.enemies = enemies;
        this.money = money;
    }

    public List<Enemy> getEnemies() {
        return enemies;
    }

    public PathFinding getPath() {
        return path;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int i) {
        lives = i;
    }

    public void IncreaseMoney() {
        money++;
    }

    public int getMoney() {
        return money;
    }

}
