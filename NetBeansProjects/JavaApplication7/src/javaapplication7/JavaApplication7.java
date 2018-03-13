/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Kon
 */
public class JavaApplication7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        //Open file
        String filename = "/tmp/jobs.txt";
        ArrayList<Job> jobs = readLines(filename);
        //hand list to job scheduler
        JobScheduler scheduler = new JobScheduler(jobs);
        //ask scheduler to generate weighted completed times
        double weightedCompletionTimes = scheduler.calculateWeightedCompletionTimes();
        //return
        
        System.out.println(weightedCompletionTimes);
        System.in.read();
    }
    
    public static ArrayList<Job> readLines(String filename) throws IOException {
        FileReader fileReader = new FileReader(filename);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        ArrayList<Job> lines = new ArrayList<Job>();
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            Job job = stringToJob(line);
            if (job != null) {
                lines.add(job);
            }
        }
        bufferedReader.close();

        return lines;
    }
    
    public static Job stringToJob(String input) {
        String[] words = input.trim().split(" ");
        if (words.length != 2) {
            return null;
        }
        
        int weight = Integer.parseInt(words[0]);
        int length = Integer.parseInt(words[1]);
        
        return new Job(weight,length);
    }
}
