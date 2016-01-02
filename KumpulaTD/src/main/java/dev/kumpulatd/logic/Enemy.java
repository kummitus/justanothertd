/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.kumpulatd.logic;

import java.awt.image.BufferedImage;
import java.util.List;

/**
 * Interface for all Enemy classes
 * @author antti
 */
public interface Enemy {
    
    /**
     *
     * @return Returns the current HP of Enemy
     */
    public int getHP();
    
    /**
     *Method to damage the Enemy
     * 
     * @param type Sets the type of damage
     * @param amount Sets the amount of damage
     */
    public void damage(int type, int amount);
    
    /**
     *
     * @return Returns speed or the average for group
     */
    public int getSpeed();
    
    /**
     *
     * @return Returns x value
     */
    public int getX();
    
    /**
     *
     * @return Returns y value
     */
    public int getY();
    
    /**
     *
     * @return Returns the image associated with the enemy, null for groups.
     */
    public BufferedImage getImg();
    
    /**
     *
     * @return Returns list of Enemies included in the group. Null for Lowest level.
     */
    public List<Enemy> getMembers();
    
    /**
     *
     * @param newx Set new x value
     */
    public void setX(int newx);
    
    /**
     *
     * @param newy Set new y value
     */
    public void setY(int newy);
    
    /**
     *
     * @return Returns the value that the Enemy is currently moving towards to
     */
    public int currentTarget();
    
    /**
     *Increases the target variable for the Enemy pathfinder so that it can seek for the next object
     */
    public void increaseTarget();
    
    
}
