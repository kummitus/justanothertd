/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kumpulatd.logic;

/**
 *
 * @author antti
 */
public interface Enemy {
    
    public int getHP();
    
    public void damage(int type, int amount);
    
    public int getSpeed();
    
    
}
