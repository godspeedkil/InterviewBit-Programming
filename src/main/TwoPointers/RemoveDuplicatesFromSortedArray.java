package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Remove duplicates from Sorted Array
 * Given a sorted array, remove the duplicates in place such that each element appears only once and return the new length.
 *
 * Note that even though we want you to return the new length, make sure to change the original array as well in place
 *
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 *
 *  Example:
 * Given input array A = [1,1,2],
 * Your function should return length = 2, and A is now [1,2].
 */
public class RemoveDuplicatesFromSortedArray {

    /**
     * For fully optimal performance, considering Java's ArrayList's remove
     * method, it is better to start right-to-left, since the way it works
     * is, each element after the removed element gets subtracted one from
     * its index.
     * Starting left-to-right can lead to near O(n^2) performance.
     */
    public static int removeDuplicates(ArrayList<Integer> a) {
        if (a.size() < 2) return a.size();

        int prev = a.get(a.size() - 1);
        for (int i = a.size() - 2; i >= 0; i--) {
            if (a.get(i) == prev) {
                a.remove(i);
            }
            else {
                prev = a.get(i);
            }
        }

        return a.size();
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList1 = new ArrayList<>(Arrays.asList(5000,
                5000,5000));
        System.out.println(removeDuplicates(arrayList1));
    }
}
