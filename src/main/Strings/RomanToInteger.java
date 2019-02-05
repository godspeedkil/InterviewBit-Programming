package Strings;

import java.util.HashMap;

/**
 * Given a roman numeral, convert it to an integer.
 *
 * Input is guaranteed to be within the range from 1 to 3999.
 *
 * Read more details about roman numerals at Roman Numeric System
 *
 * Example :
 *
 * Input : "XIV"
 * Return : 14
 * Input : "XX"
 * Output : 20
 */
public class RomanToInteger {
    private static HashMap<Character, Integer> numerals = new HashMap();

    /**
     * Going from right-to-left deals with "subtracting" numbers by itself.
     * If the current number is less than the previous (the one to the right
     * of it), then subtract, else add.
     * O(n) solution.
     */
    public static int romanToInt(String A) {
        numerals.put('I', 1);
        numerals.put('V', 5);
        numerals.put('X', 10);
        numerals.put('L', 50);
        numerals.put('C', 100);
        numerals.put('D', 500);
        numerals.put('M', 1000);
        int result = 0;
        int prev = A.length()-1;

        for(int i=A.length()-1; i>=0; i--) {
            int currentVal = numerals.get(A.charAt(i));
            int prevVal = numerals.get(A.charAt(prev));
            if(currentVal<prevVal)
                result -= currentVal;
            else
                result += currentVal;
            prev = i;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("XXX"));
        System.out.println(romanToInt("I"));
        System.out.println(romanToInt("IX"));
        System.out.println(romanToInt("MMMCMXCIX"));
    }
}
