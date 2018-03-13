/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package twosat;

import java.io.*;

/**
 *
 * @author Kon
 */
public class TwoSat {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        FileReader fileReader = new FileReader("/tmp/2sat6.txt");
        FileWriter writer = new FileWriter("/tmp/2sat6p.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] temp = line.split("\\s+");
            if (temp.length == 2) {
                int a = Integer.parseInt(temp[0]);
                int b = Integer.parseInt(temp[1]);
                writer.write(-a + " " + b + "\n");
                writer.write(-b + " " + a + "\n");
            }
        }
        bufferedReader.close();
        writer.close();
    }
}
