/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.kumpulatd.logic;

import dev.kumpulatd.objects.Ammunition;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author kummi
 */
public class AmmoManager {

    /**
     *
     * @param ammunition
     */
    public static void removeDeadAmmo(List<Ammunition> ammunition) {
        Iterator itr = ammunition.iterator();
        while (itr.hasNext()) {
            Ammunition ammo = (Ammunition) itr.next();
            if (ammo.getEnemy() == null) {
                itr.remove();
            } else if (ammo.getEnemy().getHP() <= 0) {
                itr.remove();
            } else if (ammo.getCounter() > 1) {
                itr.remove();
            }
        }
    }
}
