/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.kumpulatd.logic;

import dev.kumpulatd.objects.Ammunition;
import dev.kumpulatd.objects.Enemy;
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
import static dev.kumpulatd.logic.TestingHelper.loseGame;
import static dev.kumpulatd.logic.TestingHelper.winGame;
import static dev.kumpulatd.logic.EnemyManager.removeSurvivedEnemies;
import static dev.kumpulatd.logic.EnemyManager.removeDeadEnemies;
import dev.kumpulatd.objects.Professor;
import dev.kumpulatd.objects.ProfessorAmmo;
import dev.kumpulatd.objects.TutorAmmo;
import dev.kumpulatd.ui.GameView;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

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
        initLists(list.get(1));
        initGoal(list.get(2));
        initPath(list.get(3));
        initTowers(list.get(4));
        initImages();
        lives = Integer.parseInt(list.get(5));
        endGameInvoked = true;
        money = Integer.parseInt(list.get(6));

    }

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
        int j = 1;
        for (int i = 0; i < list.length; i += 2) {
            towerlocations.add(new TowerLocation(Integer.parseInt(list[i]), Integer.parseInt(list[i + 1]), j));
            j++;
            if (j > 9) {
                break;
            }
        }
    }

    private void initImages() {
        imagelist = new ArrayList<>();
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("src/main/resources/freshman0.png"));
        } catch (IOException e) {

            img = new BufferedImage(1, 1, 1);

        }
        imagelist.add(img);
        try {
            img = ImageIO.read(new File("src/main/resources/freshman1.png"));
        } catch (IOException e) {

            img = new BufferedImage(1, 1, 1);

        }
        imagelist.add(img);
        try {
            img = ImageIO.read(new File("src/main/resources/tutor.png"));
        } catch (IOException e) {

            img = new BufferedImage(1, 1, 1);

        }
        imagelist.add(img);
        try {
            img = ImageIO.read(new File("src/main/resources/professor.png"));
        } catch (IOException e) {

            img = new BufferedImage(1, 1, 1);

        }
        imagelist.add(img);
        try {
            img = ImageIO.read(new File("src/main/resources/tutorammo.png"));
        } catch (IOException e) {

            img = new BufferedImage(1, 1, 1);

        }
        imagelist.add(img);
        try {
            img = ImageIO.read(new File("src/main/resources/professorammo.png"));
        } catch (IOException e) {

            img = new BufferedImage(1, 1, 1);

        }
        imagelist.add(img);
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
            targetEnemies(frame);
            removeDeadAmmo();
            PathFinder.moveAmmo(ammunition);
            damageEnemies();
            if (frame < 10000) {
                spawnEnemies1(frame);
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

    public void update(GameView view) {
    }

    private void removeDeadAmmo() {
        Iterator itr = ammunition.iterator();
        while (itr.hasNext()) {
            Ammunition ammo = (Ammunition) itr.next();
            if (ammo.getEnemy() == null) {
                itr.remove();
            } else if (ammo.getEnemy().getHP() <= 0) {
                itr.remove();
            } else if (ammo.getCounter() > 1) {
                itr.remove();
            }
        }
    }

    private void damageEnemies() {
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

    private void targetEnemies(int frame) {
        if (frame % 4 == 0) {
            for (Tower tower : towers) {
                if (tower.getName().equals("Tutor")) {
                    Enemy e = getClosestEnemey(tower);
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
                    Enemy e = getClosestEnemey(tower);
                    ammunition.add(new ProfessorAmmo(tower.getLocation().getX(), tower.getLocation().getY(), e, tower.damage(), tower.damageType(), imagelist.get(5), tower.getRadius()));
                }
            }
        }
    }

    private Enemy getClosestEnemey(Tower tower) {
        for (Enemy e : enemies) {
            if (isClose(e.getX(), e.getY(), tower.getLocation(), tower.range())) {
                return e;
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
     * @return Gathers the required information from the game and gives it back
     * to view to show player interesting information
     */
    public List<String> getInfoString() {
        return GameInfo.infoBuilder(towerlocations, towers, enemies, money, lives);
    }

    /**
     *
     * @param currentTower Gives the tower location to be manipulated to the
     * logic and tries to perform action on it
     * @param tow
     */
    public void buyTower(int currentTower, String tow) {
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
    }

    /**
     *
     * @param currentTower Gives the tower location to be manipulated to the
     * logic and tries to perform action on it
     * @param tow Towertype to be sold
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
    }

    /**
     *
     * @param currentTower Gives the method tower on which upgrade is attempted
     * @param tow Gives the towers type
     */
    public void upgradeTower(int currentTower, String tow) {
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
    }
}
