/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.kumpulatd.logic;

import dev.kumpulatd.logic.GoalLocation;
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
 * @author antti
 */
public class GoalLocationTest {
    
    GoalLocation point;
    
    public GoalLocationTest() {
    }
    

    @Before
    public void setUp() {
        point = new GoalLocation(5,5);
    }
    
    @Test
    public void testX(){
        assertEquals(5, point.getX());
    }
    
    @Test
    public void testY(){
        assertEquals(5, point.getY());
    }
    
    @Test
    public void testImg() {
        BufferedImage img;
        try {
            img = ImageIO.read(new File("src/main/resources/goal.png"));
        } catch (IOException e) {
            assertEquals(null, point.getImg());
            img = null;
        }
        if (img != null) {
            assertEquals(img.getHeight(), point.getImg().getHeight());
            assertEquals(img.getWidth(), point.getImg().getWidth());
        }
        
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
