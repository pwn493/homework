/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package twosum;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 *
 * @author Kon
 */
public class TwoSum {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        SumFinder finder = new SumFinder(readLines("/Users/Kon/Desktop/HashInt.txt"));
        int[] input = {231552,234756,596873,648219,726312,981237,988331,1277361,1283379};
        for(int i : input) {
            System.out.println(i + " " + finder.canSum(i));
        }
        
        System.in.read();
    }
    
        public static HashMap<Integer, Integer> readLines(String filename) throws IOException {
        FileReader fileReader = new FileReader(filename);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        HashMap<Integer, Integer> lines = new HashMap<Integer, Integer>();
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            int i = Integer.parseInt(line);
            if (!lines.containsKey(i)) {
                lines.put(i, 0);
            }
            
            lines.put(i, lines.get(i) + 1);
        }
        bufferedReader.close();

        return lines;
    }
    
}
