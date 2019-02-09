package BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a sorted array of integers, find the starting and ending position of a given target value.
 *
 * Your algorithm’s runtime complexity must be in the order of O(log n).
 *
 * If the target is not found in the array, return [-1, -1].
 *
 * Example:
 *
 * Given [5, 7, 7, 8, 8, 10]
 *
 * and target value 8,
 *
 * return [3, 4].
 */
public class SearchForARange {

    /**
     * The approach isn't too complicated. It's just a modified binary
     * search, but with two peculiarities. For one, we are searching for two
     * values, which means we must make two separate searches (with their own
     * parameters). Second, these two searches need to watch out for their
     * own problems (first occurrence making sure it's the leftmost
     * occurrence, last being the rightmost). Once that's out of the way we
     * get an O(logn) solution as you would with any binary search.
     */
    private static int firstOccurrence(final List<Integer> a, int low,
                                       int high, int b) {
        if (high>=low) {
            int mid = low + (high-low)/2;
            if ((mid==0 || b>a.get(mid-1)) && a.get(mid)==b)
                return mid;
            else if (b>a.get(mid))
                return firstOccurrence(a, mid+1, high, b);
            else
                return firstOccurrence(a, low, mid-1, b);
        }

        return -1;
    }

    private static int lastOccurrence(final List<Integer> a, int low,
                                      int high, int b) {
        if (high>=low) {
            int mid = low + (high-low)/2;
            if ((mid==a.size()-1 || b<a.get(mid+1)) && a.get(mid)==b)
                return mid;
            else if (b<a.get(mid))
                return lastOccurrence(a, low, mid-1, b);
            else
                return lastOccurrence(a, mid+1, high, b);
        }

        return -1;
    }

    public static ArrayList<Integer> searchRange(final List<Integer> a, int b) {
        int first = firstOccurrence(a, 0, a.size()-1, b);
        int last = lastOccurrence(a, 0, a.size()-1, b);
        return new ArrayList<Integer>(Arrays.asList(first, last));
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList1 = new ArrayList<>(Arrays.asList(5, 7, 7
                , 8, 8, 10));
        System.out.println(searchRange(arrayList1, 8));
        System.out.println(searchRange(arrayList1, 10));
        System.out.println(searchRange(arrayList1, 7));
        System.out.println(searchRange(arrayList1, 5));
    }
}
