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
public class NodeTest {
    
    public NodeTest() {
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

    @Test
    public void testEatNode() {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        
        n1.addNeighbor(n2);
        n1.addNeighbor(n3);
        n1.addNeighbor(n4);
        
        n2.addNeighbor(n1);
        
        n3.addNeighbor(n1);
        n3.addNeighbor(n4);
        
        n4.addNeighbor(n1);
        n4.addNeighbor(n3);
        
        n1.eatNode(n3);
        assert(n1.getIds().contains(3));
        assert(n1.getNeighbors().contains(n4));
        assert(!n1.getNeighbors().contains(n3));
        
        n1.eatNode(n4);
        assert(n1.getIds().contains(3));
        assert(n1.getIds().contains(4));
        assert(n1.getNeighbors().size() == 1);
        assert(n1.getNeighbors().contains(n2));
    }
}
