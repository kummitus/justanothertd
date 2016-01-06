/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.kumpulatd.logic;

import dev.kumpulatd.objects.Freshman;
import dev.kumpulatd.objects.SpawnLocation;
import dev.kumpulatd.ui.GameView;
import dev.kumpulatd.ui.Window;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author kummi
 */
public class GameTest {

    Game game;

    /**
     *
     */
    public GameTest() {
    }

    /**
     *
     */
    @Before
    public void setUp() {
        List<String> list = new ArrayList<>();
        list.add("src/main/resources/background.png");
        list.add("668,723,660,550");
        list.add("350,220");
        list.add("642,555,483,563,470,521,550,440,350,220");
        list.add("530,588,468,505,524,370,370,266");
        list.add("1");
        list.add("30");
        game = new Game(list);
    }

    /**
     *
     */
    @Test
    public void nullEnemies() {
        assertEquals(new ArrayList<>(), game.getEnemies());
    }

    /**
     *
     */
    @Test
    public void nullTowers() {
        assertEquals(new ArrayList<>(), game.getTowers());
    }

    /**
     *
     */
    @Test
    public void nullAmmunition() {
        assertEquals(new ArrayList<>(), game.getAmmunition());
    }

    /**
     *
     */
    @Test
    public void firstSpawnFrame() {
        game.update(30, new GameView(new Window(), "kumpula"));
        for (SpawnLocation sl : game.getSpawns()) {
            if (sl.getX() == game.getEnemies().get(0).getMembers().get(0).getX() && sl.getY() == game.getEnemies().get(0).getMembers().get(0).getY()) {
                assertEquals(new ArrayList<>().add(new Freshman(sl.getX(), sl.getY())), game.getEnemies().get(0).getMembers());

            }
        }

    }

    /**
     *
     */
    @Test
    public void testPathPoints() {
        assertEquals(game.getPath().getPoints(), game.getPath().getPoints());
        assertEquals(642, game.getPath().getPoint(0).getX());
        assertEquals(555, game.getPath().getPoint(0).getY());
        assertEquals(483, game.getPath().getPoint(1).getX());
        assertEquals(563, game.getPath().getPoint(1).getY());
        assertEquals(470, game.getPath().getPoint(2).getX());
        assertEquals(521, game.getPath().getPoint(2).getY());
        assertEquals(550, game.getPath().getPoint(3).getX());
        assertEquals(440, game.getPath().getPoint(3).getY());
        assertEquals(350, game.getPath().getPoint(4).getX());
        assertEquals(220, game.getPath().getPoint(4).getY());

    }

    /**
     *
     */
    @Test
    public void testGoalLocation() {
        assertEquals(350, game.getGoal().getX());
        assertEquals(220, game.getGoal().getY());
    }

    /**
     *
     */
    @Test
    public void testTowerLocations1() {
        game.buyTower(1, "Tutor");
        assertEquals(530, game.getTowers().get(0).getLocation().getX());
        assertEquals(588, game.getTowers().get(0).getLocation().getY());
    }

    /**
     *
     */
    @Test
    public void testTowerLocations2() {
        game.buyTower(2, "Tutor");
        assertEquals(468, game.getTowers().get(0).getLocation().getX());
        assertEquals(505, game.getTowers().get(0).getLocation().getY());
    }

    /**
     *
     */
    @Test
    public void testTowerLocations3() {
        game.buyTower(3, "Tutor");
        assertEquals(524, game.getTowers().get(0).getLocation().getX());
        assertEquals(370, game.getTowers().get(0).getLocation().getY());
    }

    /**
     *
     */
    @Test
    public void testTowerLocations4() {
        game.buyTower(4, "Tutor");
        assertEquals(370, game.getTowers().get(0).getLocation().getX());
        assertEquals(266, game.getTowers().get(0).getLocation().getY());
    }

    /**
     *
     */
    @Test
    public void testNonExistingTower() {
        game.buyTower(5, "Tutor");
        game.buyTower(0, "Tutor");
        assertEquals(new ArrayList<>(), game.getTowers());
    }

    /**
     *
     */
    @Test
    public void sellTower() {
        game.buyTower(4, "Tutor");
        game.sellTower(4, "Tutor");
        assertEquals(new ArrayList<>(), game.getTowers());
    }

    /**
     *
     */
    @Test
    public void sellNonExistingTower() {
        game.buyTower(4, "Tutor");
        game.sellTower(5, "Tutor");
        game.sellTower(0, "Tutor");
        assertEquals(370, game.getTowers().get(0).getLocation().getX());
    }

    /**
     *
     */
    @Test
    public void tryReplacingTower() {
        game.buyTower(4, "Tutor");
        game.buyTower(4, "Tutor");
        assertEquals(370, game.getTowers().get(0).getLocation().getX());
    }

    /**
     *
     */
    @Test
    public void buyTowers() {
        game.buyTower(4, "Tutor");
        game.buyTower(4, "Tutor");
        assertEquals(370, game.getTowers().get(0).getLocation().getX());
        assertEquals(1, game.getTowers().size());
    }

    /**
     *
     */
    @Test
    public void testSpawns() {
        assertEquals(668, game.getSpawns().get(0).getX());
        assertEquals(723, game.getSpawns().get(0).getY());
        assertEquals(660, game.getSpawns().get(1).getX());
        assertEquals(550, game.getSpawns().get(1).getY());
    }

    /**
     *
     */
    @Test
    public void testInfoString() {
        List<String> list = new ArrayList<>();
        list.add("Money: 30");
        list.add("Remaining lives: 1");
        list.add("Tower 1: empty");
        list.add("Tower 2: empty");
        list.add("Tower 3: empty");
        list.add("Tower 4: empty");
        list.add("");
        list.add("Press number key to select tower");
        list.add("Press 'a' to buy Tutor tower, costs 30");
        list.add("Press 's' to sell Tutor tower, sells for 20");
        list.add("Press 'd' to upgrade Tutor, costs 15");
        list.add("");
        list.add("Press 'q' to buy Professor tower, costs 40");
        list.add("Press 'w' to sell Professor tower, sells for 25");
        list.add("Press 'e' to upgrade Professor, costs 15");
        list.add("");
        list.add("");
        list.add("Enemies: ");
        
        assertEquals(game.getInfoString(), list);
    }

    /**
     *
     */
    @Test
    public void testInfoString1() {
        game.buyTower(1, "Tutor");
        game.buyTower(2, "Tutor");
        game.buyTower(3, "Tutor");
        game.buyTower(4, "Tutor");
        List<String> list = new ArrayList<>();
        list.add("Money: 0");
        list.add("Remaining lives: 1");
        list.add("Tower 1: Tutor");
        list.add("Tower 2: ");
        list.add("Tower 3: ");
        list.add("Tower 4: ");
        list.add("");
        list.add("Press number key to select tower");
        list.add("Press 'a' to buy Tutor tower, costs 30");
        list.add("Press 's' to sell Tutor tower, sells for 20");
        list.add("Press 'd' to upgrade Tutor, costs 15");
        list.add("");
        list.add("Press 'q' to buy Professor tower, costs 40");
        list.add("Press 'w' to sell Professor tower, sells for 25");
        list.add("Press 'e' to upgrade Professor, costs 15");
        list.add("");
        list.add("Tower: 1");
        list.add("Damage: 5");
        list.add("Range: 150");
        list.add("Type: 1");
        list.add("");
        list.add("Enemies: ");
        
        assertEquals(game.getInfoString(), list);
    }

    /**
     *
     */
    @Test
    public void getToEnd() {
        for (int i = 0; i < 1000; i++) {
            game.update(i, new GameView(new Window(), "kumpula"));
        }

    }

}
