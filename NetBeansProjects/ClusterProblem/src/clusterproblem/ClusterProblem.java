/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clusterproblem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;

/**
 *
 * @author Kon
 */
public class ClusterProblem {

    private static int numNodes;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        PriorityQueue<Edge> edgeLengths = readLines("/tmp/clustering1.txt");
        Integer[] nodeMap = buildNodeList(numNodes);
        while (getDistinctGroups(nodeMap) > 4) {
            Edge e = edgeLengths.remove();
            if (!isSelfReferencing(e, nodeMap)) {
                System.out.println(e.getValue());
                mergeEdge(e, nodeMap);
            }
        }
        Edge answer = edgeLengths.remove();
        while (isSelfReferencing(answer, nodeMap)) {
            answer = edgeLengths.remove();
            //System.out.println(answer.getValue());
        }
        System.out.println(answer.getValue());
        System.in.read();
    }
    public static void mergeEdge(Edge e, Integer[] nodeMap) {
        // make tail value = head value
        int tailValue = nodeMap[e.getTail() - 1];
        int headValue = nodeMap[e.getHead() - 1];
        // find all nodes in nodeMap where value = tail value and set to head value
        for (int i=0; i<nodeMap.length; i++) {
            if (nodeMap[i] == tailValue) {
                nodeMap[i] = headValue;
            }
        }
    }
    public static int getDistinctGroups(Integer[] nodeMap) {
        HashSet<Integer> distinctNums = new HashSet<Integer>();
        distinctNums.addAll(Arrays.asList(nodeMap));
        return distinctNums.size();
    }
    public static boolean isSelfReferencing(Edge e, Integer[] nodeMap) {
        int headValue = nodeMap[e.getHead() - 1];
        int tailValue = nodeMap[e.getTail() - 1];
        return headValue == tailValue;
    }
    public static Integer[] buildNodeList(int numberOfNodes) {
        Integer[] nodes = new Integer[numberOfNodes];
        for (int i = 1; i <= numberOfNodes; i++){
            nodes[i - 1] = i;
        }
        
        return nodes;
    }
    public static PriorityQueue<Edge> readLines(String filename) throws IOException {
        FileReader fileReader = new FileReader(filename);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        PriorityQueue<Edge> edgeLengths = new PriorityQueue<Edge>();
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            String[] numbers = line.split(" ");
            if (numbers.length == 1) {
                numNodes = Integer.parseInt(numbers[0]);
            } else {
                Edge e = new Edge(
                        Integer.parseInt(numbers[0]), 
                        Integer.parseInt(numbers[1]), 
                        Integer.parseInt(numbers[2])
                );
                edgeLengths.add(e);
            }
        }
        bufferedReader.close();
        return edgeLengths;
    }
}
