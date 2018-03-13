/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mapcontraction;

import java.util.*;

/**
 *
 * @author Kon
 */
public class FindMinCuts {
    private static Random r = new Random();
    
    public int tryHarder(String[] nodes) throws Exception {
        int tries = nodes.length * nodes.length;
        
        int minCuts = Integer.MAX_VALUE;
        for(int i = 0; i < tries; i++) {
            int attempt = tryFindMinCuts(new NodeBuilder().buildNodeArray(nodes));
            if (attempt < minCuts) minCuts = attempt;
        }
        
        return minCuts;
    }
    
    public int tryFindMinCuts(Node[] nodes) throws Exception {
        List<Node> nodesLeft = new ArrayList(Arrays.asList(nodes));
        converge(nodesLeft);
        int count =  countMinNodes(nodesLeft);
        return count;
    }
    
    public void converge(List<Node> nodes) throws Exception {
        int id = 0, nid = 0, nindex = 0;
        
        if (nodes.size() == 2) return;

        // pick a nonnull node
        id = r.nextInt(nodes.size());
        Node n = nodes.get(id);
        // pick one of its edges
        nid = r.nextInt(n.getNeighbors().size());
        
        Node n2 = n.getNeighbors().get(nid);
        nindex = nodes.indexOf(n2);
        
        if (nindex == -1) {
            for (Node nd : nodes) {
                if (nd.getIds().contains(n2.getIds().get(0))) {
                    n.switchNeighbor(n2, nd);
                    n2 = nd;
                    nindex = nodes.indexOf(nd);
                    break;
                }
            }
        } 
        
        try {
            
            for (Node nd : nodes) {
                if (nd.getNeighbors().contains(n2)) {
                    nd.switchNeighbor(n2, n);
                }
            }
            
            // first node eatNode other
            n.eatNode(n2);
            
            nodes.remove(nindex);
            
        }
        catch (Exception e) {
            System.out.println(e.toString());
            
            for (Node nd : nodes) {
                System.out.println(nd.toString());
            }
            
            System.out.println(nodes.size());
            System.out.println(id);
            System.out.println(nid);
            System.out.println(nindex);
            System.out.println(n);
            System.out.println(n2);
            
            throw e;
        }
        converge(nodes);
    }
    
    public int countMinNodes(List<Node> nodes) {
        for (Node n : nodes) {
            if (n != null) {
                return n.getNeighbors().size();
            }
        }
        
        return 0;
    }
}
