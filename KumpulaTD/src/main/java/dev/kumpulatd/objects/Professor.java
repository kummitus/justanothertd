/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.kumpulatd.objects;

import java.awt.image.BufferedImage;

/**
 * Professor Tower
 * @author kummi
 */
public class Professor implements Tower {

    private TowerLocation location;
    private int range;
    private int damageType;
    private BufferedImage img;
    private int damage;
    private String name;
    private int radius;

    /**
     *
     * @param location
     * @param img
     */
    public Professor(TowerLocation location, BufferedImage img) {
        this.location = location;
        range = 100;
        this.img = img;
        damageType = 2;
        damage = 3;
        name = "Professor";
        radius = 50;
    }

    /**
     *
     * @return
     */
    @Override
    public int range() {
        return range;
    }

    /**
     *
     * @return
     */
    @Override
    public int damage() {
        return damage;
    }

    /**
     *
     * @return
     */
    @Override
    public int damageType() {
        return damageType;
    }

    /**
     *
     * @return
     */
    @Override
    public BufferedImage getImg() {
        return img;
    }

    /**
     *
     * @return
     */
    @Override
    public TowerLocation getLocation() {
        return location;
    }


    /**
     *
     * @return
     */
    @Override
    public String getName() {
        return name;
    }
    
    /**
     *
     * @return
     */
    public int getRadius(){
        return radius;
    }

    /**
     *
     */
    @Override
    public void upgrade() {
        range += 5;
        damage += 1;
        radius += 1;
    }
}
