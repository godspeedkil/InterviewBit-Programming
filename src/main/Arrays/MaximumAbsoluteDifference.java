package Arrays;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * You are given an array of N integers, A1, A2 ,…, AN. Return maximum value of f(i, j) for all 1 ≤ i, j ≤ N.
 * f(i, j) is defined as |A[i] - A[j]| + |i - j|, where |x| denotes absolute value of x.
 */
public class MaximumAbsoluteDifference {
    private static int functionf(ArrayList<Integer> A, int i, int j) {
        return Math.abs(A.get(i)-A.get(j)) + Math.abs(i-j);
    }

    /**
     * Naive first implementation, however, inefficient since it runs in O
     * (n^2) time, needs improvement in run time
     */
    public static int naiveMaxArr(ArrayList<Integer> A) {
        int max = Integer.MIN_VALUE;
        for(int i=0; i<A.size(); i++) {
            for(int j=A.size()-1; j>i; j--) {
                int currentf = functionf(A, i, j);
                if(currentf>max)
                    max = currentf;
            }
        }
        return max;
    }

    /**
     * Considering the original formula , it is not hard to translate to
     * maximized form, resulting in only two separate cases that cover all
     * possibilities
     *
     * Case 1: A[i] > A[j] and i > j
     * |A[i] - A[j]| = A[i] - A[j]
     * |i -j| = i - j
     * f(i, j) = (A[i] + i) - (A[j] + j)
     *
     * Case 2: A[i] > A[j] and i < j
     * |A[i] - A[j]| = A[i] - A[j]
     * |i -j| = -(i) + j
     * f(i, j) = (A[i] - i) - (A[j] - j)
     *
     * Utilizing this knowledge, we implement an O(n) solution
     */
    public static int maxArr(ArrayList<Integer> A) {
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;

        for(int i=0; i<A.size(); i++) {
            max1 = Math.max(max1, A.get(i)+i);
            min1 = Math.min(min1, A.get(i)+i);
            max2 = Math.max(max2, A.get(i)-i);
            min2 = Math.min(min2, A.get(i)-i);
        }

        return Math.max(max1-min1, max2-min2);
    }

    public static void main(String[] args) {
        Integer[] array = {1, 3, -1};
        ArrayList<Integer> arrayList =
                new ArrayList<Integer>(Arrays.asList(array));
        System.out.println(maxArr(arrayList));
    }
}
