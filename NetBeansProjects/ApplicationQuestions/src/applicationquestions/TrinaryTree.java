/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package applicationquestions;

import com.sun.tools.javac.util.Pair;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kon
 */
public class TrinaryTree {
    public TrinaryTreeNode root;
    
    public void delete(int value) {
        TrinaryTreeNode node = trimNode(value);
        
        if (node == null) return;
        
        List<TrinaryTreeNode> children = getAllDescendants(node);
        
        for (TrinaryTreeNode child : children) {
            insert(child);
        }
    }
    
    private List<TrinaryTreeNode> getAllDescendants(TrinaryTreeNode node) {
        List<TrinaryTreeNode> nodes = new ArrayList<TrinaryTreeNode>();
        
        getAllDescendants(node.greaterChild, nodes);
        getAllDescendants(node.lesserChild, nodes);
        getAllDescendants(node.twin, nodes);
        
        return nodes;
    }

    private void getAllDescendants(TrinaryTreeNode node, List<TrinaryTreeNode> list) {
        if (node == null) return;
        
        list.add(node);
        getAllDescendants(node.greaterChild, list);
        getAllDescendants(node.lesserChild, list);
        getAllDescendants(node.twin, list);
    }
    
    /*
     * returns the parent and child
     */
    private TrinaryTreeNode trimNode(int value) {
        TrinaryTreeNode current = this.root;
        TrinaryTreeNode parent = null;
        
        while (current != null) {
            if (value > current.value) {
                parent = current;
                current = current.greaterChild;
            }
            if (value < current.value) {
                parent = current;
                current = current.lesserChild;
            }
            if (value == current.value) {
                if (current.twin != null) {
                    parent = current;
                    current = current.twin;
                } else {
                    if (current.value < parent.value) parent.lesserChild = null;
                    if (current.value > parent.value) parent.greaterChild = null;
                    if (current.value == parent.value) parent.twin = null;
                    
                    return current;
                }
            }
        }
        
        return null;
    }
    
    public void insert(TrinaryTreeNode node) {
        if (this.root == null) {
            this.root = node;
            return;
        }
        
        TrinaryTreeNode current = this.root;
        
        while (current != null) {
            if (node.value > current.value) {
                if (current.greaterChild == null) {
                    current.greaterChild = node;
                    break;
                }
                current = current.greaterChild;
            }
            if (node.value < current.value) {
                if (current.lesserChild == null) {
                    current.lesserChild = node;
                    break;
                }
                current = current.lesserChild;
            }
            if (node.value == current.value) {
                if (current.twin == null) {
                    current.twin = node;
                    break;
                }
                current = current.twin;
            }
        }
    }
}
