/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.kumpulatd.objects;

import java.awt.image.BufferedImage;

/**
 * Interface for alla ammunition classes
 * @author kummi
 */
public interface Ammunition {
    
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
     */
    public void IncreaseCounter();
    
    /**
     *
     * @return
     */
    public int getCounter();

    /**
     *
     * @return
     */
    public boolean onTarget();
    
    /**
     *
     * @return
     */
    public Enemy getEnemy();

    /**
     *
     * @param i
     */
    public void setX(int i);

    /**
     *
     * @param i
     */
    public void setY(int i);

    /**
     *
     * @return
     */
    public int getType();

    /**
     *
     * @return
     */
    public int getAmount();

    /**
     *
     */
    public void setOnTarget();

    /**
     *
     * @return
     */
    public int getRadius();
    
    
}
