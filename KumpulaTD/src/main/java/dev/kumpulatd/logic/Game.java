/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.kumpulatd.logic;

import dev.kumpulatd.objects.Ammunition;
import dev.kumpulatd.objects.Enemy;
import dev.kumpulatd.objects.EnemyGroup;
import dev.kumpulatd.objects.Freshman;
import dev.kumpulatd.objects.GoalLocation;
import dev.kumpulatd.objects.SpawnLocation;
import dev.kumpulatd.objects.Tower;
import dev.kumpulatd.objects.TowerLocation;
import dev.kumpulatd.objects.Tutor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import static dev.kumpulatd.logic.TestingHelper.testForRemainingLives;
import static dev.kumpulatd.logic.TestingHelper.winGame;
import static dev.kumpulatd.logic.EnemyManager.removeSurvivedEnemies;
import static dev.kumpulatd.logic.EnemyManager.removeDeadEnemies;
import dev.kumpulatd.objects.Professor;
import dev.kumpulatd.ui.GameView;

/**
 * Combines all the game logic found from the game in the update method
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
    private int money;
    private GameInfo info;

    /**
     * Constructor for the game class
     *
     * @param list
     */
    public Game(List<String> list) {
        initLists(list.get(0));
        initGoal(list.get(1));
        initPath(list.get(2));
        initTowers(list.get(3));
        lives = Integer.parseInt(list.get(4));
        endGameInvoked = true;
        money = Integer.parseInt(list.get(5));
    }

    private void initGoal(String row) {
        String[] list = row.split(",");
        goal = new GoalLocation(Integer.parseInt(list[0]), Integer.parseInt(list[1]));
    }

    private void initLists(String row) {
        String[] list = row.split(",");
        enemies = new ArrayList<>();
        towers = new ArrayList<>();
        ammunition = new ArrayList<>();
        spawns = new ArrayList<>();
        for (int i = 0; i < list.length; i += 2) {
            spawns.add(new SpawnLocation(Integer.parseInt(list[i]), Integer.parseInt(list[i + 1])));
        }
        towerlocations = new ArrayList<>();
    }

    private void initPath(String row) {
        String[] list = row.split(",");
        pathFinder = new PathFinder();
        path = new PathFinding();
        for (int i = 0; i < list.length; i += 2) {
            path.addPoint(Integer.parseInt(list[i]), Integer.parseInt(list[i + 1]));
        }
    }

    private void initTowers(String row) {
        String[] list = row.split(",");
        for (int i = 0; i < list.length; i += 2) {
            towerlocations.add(new TowerLocation(Integer.parseInt(list[i]), Integer.parseInt(list[i + 1])));
        }
    }

    /**
     *
     * @return Returns all enemies currently in-game
     */
    public List<Enemy> getEnemies() {
        return enemies;
    }

    /**
     *
     * @return Returns all Towers currently in-game
     */
    public List<Tower> getTowers() {
        return towers;
    }

    /**
     *
     * @return Returns all Ammunition currently in-game
     */
    public List<Ammunition> getAmmunition() {
        return ammunition;
    }

    /**
     *
     * @return Returns all spawn points in map
     */
    public List<SpawnLocation> getSpawns() {
        return spawns;
    }

    /**
     *
     * @return Returns goal location in game
     */
    public GoalLocation getGoal() {
        return goal;
    }

    /**
     *
     * @return Returns the pathfinding associated with the map
     */
    public PathFinding getPath() {
        return path;
    }

    /**
     * Update method is used to process the game logic as whole
     *
     * @param frame Frame is the current frame in the game and is passed from
     * the view
     * @param view View is the frame allocated to the game and is used for
     * callback when the game is finished
     */
    public void update(int frame, GameView view) {

        if (lives >= 1) {
            if (frame < 10000) {
                info = removeSurvivedEnemies(new GameInfo(enemies, path, lives));
                enemies = info.getEnemies();
                lives = info.getLives();
                info = removeDeadEnemies(new GameInfo(enemies, money));
                enemies = info.getEnemies();
                money = info.getMoney();

                damageEnemies(frame);
                spawnEnemies1(frame);

                enemies = pathFinder.testForPathFinding(enemies, goal, path);
            }
            if (frame > 10000 && enemies.isEmpty()) {
                winGame(view);
            }
        } else if (lives == 0) {
            if (endGameInvoked) {
                removeSurvivedEnemies(new GameInfo(enemies, path, lives));
                info = removeDeadEnemies(new GameInfo(enemies, money));
                enemies = info.getEnemies();
                money = info.getMoney();
                endGameInvoked = false;
                testForRemainingLives(lives, view);
                //view.stopTimer();

            }

        }

    }

    private void damageEnemies(int frame) {
        if (frame % 4 == 0) {
            for (Tower tower : towers) {
                if (tower.getName().equals("Tutor")) {
                    Enemy e = getClosestEnemey(tower);
                    try {
                        e.damage(tower.damageType(), tower.damage());
                    } catch (Exception ex) {

                    }
                }
            }
        }
        if (frame % 8 == 0) {
            for (Tower tower : towers) {
                if (tower.getName().equals("Professor")) {
                    Enemy e = getClosestEnemey(tower);
                    try {
                        for (Enemy ee : enemies) {
                            for (Enemy eee : ee.getMembers()) {
                                if (isClose(eee.getX(), eee.getY(), new TowerLocation(e.getX(), e.getY()), 50)) {
                                    eee.damage(tower.damageType(), tower.damage());
                                }
                            }
                        }

                    } catch (Exception ex) {

                    }
                }
            }
        }
    }

    private Enemy getClosestEnemey(Tower tower) {
        for (Enemy e : enemies) {
            for (Enemy ee : e.getMembers()) {
                if (isClose(ee.getX(), ee.getY(), tower.getLocation(), tower.range())) {
                    return ee;
                }
            }
        }
        return null;
    }

    private boolean isClose(int x, int y, TowerLocation location, int range) {
        int dx = Math.abs(x - location.getX());
        int dy = Math.abs(y - location.getY());
        if (Math.sqrt(dx * dx + dy * dy) < range) {
            return true;
        }
        return false;
    }

    private void spawnEnemies1(int frame) {
        if (frame % 30 == 0) {
            int random = new Random().nextInt(2);
            int x = spawns.get(random).getX();
            int y = spawns.get(random).getY();
            EnemyGroup group = new EnemyGroup();
            group.addMember(new Freshman(x, y));
            enemies.add(group);
        }
    }

    /**
     *
     * @return Gathers the required information from the game and gives it back
     * to view to show player interesting information
     */
    public List<String> getInfoString() {
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
        list = setInfo(str, list);
        return list;
    }

    private List<String> setInfo(StringBuilder str, List<String> list) {
        str = new StringBuilder();
        str.append("");
        list.add(str.toString());
        str = new StringBuilder();
        str.append("Press number key to select tower");
        list.add(str.toString());
        str = new StringBuilder();
        str.append("Press 'a' to buy Tutor tower, costs 30");
        list.add(str.toString());
        str = new StringBuilder();
        str.append("Press 's' to sell Tutor tower, sells for 20");
        list.add(str.toString());
        str = new StringBuilder();
        str.append("Press 'd' to upgrade Tutor, costs 15");
        list.add(str.toString());
        str = new StringBuilder();
        str.append("Press number key to select tower");
        list.add(str.toString());
        str = new StringBuilder();
        str.append("");
        list.add(str.toString());
        list = generateTowerInfo(list, str);
        list = generateEnemyInfo(list, str);

        return list;
    }

    private List<String> generateTowerInfo(List<String> list, StringBuilder str) {

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

    private List<String> generateEnemyInfo(List<String> list, StringBuilder str) {
        str = new StringBuilder();
        str.append("");
        list.add(str.toString());
        str = new StringBuilder();
        str.append("Enemies: ");
        list.add(str.toString());
        for (Enemy e : enemies) {
            for (Enemy ee : e.getMembers()) {

                str = new StringBuilder();
                str.append("Type: ").append(ee.getName()).append(" HP: ").append(ee.getHP());
                list.add(str.toString());
            }
        }
        return list;
    }

    /**
     *
     * @param currentTower Gives the tower location to be manipulated to the
     * logic and tries to perform action on it
     * @param tow
     */
    public void buyTower(int currentTower, String tow) {
        boolean test = true;
        if (money >= 30) {
            if (currentTower - 1 < towerlocations.size() && currentTower > 0) {
                for (Tower tower : towers) {
                    if (tower.getLocation() == towerlocations.get(currentTower - 1)) {
                        test = false;
                    }
                }
                if (test) {

                    if (tow.equals("Tutor")) {
                        money -= 30;
                        towers.add(new Tutor(towerlocations.get(currentTower - 1)));
                    }
                    if (tow.equals("Professor")) {
                        money -= 40;
                        towers.add(new Professor(towerlocations.get(currentTower - 1)));
                    }
                }
            }

        }
    }

    /**
     *
     * @param currentTower Gives the tower location to be manipulated to the
     * logic and tries to perform action on it
     * @param tow
     */
    public void sellTower(int currentTower, String tow) {
        boolean test = false;
        if (currentTower - 1 < towerlocations.size() && currentTower > 0) {
            for (Tower tower : towers) {
                if (tower.getLocation() == towerlocations.get(currentTower - 1)) {
                    test = true;
                }
            }
            if (test) {
                if (tow.equals("Tutor")) {
                    money += 20;
                } else if (tow.equals("Professor")) {
                    money += 30;
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
    }

    public void upgradeTower(int currentTower, String tow) {
        boolean test = false;
        if (money >= 15) {
            if (currentTower - 1 < towerlocations.size() && currentTower > 0) {
                for (Tower tower : towers) {
                    if (tower.getLocation() == towerlocations.get(currentTower - 1)) {
                        test = true;
                    }
                }
                if (test) {
                    money -= 15;
                    for (Tower lct : towers) {
                        if (towerlocations.get(currentTower - 1).equals(lct.getLocation())) {
                            lct.upgrade();
                        }
                    }
                }
            }
        }
    }

}
