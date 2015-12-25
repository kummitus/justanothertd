/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kumpulatd.logic;


import java.util.ArrayList;
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
            if(sl.getX() == game.getEnemies().get(0).getX() && sl.getY() == game.getEnemies().get(0).getY()){
                assertEquals(new ArrayList<>().add(new Fuksi(sl.getX(), sl.getY())), game.getEnemies());
            }
        }
        
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

}
