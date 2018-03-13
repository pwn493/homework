/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package applicationquestions;

import java.util.HashMap;

/**
 * I chose to use a lookup table to convert the characters to ints.
 * I could have used the ascii value of the characters to convert to integers,
 * but there are two problems with that solution.
 * 1. It's hard to see bugs in that solution.
 * 2. It restricts you to converting number patterns that are contiguous in ascii
 * @author Danny
 */
public class StringToLongConverter {
    private HashMap<Character, Integer> lookup = new HashMap<Character, Integer>() {
        {
            put('0', 0);
            put('1', 1);
            put('2', 2);
            put('3', 3);
            put('4', 4);
            put('5', 5);
            put('6', 6);
            put('7', 7);
            put('8', 8);
            put('9', 9);
        }
    };
    
    public long convertToInt(String input) {
        long negOrPos = 1;
        if (isNegative(input)) {
            negOrPos = -1;
            input = input.substring(1);
        }
        
        int endIndex = input.length() - 1;
        long total = 0;        
        long tens = 1;
        
        for (int i = endIndex; i > -1; i--) {
            Character key = input.charAt(i);
            
            if (!this.lookup.containsKey(key)) {
                throw new IllegalArgumentException("You must provide a string only containing digits 0-9");
            }
            
            int value = this.lookup.get(key);
            total += tens * value;
            tens = tens * 10;
        }
        
        return total * negOrPos;
    }
    
    private boolean isNegative(String string) {
        return string.startsWith("-");
    }
}
