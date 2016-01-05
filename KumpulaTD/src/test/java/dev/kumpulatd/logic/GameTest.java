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

    public GameTest() {
    }

    @Before
    public void setUp() {
        game = new Game();
    }

    @Test
    public void nullEnemies() {
        assertEquals(new ArrayList<>(), game.getEnemies());
    }

    @Test
    public void nullTowers() {
        assertEquals(new ArrayList<>(), game.getTowers());
    }

    @Test
    public void nullAmmunition() {
        assertEquals(new ArrayList<>(), game.getAmmunition());
    }

    @Test
    public void firstSpawnFrame() {
        game.update(30, new GameView(new Window()));
        for (SpawnLocation sl : game.getSpawns()) {
            if (sl.getX() == game.getEnemies().get(0).getMembers().get(0).getX() && sl.getY() == game.getEnemies().get(0).getMembers().get(0).getY()) {
                assertEquals(new ArrayList<>().add(new Freshman(sl.getX(), sl.getY())), game.getEnemies().get(0).getMembers());

            }
        }

    }

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

    @Test
    public void testGoalLocation() {
        assertEquals(350, game.getGoal().getX());
        assertEquals(220, game.getGoal().getY());
    }

    @Test
    public void testTowerLocations1() {
        game.buyTower(1);
        assertEquals(530, game.getTowers().get(0).getLocation().getX());
        assertEquals(588, game.getTowers().get(0).getLocation().getY());
    }

    @Test
    public void testTowerLocations2() {
        game.buyTower(2);
        assertEquals(468, game.getTowers().get(0).getLocation().getX());
        assertEquals(505, game.getTowers().get(0).getLocation().getY());
    }

    @Test
    public void testTowerLocations3() {
        game.buyTower(3);
        assertEquals(524, game.getTowers().get(0).getLocation().getX());
        assertEquals(370, game.getTowers().get(0).getLocation().getY());
    }

    @Test
    public void testTowerLocations4() {
        game.buyTower(4);
        assertEquals(370, game.getTowers().get(0).getLocation().getX());
        assertEquals(266, game.getTowers().get(0).getLocation().getY());
    }

    @Test
    public void testNonExistingTower() {
        game.buyTower(5);
        game.buyTower(0);
        assertEquals(new ArrayList<>(), game.getTowers());
    }

    @Test
    public void sellTower() {
        game.buyTower(4);
        game.sellTower(4);
        assertEquals(new ArrayList<>(), game.getTowers());
    }

    @Test
    public void sellNonExistingTower() {
        game.buyTower(4);
        game.sellTower(5);
        game.sellTower(0);
        assertEquals(370, game.getTowers().get(0).getLocation().getX());
    }

    @Test
    public void tryReplacingTower() {
        game.buyTower(4);
        game.buyTower(4);
        assertEquals(370, game.getTowers().get(0).getLocation().getX());
    }   
    
    @Test
    public void buyTowers() {
        game.buyTower(4);
        game.buyTower(4);
        assertEquals(370, game.getTowers().get(0).getLocation().getX());
        assertEquals(1, game.getTowers().size());
    }

    @Test
    public void testSpawns() {
        assertEquals(668, game.getSpawns().get(0).getX());
        assertEquals(723, game.getSpawns().get(0).getY());
        assertEquals(660, game.getSpawns().get(1).getX());
        assertEquals(550, game.getSpawns().get(1).getY());
    }

    @Test
    public void testInfoString() {
        List<String> list = new ArrayList<>();
        list.add("Remaining lives: 1");
        list.add("Tower 1: empty");
        list.add("Tower 2: empty");
        list.add("Tower 3: empty");
        list.add("Tower 4: empty");
        assertEquals(game.getInfoString(), list);
    }

    @Test
    public void testInfoString1() {
        game.buyTower(1);
        game.buyTower(2);
        game.buyTower(3);
        game.buyTower(4);
        List<String> list = new ArrayList<>();
        list.add("Remaining lives: 1");
        list.add("Tower 1: Tutor");
        list.add("Tower 2: Tutor");
        list.add("Tower 3: Tutor");
        list.add("Tower 4: Tutor");
        assertEquals(game.getInfoString(), list);
    }
    
    @Test
    public void getToEnd(){
        for (int i = 0; i < 1000; i++) {
            game.update(i, new GameView(new Window()));
        }
        
    }

}
