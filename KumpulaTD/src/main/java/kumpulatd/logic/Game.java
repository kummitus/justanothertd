/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kumpulatd.logic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import static kumpulatd.logic.TestingHelper.testForRemainingLives;
import kumpulatd.ui.GameView;

/**
 *
 * @author kummi
 */
public final class Game {

    private List<Enemy> enemies;
    private List<Tower> towers;
    private List<Ammunition> ammunition;
    private List<SpawnLocation> spawns;
    private GoalLocation goal;
    private PathFinding path;
    private List<TowerLocation> towerlocations;
    private PathFinder pathFinder;
    private int lives;
    private boolean endGameInvoked;

    public Game() {
        initLists();
        initGoal();
        initPath();
        initTowers();
        lives = 1;
        endGameInvoked = true;
    }

    private void initGoal() {
        goal = new GoalLocation(350, 220);
    }

    private void initLists() {
        enemies = new ArrayList<>();
        towers = new ArrayList<>();
        ammunition = new ArrayList<>();
        spawns = new ArrayList<>();
        spawns.add(new SpawnLocation(668, 723));
        spawns.add(new SpawnLocation(660, 550));
        towerlocations = new ArrayList<>();
    }

    private void initPath() {
        pathFinder = new PathFinder();
        path = new PathFinding();
        path.addPoint(642, 555);
        path.addPoint(483, 563);
        path.addPoint(470, 521);
        path.addPoint(550, 440);
        path.addPoint(350, 220);
    }

    private void initTowers() {
        towerlocations.add(new TowerLocation(530, 588));
        towerlocations.add(new TowerLocation(468, 505));
        towerlocations.add(new TowerLocation(524, 370));
        towerlocations.add(new TowerLocation(370, 266));
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

    public List<SpawnLocation> getSpawns() {
        return spawns;
    }

    public GoalLocation getGoal() {
        return goal;
    }

    public PathFinding getPath() {
        return path;
    }

    public void update(int frame, GameView view) {

        if (lives >= 1) {
            removeSurvivedEnemies();
            removeDeadEnemies();

            spawnEnemies1(frame);

            enemies = pathFinder.testForPathFinding(enemies, goal, path);
        } else if (lives == 0) {
            if (endGameInvoked) {
                removeSurvivedEnemies();
                removeDeadEnemies();
                endGameInvoked = false;
                testForRemainingLives(lives, view);
                //view.stopTimer();
                
            }
        }

    }

    private void spawnEnemies1(int frame) {
        if (frame % 30 == 0) {
            int random = new Random().nextInt(2);
            int x = spawns.get(random).getX();
            int y = spawns.get(random).getY();
            EnemyGroup group = new EnemyGroup();
            group.addMember(new Fuksi(x, y));
            enemies.add(group);
        }
    }

    public List<String> getInfoString() {
        StringBuilder str;
        List<String> list = new ArrayList<>();
        int i = 1;
        int j = 0;
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
        return list;
    }

    public void buyTower(int currentTower) {
        boolean test = true;
        if (currentTower - 1 < towerlocations.size() && currentTower >= 0) {
            for (Tower tower : towers) {
                if (tower.getLocation() == towerlocations.get(currentTower - 1)) {
                    test = false;
                }
            }
            if (test) {
                towers.add(new Tutor(towerlocations.get(currentTower - 1)));
            }
        }
    }

    
    public void sellTower(int currentTower) {
        boolean test = false;
        if (currentTower - 1 < towerlocations.size() && currentTower >= 0) {
            for (Tower tower : towers) {
                if (tower.getLocation() == towerlocations.get(currentTower - 1)) {
                    test = true;
                }
            }
            if (test) {
                Iterator itr = towers.iterator();
                while (itr.hasNext()) {
                    Tower lct = (Tower) itr.next();
                    if (towerlocations.get(currentTower - 1).equals(lct.getLocation())) {
                        itr.remove();
                    }
                }
            }
        }
    }

    private void removeDeadEnemies() {
        Iterator itr = enemies.iterator();
        while (itr.hasNext()) {
            Enemy group = (Enemy) itr.next();
            List<Enemy> grouplist = group.getMembers();
            Iterator finalitr = grouplist.iterator();
            while (finalitr.hasNext()) {
                Enemy enemy = (Enemy) finalitr.next();
                if (enemy.getHP() <= 0) {
                    finalitr.remove();
                }
            }
            if (group.getMembers().isEmpty()) {
                itr.remove();
            }
        }
    }

    private void removeSurvivedEnemies() {
        Iterator itr = enemies.iterator();
        while (itr.hasNext()) {
            Enemy group = (Enemy) itr.next();
            List<Enemy> grouplist = group.getMembers();
            Iterator finalitr = grouplist.iterator();
            while (finalitr.hasNext()) {
                Enemy enemy = (Enemy) finalitr.next();
                if (enemy.currentTarget() > path.getSize() - 1) {
                    finalitr.remove();
                    lives--;
                }
            }
            if (group.getMembers().isEmpty()) {
                itr.remove();
            }
        }
    }

}
