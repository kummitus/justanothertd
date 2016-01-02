/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.kumpulatd.logic;

import java.awt.image.BufferedImage;

/**
 * Interface for all the tower classes
 * @author antti
 */
public interface Tower {
    
    /**
     *
     * @return
     */
    public int range();
    
    /**
     *
     * @return
     */
    public int damage();
    
    /**
     *
     * @return
     */
    public int damageType();
    
    /**
     *
     * @return
     */
    public BufferedImage getImg();
    
    /**
     *
     * @return
     */
    public TowerLocation getLocation();
    
    /**
     *
     * @return
     */
    public String getName();
    
}
