/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fwshortestpath;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Kon
 */
public class FWShortestPath {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // read in file get n and m and build the table where k = 0
        Integer[][] B = readLines("/tmp/g3.txt");
        int n = B.length - 1;
        Integer[][] A = new Integer[B.length][B.length];
        
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <=n; i++) {
                for (int j = 1; j <=n; j++) {
                    int nValue = (B[i][k] == Integer.MAX_VALUE ||B[k][j] == Integer.MAX_VALUE) ? Integer.MAX_VALUE : B[i][k] + B[k][j];
                    A[i][j] = Math.min(
                            B[i][j], 
                            nValue
                        );
                    if (i == j && A[i][j] < 0) {
                        System.out.println("negative loop");
                        return;
                    }
                }
            }
            B = A;
            A = new Integer[B.length][B.length];
        }
        
        int min = Integer.MAX_VALUE;
        for (int p = 1; p <=n; p++) {
            for (int q = 1; q <=n; q++) {
                if (B[p][q] < min) {
                    min = B[p][q];
                }
            }
        }
        
        System.out.println(min);
    }
    
    public static Integer[][] readLines(String filename) throws IOException {
        FileReader fileReader = new FileReader(filename);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        boolean isFirst = true;
        int n = 0;
        Integer[][] A = null;
        while ((line = bufferedReader.readLine()) != null) {
            String[] temp = line.split("\\s+");
            if (isFirst) {
                n = Integer.parseInt(temp[0]);
                isFirst = false;
                A = new Integer[n+1][n+1];
            } else {
                A[Integer.parseInt(temp[0])][Integer.parseInt(temp[1])] = Integer.parseInt(temp[2]);
            }
        }
        bufferedReader.close();
        
        for(int i=0; i<=n; i++) {
            for (int j=0; j<=n; j++){
                if (A[i][j] == null) {
                    A[i][j] = (i == j) ? 0 : Integer.MAX_VALUE;
                }
            }
        }

        return A;
    }
}
