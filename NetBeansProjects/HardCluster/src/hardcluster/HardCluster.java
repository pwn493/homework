/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hardcluster;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

/**
 *
 * @author Kon
 */
public class HardCluster {

    private static int numNodes;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        HashSet<Integer> bits = readLines("/tmp/test23.txt");
        int n = bits.size();
        List<Integer> bitList = new ArrayList<Integer>(bits);
        for (int i = 0; i < bits.size(); i++) {
            int item = bitList.get(i);
            n -= numberSingleBitDifference(item, bits);
            n -= numberDoubleBitDifference(item, bits);
            bits.remove(item);
        }
        
        System.out.println(n);
        System.in.read();
    }
    
    public static int numberSingleBitDifference(Integer item, HashSet<Integer> bits) {
        int singleBitMatches = 0;
        for (int i=0; i<24; i++) {
            //change that bit
            int xorThing = ((Double)Math.pow(2, i)).intValue();
            int temp = item ^ xorThing;
            //search
            if (bits.contains(temp)) {
                singleBitMatches++;
            }
        }
        
        return singleBitMatches;
    }
    
    public static int numberDoubleBitDifference(Integer item, HashSet<Integer> bits) {
        int doubleBitMatches = 0;
        for (int i=0; i<24; i++) {
            for (int j=i+1; j<24; j++) {
                //change that bit
                int xorThing = ((Double)Math.pow(2, i)).intValue() + ((Double)Math.pow(2,j)).intValue();
                int temp = item ^ xorThing;
                //search
                if (bits.contains(temp)) {
                    doubleBitMatches++;
                }
            }
        }
        
        return doubleBitMatches;       
    }
    
    public static HashSet<Integer> readLines(String filename) throws IOException {
        FileReader fileReader = new FileReader(filename);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        HashSet<Integer> bits = new HashSet<Integer>();
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            String formattedLine = line.replaceAll(" ", "");
            Integer i = Integer.parseInt(formattedLine, 2);
            bits.add(i);
        }
        bufferedReader.close();
        return bits;
    }
}
