/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kumpulatd.logic;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author antti
 */
public class Game {

    private List<Enemy> enemylist;
    private List<Tower> towerlist;
    private Scanner reader;

    public Game(Scanner reader) {
        enemylist = new ArrayList<>();
        towerlist = new ArrayList<>();
        this.reader = reader;
    }

    public void init() {
        GameBoard board = new GameBoard();
        gameLoop(board);
    }

    public void gameLoop(GameBoard board) {
            if(board == null){
                return;
            }
        //while (true) {
            board.draw();
            try {
                Thread.sleep(16);
            } catch (Exception e) {
                System.out.println("Sleep unsuccesfull");
                //break;
            }
            //int command = 0;
            //command = catchCommand();
            //if (command == 1) {
                //break;
            //}

        //}
    }

    public int catchCommand() {
        int i = 0;
        try {
            i = Integer.parseInt(reader.skip("").nextLine());
        }
        catch (Exception e ){
            return 0;
        }
        return i;
    }

}
