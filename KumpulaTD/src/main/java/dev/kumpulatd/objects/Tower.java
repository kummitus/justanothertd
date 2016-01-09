/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.kumpulatd.objects;

import java.awt.image.BufferedImage;

/**
 * Interface for all the tower classes
 *
 * @author antti
 */
public interface Tower {

    /**
     *
     * @return tower damage
     */
    public int range();

    /**
     *
     * @return tower damage
     */
    public int damage();

    /**
     *
     * @return Tower damage type
     */
    public int damageType();

    /**
     *
     * @return Returns tower Sprite
     */
    public BufferedImage getImg();

    /**
     *
     * @return Returns tower location
     */
    public TowerLocation getLocation();

    /**
     *
     * @return tower name/type
     */
    public String getName();

    /**
     * Upgrades tower with better abilities
     */
    public void upgrade();

    /**
     * GetRadius for splash
     */
    public int getRadius();

}
