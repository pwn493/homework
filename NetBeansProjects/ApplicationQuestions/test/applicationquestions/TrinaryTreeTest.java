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
public class TrinaryTreeTest {
    
    public TrinaryTreeTest() {
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
     * Test of Insert method, of class TrinaryTree.
     */
    @Test
    public void testInsert() {
        System.out.println("Insert");
        TrinaryTreeNode node = new TrinaryTreeNode(5);
        TrinaryTreeNode node1 = new TrinaryTreeNode(4);
        TrinaryTreeNode node2 = new TrinaryTreeNode(9);
        TrinaryTreeNode node3 = new TrinaryTreeNode(5);
        TrinaryTreeNode node4 = new TrinaryTreeNode(7);
        TrinaryTreeNode node5 = new TrinaryTreeNode(2);
        TrinaryTreeNode node6 = new TrinaryTreeNode(2);
        TrinaryTree instance = new TrinaryTree();
        instance.insert(node);
        instance.insert(node1);
        instance.insert(node2);
        instance.insert(node3);
        instance.insert(node4);
        instance.insert(node5);
        instance.insert(node6);
        
        assertEquals(instance.root, node);
    }

    /**
     * Test of Delete method, of class TrinaryTree.
     */
    @Test
    public void testDelete() {
        System.out.println("Delete");
        
        TrinaryTreeNode node = new TrinaryTreeNode(5);
        TrinaryTreeNode node1 = new TrinaryTreeNode(4);
        TrinaryTreeNode node2 = new TrinaryTreeNode(9);
        TrinaryTreeNode node3 = new TrinaryTreeNode(5);
        TrinaryTreeNode node4 = new TrinaryTreeNode(7);
        TrinaryTreeNode node5 = new TrinaryTreeNode(2);
        TrinaryTreeNode node6 = new TrinaryTreeNode(2);
        TrinaryTree instance = new TrinaryTree();
        
        instance.insert(node);
        instance.insert(node1);
        instance.insert(node2);
        instance.insert(node3);
        instance.insert(node4);
        instance.insert(node5);
        instance.insert(node6);
        
        instance.delete(4);
        
        assertEquals(instance.root, node);
    }
}
