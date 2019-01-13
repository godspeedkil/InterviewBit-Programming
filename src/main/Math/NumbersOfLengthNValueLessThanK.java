package Math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * Given a set of digits (A) in sorted order, find how many numbers of length B are possible whose value is less than number C.
 *
 *  NOTE: All numbers can only have digits from the given set.
 */
public class NumbersOfLengthNValueLessThanK {

    /**
     * Simple O(n) solution that compares digits of number less than C.
     * Considering that numbers from A may be repeated as many times as
     * desired, then any combination of those numbers may be made, such that
     * it's simply a matter of seeing how many of those combinations have
     * length B.
     **/
    public static int solve(ArrayList<Integer> A, int B, int C) {
        HashSet<Integer> options = new HashSet<>(A);
        Integer result = 0;
        if(options.contains(0) && B==1) result++;

        for(Integer i=0; i<C; i++) {
            int current = i;
            while(current>0) {
                if(!options.contains(current % 10))
                    break;
                current /= 10;
                if(current<=0 && i.toString().length()==B) result++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(solve(new ArrayList<>(Arrays.asList(0, 1, 5)), 1,
                2));
        System.out.println(solve(new ArrayList<>(Arrays.asList(0, 1, 2, 5)),
                2, 21));
    }
}
