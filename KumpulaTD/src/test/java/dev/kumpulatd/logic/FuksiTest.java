/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.kumpulatd.logic;

import dev.kumpulatd.logic.Fuksi;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author antti
 */
public class FuksiTest {

    Fuksi fuksi;

    public FuksiTest() {
    }

    @Before
    public void setUp() {

        fuksi = new Fuksi(5, 5);
    }

    @Test
    public void testNewFuksi() {
        assertEquals(100, fuksi.getHP());
        assertEquals(5, fuksi.getSpeed());
    }

    @Test
    public void testDamage() {
        fuksi.damage(0, 5);
        assertEquals(95, fuksi.getHP());
    }

    @Test
    public void testImg(){
        BufferedImage img;
        try {
            img = ImageIO.read(new File("src/main/resources/freshman.png"));
            //assertEquals(img, fuksi.getImg());
        } catch (IOException e) {
            assertEquals(null, fuksi.getImg());
        }

    }

    @Test
    public void testMembersIsNull() {
        assertEquals(null, fuksi.getMembers());
    }

    @Test
    public void testSetXSetY() {
        fuksi.setX(100);
        fuksi.setY(100);
        assertEquals(100, fuksi.getY());
        assertEquals(100, fuksi.getX());
    }
}
