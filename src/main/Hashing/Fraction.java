package Hashing;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.
 *
 * If the fractional part is repeating, enclose the repeating part in parentheses.
 *
 * Example :
 *
 * Given numerator = 1, denominator = 2, return "0.5"
 * Given numerator = 2, denominator = 1, return "2"
 * Given numerator = 2, denominator = 3, return "0.(6)"
 */
public class Fraction {

    /**
     * The problem specifications and constraints are not very well established, which took me
     * quite a bit of trial and error to get it right.
     */
    public static String fractionToDecimal(int A, int B) {
        long longA = A, longB = B;

        if (longA%longB == 0)
            return String.valueOf(longA/longB);

        StringBuilder result = new StringBuilder();

        if ((longA>0 && longB<0) || (longA<0 && longB>0))
            result.append("-");

        longA = Math.abs(longA);
        longB = Math.abs(longB);
        result.append(longA/longB + ".");

        long remainder = (longA%longB)*10;

        HashMap<Long, Integer> seen = new HashMap<>();
        while (!seen.containsKey(remainder)) {
            seen.put(remainder, result.length());
            result.append(String.valueOf(remainder/longB));
            remainder = (remainder%longB)*10;

            if (remainder==0)
                return result.toString();
        }

        return result.insert(seen.get(remainder), "(").append(")").toString();
    }

    public static void main(String[] args) {
        System.out.println(fractionToDecimal(1, 2));
        System.out.println(fractionToDecimal(2, 1));
        System.out.println(fractionToDecimal(2, 3));
        System.out.println(fractionToDecimal(1, 2147483640));
        System.out.println(fractionToDecimal(Integer.MAX_VALUE, 1));
        System.out.println(fractionToDecimal(Integer.MIN_VALUE, 1));
        System.out.println(fractionToDecimal(1, Integer.MIN_VALUE));
        System.out.println(fractionToDecimal(3, 2));
    }
}
