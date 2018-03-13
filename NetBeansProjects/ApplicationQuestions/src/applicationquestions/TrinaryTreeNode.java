/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package applicationquestions;

/**
 *
 * @author Kon
 */
public class TrinaryTreeNode {
    // Normall I would create getters and setters for all these properties
    public int value;
    public TrinaryTreeNode greaterChild;
    public TrinaryTreeNode lesserChild;
    public TrinaryTreeNode twin;
    
    public TrinaryTreeNode(int value) {
        this.value = value;
    }
    
    @Override
    public String toString() {
        return Integer.toString(value);
    }
}
