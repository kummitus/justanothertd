/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kumpulatd.logic;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
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
        group.addMember(new Fuksi(5,5));
        group.addMember(new Fuksi(5,5));
        assertEquals(200, group.getHP());
        assertEquals(5, group.getSpeed());
    }

    @Test
    public void testDamage() {
        group.addMember(new Fuksi(5,5));
        group.addMember(new Fuksi(5,5));
        group.damage(0, 50);
        assertEquals(100, group.getHP());
        assertEquals(5, group.getSpeed());
    }

    @Test
    public void testEmptySpeed() {
        assertEquals(0, group.getHP());
        assertEquals(0, group.getSpeed());
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
