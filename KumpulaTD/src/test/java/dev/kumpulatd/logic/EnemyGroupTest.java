/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.kumpulatd.logic;

import dev.kumpulatd.objects.Freshman;
import dev.kumpulatd.objects.Enemy;
import dev.kumpulatd.objects.EnemyGroup;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author kummi
 */
public class EnemyGroupTest {

    EnemyGroup group;

    public EnemyGroupTest() {
    }

    @Before
    public void setUp() {
        group = new EnemyGroup();

    }

    @Test
    public void testAddMember() {
        group.addMember(new Freshman(5, 5));
        group.addMember(new Freshman(5, 5));
        assertEquals(200, group.getHP());
        assertEquals(5, group.getSpeed());

    }

    @Test
    public void testDamage() {
        group.addMember(new Freshman(5, 5));
        group.addMember(new Freshman(5, 5));
        group.damage(0, 50);
        assertEquals(100, group.getHP());
        assertEquals(5, group.getSpeed());
    }

    @Test
    public void testEmptySpeed() {
        assertEquals(0, group.getHP());
        assertEquals(0, group.getSpeed());
    }

    @Test
    public void testEmptyMembers() {
        assertEquals(new ArrayList<>(), group.getMembers());
    }

    @Test
    public void testOneMembers() {
        Enemy fuksi = new Freshman(1, 1);
        group.addMember(fuksi);
        List<Enemy> list = new ArrayList<>();
        list.add(fuksi);
        assertEquals(list, group.getMembers());
    }

    @Test
    public void ifEmptyGetX() {
        assertEquals(0, group.getX());
    }

    @Test
    public void ifEmptyGetY() {
        assertEquals(0, group.getY());
    }

    @Test
    public void oneMemberGetXY() {
        group.addMember(new Freshman(5, 5));
        assertEquals(5, group.getX());
        assertEquals(5, group.getY());

    }

    @Test
    public void averageMemberGetXY() {
        group.addMember(new Freshman(5, 5));
        group.addMember(new Freshman(15, 15));
        assertEquals(10, group.getX());
        assertEquals(10, group.getY());

    }

    @Test
    public void average2MemberGetXY() {
        group.addMember(new Freshman(5, 5));
        group.addMember(new Freshman(10, 10));
        assertEquals(7, group.getX());
        assertEquals(7, group.getY());

    }
    
    @Test
    public void nullBufferedImage(){
        assertEquals(null, group.getImg());
    }
    
    @Test
    public void currentTarget(){
        assertEquals(0, group.currentTarget());
    }
    
    @Test
    public void nextTarget(){
        group.increaseTarget();
        assertEquals(1, group.currentTarget());
    }
    
    @Test
    public void nextTargetMember(){
        group.addMember(new Freshman(5,5));
        group.increaseTarget();
        assertEquals(1, group.getMembers().get(0).currentTarget());
    }
    
    @Test
    public void setXsetY(){
        group.addMember(new Freshman(5,5));
        group.addMember(new Freshman(10, 10));
        group.setX(200);
        group.setY(200);
        assertEquals(200, group.getX());
        assertEquals(200, group.getY());
    }

    
}
