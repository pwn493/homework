/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package twosum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Kon
 */
public class SumFinderTest {
    
    public SumFinderTest() {
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
     * Test of canSum method, of class SumFinder.
     */
    @Test
    public void testCanSum() {
        System.out.println("canSum");
        int total = 4;
        HashMap<Integer,Integer> set = newHashMap(1,3,5,9,9);
        SumFinder instance = new SumFinder(set);
        boolean expResult = true;
        boolean result = instance.canSum(total);
        assertEquals(expResult, result);
        
        assertEquals(false, instance.canSum(7));
        
        assertEquals(false, instance.canSum(2));
        
        assertEquals(true, instance.canSum(18));
    }
    
    public static HashMap<Integer, Integer> newHashMap(Integer... ints) {
        HashMap<Integer, Integer> set = new HashMap<Integer, Integer>();
        for (int i : ints) {
            if (!set.containsKey(i)) {
                set.put(i, 0);
            }
            
            set.put(i, set.get(i) + 1);
        }
        
        return set;
    }
}
