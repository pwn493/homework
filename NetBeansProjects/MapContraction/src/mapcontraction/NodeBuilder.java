/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mapcontraction;

import java.util.ArrayList;

import mapcontraction.Node;

/**
 *
 * @author Kon
 */
public class NodeBuilder {
    public Node[] buildNodeArray(String[] input) {
        ArrayList<Node> preOutput = new ArrayList<Node>();
        int start = 0;
        for(String line : input) {
            String[] temp = line.split("\\s+");
            
            if ("".equals(temp[0])) {
                start = 1;
            }
            
            preOutput.add(new Node(Integer.parseInt(temp[start])));
        }
        
        Node[] output = preOutput.toArray(new Node[0]);
        
        for (String line : input) {
            String[] temp = line.split("\\s+");
            
            int id = Integer.parseInt(temp[start]);
            for (int i = start + 1; i < temp.length; i++) {
                int neighbor = Integer.parseInt(temp[i]);
                output[id-1].addNeighbor(output[neighbor-1]);
            }
        }
        
        return output;
    }
}
