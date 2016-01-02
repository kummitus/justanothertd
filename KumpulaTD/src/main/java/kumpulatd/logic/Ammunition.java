/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kumpulatd.logic;

import java.awt.image.BufferedImage;

/**
 *
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
    
}
