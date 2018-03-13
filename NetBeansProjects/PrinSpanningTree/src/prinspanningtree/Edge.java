/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package prinspanningtree;

/**
 *
 * @author Kon
 */
public class Edge {
    private Node head;
    private Node tail;
    private int value;
    
    public Edge(Node head, Node tail, int value) {
        this.head = head;
        this.tail = tail;
        this.value = value;
    }
    
    public Node getHead() {
        return this.head;
    }
    
    public Node getTail() {
        return this.tail;
    }
    
    public int getValue() {
        return this.value;
    }
    
    @Override
    public String toString() {
        return this.head.getId() + " " + this.tail.getId();
    }
}
