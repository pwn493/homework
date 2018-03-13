/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clusterproblem;

/**
 *
 * @author Kon
 */
public class Edge implements Comparable {
    private int head;
    private int tail;
    private int value;
    
    public Edge(int head, int tail, int value) {
        this.head = head;
        this.tail = tail;
        this.value = value;
    }
    
    public int getHead() {
        return this.head;
    }
    
    public int getTail() {
        return this.tail;
    }
    
    public int getValue() {
        return this.value;
    }
    
    @Override
    public String toString() {
        return this.head + " " + this.tail;
    }

    @Override
    public int compareTo(Object t) {
        Integer v = this.value;
        Integer ov = ((Edge)t).value;
        return v.compareTo(ov);
    }
}
