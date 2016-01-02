/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.kumpulatd.logic;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.imageio.ImageIO;
import dev.kumpulatd.ui.WarningMessage;

/**
 * Implementation of enemy class
 * @author antti
 */
public class Fuksi implements Enemy {

    private int HP;
    private int speed;
    private Map<Integer, Integer> resistance;
    private BufferedImage img;
    private int x;
    private int y;
    private int target;

    /**
     *
     * @param x
     * @param y
     */
    public Fuksi(int x, int y) {
        HP = 100;
        speed = 5;
        resistance = new HashMap<>();
        img = null;
        try {
            img = ImageIO.read(new File("src/main/resources/freshman.png"));
        } catch (IOException e) {

            new WarningMessage().invokeWarning();
        }
        this.x = x;
        this.y = y;
        target = 0;
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

}
