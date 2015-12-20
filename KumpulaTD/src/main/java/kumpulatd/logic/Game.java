/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kumpulatd.logic;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author antti
 */
public class Game {

    private List<Enemy> enemylist;
    private List<Tower> towerlist;

    public Game() {
        enemylist = new ArrayList<>();
        towerlist = new ArrayList<>();

        init();
    }

    public void init() {
        GameBoard board = new GameBoard();
        gameLoop(board);
    }

    public void gameLoop(GameBoard board)  {
        while (true) {
            board.draw();
            try {
            Thread.sleep(16);
            }
            catch( Exception e){
                
            }
        }
    }

}
