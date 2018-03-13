/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mergesort;

import java.util.Arrays;
import org.junit.*;

/**
 *
 * @author Kon
 */
public class MergeSortTest {
    
    public MergeSortTest() {
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
     * Test of mergeSort method, of class MergeSort.
     */
    @Test
    public void testMergeSort() {
        MergeSort.reset();
        System.out.println("mergeSort");
        int[] array1 = { 3, 5, 1 };
        int[] expResult = {1, 3, 5};
        int[] result = MergeSort.mergeSort(array1);
        
        System.out.println(MergeSort.getInversions());
        assert Arrays.equals(expResult, result);
        
        MergeSort.reset();
        int[] array2 = {5,2,3,1};
        int[] expResult1 = {1,2,3,5};
        int[] result1 = MergeSort.mergeSort(array2);
        
        System.out.println(MergeSort.getInversions());
        assert Arrays.equals(expResult1, result1);
    }
}
