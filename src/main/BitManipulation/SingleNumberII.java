package BitManipulation;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array of integers, every element appears thrice except for one which occurs once.
 *
 * Find that element which does not appear thrice.
 *
 * Note: Your algorithm should have a linear runtime complexity.
 *
 * Could you implement it without using extra memory?
 *
 * Example :
 *
 * Input : [1, 2, 4, 3, 3, 2, 2, 3, 1, 1]
 * Output : 4
 */
public class SingleNumberII {

    /**
     * O(n) solution with O(1) extra space. Simple approach that takes into
     * account the number of set bits for every bit position and doing modulo
     * 3 for each to find out the missing number. This is the best approach
     * in case you want to extend the solution to n repetitions of numbers
     * (that are odd).
     */
    public static int singleNumber(final List<Integer> A) {
        int result = 0;

        for(int i=0; i<32; i++) {
            int setCount = 0;
            int bit = 1<<i;
            for(int j=0; j<A.size(); j++)
                if((A.get(j) & bit) == 0)
                    setCount++;
            if(setCount%3 == 0)
                result |= bit;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(singleNumber(Arrays.asList(1, 1, 1, 2, 3, 3, 3)));
    }
}
