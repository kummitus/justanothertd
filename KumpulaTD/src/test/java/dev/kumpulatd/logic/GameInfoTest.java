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
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author kummi
 */
public class GameInfoTest {
    GameInfo info1;    
    GameInfo info2;
    
    /**
     *
     */
    public GameInfoTest() {
    }
    
    /**
     *
     */
    @BeforeClass
    public static void setUpClass() {
    }
    
    /**
     *
     */
    @AfterClass
    public static void tearDownClass() {
    }
    
    /**
     *
     */
    @Before
    public void setUp() {
        info1 = new GameInfo(new ArrayList<Enemy>(), new PathFinding(), 1);
        info2 = new GameInfo(new ArrayList<Enemy>(), 5);
    }
    
    /**
     *
     */
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

    /**
     *
     */
    
    @Test
    public void testLives(){
        assertEquals(1, info1.getLives());
    }
    
    /**
     *
     */
    @Test
    public void testIncMoney(){
        info2.IncreaseMoney();
        assertEquals(6, info2.getMoney());
    }
    
    /**
     *
     */
    @Test
    public void testMoney(){
        assertEquals(5, info2.getMoney());
    }
    
    /**
     *
     */
    @Test
    public void testEnemies(){
        assertEquals(0, info1.getEnemies().size());
    }
    
    /**
     *
     */
    @Test
    public void testEmptyInfoBuilder(){
        assertEquals(14, GameInfo.infoBuilder(new ArrayList<TowerLocation>(), new ArrayList<Tower>(), new ArrayList<Enemy>(), 0, 0).size());
    }
}
