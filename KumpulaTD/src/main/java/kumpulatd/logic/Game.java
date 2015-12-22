/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kumpulatd.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import kumpulatd.logic.Fuksi;

/**
 *
 * @author kummi
 */
public class Game {
    private List<Enemy> enemies;
    private List<Tower> towers;
    private List<Ammunition> ammunition;
    private List<SpawnLocation> spawns;
    private GoalLocation goal;
    
    
    public Game(){
        enemies = new ArrayList<>();
        towers = new ArrayList<>();
        ammunition = new ArrayList<>();
        spawns = new ArrayList<>();
        spawns.add(new SpawnLocation(668, 723));
        spawns.add(new SpawnLocation(660, 550));
        goal = new GoalLocation(330, 390);
        
    }

    public void update(int frame) {
        if(frame % 30 == 0){
            int random = new Random().nextInt(2);
            int x = spawns.get(random).getX();
            int y = spawns.get(random).getY();
            EnemyGroup group = new EnemyGroup();
            group.addMember(new Fuksi(x, y));
            enemies.add(group);
        }
        
        for (Enemy e : enemies) {
            for (Enemy ee : e.getMembers()) {
                ee.setX(ee.getX() - 2);
                ee.setY(ee.getY() - 2);
            }
        }
    }

    public List<Enemy> getEnemies() {
        return enemies;
    }

    public List<Tower> getTowers() {
        return towers;
    }

    public List<Ammunition> getAmmunition() {
        return ammunition;
    }
    
}
