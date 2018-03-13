/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication7;

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Kon
 */
public class JobTest {
    
    public JobTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of value method, of class Job.
     */
    @Test
    public void testValue() {
        Job instance = new Job(4,3);
        Integer expResult = 1;
        Double result = instance.value();
        assertEquals(expResult, result);
    }

    /**
     * Test of compareTo method, of class Job.
     */
    @Test
    public void testCompareTo() {
        Object t = new Job(5,3);
        Job instance = new Job(3,5);
        int expResult = -1;
        int result = instance.compareTo(t);
        assertEquals(expResult, result);
    }
}
