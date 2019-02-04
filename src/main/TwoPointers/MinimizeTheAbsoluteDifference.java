package TwoPointers;

import com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given three sorted arrays A, B and Cof not necessarily same sizes.
 *
 * Calculate the minimum absolute difference between the maximum and minimum number from the triplet a, b, c such that a, b, c belongs arrays A, B, C respectively.
 * i.e. minimize | max(a,b,c) - min(a,b,c) |.
 *
 * Example :
 *
 * Input:
 *
 * A : [ 1, 4, 5, 8, 10 ]
 * B : [ 6, 9, 15 ]
 * C : [ 2, 3, 6, 6 ]
 * Output:
 *
 * 1
 * Explanation: We get the minimum difference for a=5, b=6, c=6 as | max(a,b,c) - min(a,b,c) | = |6-5| = 1.
 */
public class MinimizeTheAbsoluteDifference {

    /**
     * There are only two approaches to minimizing the absolute difference:
     * (1) Start with the lowest values and keep increasing the lowest one
     * (2) Start with the highest values and keep decreasing the highest one
     *
     * My approach uses the former.
     */
    public static int solve(ArrayList<Integer> A, ArrayList<Integer> B,
                      ArrayList<Integer> C) {
        int pointerA = 0, pointerB = 0, pointerC = 0;
        int min = Integer.MAX_VALUE;

        while(pointerA<A.size() && pointerB<B.size() && pointerC<C.size()) {
            int a = A.get(pointerA), b = B.get(pointerB), c = C.get(pointerC);
            int minABC = Math.min(Math.min(a, b), c);
            int maxABC = Math.max(Math.max(a, b), c);
            min = Math.min(min, Math.abs(maxABC-minABC));
            if(minABC==a) {
                pointerA++;
            }
            else if(minABC==b) {
                pointerB++;
            }
            else pointerC++;
        }

        return min;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList1 = new ArrayList<>(Arrays.asList(1, 4, 5
                , 8, 10));
        ArrayList<Integer> arrayList2 = new ArrayList<>(Arrays.asList(6, 9,
                15));
        ArrayList<Integer> arrayList3 = new ArrayList<>(Arrays.asList(2, 3, 6
                , 6));
        System.out.println(solve(arrayList1, arrayList2, arrayList3));
    }
}
