/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kumpulatd.logic;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author antti
 */
public class EnemyGroup implements Enemy{
    private List<Enemy> list;
    
    public EnemyGroup(){
        list = new ArrayList<>();
        
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
        if(list.isEmpty()){
            return 0;
        } else {
            return list.get(0).getSpeed();
        }
    }
    
    public void addMember(Enemy e){
        list.add(e);
    }
    
}
