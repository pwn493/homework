/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package quicksort;

import java.util.Arrays;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Kon
 */
public class QuickSortTest {
    
    public QuickSortTest() {
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
     * Test of main method, of class QuickSort.
     */
    @Test
    public void testPivot() {
        int[] input = {2, 3, 1, 4};
        int[] expected = {1, 2, 3, 4 };
        QuickSort.pivot(input, 0, input.length);
        
        assert Arrays.equals(input, expected);
    }
    
    @Test
    public void testSort() {
        int[] input = {9,2,3,8,4,7,2,9,3,8};
        int[] expected = {2,2,3,3,4,7,8,8,9,9};
        QuickSort.sort(input, 0, input.length);
        
        assert Arrays.equals(input, expected);
    }
    
    @Test
    public void testComparisons() {
        int[] input = {1, 2, 3, 4};
        long expected = 6;
        
        assert expected == QuickSort.sort(input, 0, input.length);
    }
}
