/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package stronglyconnectedgraph;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kon
 */
public class Node {
    private int id;
    private boolean explored;
    private int leader;
    private List<Node> out;
    private List<Node> in;
    
    public Node(int id) {
        this.id = id;
        this.out = new ArrayList<Node>();
        this.in = new ArrayList<Node>();
    }
    
    public int getId() {
        return this.id;
    }
    
    public List<Node> getOut() {
        return this.out;
    }
    
    public List<Node> getIn() {
        return this.in;
    }
    
    public int getLeader() {
        return this.leader;
    }
    
    public void setLeader(int leader) {
        this.leader = leader;
    }
    
    public void addOut(Node other) {
        this.out.add(other);
    }
    
    public void addIn(Node other) {
        this.in.add(other);
    }
    
    public boolean isExplored() {
        return this.explored;
    }
    
    public void explore() {
        this.explored = true;
    }
    
    public void reset() {
        this.explored = false;
    }
    
    @Override
    public String toString() {
        StringBuilder neighborString = new StringBuilder();
        for (Node n : this.out) {
            neighborString.append(" : ").append(n.getId());
        }
        
        return this.id + neighborString.toString();
    }
}
