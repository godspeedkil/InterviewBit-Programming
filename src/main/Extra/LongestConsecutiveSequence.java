package Extra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 *
 * Example:
 * Given [100, 4, 200, 1, 3, 2],
 * The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
 *
 * Your algorithm should run in O(n) complexity.
 */
public class LongestConsecutiveSequence {

    /**
     * O(n) solution that uses a modified counting sort. Not very memory-efficient, though.
     **/
    public static int longestConsecutive(final List<Integer> A) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

        for (Integer num : A) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        int n = max-min;
        int offset = min;
        int[] arr = new int[n+1];

        for (Integer num : A) {
            arr[num-offset] = 1;
        }

        HashSet tempSeq = new HashSet<Integer>();
        int result = 0;
        for (int i=0; i<arr.length; i++) {
            if (arr[i]!=0) {
                tempSeq.add(i);
            }
            else {
                result = (tempSeq.size()>result) ? tempSeq.size() : result;
                tempSeq.clear();
            }
        }
        result = (tempSeq.size()>result) ? tempSeq.size() : result;

        return result;
    }

    public static void main(String[] args) {
        ArrayList arrayList1 = new ArrayList<Integer>(Arrays.asList(100, 4, 200, 1, 3, 2));
        System.out.println(longestConsecutive(arrayList1));
        ArrayList arrayList2 = new ArrayList<Integer>(Arrays.asList(-5));
        System.out.println(longestConsecutive(arrayList2));
    }
}
