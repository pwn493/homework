/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package twosum;

import java.util.HashMap;
import java.util.HashSet;

/**
 *
 * @author Kon
 */
public class SumFinder {
    private HashMap<Integer, Integer> numberSet;
    
    public SumFinder(HashMap<Integer, Integer> numberSet) {
        this.numberSet = numberSet;
    }
    
    public boolean canSum(int total) {
        for (int i : this.numberSet.keySet()) {
            if (this.numberSet.containsKey(total - i)) {
                if (total - i != i || this.numberSet.get(i) > 1) {
                    return true;
                }
            }
        }
        
        return false;
    }
}
