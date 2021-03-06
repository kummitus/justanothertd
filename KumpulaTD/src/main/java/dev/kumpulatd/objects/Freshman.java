/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.kumpulatd.objects;

import java.awt.image.BufferedImage;
import java.util.List;

/**
 * Implementation of enemy class
 *
 * @author antti
 */
public class Freshman implements Enemy {

    private int HP;
    private int speed;
    private BufferedImage img;
    private int x;
    private int y;
    private int target;
    private String name;

    /**
     *
     * @param x
     * @param y
     * @param img
     */
    public Freshman(int x, int y, BufferedImage img) {
        HP = 50;
        speed = 5;
        this.img = img;
        this.x = x;
        this.y = y;
        target = 0;
        name = "Freshman";
    }

    /**
     *
     * @return
     */
    @Override
    public int getHP() {
        return HP;
    }

    /**
     *
     * @param type
     * @param amount
     */
    @Override
    public void damage(int type, int amount) {
        HP -= amount;
    }

    /**
     *
     * @return
     */
    @Override
    public int getSpeed() {
        return speed;
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
    public int getX() {
        return x;
    }

    /**
     *
     * @return
     */
    @Override
    public int getY() {
        return y;
    }

    /**
     *
     * @return
     */
    @Override
    public List<Enemy> getMembers() {
        return null;
    }

    /**
     *
     * @param x
     */
    @Override
    public void setX(int x) {
        this.x = x;
    }

    /**
     *
     * @param y
     */
    @Override
    public void setY(int y) {
        this.y = y;
    }

    /**
     *
     * @return
     */
    @Override
    public int currentTarget() {
        return target;
    }

    /**
     *
     */
    @Override
    public void increaseTarget() {
        target++;
    }

    /**
     *
     * @return
     */
    @Override
    public String getName() {
        return name;
    }

}