package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target.
 * Return the sum of the three integers.
 *
 * Assume that there will only be one solution
 *
 * Example:
 * given array S = {-1 2 1 -4},
 * and target = 1.
 *
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2)
 */
public class ThreeSum {

    /**
     * Best I could do was O(n^2) by treating the sum of two as a single
     * unit, then modify those two pointers accordingly.
     * I got it wrong the first time, assuming the array was sorted, my bad.
     */
    public static int threeSumClosest(ArrayList<Integer> A, int B) {
        int result = A.get(0) + A.get(1) + A.get(2);

        A.sort(Integer::compareTo);
        for(int i=0; i<A.size()-2; i++) {
            int j=i+1, k=A.size()-1;
            while(j<k) {
                int temp = A.get(i)+A.get(j)+A.get(k);
                if(Math.abs(B-temp)<Math.abs(B-result))
                    result = temp;
                if(temp<B)
                    j++;
                else
                    k--;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList1 = new ArrayList<>(Arrays.asList(5, -2,
                -1, -10, 10));
        System.out.println(threeSumClosest(arrayList1, 5));
    }
}
