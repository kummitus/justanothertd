/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.kumpulatd.objects;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of Enemy class to form groups of enemies
 * @author antti
 */
public class EnemyGroup implements Enemy {

    private List<Enemy> list;
    private int target;

    /**
     * Constructor for EnemyGroup
     */
    public EnemyGroup() {
        list = new ArrayList<>();
        target = 0;

    }

    /**
     *
     * @return
     */
    @Override
    public List<Enemy> getMembers() {
        return list;
    }

    /**
     *
     * @return
     */
    @Override
    public int getHP() {
        int hp = 0;
        for (Enemy e : list) {
            hp += e.getHP();
        }
        return hp;
    }

    /**
     *
     * @param type
     * @param amount
     */
    @Override
    public void damage(int type, int amount) {
        for (Enemy e : list) {
            e.damage(type, amount);
        }
    }

    /**
     *
     * @return
     */
    @Override
    public int getSpeed() {
        if (list.isEmpty()) {
            return 0;
        } else {
            return list.get(0).getSpeed();
        }
    }

    /**
     *
     * @param e
     */
    public void addMember(Enemy e) {
        list.add(e);
    }

    /**
     *
     * @return
     */
    @Override
    public int getX() {
        if (list.isEmpty()) {
            return 0;
        }
        int sum = 0;

        for (Enemy e : list) {
            sum += e.getX();
        }
        return sum / list.size();
    }

    /**
     *
     * @return
     */
    @Override
    public int getY() {
        if (list.isEmpty()) {
            return 0;
        }
        int sum = 0;

        for (Enemy e : list) {
            sum += e.getY();
        }
        return sum / list.size();
    }

    /**
     *
     * @return
     */
    @Override
    public BufferedImage getImg() {
        return null;
    }

    /**
     *
     * @param x
     */
    @Override
    public void setX(int x) {
        for (Enemy e : list) {
            e.setX(x);
        }
    }

    /**
     *
     * @param y
     */
    @Override
    public void setY(int y) {
        for (Enemy e : list) {
            e.setY(y);
        }
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
        if (list.isEmpty()) {
            target++;
        } else {
            for (Enemy e : list) {
                e.increaseTarget();
            }
        }
    }

    public void setMembers(List<Enemy> testForPathFinding) {
        this.list = testForPathFinding;
    }

    @Override
    public String getName() {
        return "";
    }
}
