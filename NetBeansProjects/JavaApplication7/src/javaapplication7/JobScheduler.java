/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author Kon
 */
public class JobScheduler {
    private ArrayList<Job>jobs;
    
    public JobScheduler(ArrayList<Job> jobsToSchedule) {
        this.jobs = jobsToSchedule;
    }
    
    public double calculateWeightedCompletionTimes() {
        Job[] sortedJobs = jobs.toArray(new Job[0]);
        Arrays.sort(sortedJobs, Collections.reverseOrder());
        
        double completionTime = 0;
        double weightedCompletionTime = 0;
        for (Job job : sortedJobs) {
            completionTime += job.length;
            weightedCompletionTime += completionTime * job.weight;
        }
        
        return weightedCompletionTime;
    }
}
