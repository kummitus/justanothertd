package dev.kumpulatd.logic;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import dev.kumpulatd.objects.TowerLocation;
import dev.kumpulatd.objects.Tutor;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
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
public class TutorTest {

    Tutor tutor;

    public TutorTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        tutor = new Tutor(new TowerLocation(1, 1));
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void testImg() {
        BufferedImage img;
        try {
            img = ImageIO.read(new File("src/main/resources/penguinillustration.png"));
        } catch (IOException e) {
            assertEquals(null, tutor.getImg());
            img = null;
        }
        if (img != null) {
            assertEquals(img.getHeight(), tutor.getImg().getHeight());
            assertEquals(img.getWidth(), tutor.getImg().getWidth());
        }
        
    }

    @Test
    public void testRange() {
        assertEquals(30, tutor.range());
    }

    @Test
    public void testDamage() {
        assertEquals(20, tutor.damage());
        assertEquals(1, tutor.damageType());
    }

    @Test
    public void testName() {
        assertEquals("Tutor", tutor.getName());
    }
}
