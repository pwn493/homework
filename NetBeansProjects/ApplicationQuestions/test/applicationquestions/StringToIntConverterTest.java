/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package applicationquestions;

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Kon
 */
public class StringToIntConverterTest {
    
    public StringToIntConverterTest() {
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
     * Test of convertToInt method, of class StringToIntConverter.
     */
    @Test
    public void testConvertToInt() {
        System.out.println("convertToInt");
        String input = "123";
        StringToLongConverter instance = new StringToLongConverter();
        long expResult = 123;
        long result = instance.convertToInt(input);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testConvertToIntError() {
        System.out.println("convertToInt");
        String input = "-2147483649";
        StringToLongConverter instance = new StringToLongConverter();
        long expResult = -2147483649L;
        long result = instance.convertToInt(input);
        assertEquals(expResult, result);
    }
}
