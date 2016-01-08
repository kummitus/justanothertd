/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.kumpulatd.objects;

import dev.kumpulatd.ui.WarningMessage;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

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

    /**
     *
     * @param location
     */
    public Professor(TowerLocation location) {
        this.location = location;
        range = 100;
        damageType = 2;
        initImg();
        damage = 5;
        name = "Professor";
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

    private void initImg() {
        img = null;
        try {
            img = ImageIO.read(new File("src/main/resources/professor.png"));
        } catch (IOException e) {
            img = new BufferedImage(1, 1, 1);
            new WarningMessage().invokeWarning();
        }
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
     */
    @Override
    public void upgrade() {
        range += 5;
        damage += 5;
    }
}
