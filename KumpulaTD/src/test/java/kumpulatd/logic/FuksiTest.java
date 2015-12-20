/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kumpulatd.logic;

import kumpulatd.logic.Fuksi;
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
public class FuksiTest {
    
    Fuksi fuksi;
    
    public FuksiTest() {
    }
    

    
    @Before
    public void setUp() {
        
        fuksi = new Fuksi();
    }
    
    @Test
    public void testNewFuksi(){
        assertEquals(100, fuksi.getHP());
        assertEquals(5, fuksi.getSpeed());
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
