/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package knapsack;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kon
 */
public class Knapsack {

    private static int totalSize = 0;
    private static int numberItems = 0;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // read in nodes + max value and n
        List<Item> items = readLines("/tmp/knapsack2.txt");
        // put nodes into an array
        //double[][] A = new double[numberItems + 1][totalSize+1];
        double[] last = new double[totalSize + 1];
        double[] current = new double[totalSize + 1];

        for (int i = 1; i <= numberItems; i++) {
            for (int x = 0; x <= totalSize; x++) {
                // calculate current solution
                double curr = last[x];
                // calculate potential solution
                double pot = 0;
                if (x - items.get(i).size >= 0) {
                    pot = last[x - items.get(i).size] + items.get(i).value; 
                }
                // update 2d matrix with better solution
                current[x] = Math.max(curr, pot);
            }
            
            last = current;
            current = new double[totalSize+1];
        }
        
        System.out.println(last[totalSize]);
        //System.in.read();
    }
    
    public static ArrayList<Item> readLines(String filename) throws IOException {
        FileReader fileReader = new FileReader(filename);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        ArrayList<Item> lines = new ArrayList<Item>();
        String line = null;
        boolean isFirst = true;
        while ((line = bufferedReader.readLine()) != null) {
            String[] temp = line.split("\\s+");
            if (isFirst) {
                totalSize = Integer.parseInt(temp[0]);
                numberItems = Integer.parseInt(temp[1]);
                isFirst = false;
            }

            Item i = new Item(Integer.parseInt(temp[1]), Integer.parseInt(temp[0]));
            lines.add(i);
        }
        bufferedReader.close();

        return lines;
    }
}
