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
public class TowerLocation {
    private int x;
    private int y;
    
    public TowerLocation(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
    
    public int CompareTo(TowerLocation loc){
        if(x == loc.getX() && y == loc.getY()){
            return 0;
        }
        return 1;
    }
}
