/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.kumpulatd.objects;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 *
 * @author kummi
 */
public class ProfessorTest {

    Professor professor;

    /**
     *
     */
    public ProfessorTest() {
    }

    /**
     *
     */
    @BeforeClass
    public static void setUpClass() {
    }

    /**
     *
     */
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     *
     */
    @Before
    public void setUp() {
        BufferedImage img;
        try {
            img = ImageIO.read(new File("src/main/resources/professor.png"));
        } catch (IOException e) {
            img = null;
        }
        professor = new Professor(new TowerLocation(1, 1), img);
    }

    /**
     *
     */
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

    /**
     *
     */
    @Test
    public void testImg() {
        BufferedImage img;
        try {
            img = ImageIO.read(new File("src/main/resources/professor.png"));
        } catch (IOException e) {
            assertEquals(null, professor.getImg());
            img = null;
        }
        if (img != null) {
            assertEquals(img.getHeight(), professor.getImg().getHeight());
            assertEquals(img.getWidth(), professor.getImg().getWidth());
        }

    }

    /**
     *
     */
    @Test
    public void testRange() {
        assertEquals(100, professor.range());
    }

    /**
     *
     */
    @Test
    public void testDamage() {
        assertEquals(5, professor.damage());
        assertEquals(2, professor.damageType());
    }

    /**
     *
     */
    @Test
    public void testName() {
        assertEquals("Professor", professor.getName());
    }
}
