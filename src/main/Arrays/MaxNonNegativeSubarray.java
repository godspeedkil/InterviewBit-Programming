package Arrays;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;

/**
 * Find out the maximum sub-array of non negative numbers from an array.
 * The sub-array should be continuous. That is, a sub-array created by choosing the second and fourth element and skipping the third element is invalid.
 *
 * Maximum sub-array is defined in terms of the sum of the elements in the sub-array. Sub-array A is greater than sub-array B if sum(A) > sum(B).
 *
 * Example:
 *
 * A : [1, 2, 5, -7, 2, 3]
 * The two sub-arrays are [1, 2, 5] [2, 3].
 * The answer is [1, 2, 5] as its sum is larger than [2, 3]
 * NOTE: If there is a tie, then compare with segment's length and return segment which has maximum length
 * NOTE 2: If there is still a tie, then return the segment with minimum starting index
 */
public class MaxNonNegativeSubarray {

    /**
     * O(n) solution that exploits the properties of hash tables (mainly, the
     * fact that only one key pairs to only one value. Keeps updating the
     * hashtable with new subarrays, then looks up the subarray corresponding
     * to the previously calculated maxSum.
     *
     * If two subarrays compete for the maxSum, the one with the longer
     * element count will replace (or remain) in the table.
     *
     * If two subarrays compete for the maxSum, with the same number of
     * elements, the one placed first will
     * always beat the new one.
     */
    public static ArrayList<Integer> maxset(ArrayList<Integer> A) {
        Hashtable<Long, ArrayList<Integer>> table =
                new Hashtable<>();
        Long maxSum = 0l;
        Long currentSum = 0l;

        ArrayList<Integer> currSubArr = new ArrayList<>();
        for(int i=0; i<A.size(); i++) {
            int currentNum = A.get(i);
            if(currentNum>=0) {
                currSubArr.add(currentNum);
                currentSum+=currentNum;
            }
            maxSum = Math.max(currentSum, maxSum);
            if(!currSubArr.isEmpty())
                if(!table.containsKey(maxSum) || table.get(maxSum).size()<currSubArr.size())
                    table.put(currentSum, new ArrayList<>(currSubArr));
            if(currentNum<0) {
                currentSum = 0l;
                currSubArr.clear();
            }
        }

        ArrayList<ArrayList<Integer>> results = new ArrayList<>();

        if(table.containsKey(maxSum)) {
            results.add(table.get(maxSum));
        }

        if(results.size()==1)
            return results.get(0);
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(1, 2, 5,
                -7, 2, 3));
        System.out.println(maxset(arrayList).toString());
        ArrayList<Integer> arrayList1 = new ArrayList<>(Arrays.asList(1, 2, 5
                , -7, 5, 2, 1));
        System.out.println(maxset(arrayList1).toString());
        ArrayList<Integer> arrayList2 = new ArrayList<>(Arrays.asList(1967513926,
                1540383426, -1303455736, -521595368));
        System.out.println(maxset(arrayList2).toString());
        ArrayList<Integer> arrayList3 = new ArrayList<>(Arrays.asList(756898537,
                -1973594324, -2038664370, -184803526, 1424268980));
        System.out.println(maxset(arrayList3));
        ArrayList<Integer> arrayList4 = new ArrayList<>(Arrays.asList(0, 0,
                -1, 0));
        System.out.println(maxset(arrayList4));
    }
}
