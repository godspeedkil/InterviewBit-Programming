package StacksAndQueues;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
 *
 * Example :
 *
 * Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 *
 * Rain water trapped: Example 1
 *
 * The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
 * In this case, 6 units of rain water (blue section) are being trapped.
 */
public class RainWaterTrapped {

    /**
     * Strangely, this was in the stacks and queues section, I suppose there
     * is an approach using those, although I couldn't come up with it.
     * The more natural solution, in my opinion was simply zoning in from
     * both sides, utilizing low and high pointers.
     */
    public static int trap(final List<Integer> A) {
        int result = 0;
        int maxL = 0, maxR = 0;
        int low = 0, high = A.size()-1;

        while (low<=high) {
            int currL = A.get(low), currR = A.get(high);
            if (currL<currR) {
                if (currL>maxL)
                    maxL = currL;
                else {
                    result += maxL - currL;
                    low++;
                }
            }
            else {
                if (currR>maxR)
                    maxR = currR;
                else {
                    result += maxR - currR;
                    high--;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList1 = new ArrayList<>(Arrays.asList(0, 1, 0
                , 2, 1, 0, 1, 3, 2, 1, 2, 1));
        System.out.println(trap(arrayList1));
    }
}
