/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kumpulatd.logic;

/**
 *
 * @author kummi
 */
public class PathPoint {
    private final int x;
    private final int y;
    
    /**
     *
     * @param x
     * @param y
     */
    public PathPoint(int x, int y){
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
