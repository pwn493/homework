/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mapcontraction;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Kon
 */
public class MapContraction {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, Exception {
        System.out.println(new FindMinCuts().tryHarder(readLines("/Users/Kon/Documents/kargerAdj.txt")));
        System.in.read();
        // Call FindMinCuts
    }
    
    public static String[] readLines(String filename) throws IOException {
        FileReader fileReader = new FileReader(filename);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        ArrayList<String> lines = new ArrayList<String>();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            lines.add(line);
        }
        bufferedReader.close();
        
        return lines.toArray(new String[0]);
    }
}
