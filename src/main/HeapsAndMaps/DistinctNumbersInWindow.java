package HeapsAndMaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * You are given an array of N integers, A1, A2 ,…, AN and an integer K. Return the of count of distinct numbers in all windows of size K.
 *
 * Formally, return an array of size N-K+1 where i’th element in this array contains number of distinct elements in sequence Ai, Ai+1 ,…, Ai+k-1.
 *
 * Note:
 *
 * If K > N, return empty array.
 * For example,
 *
 * A=[1, 2, 1, 3, 4, 3] and K = 3
 *
 * All windows of size K are
 *
 * [1, 2, 1]
 * [2, 1, 3]
 * [1, 3, 4]
 * [3, 4, 3]
 *
 * So, we return an array [2, 3, 3, 2].
 */
public class DistinctNumbersInWindow {

    public static ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {
        int n = A.size();
        HashMap<Integer, Integer> uniquesCount = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();
        int currentUniques = 0;

        if (B>n) return result;

        for (int i=0; i<B; i++) {
            if (uniquesCount.get(A.get(i))==null) {
                uniquesCount.put(A.get(i), 1);
                currentUniques++;
            }
            else {
                int count = uniquesCount.get(A.get(i));
                uniquesCount.put(A.get(i), count+1);
            }
        }

        result.add(currentUniques);

        for (int i=B; i<n; i++) {
            if (uniquesCount.get(A.get(i-B))==1) {
                uniquesCount.remove(A.get(i-B));
                currentUniques--;
            }
            else {
                int count = uniquesCount.get(A.get(i-B));
                uniquesCount.put(A.get(i-B), count-1);
            }
            if (uniquesCount.get(A.get(i))==null) {
                uniquesCount.put(A.get(i), 1);
                currentUniques++;
            }
            else {
                int count = uniquesCount.get(A.get(i));
                uniquesCount.put(A.get(i), count+1);
            }

            result.add(currentUniques);
        }

        return result;
    }

    public static void main(String[] args) {
//        ArrayList arrayList1 = new ArrayList<Integer>(Arrays.asList(1, 2, 1, 3, 4, 3));
//        System.out.println(dNums(arrayList1, 3));
        ArrayList arrayList2 = new ArrayList<Integer>(Arrays.asList(2, 2, 4, 4, 4, 4, 4, 4, 4, 4,
         47, 57, 57, 83));
        System.out.println(dNums(arrayList2, 5));
    }
}
