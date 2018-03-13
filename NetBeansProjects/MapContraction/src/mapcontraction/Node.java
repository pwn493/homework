/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mapcontraction;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kon
 */
public class Node {
    private List<Integer> ids;
    private List<Node> neighbors;
    
    public Node(int id, ArrayList<Node> neighbors) {
        this.ids = new ArrayList<Integer>();
        this.ids.add(id);
        this.neighbors = neighbors;
    }
    
    public Node(int id) {
        this.ids = new ArrayList<Integer>();
        this.ids.add(id);
        this.neighbors = new ArrayList<Node>();
    }
    
    public void eatNode(Node other) {
        if (other == null) return;
        this.ids.addAll(other.getIds());
        this.neighbors.addAll(other.getNeighbors());
        
        List<Node> temp = (List<Node>)new ArrayList(this.neighbors).clone();
        for (Node neighbor : temp) {
            for (int id : this.ids) {
                if (neighbor.getIds().contains(id)) {
                    this.neighbors.remove(neighbor);
                    continue;
                }
            }
        }
    }
    
    public List<Integer> getIds() {
        return this.ids;
    }
    
    public List<Node> getNeighbors() {
        return this.neighbors;
    }
    
    public void addNeighbor(Node other) {
        this.neighbors.add(other);
    }
    
    @Override
    public String toString() {
        StringBuilder neighborString = new StringBuilder();
        for (Node n : this.neighbors) {
            neighborString.append(" : " + n.getIds().toString());
        }
        
        return this.ids + neighborString.toString();
    }

    public void switchNeighbor(Node old, Node newer) {
        if( ! this.neighbors.remove(old)) {
            System.out.println("p");
        }
        this.neighbors.add(newer);
    }
}
