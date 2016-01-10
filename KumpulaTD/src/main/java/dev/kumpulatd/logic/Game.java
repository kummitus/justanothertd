/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.kumpulatd.logic;

import dev.kumpulatd.objects.Ammunition;
import dev.kumpulatd.objects.Enemy;
import dev.kumpulatd.objects.GoalLocation;
import dev.kumpulatd.objects.SpawnLocation;
import dev.kumpulatd.objects.Tower;
import dev.kumpulatd.objects.TowerLocation;
import java.util.ArrayList;
import java.util.List;
import static dev.kumpulatd.logic.TestingHelper.loseGame;
import static dev.kumpulatd.logic.TestingHelper.winGame;
import static dev.kumpulatd.logic.EnemyManager.removeSurvivedEnemies;
import static dev.kumpulatd.logic.EnemyManager.removeDeadEnemies;
import dev.kumpulatd.ui.GameView;
import dev.kumpulatd.ui.WarningMessage;
import java.awt.image.BufferedImage;

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
    private List<BufferedImage> imagelist;

    /**
     * Constructor for the game class
     *
     *
     * @param list Takes configuration as parameter of which it creates the
     * played map
     */
    public Game(List<String> list) {
        enemies = new ArrayList<>();
        towers = new ArrayList<>();
        ammunition = new ArrayList<>();
        spawns = new ArrayList<>();
        pathFinder = new PathFinder();
        path = new PathFinding();
        imagelist = new ArrayList<>();
        towerlocations = new ArrayList<>();
        Initializer.initImages(imagelist);
        Initializer.initLists(list.get(1), spawns, towerlocations);
        goal = Initializer.initGoal(list.get(2), goal);
        Initializer.initPath(list.get(3), path);
        Initializer.initTowers(list.get(4), towerlocations);
        try {
            lives = Integer.parseInt(list.get(5));
            money = Integer.parseInt(list.get(6));
        } catch (Exception e) {
            new WarningMessage().invokeWarning("Map file corrupt");
        }
        endGameInvoked = true;
    }

    /**
     *
     */
    public Game() {
        lives = 0;
        endGameInvoked = false;
        money = 0;
        enemies = new ArrayList<>();
        towers = new ArrayList<>();
        ammunition = new ArrayList<>();
        spawns = new ArrayList<>();
        goal = new GoalLocation(1, 1);
        towerlocations = new ArrayList<>();
        path = new PathFinding();
        pathFinder = new PathFinder();
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
     *
     * @return Returns towerlocations
     */
    public List<TowerLocation> getTowerLocations() {
        return towerlocations;
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

            info = removeSurvivedEnemies(new GameInfo(enemies, path, lives));
            enemies = info.getEnemies();
            lives = info.getLives();
            info = removeDeadEnemies(new GameInfo(enemies, money));
            enemies = info.getEnemies();
            money = info.getMoney();
            EnemyManager.targetEnemies(frame, towers, enemies, ammunition, imagelist);
            AmmoManager.removeDeadAmmo(ammunition);
            PathFinder.moveAmmo(ammunition);
            EnemyManager.damageEnemies(ammunition, enemies);
            if (frame < 10000) {
                EnemyManager.spawnEnemies1(frame, enemies, imagelist, spawns);
            }
            enemies = pathFinder.testForPathFinding(enemies, goal, path);

            if (frame > 10000 && enemies.isEmpty() && endGameInvoked) {
                endGameInvoked = false;
                winGame(view);
            }
        } else if (lives == 0) {
            if (endGameInvoked) {
                removeSurvivedEnemies(new GameInfo(enemies, path, lives));
                info = removeDeadEnemies(new GameInfo(enemies, money));
                enemies = info.getEnemies();
                money = info.getMoney();
                endGameInvoked = false;
                loseGame(view);
            }
        }
    }

    /**
     *
     * @param view
     */
    public void update(GameView view) {
    }

    /**
     *
     * @return Gathers the required information from the game and gives it back
     * to view to show player interesting information
     */
    public List<String> getInfoString() {
        return GameInfo.infoBuilder(towerlocations, towers, enemies, money, lives);
    }

    /**
     *
     * @param money
     */
    public void setMoney(int money) {
        this.money = money;
    }

    /**
     *
     * @param currentTower
     * @param tow
     */
    public void buyTower(int currentTower, String tow) {
        TowerManager.buyTower(currentTower, tow, money, towerlocations, towers, imagelist, this);
    }

    /**
     *
     * @param currentTower
     * @param tow
     */
    public void sellTower(int currentTower, String tow) {
        TowerManager.sellTower(currentTower, tow, money, towerlocations, towers, this);
    }

    /**
     *
     * @param currentTower
     * @param tow
     */
    public void upgradeTower(int currentTower, String tow) {
        TowerManager.upgradeTower(currentTower, tow, money, towerlocations, towers, this);
    }

    /**
     *
     * @param view
     */
    public void runCommand(GameView view) {
        CommandHandler.handleCommand(view.getCurrentCommand(), view.getCurrentTower(), this, view);
    }
}
