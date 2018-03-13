/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package stronglyconnectedgraph;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Kon
 */
public class StronglyConnectedGraph {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        //Node[] nodes = new NodeBuilder().buildNodeArray("/Users/Kon/Desktop/testFile");
        for (int i = 0; i < 6; i++) {
           Node[] nodes = new NodeBuilder().buildNodeArray("/tmp/2sat" + (i + 1) + "p.txt"); 
           
           boolean sol = !(new StrongConnectionFinder().findIfConnectionsHaveConflictingData(nodes));
           System.out.println(sol);
        }
    }
}
