package Math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Hamming distance between two non-negative integers is defined as the number of positions at which the corresponding bits are different.
 *
 * For example,
 *
 * HammingDistance(2, 7) = 2, as only the first and the third bit differs in the binary representation of 2 (010) and 7 (111).
 *
 * Given an array of N non-negative integers, find the sum of hamming distances of all pairs of integers in the array.
 * Return the answer modulo 1000000007.
 *
 * Example
 *
 * Let f(x, y) be the hamming distance defined above.
 *
 * A=[2, 4, 6]
 *
 * We return,
 * f(2, 2) + f(2, 4) + f(2, 6) +
 * f(4, 2) + f(4, 4) + f(4, 6) +
 * f(6, 2) + f(6, 4) + f(6, 6) =
 *
 * 0 + 2 + 1
 * 2 + 0 + 1
 * 1 + 1 + 0 = 8
 */
public class SumOfPairwiseHammingDistance {

    /**
     * Naive first implementation running in O(n^2) time. However, based on
     * the correct assumption that comparisons with themselves does nothing
     * to change the result, and additional comparisons between the same
     * elements simply doubles the result.
     **/
    public static int hammingDistanceNaive(final List<Integer> A) {
        ArrayList<Integer> hammings = new ArrayList<>();
        for(int i=0; i<A.size()-1; i++) {
            for(int j=i+1; j<A.size(); j++) {
                hammings.add(A.get(i) ^ A.get(j));
            }
        }
        for(int i=0; i<hammings.size(); i++) {
            Integer currentInt = hammings.get(i);
            Integer hamming = 0;
            while(currentInt>0) {
                if(currentInt%2 != 0)
                    hamming++;
                currentInt /= 2;
            }
            hammings.set(i, hamming);
        }
        long finalSum = 0;
        for(Integer hamming : hammings)
            finalSum += hamming;

        return (int) ((finalSum*2)%1000000007);
    }

    /**
     * O(n) implementation, where n is representative of the total number of
     * elements * 32(bits). Takes advantage of the fact that only thing that
     * matters is how many differences exist at every bit.
     * Long and int casting is only there for overflow protection, mostly
     * when dealing with calculating the finalSum.
     */
    public static int hammingDistance(final int[] A) {
        long finalSum = 0;

        for(int i=0; i<32; i++) {
            long currentCount = 0;

            // Simply count the number of set ith bits
            for(int j=0; j<A.length; j++)
                if((A[j] & (1 << i)) == 0)
                    currentCount++;

            // Adds number of comparisons that would result in a difference
            finalSum += (currentCount * (A.length - currentCount) * 2);
        }

        return (int) (finalSum % 1000000007);
    }

    public static void main(String[] args) {
        int[] array = {2, 4, 6};
        System.out.println(hammingDistance(array));
    }
}
