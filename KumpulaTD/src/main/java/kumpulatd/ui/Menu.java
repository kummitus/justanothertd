/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kumpulatd.ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.util.Scanner;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import kumpulatd.logic.Game;

/**
 *
 * @author antti
 */
public class Menu implements Runnable{

    //private Scanner reader;
    private JFrame frame;

    public Menu() {
        //reader = new Scanner(System.in);

        //menuLoop();
    }

//    private void menuLoop() {
//        System.out.println("Select:");
//        while (true) {
//            System.out.println("  1: New Game"
//                    + "\n  2: Quit");
//            String choice = reader.nextLine();
//            if(choice.equals("1")){
//                Game game = new Game(reader);
//                game.init();
//            } else if(choice.equals("2")){
//                break;
//            }
//        }
//    }

    @Override
    public void run() {
        
        frame = new JFrame("Menu");
        frame.setPreferredSize(new Dimension(800, 800));
        
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        createComponents(frame.getContentPane());
    }

    private void createComponents(Container contentPane) {
        
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
        
        JButton newgame = new JButton("New Game");
        JButton exit = new JButton("Exit");
        
        ButtonGroup buttons = new ButtonGroup();
        buttons.add(newgame);
        buttons.add(exit);
                
        contentPane.add(newgame);
        contentPane.add(exit);
        
    }
    
    public JFrame getFrame(){
        return frame;
    }
}
