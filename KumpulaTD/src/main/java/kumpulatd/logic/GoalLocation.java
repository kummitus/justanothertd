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
import kumpulatd.ui.WarningMessage;

/**
 *
 * @author kummi
 */
public class GoalLocation {
    private int x;
    private int y;
    private BufferedImage img;

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

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    public BufferedImage getImg(){
        return img;
    }
}
