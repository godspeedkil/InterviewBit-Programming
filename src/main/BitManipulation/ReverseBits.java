package BitManipulation;

/**
 * Reverse bits of an 32 bit unsigned integer
 *
 * Example 1:
 *
 * x = 0,
 *
 *           00000000000000000000000000000000
 * =>        00000000000000000000000000000000
 * return 0
 *
 * Example 2:
 *
 * x = 3,
 *
 *           00000000000000000000000000000011
 * =>        11000000000000000000000000000000
 * return 3221225472
 *
 * Since java does not have unsigned int, use long
 */
public class ReverseBits {

    /**
     * Simple O(1) solution. Bit shift, check for set bit, set bit in result
     * by adding appropriate exponent of 2.
     */
    public static long reverse(long a) {
        int original = 0, reverse = 31;
        long result = 0;

        while(reverse>=0) {
            if((a>>original)%2==1)
                result += Math.pow(2, reverse);
            reverse--;
            original++;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(reverse(3L));
    }
}
