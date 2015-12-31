/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kumpulatd.logic;

import java.awt.image.BufferedImage;

/**
 *
 * @author antti
 */
public interface Tower {
    
    public int range();
    
    public int damage();
    
    public int damageType();
    
    public BufferedImage getImg();
    
    public TowerLocation getLocation();
    
    public String getName();
    
}
