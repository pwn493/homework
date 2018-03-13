/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package prinspanningtree;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kon
 */
public class Node implements Comparable {
    private int id;
    private List<Edge> edges;
    private int key;
    
    public Node(int id) {
        this.id = id;
        this.edges = new ArrayList<Edge>();
        this.key = Integer.MAX_VALUE;
    }
    
    public void addEdge(Edge edge) {
        this.edges.add(edge);
    }
    
    public List<Edge> getEdges() {
        return this.edges;
    }
    
    public int getId() {
        return this.id;
    }
    
    public Integer getKey() {
        return this.key;
    }
    
    public void setKey(int key) {
        this.key = key;
    }

    @Override
    public int compareTo(Object t) {
        Integer k = this.key;
        Node other = (Node) t;
        return k.compareTo(other.getKey());
    }
    
    @Override
    public String toString() {
        return this.id + " " + this.key;
    }
}
