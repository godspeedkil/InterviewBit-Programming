package BinarySearch;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., 0 1 2 4 5 6 7  might become 4 5 6 7 0 1 2 ).
 *
 * You are given a target value to search. If found in the array, return its index, otherwise return -1.
 *
 * You may assume no duplicate exists in the array.
 *
 * Input : [4 5 6 7 0 1 2] and target = 4
 * Output : 0
 *
 * NOTE : Think about the case when there are duplicates. Does your current solution work? How does the time complexity change?*
 */
public class RotatedSortedArraySearch {

    /**
     * Once you find the pivot, there's really not much different in the way
     * of an ordinary binary search. The problem is, the automated check is
     * apparently not properly time-bounded, as simply finding the pivot
     * first, then using it as a "mid" should theoretically be O(log*n), but
     * that answer is not accepted. Instead, the only way to get it accepted
     * is to use the following approach, which looks for the pivot WHILE
     * binary searching.
     */
    private static int searchRec(final List<Integer> a, int b, int low,
                                 int high) {
        if (low>high) return -1;

        int mid = (low+high)/2;
        if (a.get(mid)==b) return mid;

        if (a.get(low)<=a.get(mid)) {
            if (b>=a.get(low) && b<=a.get(mid))
                return searchRec(a, b, low, mid-1);

            return searchRec(a, b, mid+1, high);
        }

        if (b>=a.get(mid) && b<=a.get(high))
            return searchRec(a, b, mid+1, high);

        return searchRec(a, b, low, mid-1);
    }

    public static int search(final List<Integer> a, int b) {
        return searchRec(a, b, 0, a.size()-1);
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList1 = new ArrayList<>(Arrays.asList(4, 5, 6
                , 7, 0, 1, 2));
        System.out.println(search(arrayList1, 1));
    }
}
