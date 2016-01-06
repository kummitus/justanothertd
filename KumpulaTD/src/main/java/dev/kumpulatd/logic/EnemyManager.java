/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.kumpulatd.logic;

import dev.kumpulatd.objects.Enemy;
import java.util.Iterator;
import java.util.List;

/**
 * Manages enemies actions
 * @author kummi
 */
public class EnemyManager {

    /**
     *
     * @param info Game gives the manager the game info
     * @return returns modified game info
     */
    public static GameInfo removeDeadEnemies(GameInfo info) {
        Iterator itr = info.getEnemies().iterator();
        while (itr.hasNext()) {
            Enemy group = (Enemy) itr.next();
            List<Enemy> grouplist = group.getMembers();
            Iterator finalitr = grouplist.iterator();
            while (finalitr.hasNext()) {
                Enemy enemy = (Enemy) finalitr.next();
                if (enemy.getHP() <= 0) {
                    info.IncreaseMoney();
                    finalitr.remove();
                }
            }
            if (group.getMembers().isEmpty()) {
                itr.remove();
            }
        }
        return info;
    }

    /**
     *
     * @param info Game gives the manager the game info
     * @return returns modified game info
     */
    public static GameInfo removeSurvivedEnemies(GameInfo info) {
        Iterator itr = info.getEnemies().iterator();
        while (itr.hasNext()) {
            Enemy group = (Enemy) itr.next();
            List<Enemy> grouplist = group.getMembers();
            Iterator finalitr = grouplist.iterator();
            while (finalitr.hasNext()) {
                Enemy enemy = (Enemy) finalitr.next();
                if (enemy.currentTarget() > info.getPath().getSize() - 1) {
                    finalitr.remove();
                    info.setLives(info.getLives()-1);
                }
            }
            if (group.getMembers().isEmpty()) {
                itr.remove();
            }
        }
        
        return info;
    }
}
