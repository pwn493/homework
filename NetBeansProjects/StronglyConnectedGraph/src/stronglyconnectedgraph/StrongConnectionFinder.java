/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package stronglyconnectedgraph;

import java.util.*;

/**
 *
 * @author Kon
 */
public class StrongConnectionFinder {
    private int finishTime;
    
    public Integer[] findLargestConnectedSizes(Node[] nodes) {
        Node[] finishTimeSorted = dfsLoop(nodes, false);
        resetNodes(finishTimeSorted);
        dfsLoop(finishTimeSorted, true);
        return getConnectionSizes(finishTimeSorted);
    }
    
    public boolean findIfConnectionsHaveConflictingData(Node[] nodes) {
        Node[] finishTimeSorted = dfsLoop(nodes, false);
        resetNodes(finishTimeSorted);
        dfsLoop(finishTimeSorted, true);
        return hasContradiction(finishTimeSorted);
    }
    
    public Node[] dfsLoop(Node[] nodes, boolean forward) {
        Node leader = null;
        
        Node[] finishTimeNodes = new Node[nodes.length];
        for (int i = nodes.length - 1; i >= 0; i--) {
            if (!nodes[i].isExplored()) {
                leader = nodes[i];
                DFS(nodes[i], nodes[i], forward, finishTimeNodes);
            }
        }
        
        return finishTimeNodes;
    }
    
    public void DFS(Node node, Node leader, boolean forward, Node[] outputNodes) {
        
        node.explore();
        int leaderId = leader.getId();
        node.setLeader(leaderId);

        List<Node> leaves = (forward) ? node.getOut() : node.getIn();

        for (Node leaf : leaves) {
            if (!leaf.isExplored()) {
                DFS(leaf, leader, forward, outputNodes);
            }
        }
        
        outputNodes[this.finishTime++] = node;
    }
    
    private void resetNodes(Node[] nodes) {
        for (Node n : nodes) {
            n.reset();
        }
        
        this.finishTime = 0;
    }
    
    private Integer[] getConnectionSizes(Node[] nodes) {
        HashMap<Integer, Integer> table = new HashMap<Integer, Integer>();
        
        for (Node n : nodes) {
            int l = n.getLeader();
            if (!table.containsKey(l)) {
                table.put(l, 0);
            }
            
            table.put(l, table.get(l) + 1);
        }
        
        Integer[] output = table.values().toArray(new Integer[0]);
        Arrays.sort(output, Collections.reverseOrder());
        return output;
    }
    
    private boolean hasContradiction(Node[] nodes) {
        HashMap<Integer, HashSet<Integer>> table = new HashMap<Integer, HashSet<Integer>>();
        
        for (Node n : nodes) {
            int l = n.getLeader();
            if (!table.containsKey(l)) {
                table.put(l, new HashSet<Integer>());
            }
            
            HashSet<Integer> stuff = table.get(l);
            int id = n.getId();
            if (stuff.contains(-id)) {
                return true;
            }
            
            stuff.add(id);
        }
        
        return false;  
    }
}
