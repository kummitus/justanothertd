/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.kumpulatd.logic;

import dev.kumpulatd.objects.Enemy;
import dev.kumpulatd.objects.EnemyGroup;
import dev.kumpulatd.objects.Freshman;
import dev.kumpulatd.objects.GoalLocation;
import static dev.kumpulatd.logic.TestingHelper.loseGame;
import static dev.kumpulatd.logic.TestingHelper.winGame;
import static dev.kumpulatd.logic.TestingHelper.testIfClose;
import dev.kumpulatd.ui.GameView;
import dev.kumpulatd.ui.Window;
import java.util.ArrayList;
import java.util.List;
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
public class TestingHelperTest {

    PathFinding path;
    EnemyGroup group;
    PathFinder finder;
    GoalLocation location;
    List<Enemy> enemies;
    TestingHelper test;

    /**
     *
     */
    public TestingHelperTest() {
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

        path = new PathFinding();
        group = new EnemyGroup();
        group.addMember(new Freshman(2, 2, null));
        finder = new PathFinder();
        location = new GoalLocation(10, 10);
        enemies = new ArrayList<>();
        enemies.add(group);
        test = new TestingHelper();

    }

    /**
     *
     */
    @After
    public void tearDown() {
    }

    /**
     *
     */
    @Test
    public void move1() {
        path.addPoint(1, 1);
        path.addPoint(10, 10);
        assertTrue(testIfClose(group.getMembers().get(0), path));
        finder.testForPathFinding(enemies, location, path);
        assertEquals(1, group.getMembers().get(0).currentTarget());
    }

    /**
     *
     */
    @Test
    public void move2() {
        path.addPoint(1, 2);
        path.addPoint(10, 10);
        assertTrue(testIfClose(group.getMembers().get(0), path));
        finder.testForPathFinding(enemies, location, path);
        assertEquals(1, group.getMembers().get(0).currentTarget());
    }

//    @Test
//    public void move3() {
//        path.addPoint(1, 3);
//        assertTrue(testIfClose(group.getMembers().get(0), path));
//    }

    /**
     *
     */
    @Test
    public void move4() {
        path.addPoint(2, 1);
        path.addPoint(10, 10);
        assertTrue(testIfClose(group.getMembers().get(0), path));
        finder.testForPathFinding(enemies, location, path);
        assertEquals(1, group.getMembers().get(0).currentTarget());
    }

    /**
     *
     */
    @Test
    public void move5() {
        path.addPoint(2, 2);
        path.addPoint(10, 10);
        assertTrue(testIfClose(group.getMembers().get(0), path));
        finder.testForPathFinding(enemies, location, path);
        assertEquals(1, group.getMembers().get(0).currentTarget());
    }

    /**
     *
     */
    @Test
    public void move6() {
        path.addPoint(2, 3);
        path.addPoint(10, 10);
        assertTrue(testIfClose(group.getMembers().get(0), path));
        finder.testForPathFinding(enemies, location, path);
        assertEquals(1, group.getMembers().get(0).currentTarget());
    }

//    @Test
//    public void move7() {
//        path.addPoint(3, 1);
//        assertTrue(testIfClose(group.getMembers().get(0), path));
//    }

    /**
     *
     */
    @Test
    public void move8() {
        path.addPoint(3, 2);
        path.addPoint(10, 10);
        assertTrue(testIfClose(group.getMembers().get(0), path));
        finder.testForPathFinding(enemies, location, path);
        assertEquals(1, group.getMembers().get(0).currentTarget());
    }

    /**
     *
     */
    @Test
    public void move9() {
        path.addPoint(3, 3);
        path.addPoint(10, 10);
        assertTrue(testIfClose(group.getMembers().get(0), path));
        finder.testForPathFinding(enemies, location, path);
        assertEquals(1, group.getMembers().get(0).currentTarget());
    }

    /**
     *
     */
    @Test
    public void moveFail() {

        path.addPoint(4, 4);
        path.addPoint(10, 10);
        assertFalse(testIfClose(group.getMembers().get(0), path));
        group.setMembers(finder.testForPathFinding(enemies, location, path));
        assertEquals(0, group.getMembers().get(0).currentTarget());
    }

    /**
     *
     */
    @Test
    public void endGame() {
        Window window = new Window();
        GameView view = new GameView(window, "kumpula");
        loseGame(view);
        assertNotNull(window.getFrame());

    }

    /**
     *
     */
//    @Test
//    public void endGame1() {
//        Window window = new Window();
//        GameView view = new GameView(window, "kumpula");
//        winGame(view);
//        assertEquals(window.getFrame(), null);
//
//    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
