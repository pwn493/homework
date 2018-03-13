/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package quicksort;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Kon
 */
public class QuickSort {

    public static long sort(int[] array, int startIndex, int length) {
        if (length < 2) {
            return 0;
        }
        
        long comparisons = length - 1;
        
        // pivot the array
        int pivotIndex = pivot(array, startIndex, length);
        // call sort on each part of the sub array
        int length1 = pivotIndex - startIndex;
        int length2 = length + startIndex - pivotIndex - 1;
        comparisons += sort(array, startIndex, length1);
        comparisons += sort(array, pivotIndex + 1, length2);
        
        return comparisons;
    }
    
    public static int pivot(int[] array, int startIndex, int length) {
        int medianIndex = startIndex;
        int middleIndex = length / 2 + length % 2 + startIndex - 1;
        int lastIndex = startIndex + length - 1;
        if (isBetween(array[startIndex], array[middleIndex], array[lastIndex])) {
            medianIndex = startIndex;
        }
        if (isBetween(array[middleIndex], array[startIndex], array[lastIndex])) {
            medianIndex = middleIndex;
        }
        if (isBetween(array[lastIndex], array[middleIndex], array[startIndex])) {
            medianIndex = lastIndex;
        }
        exchange(array, startIndex, medianIndex);
        int pivot = array[startIndex];
        int secondPartition = startIndex + 1;
        
        for (int i = startIndex + 1; i < startIndex + length; i++) {
            // if the value is less than i then switch with secondPartition and increment
            if (array[i] < pivot) {
                exchange(array, i, secondPartition);
                secondPartition++;
            }
        }
        
        exchange(array, secondPartition - 1, startIndex);
        return secondPartition - 1;
    }
    
    public static boolean isBetween(int consideration, int bound1, int bound2) {
        return (consideration < bound1 && consideration > bound2) || (consideration > bound1 && consideration < bound2);
    }
    
    public static void exchange(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        int[] numbers = readLines("/Users/Kon/Downloads/QuickSort.txt");
        
        System.out.println(new Date().toString());
        
        long comparisons = sort(numbers, 0 , numbers.length);

        System.out.println(new Date().toString());
        System.out.println(comparisons);
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
}
