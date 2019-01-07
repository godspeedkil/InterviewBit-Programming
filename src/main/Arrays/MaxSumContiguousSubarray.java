package Arrays;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 *
 * For example:
 *
 * Given the array [-2,1,-3,4,-1,2,1,-5,4],
 *
 * the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 *
 * For this problem, return the maximum sum.
 */
public class MaxSumContiguousSubarray {

    public static int maxSubArray(final List<Integer> A) {
        int highestMax = Integer.MIN_VALUE, subArrayMax = 0;

        /**
         * At any moment the current max drops below 0, that means the
         * numbers previous to it are not in any combination enough to
         * overcome the magnitude of it, hence why we restart subArrayMax in
         * such occasions
         */
        for(Integer i : A) {
            subArrayMax = subArrayMax + i;
            if(highestMax < subArrayMax)
                highestMax = subArrayMax;
            if(subArrayMax < 0)
                subArrayMax = 0;
        }

        return highestMax;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList =
                new ArrayList<Integer>(Arrays.asList(-2, 1, -3, 4, -1, 2, 1,
                        -5, 4));
        System.out.println(maxSubArray(arrayList));
    }
}
