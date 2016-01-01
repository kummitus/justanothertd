/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kumpulatd.logic;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import kumpulatd.ui.WarningMessage;

/**
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

    Tutor(TowerLocation location) {
        this.location = location;
        range = 30;
        damageType = 1;
        initImg();
        damage = 20;
        name = "Tutor";
    }

    @Override
    public int range() {
        return range;
    }

    @Override
    public int damage() {
        return damage;
    }

    @Override
    public int damageType() {
        return damageType;
    }

    @Override
    public BufferedImage getImg() {
        return img;
    }

    @Override
    public TowerLocation getLocation() {
        return location;
    }

    private void initImg() {
        img = null;
        try {
            img = ImageIO.read(new File("src/main/resources/penguinillustration.png"));
        } catch (IOException e) {

            new WarningMessage().invokeWarning();
        }
    }

    @Override
    public String getName() {
        return name;
    }

}
