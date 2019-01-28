package BitManipulation;

import java.util.Arrays;
import java.util.List;

/**
 * Given an array of integers, every element appears twice except for one. Find that single one.
 *
 * Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 *
 * Example :
 *
 * Input : [1 2 2 3 1]
 * Output : 3
 */
public class SingleNumber {

    /**
     * Just exploit the nature of the XOR comparison. Equal values that are
     * XORed are cancelled, leaving only the lone number.
     */
    public static int singleNumber(final List<Integer> A) {
        int result = 0;
        for(Integer num : A)
            result = result ^ num;
        return result;
    }

    public static void main(String[] args) {
        System.out.println(singleNumber(Arrays.asList(1, 1, 2, 2, 3, 4, 4, 5, 5)));
    }
}
