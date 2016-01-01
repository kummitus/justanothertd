/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kumpulatd.logic;


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
    public void nullEnemies(){
        assertEquals(new ArrayList<>(), game.getEnemies());
    }

    @Test
    public void nullTowers(){
        assertEquals(new ArrayList<>(), game.getTowers());
    }
    
    @Test
    public void nullAmmunition(){
        assertEquals(new ArrayList<>(), game.getAmmunition());
    }
    
    @Test
    public void firstSpawnFrame(){
        game.update(30);
        for (SpawnLocation sl : game.getSpawns()) {
            if(sl.getX() == game.getEnemies().get(0).getMembers().get(0).getX() && sl.getY() == game.getEnemies().get(0).getMembers().get(0).getY()){
                assertEquals(new ArrayList<>().add(new Fuksi(sl.getX(), sl.getY())), game.getEnemies().get(0).getMembers());
                
            }
        }
        
        
    }
    
    
    

    
    @Test
    public void testPathPoints(){
        assertEquals(game.path().getPoints(), game.path().getPoints());
        assertEquals(642, game.path().getPoint(0).getX());
        assertEquals(555, game.path().getPoint(0).getY());
        assertEquals(483, game.path().getPoint(1).getX());
        assertEquals(563, game.path().getPoint(1).getY());
        assertEquals(470, game.path().getPoint(2).getX());
        assertEquals(521, game.path().getPoint(2).getY());
        assertEquals(550, game.path().getPoint(3).getX());
        assertEquals(440, game.path().getPoint(3).getY());
        assertEquals(350, game.path().getPoint(4).getX());
        assertEquals(220, game.path().getPoint(4).getY());
        
    }

}
