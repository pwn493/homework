/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mapcontraction;

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Kon
 */
public class FindMinCutsTest {
    
    public FindMinCutsTest() {
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
     * Test of tryFindMinCuts method, of class FindMinCuts.
     */
    @Test
    public void testFindMinCuts() throws Exception {
        System.out.println("tryFindMinCuts");
        String[] input = {"1   2 3", "2  1 3 4", "3  1   2", "4 2"};
        FindMinCuts instance = new FindMinCuts();
        int expResult = 1;
        int result = instance.tryHarder(input);
        System.err.println(expResult + " " + result);
        assert(expResult == result);
    }
}
