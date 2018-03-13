/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication7;

import java.util.ArrayList;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Kon
 */
public class JobSchedulerTest {
    
    public JobSchedulerTest() {
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
     * Test of calculateWeightedCompletionTimes method, of class JobScheduler.
     */
    @Test
    public void testCalculateWeightedCompletionTimes() {
        ArrayList<Job> jobs = new ArrayList<Job>();
        jobs.add(new Job(3,5));
        jobs.add(new Job(1,2));
        JobScheduler instance = new JobScheduler(jobs);
        double expResult = 23;
        double result = instance.calculateWeightedCompletionTimes();
        assertEquals(expResult, result, 0.0);
    }
}
