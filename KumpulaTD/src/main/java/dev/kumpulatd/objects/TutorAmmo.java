/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.kumpulatd.objects;

import java.awt.image.BufferedImage;

/**
 *
 * @author kummi
 */
public class TutorAmmo implements Ammunition {

    private int x;
    private int y;
    private BufferedImage img;
    private int counter;
    private boolean onTarget;
    private Enemy enemy;
    private int type;
    private int damage;

    /**
     *
     * @param x
     * @param y
     * @param enemy
     * @param damage
     * @param type
     * @param img
     */
    public TutorAmmo(int x, int y, Enemy enemy, int damage, int type, BufferedImage img) {
        this.x = x;
        this.y = y;
        counter = 0;
        this.img = img;
        onTarget = false;
        this.enemy = enemy;
        this.type = type;
        this.damage = damage;
        
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public BufferedImage getImg() {
        return img;
    }

    @Override
    public void IncreaseCounter() {
        counter++;
    }

    @Override
    public int getCounter() {
        return counter;
    }

    /**
     *
     * @return
     */
    @Override
    public boolean onTarget() {
        return onTarget;
    }

    /**
     *
     * @return
     */
    @Override
    public Enemy getEnemy() {
        return enemy;
    }

    /**
     *
     * @param i
     */
    @Override
    public void setX(int i) {
        if (i < 6) {
            x += i;
        } else {
            x = i;
        }
    }

    /**
     *
     * @param i
     */
    @Override
    public void setY(int i) {
        if (i < 6) {
            y += i;
        } else {
            y = i;
        }
    }

    /**
     *
     * @return
     */
    @Override
    public int getType() {
        return type;
    }

    /**
     *
     * @return
     */
    @Override
    public int getAmount() {
        return damage;
    }

    /**
     *
     */
    @Override
    public void setOnTarget() {
        onTarget = true;
    }

    /**
     *
     * @return
     */
    @Override
    public int getRadius() {
        return 1;
    }
}
