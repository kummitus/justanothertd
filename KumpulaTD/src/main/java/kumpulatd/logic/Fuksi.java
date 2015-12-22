/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kumpulatd.logic;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.imageio.ImageIO;

/**
 *
 * @author antti
 */
public class Fuksi implements Enemy {

    private int HP;
    private int speed;
    private Map<Integer, Integer> resistance;
    private BufferedImage img;
    private int x;
    private int y;

    public Fuksi(int x, int y) {
        HP = 100;
        speed = 5;
        resistance = new HashMap<>();
        img = null;
        try {
            img = ImageIO.read(new File("src/main/resources/freshman.png"));
        } catch (IOException e) {
        }
        this.x = x;
        this.y = y;
    }

    @Override
    public int getHP() {
        return HP;
    }

    @Override
    public void damage(int type, int amount) {
        HP -= amount;
    }

    @Override
    public int getSpeed() {
        return speed;
    }
    
    @Override
    public BufferedImage getImg(){
        return img;
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
    public List<Enemy> getMembers() {
        return null;
    }

    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }

}
