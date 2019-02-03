package BitManipulation;

/**
 * Divide two integers without using multiplication, division and mod operator.
 *
 * Return the floor of the result of the division.
 *
 * Example:
 *
 * 5 / 2 = 2
 * Also, consider if there can be overflow cases. For overflow case, return INT_MAX.
 */
public class DivideIntegers {

    /**
     * Solution makes use of bit manipulation to iterate through significant
     * digits. acc accumulates the portion of the quotient already accounted
     * for.
     * There's only one case to account for overflow.
     */
    public static int divide(int A, int B) {
        if(A==Integer.MIN_VALUE && B==-1)
            return Integer.MAX_VALUE;

        int sign = ((A<0) ^ (B<0)) ? -1 : 1;

        long longA = Math.abs(A * 1L);
        long longB = Math.abs(B);

        long quotient = 0, acc = 0;

        for(int i=31; i>=0; --i) {
            if(acc + (longB<<i) <= longA) {
                acc += longB<<i;
                quotient |= 1<<i;
            }
        }

        return (int)(sign * quotient);
    }

    public static void main(String[] args) {
        //System.out.println(divide(10, 3));
        System.out.println(divide(-2147483648, -1));
    }
}
