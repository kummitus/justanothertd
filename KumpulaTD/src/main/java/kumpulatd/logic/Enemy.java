/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kumpulatd.logic;

import java.awt.image.BufferedImage;
import java.util.List;

/**
 *
 * @author antti
 */
public interface Enemy {
    
    public int getHP();
    
    public void damage(int type, int amount);
    
    public int getSpeed();
    
    public int getX();
    
    public int getY();
    
    public BufferedImage getImg();
    
    public List<Enemy> getMembers();
    
    public void setX(int newx);
    
    public void setY(int newy);
    
    public int currentTarget();
    
    public void increaseTarget();
    
    
}
