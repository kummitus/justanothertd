/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kumpulatd.logic;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author antti
 */
public class EnemyGroup implements Enemy {

    private List<Enemy> list;
    private int target;

    public EnemyGroup() {
        list = new ArrayList<>();
        target = 0;

    }

    @Override
    public List<Enemy> getMembers() {
        return list;
    }

    @Override
    public int getHP() {
        int hp = 0;
        for (Enemy e : list) {
            hp += e.getHP();
        }
        return hp;
    }

    @Override
    public void damage(int type, int amount) {
        for (Enemy e : list) {
            e.damage(type, amount);
        }
    }

    @Override
    public int getSpeed() {
        if (list.isEmpty()) {
            return 0;
        } else {
            return list.get(0).getSpeed();
        }
    }

    public void addMember(Enemy e) {
        list.add(e);
    }

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

    @Override
    public BufferedImage getImg() {
        return null;
    }

    @Override
    public void setX(int x) {
        for (Enemy e : list) {
            e.setX(x);
        }
    }

    @Override
    public void setY(int y) {
        for (Enemy e : list) {
            e.setY(y);
        }
    }

    @Override
    public int currentTarget() {
        return target;
    }

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
}
