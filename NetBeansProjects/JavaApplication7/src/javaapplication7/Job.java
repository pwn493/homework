/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication7;

/**
 *
 * @author Kon
 */
public class Job implements Comparable {
    public Integer weight;
    public Integer length;
    
    public Job(int weight, int length) {
        this.weight = weight;
        this.length = length;
    }
    
    public Double value() {
        double dw = (double) this.weight;
        double dl = (double) this.length;
        return dw/dl;
    }

    @Override
    public int compareTo(Object t) {
        Job otherJob = (Job) t;
        Double myValue = this.value();
        Double otherValue = otherJob.value();
        
        if (myValue == otherValue) {
            return this.weight.compareTo(otherJob.weight);
        } else {
            return myValue.compareTo(otherValue);
        }
    }
}
