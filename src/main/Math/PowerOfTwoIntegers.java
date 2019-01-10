package Math;

import java.math.BigDecimal;

/**
 * Given a positive integer which fits in a 32 bit signed integer, find if it can be expressed as A^P where P > 1 and A > 0. A and P both should be integers.
 *
 * Example
 *
 * Input : 4
 * Output : True
 * as 2^2 = 4.
 */
public class PowerOfTwoIntegers {

    /**
     * Fastest solution that runs in O(n), where n is relative to the size of
     * the int. This would hold true for infinite values. Considering the
     * maximum integer representation is Integer.MAX_VALUE which is 32-bit
     * 0x7fffffff, this solution is really more in the order of O(1), if we
     * consider this to be the maximum runtime.
     * Using imprecise primitives or not defining a precision can lead to
     * wrong answers.
     */
    public static int isPower(int A) {
        if(A==0 || A==1) return 1;

        if(A==2) return 0;

        for(double i=2; i<=Math.ceil(Math.sqrt(A)); i++) {
            double exponent = Math.log(A)/Math.log(i);
            int exponentInt = (int)exponent;
            if(Math.abs(exponent-exponentInt) < 0.0000001)
                return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        int num = 5000;
        System.out.println(isPower(num));
        int num2 = 4;
        int num3 = 8;
        int num4 = 12;
        int num5 = 25;
        int num6 = 50;
        System.out.println(isPower(num2));
        System.out.println(isPower(num3));
        System.out.println(isPower(num4));
        System.out.println(isPower(num5));
        System.out.println(isPower(num6));
        int num7 = 536870912;
        System.out.println(isPower(num7));
        int num8 = 16808;
        System.out.println(isPower(num8));
    }
}
