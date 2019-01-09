package Math;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given an even number ( greater than 2 ), return two prime numbers whose sum will be equal to given number.
 *
 * NOTE A solution will always exist. read Goldbach’s conjecture
 *
 * Example:
 *
 *
 * Input : 4
 * Output: 2 + 2 = 4
 *
 * If there are more than one solutions possible, return the lexicographically smaller solution.
 *
 * If [a, b] is one solution with a <= b,
 * and [c,d] is another solution with c <= d, then
 *
 * [a, b] < [c, d]
 *
 * If a < c OR a==c AND b < d.
 */
public class PrimeSum {

    private static boolean[] generatePrimes(int A) {
        boolean[] isPrime = new boolean[A+1];
        isPrime[0] = isPrime[1] = false;
        for(int i=2; i<=A; i++)
            isPrime[i] = true;

        for(int i=2; i*i<=A; i++)
            if(isPrime[i])
                for(int j=i*2; j<=A; j+=i)
                    isPrime[j] = false;

        return isPrime;
    }

    /**
     * O(n) solution that utilizes an auxiliary O(n) space array populated
     * with prime flags for finding the solution.
     */
    public static ArrayList<Integer> primesum(int A) {
        boolean[] isPrime = generatePrimes(A);

        for(int i=0; i<A; i++)
            if(isPrime[i] && isPrime[A-i])
                return new ArrayList<>(Arrays.asList(i, A-i));

        return new ArrayList<>();
    }

    public static void main(String[] args) {
        int A = 20;
        System.out.println(Arrays.toString(generatePrimes(20)));
        System.out.println(primesum(A).toString());
    }
}
