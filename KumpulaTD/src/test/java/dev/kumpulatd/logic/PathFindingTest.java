package dev.kumpulatd.logic;

import dev.kumpulatd.logic.PathFinding;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author antti
 */
public class PathFindingTest {

    PathFinding path;

    public PathFindingTest() {
    }

    @Before
    public void setUp() {
        path = new PathFinding();
    }
    
    @Test
    public void getSinglePoint(){
        path.addPoint(0, 0);
        assertEquals(path.getPoint(0), path.getPoint(0));
    }
    
    @Test
    public void getSinglePointSize(){
        path.addPoint(0, 0);
        assertEquals(1, path.getSize());
    }
    
    @Test
    public void getInvalidPoint(){
        assertEquals(null, path.getPoint(0));
    }
    
    @Test
    public void sizeZeroListIsZeroSize(){
        assertEquals(0, path.getPoints().size());
    }

}
