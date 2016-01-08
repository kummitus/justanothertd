/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.kumpulatd.objects;

import dev.kumpulatd.objects.Freshman;
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
public class FreshmanTest {

    Freshman fuksi;

    /**
     *
     */
    public FreshmanTest() {
    }

    /**
     *
     */
    @Before
    public void setUp() {
        BufferedImage img;

        try {
            img = ImageIO.read(new File("src/main/resources/freshman1.png"));
        } catch (IOException e) {
            img = null;
        }
        fuksi = new Freshman(5, 5, img);
    }

    /**
     *
     */
    @Test
    public void testNewFuksi() {
        assertEquals(50, fuksi.getHP());
        assertEquals(5, fuksi.getSpeed());
    }

    /**
     *
     */
    @Test
    public void testDamage() {
        fuksi.damage(0, 5);
        assertEquals(45, fuksi.getHP());
    }

    /**
     *
     */
    @Test
    public void testImg() {
        BufferedImage img;

        try {
            img = ImageIO.read(new File("src/main/resources/freshman1.png"));
        } catch (IOException e) {
            img = null;
        }

        assertEquals(img.getHeight(), fuksi.getImg().getHeight());
        assertEquals(img.getWidth(), fuksi.getImg().getWidth());

    }

    /**
     *
     */
    @Test
    public void testMembersIsNull() {
        assertEquals(null, fuksi.getMembers());
    }

    /**
     *
     */
    @Test
    public void testSetXSetY() {
        fuksi.setX(100);
        fuksi.setY(100);
        assertEquals(100, fuksi.getY());
        assertEquals(100, fuksi.getX());
    }
}
