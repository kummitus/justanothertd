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

    public boolean onTarget();
    
    public Enemy getEnemy();

    public void setX(int i);

    public void setY(int i);

    public int getType();

    public int getAmount();

    public void setOnTarget();

    public int getRadius();
    
    
}
