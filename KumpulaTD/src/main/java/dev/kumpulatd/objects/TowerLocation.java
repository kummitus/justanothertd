/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.kumpulatd.objects;

/**
 * Specifies a tower location
 * @author antti
 */
public class TowerLocation {
    private int x;
    private int y;
    
    /**
     *
     * @param x
     * @param y
     */
    public TowerLocation(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    /**
     *
     * @return
     */
    public int getX(){
        return x;
    }
    
    /**
     *
     * @return
     */
    public int getY(){
        return y;
    }
    
    /**
     *
     * @param loc
     * @return
     */

}