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
 *
 * @author kummi
 */
public class ProfessorAmmo implements Ammunition {

    private int x;
    private int y;
    private BufferedImage img;
    private int counter;
    private boolean onTarget;
    private Enemy enemy;
    private int type;
    private int damage;

    public ProfessorAmmo(int x, int y, Enemy enemy, int damage, int type) {
        this.x = x;
        this.y = y;
        counter = 0;
        img = null;
        this.enemy = enemy;
        onTarget = false;
        this.type = type;
        this.damage = damage;
        try {
            img = ImageIO.read(new File("src/main/resources/tutorammo.png"));
        } catch (IOException e) {
            new WarningMessage().invokeWarning("Ammo Image not Found");
        }
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

    @Override
    public boolean onTarget() {
        return onTarget;
    }

    @Override
    public Enemy getEnemy() {
        return enemy;
    }

    @Override
    public void setX(int i) {
        if (i < 6) {
            x += i;
        } else {
            x = i;
        }
    }

    @Override
    public void setY(int i) {
        if (i < 6) {
            y += i;
        } else {
            y = i;
        }
    }

    @Override
    public int getType() {
        return type;
    }

    @Override
    public int getAmount() {
        return damage;
    }

    @Override
    public void setOnTarget() {
        onTarget = true;
    }
}
