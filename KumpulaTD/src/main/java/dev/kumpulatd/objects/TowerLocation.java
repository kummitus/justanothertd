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
 * Specifies a tower location
 *
 * @author antti
 */
public class TowerLocation {

    private int x;
    private int y;
    private BufferedImage img;

    /**
     *
     * @param x
     * @param y
     * @param image
     */
    public TowerLocation(int x, int y, int image) {
        this.x = x;
        this.y = y;
        img = null;
        try {
            img = ImageIO.read(new File("src/main/resources/" + image + ".png"));
        } catch (IOException e) {
            new WarningMessage().invokeWarning("Towerbase Image not Found");
        }
    }
    
    public TowerLocation(int x, int y) {
        this.x = x;
        this.y = y;
        img = null;
    }

    /**
     *
     * @return
     */
    public int getX() {
        return x;
    }

    /**
     *
     * @return
     */
    public int getY() {
        return y;
    }
    
    public BufferedImage getImg(){
        return img;
    }


}
