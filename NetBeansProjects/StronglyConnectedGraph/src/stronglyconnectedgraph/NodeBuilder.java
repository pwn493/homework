/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package stronglyconnectedgraph;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 *
 * @author Kon
 */
public class NodeBuilder {
    public Node[] buildNodeArray(String inputFile) throws FileNotFoundException, IOException {
        
        HashMap<Integer,Node> lookupTable = new HashMap<Integer,Node>();
        
        //start
        FileReader fileReader = new FileReader(inputFile);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            int id = getId(line);
            if (!lookupTable.containsKey(id)) {
                lookupTable.put(id, new Node(id));
            }
        }
        bufferedReader.close();
        
        //end
        
        FileReader fileReader2 = new FileReader(inputFile);
        BufferedReader bufferedReader2 = new BufferedReader(fileReader2);
        String line2;
        while ((line2 = bufferedReader2.readLine()) != null) {
            wireUpNodes(line2, lookupTable);
        }
        bufferedReader2.close();
        
        return lookupTable.values().toArray(new Node[0]);
    }
    
    private int getId(String line) {
        String[] temp = line.split("\\s+");
        return Integer.parseInt(temp[0]);
    }
    
    private void wireUpNodes(String line, HashMap<Integer, Node> lookupTable) {
        String[] temp = line.split("\\s+");

        int tailId = Integer.parseInt(temp[0]);
        int headId = Integer.parseInt(temp[1]);

        Node tail = lookupTable.get(tailId);
        Node head = lookupTable.get(headId);

        if (head == null) {
            head = new Node(headId);
            lookupTable.put(headId, head);
        }
        
        if (tail == null) {
            tail = new Node(tailId);
            lookupTable.put(tailId, tail);
        }
        
        tail.addOut(head);
        head.addIn(tail);
    }
}
