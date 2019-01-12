package Math;

/**
 * Reverse digits of an integer.
 *
 * Example1:
 *
 * x = 123,
 *
 * return 321
 * Example2:
 *
 * x = -123,
 *
 * return -321
 *
 * Return 0 if the result overflows and does not fit in a 32 bit signed integer
 */
public class ReverseInteger {

    /**
     * Same logic as PalindromeInteger, we just need to add overflow check.
     * Simplest solution is to keep reversed value in a bigger primitive
     * (long) and then check for potential overflow.
     */
    public static int reverse(int A) {
        long reversed = 0;
        int copyA = A;
        while(copyA!=0) {
            reversed = reversed * 10 + copyA % 10;
            copyA /= 10;
        }
        if(reversed > Integer.MAX_VALUE || reversed < Integer.MIN_VALUE)
            return 0;
        return (int)reversed;
    }

    public static void main(String[] args) {
        System.out.println(reverse(-123));
        System.out.println(reverse(-389723));
        System.out.println(reverse(1000000009));
    }
}
