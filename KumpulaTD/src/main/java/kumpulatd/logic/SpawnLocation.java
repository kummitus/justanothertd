/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kumpulatd.logic;

/**
 * Spawn location class
 * @author kummi
 */
public class SpawnLocation {
    private int x;
    private int y;
    
    /**
     *
     * @param x
     * @param y
     */
    public SpawnLocation(int x, int y){
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
}
