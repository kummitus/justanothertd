/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kumpulatd.logic;

import java.util.Scanner;
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
public class GameTest {

    Game game;
    Scanner reader;

    public GameTest() {
    }

    @Before
    public void setUp() {
        game = new Game(reader);
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void testCatchCommand() {
        reader = new Scanner("5");
        game = new Game(reader);
        assertEquals(5, game.catchCommand());
    }

    @Test
    public void testCatchCommandString() {
        reader = new Scanner("hey");
        game = new Game(reader);
        assertEquals(0, game.catchCommand());
    }
}
