package BitManipulation;

/**
 * Write a function that takes an unsigned integer and returns the number of 1 bits it has.
 *
 * Example:
 *
 * The 32-bit integer 11 has binary representation
 *
 * 00000000000000000000000000001011
 * so the function should return 3.
 *
 * Note that since Java does not have unsigned int, use long for Java
 */
public class NumberOf1Bits {

    /**
     * Self-explanatory, just cycle through the bits.
     */
    public static int numSetBits(long a) {
        int count = 0;
        while(a>0) {
            if(a%2==1) count++;
            a = a>>>1;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(numSetBits(1));
        System.out.println(numSetBits(2));
        System.out.println(numSetBits(3));
        System.out.println(numSetBits(1209387412093871234L));
    }
}
