package Arrays;

import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;

/**
 * You are given a read only array of n integers from 1 to n.
 *
 * Each integer appears exactly once except A which appears twice and B which is missing.
 *
 * Return A and B.
 *
 * Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 *
 * Note that in your output A should precede B.
 *
 * Example:
 *
 * Input:[3 1 2 5 3]
 *
 * Output:[3, 4]
 *
 * A = 3, B = 4
 */
public class RepeatAndMissingNumberArray {

    /**
     * First naive implementation, works fine, but once n becomes too big, so
     * does the totalSum of all elements, can't be held in a long or long
     * long and certainly the missing element can't be cast back from either
     * to int
     */
    public static ArrayList<Integer> repeatedNumberNaive(final List<Integer> A) {
        HashSet<Integer> present = new HashSet<>();
        Integer max = 0;
        Integer repeatedNum = 0, missingNum = 0;

        for(Integer num : A) {
            if(!present.add(num))
                repeatedNum = num;
            if(num>max)
                max = num;
        }

        for(Integer i=1; i<=max; i++)
            if(!present.contains(i)) {
                missingNum = i;
                break;
            }

        return new ArrayList<Integer>(Arrays.asList(repeatedNum, missingNum));
    }

    /**
     * O(n) solution that exploits the properties of XOR to provide the
     * correct solution
     *
     * First, xor the entire array against 1 to n, the result will contain
     * bits that are set in either x or y (since 1 bits of the result have to
     * be in either, but not both)
     *
     * Second, separate the array elements by one of the set bits of
     * xorHolder, this will ensure that x and y get separated
     *
     * Third, repeat the process of getting xor for all elements, while
     * maintaining the division of elements, this will give you x and y
     *
     * Last, to differentiate between the repeated number and missing number,
     * simply do one more pass of the array and check for the existing one,
     * the other must be the missing one
     */
    public static int[] repeatedNumber(int[] arr) {
        int n = arr.length;
        int singleSetBit = 0, x = 0, y = 0, i;
        int xorHolder = arr[0];

        for(i=1; i<n; i++)
            xorHolder = xorHolder ^ arr[i];

        for(i=1; i<=n; i++)
            xorHolder = xorHolder ^ i;

        singleSetBit = xorHolder & ~(xorHolder - 1);

        for(i=0; i<n; i++) {
            if((arr[i] & singleSetBit) != 0)
                x = x ^ arr[i];
            else
                y = y ^ arr[i];
        }
        for(i=1; i<= n; i++) {
            if((i & singleSetBit) != 0)
                x = x ^ i;
            else
                y = y ^i;
        }

        int[] result = new int[2];

        for(i=0; i<n; i++) {
            if (arr[i] == x) {
                result[0] = x;
                result[1] = y;
            }
            if (arr[i] == y) {
                result[0] = y;
                result[1] = x;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] array = {3, 1, 2, 5, 3};
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(3, 1, 2,
         5, 3));
        System.out.println(repeatedNumberNaive(arrayList).toString());
        System.out.println(Arrays.toString(repeatedNumber(array)));
    }
}
