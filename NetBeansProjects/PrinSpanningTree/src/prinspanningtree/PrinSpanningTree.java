/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package prinspanningtree;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 *
 * @author Kon
 */
public class PrinSpanningTree {

    static List<Edge>edges = new ArrayList<Edge>();
    static HashMap<Integer, Node>nIds = new HashMap<Integer, Node>();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        //Read in nodes and edges
        readLines("/tmp/edges.txt");
        //Create PrinSpanningTreeBuilder with nodes and edges
        PrinSpanningTreeBuilder builder = new PrinSpanningTreeBuilder();
        List<Edge> mst = builder.buildSpanningTree(new ArrayList<Node>(nIds.values()), edges);
        //Ask for total length of spanning tree
        System.out.println(sumEdgeLength(mst));
        System.in.read();
    }
    
    public static double sumEdgeLength (List<Edge> edges) {
        double sum = 0;
        for (Edge e : edges) {
            sum += e.getValue();
        }
        
        return sum;
    }
    
    public static void readLines(String filename) throws IOException {
        FileReader fileReader = new FileReader(filename);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            stringToGraph(line);
        }
        bufferedReader.close();
    }
    
    public static void stringToGraph(String input) {
        String[] words = input.trim().split(" ");
        if (words.length != 3) {
            return;
        }
        
        int node1 = Integer.parseInt(words[0]);
        int node2 = Integer.parseInt(words[1]);
        int cost = Integer.parseInt(words[2]);
        
        Node n1;
        Node n2;
        
        if (!nIds.containsKey(node1)) {
            nIds.put(node1, new Node(node1));
        }
        n1 = nIds.get(node1);
        
        if (!nIds.containsKey(node2)) {
            nIds.put(node2, new Node(node2));
        }
        n2 = nIds.get(node2);
        
        Edge e = new Edge(n1, n2, cost);
        n1.addEdge(e);
        n2.addEdge(e);
        edges.add(e);
    }
}
