package BinarySearch;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * There are two sorted arrays A and B of size m and n respectively.
 *
 * Find the median of the two sorted arrays ( The median of the array formed by merging both the arrays ).
 *
 * The overall run time complexity should be O(log (m+n)).
 *
 * Sample Input
 *
 * A : [1 4 5]
 * B : [2 3]
 *
 * Sample Output
 *
 * 3
 *  NOTE: IF the number of elements in the merged array is even, then the median is the average of n / 2 th and n/2 + 1th element.
 * For example, if the array is [1 2 3 4], the median is (2 + 3) / 2.0 = 2.5
 */
public class MedianOfArray {

    /**
     * The solution is based on an approach that takes into account the
     * numbers within these two lists can't exceed the limits of Integer
     * itself. As such, we can simply start from the bigger range of numbers
     * (i.e., that which goes from the lowest to the highest number in both
     * arrays.)
     *
     * Parting from that, we just have to approach the median by seeing if
     * there are more smaller numbers or larger numbers, adjusting the low
     * and high pointers until we zero in on the correct median. In the case
     * of an even amount of elements, we do this twice, discarding one
     * element to get the other half of the median.
     */
    private static int countSmaller(final List<Integer> a, int b) {
        int low = 0, high = a.size()-1;

        while (low<=high) {
            int mid = (low+high)/2;

            if (b<=a.get(mid))
                high = mid-1;
            else
                low = mid+1;
        }

        return low;
    }

    private static double search(final List<Integer> a, final List<Integer> b
            , int count) {
        int low = Integer.MIN_VALUE, high = Integer.MAX_VALUE;

        while (low<=high) {
            int mid = (int)(low + ((long)high-low)/2);
            int smaller = countSmaller(a, mid) + countSmaller(b, mid);

            if (smaller>count)
                high = mid-1;
            else
                low = mid+1;
        }

        return high;
    }

    public static double findMedianSortedArrays(final List<Integer> a,
                                                final List<Integer> b) {
        int total = a.size() + b.size();

        if((total&1) == 1)
            return search(a, b, total/2);

        return (search(a, b, total/2) + search(a, b, total/2-1))/2;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList1 = new ArrayList<>(Arrays.asList(-40,
                -25, 5, 10, 14, 28, 29, 48));
        ArrayList<Integer> arrayList2 = new ArrayList<>(Arrays.asList(-48,
                -31, -15, -6, 1, 8));
        System.out.println(findMedianSortedArrays(arrayList1, arrayList2));
    }
}
