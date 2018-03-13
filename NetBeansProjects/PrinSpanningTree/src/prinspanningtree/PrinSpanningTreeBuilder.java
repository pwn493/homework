/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package prinspanningtree;

import java.util.*;

/**
 *
 * @author Kon
 */
public class PrinSpanningTreeBuilder {
    public List<Edge> buildSpanningTree(List<Node> nodes, List<Edge> edges) {
        PriorityQueue<Node> heap = new PriorityQueue<Node>();
        // get a node
        Node start = nodes.get(0);
        nodes.remove(start);
        List<Node> X = new ArrayList<Node>();
        HashSet<Integer> xIds = new HashSet<Integer>();
        List<Edge> T = new ArrayList<Edge>();
        
        X.add(start);
        xIds.add(start.getId());
        
        //assign key values
        for (Edge e : start.getEdges()) {
            Node other = (e.getHead() == start) ? e.getTail() : e.getHead();
            other.setKey(e.getValue());
        }
        
        // add to heap
        for (Node n : nodes) {
            heap.add(n);
        }
        
        // loop while heap is not empty
        while (heap.size() > 0) {
            // pick the minimum value in the queue and add to X
            Node min = heap.remove();
            xIds.add(min.getId());
            X.add(min);
            // Find the edge with that value in that node and add it to T
            for (Edge e : min.getEdges()) {
                if (e.getValue() == min.getKey()) {
                    Node other = (e.getHead() == min) ? e.getTail() : e.getHead();
                    if (xIds.contains(other.getId())) {
                        // We have the right edge
                        T.add(e);
                        break;
                    }
                }
            }

            // foreach edge e in x
            for(Edge e : min.getEdges()) {
                Node other = (e.getHead() == min) ? e.getTail() : e.getHead();
                if (!xIds.contains(other.getId())) {
                    // recalculate heap values
                    if (other.getKey() > e.getValue()) {
                        heap.remove(other);
                        other.setKey(e.getValue());
                        heap.add(other);
                    }
                }
            }
        }
        return T;
    }
}
