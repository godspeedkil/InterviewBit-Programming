package Arrays;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given a non-negative number represented as an array of digits,
 *
 * add 1 to the number ( increment the number represented by the digits ).
 *
 * The digits are stored such that the most significant digit is at the head of the list.
 *
 * Example:
 *
 * If the vector has [1, 2, 3]
 *
 * the returned vector should be [1, 2, 4]
 *
 * as 123 + 1 = 124.
 */
public class AddOneToNumber {

    private static ArrayList<Integer> trimZeroes(ArrayList<Integer> A) {
        while(A.get(0)==0) {
            A.remove(0);
        }
        return A;
    }

    public static ArrayList<Integer> plusOne(ArrayList<Integer> A) {
        int n = A.size();

        A.set(n-1, A.get(n-1)+1);
        int carry = A.get(n-1) / 10;
        A.set(n-1, A.get(n-1) % 10);

        for(int i=n-2; i>=0; i--) {
            if(carry==1) {
                A.set(i, A.get(i)+1);
                carry = A.get(i) / 10;
                A.set(i, A.get(i) % 10);
            }
        }
        if(carry==1)
            A.add(0, 1);

        return trimZeroes(A);
    }

    public static void main(String[] args) {
        ArrayList<Integer> array = new ArrayList<>();
        array.add(1);
        array.add(2);
        array.add(3);
        System.out.println(plusOne(array).toString());
    }
}
