/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kumpulatd.logic;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author antti
 */
public class Fuksi implements Enemy{
    private int HP;
    private int speed;
    private Map<Integer, Integer> resistance;
    
    public Fuksi(){
        HP = 100;
        speed = 5;
        resistance = new HashMap<>();
    }
    
    @Override
    public int getHP() {
        return HP;
    }

    @Override
    public void damage(int type, int amount) {
        HP -= amount;
    }

    @Override
    public int getSpeed() {
        return speed;
    }
    
}
