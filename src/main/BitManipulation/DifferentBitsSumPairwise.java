package BitManipulation;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * We define f(X, Y) as number of different corresponding bits in binary representation of X and Y. For example, f(2, 7) = 2, since binary representation of 2 and 7 are 010 and 111, respectively. The first and the third bit differ, so f(2, 7) = 2.
 *
 * You are given an array of N positive integers, A1, A2 ,…, AN. Find sum of f(Ai, Aj) for all pairs (i, j) such that 1 ≤ i, j ≤ N. Return the answer modulo 109+7.
 *
 * For example,
 *
 * A=[1, 3, 5]
 *
 * We return
 *
 * f(1, 1) + f(1, 3) + f(1, 5) +
 * f(3, 1) + f(3, 3) + f(3, 5) +
 * f(5, 1) + f(5, 3) + f(5, 5) =
 *
 * 0 + 1 + 1 +
 * 1 + 0 + 2 +
 * 1 + 2 + 0 = 8
 */
public class DifferentBitsSumPairwise {

    /**
     * Simplest solution simply involves going bit-by-bit and checking
     * whether it's set in each number, then figure out the possible
     * combinations through simple multiplication.
     */
    public static int cntBits(ArrayList<Integer> a) {
        int mod = 1000000007;
        long result = 0;

        for(int i=0; i<=31; i++) {
            int zeros = 0, ones = 0;
            for(Integer num : a) {
                if((num>>i) % 2 == 0)
                    zeros++;
                else
                    ones++;
            }
            result += ((long)zeros*ones) % mod;
        }

        return (int)(2*result%mod);
    }

    public static void main(String[] args) {
        System.out.println(cntBits(new ArrayList<>(Arrays.asList(1, 3, 5))));
    }
}
