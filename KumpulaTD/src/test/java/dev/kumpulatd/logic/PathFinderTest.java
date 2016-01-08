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
public class PathFinderTest {

    PathFinder path;
    EnemyGroup group;

    /**
     *
     */
    public PathFinderTest() {
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
        path = new PathFinder();
        group = new EnemyGroup();
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
    public void moveGroup1() {
        List<Enemy> enemies = new ArrayList<>();
        enemies.add(group);
        group.addMember(new Freshman(1, 5, null));
        group.addMember(new Freshman(1, 30, null));
        PathFinding paths = new PathFinding();
        paths.addPoint(1, 20);
        path.testForPathFinding(enemies, new GoalLocation(1, 20), paths);
        assertEquals(6, group.getMembers().get(0).getY());
        assertEquals(29, group.getMembers().get(1).getY());

    }

    /**
     *
     */
    @Test
    public void moveGroup2() {
        List<Enemy> enemies = new ArrayList<>();
        enemies.add(group);
        group.addMember(new Freshman(5, 1, null));
        group.addMember(new Freshman(30, 1, null));
        PathFinding paths = new PathFinding();
        paths.addPoint(20, 1);
        path.testForPathFinding(enemies, new GoalLocation(20, 1), paths);
        assertEquals(6, group.getMembers().get(0).getX());
        assertEquals(29, group.getMembers().get(1).getX());

    }
}
