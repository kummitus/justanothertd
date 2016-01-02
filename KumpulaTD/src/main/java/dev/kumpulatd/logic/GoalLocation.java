/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.kumpulatd.logic;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import dev.kumpulatd.ui.WarningMessage;

/**
 * Is used to determine the last point of pathfinding
 * @author kummi
 */
public class GoalLocation {
    private int x;
    private int y;
    private BufferedImage img;

    /**
     * Constructor for goal location
     * @param x X value
     * @param y Y value
     */
    public GoalLocation(int x, int y) {
        this.x = x;
        this.y = y;
        
        img = null;
        try {
            img = ImageIO.read(new File("src/main/resources/goal.png"));
        } catch (IOException e) {

            new WarningMessage().invokeWarning();
        }
    }

    /**
     *
     * @return X value
     */
    public int getX() {
        return x;
    }

    /**
     *
     * @return Y value
     */
    public int getY() {
        return y;
    }
    
    /**
     *
     * @return Image associated with goal
     */
    public BufferedImage getImg(){
        return img;
    }
}
