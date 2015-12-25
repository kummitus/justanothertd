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
 * @author antti
 */
public class PathPointTest {
    
    PathPoint point;
    
    public PathPointTest() {
    }
    

    @Before
    public void setUp() {
        point = new PathPoint(5,5);
    }
    
    @Test
    public void testX(){
        assertEquals(5, point.getX());
    }
    
    @Test
    public void testY(){
        assertEquals(5, point.getY());
    }
    

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
