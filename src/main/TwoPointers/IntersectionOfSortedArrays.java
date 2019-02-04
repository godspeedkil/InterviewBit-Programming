package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Find the intersection of two sorted arrays.
 * OR in other words,
 * Given 2 sorted arrays, find all the elements which occur in both the arrays.
 *
 * Example :
 *
 * Input :
 *     A : [1 2 3 3 4 5 6]
 *     B : [3 3 5]
 *
 * Output : [3 3 5]
 *
 * Input :
 *     A : [1 2 3 3 4 5 6]
 *     B : [3 5]
 *
 * Output : [3 5]
 *  NOTE : For the purpose of this problem ( as also conveyed by the sample case ), assume that elements that appear more than once in both arrays should be included multiple times in the final output.
 */
public class IntersectionOfSortedArrays {

    /**
     * To solve this in O(n) time, we do a slight modification of the general
     * merge algorithm.
     */
    public static ArrayList<Integer> intersect(final List<Integer> A,
                                         final List<Integer> B) {
        int pointerA = 0, pointerB = 0;
        ArrayList<Integer> result = new ArrayList<>();

        while(pointerA < A.size() && pointerB < B.size()) {
            switch(A.get(pointerA).compareTo(B.get(pointerB))) {
                case 0:
                    result.add(A.get(pointerA));
                    pointerB++;
                case -1:
                    pointerA++;
                    break;
                case 1:
                    pointerB++;
                    break;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList1 = new ArrayList<>(Arrays.asList(1, 2, 3
                , 3, 4, 5, 6));
        ArrayList<Integer> arrayList2 = new ArrayList<>(Arrays.asList(3, 3, 5));
        System.out.println(intersect(arrayList1, arrayList2));
    }
}
