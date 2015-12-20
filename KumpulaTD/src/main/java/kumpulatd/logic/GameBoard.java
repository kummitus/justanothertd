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
public class GameBoard {
    private List<List<String>> map;
    private int frame;
    
    public GameBoard(){
        map = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            List<String> list = new ArrayList<>();
            for (int j = 0; j < 29; j++) {
                list.add("#");
            }
            map.add(list);
        }
        frame = 0;
    }

    void draw() {
        System.out.flush(); 
        StringBuilder sb = new StringBuilder(7000);
        frame++;
        sb.append(frame);
        for (List<String> list : map) {
            for (String s : list) {
                sb.append(s);
            }
            sb.append("\n");
        }
        System.out.println(sb);
        
    }
    
}
