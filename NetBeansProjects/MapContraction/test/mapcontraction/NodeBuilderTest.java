/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mapcontraction;

import java.util.Arrays;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Kon
 */
public class NodeBuilderTest {
    
    public NodeBuilderTest() {
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
     * Test of buildNodeArray method, of class NodeBuilder.
     */
    @Test
    public void testBuildNodeArray() {
        System.out.println("buildNodeArray");
        String[] input = {"1    3", "2  3", "3  1   2"} ;
        NodeBuilder instance = new NodeBuilder();
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        n1.addNeighbor(n3);
        n2.addNeighbor(n3);
        n3.addNeighbor(n1);
        n3.addNeighbor(n2);
        Node[] expResult = {n1, n2, n3};
        Node[] result = instance.buildNodeArray(input);
        assert(areEqual(result, expResult));
    }
    
    private boolean areEqual(Node[] n1, Node[] n2) {
        if (n1.length != n2.length) return false;
        
        for(int i = 0; i < n1.length; i++) {
            if (!Arrays.equals(n1[i].getIds().toArray(), n2[i].getIds().toArray())) return false;
            if (n1[i].getNeighbors().size() != n2[i].getNeighbors().size()) return false;
        }
        
        return true;
    }
}
