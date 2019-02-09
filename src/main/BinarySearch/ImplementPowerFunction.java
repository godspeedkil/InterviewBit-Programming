package BinarySearch;

/**
 * Implement pow(x, n) % d.
 *
 * In other words, given x, n and d,
 *
 * find (xn % d)
 *
 * Note that remainders on division cannot be negative.
 * In other words, make sure the answer you return is non negative.
 *
 * Input : x = 2, n = 3, d = 3
 * Output : 2
 *
 * 2^3 % 3 = 8 % 3 = 2.
 */
public class ImplementPowerFunction {

    /**
     * The naive implementation suffers from overflow problems pretty easily.
     * Utilizing a bit of modular operations properties, we can obtain an
     * accurate answer.
     *
     * The property that makes this possible is
     * (ab) mod p = ( (a mod p) (b mod p) ) mod p
     */
    public static int pow(int x, int n, int d) {
        long temp = x;
        long result = 1L;

        while(n>0) {
            if(n%2 == 1) {
                result *= temp;
                result %= d;
            }

            temp *= temp;
            temp %= d;
            n = n >> 1;
        }

        result = (result + d) % d;

        return (int) result;
    }

    public static void main(String[] args) {
//        System.out.println(pow(10, 8, 5));
//        System.out.println(pow(-1, 1, 20));
        System.out.println(pow(71045970, 41535484, 64735492));
    }
}
