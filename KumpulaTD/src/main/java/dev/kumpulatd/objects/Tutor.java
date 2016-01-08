/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.kumpulatd.objects;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import dev.kumpulatd.ui.WarningMessage;

/**
 * Implementation of Tower
 *
 * @author kummi
 */
public class Tutor implements Tower {

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
    public Tutor(TowerLocation location) {
        this.location = location;
        range = 150;
        damageType = 1;
        initImg();
        damage = 8;
        name = "Tutor";
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
            img = ImageIO.read(new File("src/main/resources/tutor.png"));
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
