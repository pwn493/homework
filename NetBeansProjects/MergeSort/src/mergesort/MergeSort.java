/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mergesort;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Kon
 */
public class MergeSort {

    private static long inversions = 0;
    
    public static void reset() {
        inversions = 0;
    }
    
    public static long getInversions() {
        return inversions;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        int[] numbers = readLines("/Users/Kon/Desktop/IntegerArray.txt");
        
        System.out.println(new Date().toString());
        
        mergeSort(numbers);
        
        
        System.out.println(new Date().toString());
        System.out.println(inversions);
    }
    
    public static int[] readLines(String filename) throws IOException {
        FileReader fileReader = new FileReader(filename);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        ArrayList<Integer> lines = new ArrayList<Integer>();
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            lines.add(Integer.parseInt(line));
        }
        bufferedReader.close();
        
        final int[] valueArray = new int[ lines.size() ];
        int counter = 0;
        for ( int value : lines ) {
        valueArray[ counter ] = value;
        counter++;
        }

        return valueArray;
    }
    
    public static int[] mergeSort(int[] input) {
        if (input.length < 2) {
            return input;
        }
        
        int middleIndex = input.length / 2 + input.length % 2;
        
        //System.out.println("mi " + middleIndex);
        int[] array1 = new int[middleIndex];
        System.arraycopy(input, 0, array1, 0, middleIndex);
        
        int[] array2 = new int[input.length / 2];
        System.arraycopy(input, middleIndex, array2, 0, input.length / 2);
        
        return merge(mergeSort(array1), mergeSort(array2));
    }
    
    public static int[] merge(int[] input1, int[] input2) {
        int[] output = new int[input1.length + input2.length];
        
        int i1 = 0, i2 = 0, o = 0;
        for (int k = 0; k < output.length; k++) {
            //System.out.println(String.format("k=%d kl=%d i2=%d i2l=%d i1=%d i1l=%d",k,output.length, i2,input2.length,i1,input1.length));
            if (i1 == input1.length) {
                output[k] = input2[i2];
                i2++;
            }
            else if (i2 == input2.length) {
                output[k] = input1[i1];
                i1++;
                //System.out.println(inversions);
            }
            else if (input1[i1] > input2[i2]) {
                output[k] = input2[i2];
                i2++;
                inversions += input1.length - i1;
                //System.out.println(inversions);
            }
            else {
                output[k] = input1[i1];
                i1++;
            }
        }

        return output;
    }
}
