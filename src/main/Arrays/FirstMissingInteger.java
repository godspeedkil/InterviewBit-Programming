package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * Given an unsorted integer array, find the first missing positive integer.
 *
 * Example:
 *
 * Given [1,2,0] return 3,
 *
 * [3,4,-1,1] return 2,
 *
 * [-8, -7, -6] returns 1
 *
 * Your algorithm should run in O(n) time and use constant space.
 */
public class FirstMissingInteger {

    /**
     * Simple O(n) solution. Utilizes HashSet to lookup values in O(1) time,
     * and a simple counter to keep track of the positive numbers.
     */
    public static int firstMissingPositive(ArrayList<Integer> A) {
        HashSet<Integer> set = new HashSet<>(A);
        int i = 1;

        while(true) {
            if(!set.contains(i) || i==Integer.MAX_VALUE) {
                break;
            }
            i++;
        }

        return i;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList1 = new ArrayList<>(Arrays.asList(1, 2, 0));
        System.out.println(firstMissingPositive(arrayList1));
        ArrayList<Integer> arrayList2 = new ArrayList<>(Arrays.asList(3, 4,
                -1, 1));
        System.out.println(firstMissingPositive(arrayList2));
        ArrayList<Integer> arrayList3 = new ArrayList<>(Arrays.asList(-8, -7,
                -6));
        System.out.println(firstMissingPositive(arrayList3));
    }
}
