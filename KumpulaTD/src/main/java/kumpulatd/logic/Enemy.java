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
    
    /**
     *
     * @return
     */
    public int getHP();
    
    /**
     *
     * @param type
     * @param amount
     */
    public void damage(int type, int amount);
    
    /**
     *
     * @return
     */
    public int getSpeed();
    
    /**
     *
     * @return
     */
    public int getX();
    
    /**
     *
     * @return
     */
    public int getY();
    
    /**
     *
     * @return
     */
    public BufferedImage getImg();
    
    /**
     *
     * @return
     */
    public List<Enemy> getMembers();
    
    /**
     *
     * @param newx
     */
    public void setX(int newx);
    
    /**
     *
     * @param newy
     */
    public void setY(int newy);
    
    /**
     *
     * @return
     */
    public int currentTarget();
    
    /**
     *
     */
    public void increaseTarget();
    
    
}
