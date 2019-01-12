package Math;

/**
 * Given an integer n, return the number of trailing zeroes in n!.
 *
 * Note: Your solution should be in logarithmic time complexity.
 *
 * Example :
 *
 * n = 5
 * n! = 120
 * Number of trailing zeros = 1
 * So, return 1
 */
public class TrailingZerosInFactorial {

    /**
     * One possible solution that runs in O(n) time. Exploits the fact that
     * the problem in question is basically asking what is the max exponent
     * of base 10 that can divide the resulting number.
     * For this solution, I am simply counting the numbers of 2s and 5s that
     * will end up appearing as factors of the final number. Every set of
     * these represents 10^1, or one zero.
     */
    public static int trailingZeroes(int A) {
        int twos = 0;
        int fives = 0;
        int copyA = A;

        for(int i=2; i<=A; i++) {
            int currentNum = i;
            while(currentNum%2==0) {
                twos++;
                currentNum /= 2;
            }
            while(currentNum%5==0) {
                fives++;
                currentNum /= 5;
            }
        }

        return Math.min(twos, fives);
    }

    public static void main(String[] args) {
        System.out.println(trailingZeroes(5));
        System.out.println(trailingZeroes(10));
    }
}
