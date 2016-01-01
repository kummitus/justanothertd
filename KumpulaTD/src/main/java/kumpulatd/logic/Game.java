/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kumpulatd.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import kumpulatd.ui.WarningMessage;

/**
 *
 * @author kummi
 */
public final class Game {

    private List<Enemy> enemies;
    private List<Tower> towers;
    private List<Ammunition> ammunition;
    private List<SpawnLocation> spawns;
    private final GoalLocation goal;
    private PathFinding path;
    private List<TowerLocation> towerlocations;

    public Game() {
        initLists();
        goal = new GoalLocation(350, 220);
        initPath();
        initTowers();

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

    public void update(int frame) {
        spawnEnemies1(frame);

        testForPathFinding();
    }

    private void testForPathFinding() {
        for (Enemy e : enemies) {
            for (Enemy ee : e.getMembers()) {
                if (ee.getX() == goal.getX() && ee.getY() == goal.getY()) {

                }
                //System.out.println(ee.currentTarget() + "" + ee.getX() + "" + ee.getY());
                if (testIfClose(ee)) {
                    ee.increaseTarget();
                    if (ee.currentTarget() > path.getSize()) {
                        new WarningMessage().invokeWarning();
                    }

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

    boolean testIfClose(Enemy ee) {
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

    public List<Enemy> getEnemies() {
        return enemies;
    }

    public List<Tower> getTowers() {
        return towers;
    }

    public List<Ammunition> getAmmunition() {
        return ammunition;
    }

    private void initPath() {
        path = new PathFinding();
        path.addPoint(642, 555);
        path.addPoint(483, 563);
        path.addPoint(470, 521);
        path.addPoint(550, 440);
        path.addPoint(350, 220);
    }

    public List<SpawnLocation> getSpawns() {
        return spawns;
    }

    public PathFinding path() {
        return path;
    }

    public List<String> infoDraw() {
        StringBuilder str;
        List<String> list = new ArrayList<>();
        int i = 1;
        int j = 0;
        for (TowerLocation location : towerlocations) {
            str = new StringBuilder();
            str.append("Tower ").append(i).append(": ");
            for (Tower tower : towers) {
                if (tower.getLocation().equals(location)) {
                    str.append(tower.getName());
                    j++;
                }
            }
            if(j == 0){
                str.append("empty");
            }
            list.add(str.toString());
            i++;
            
        }
        return list;
    }

    private void initTowers() {
        towerlocations.add(new TowerLocation(530, 588));
        towerlocations.add(new TowerLocation(468, 505));
        towerlocations.add(new TowerLocation(524, 370));
        towerlocations.add(new TowerLocation(370, 266));
    }

    public GoalLocation getGoal() {
        return goal;
    }

}
