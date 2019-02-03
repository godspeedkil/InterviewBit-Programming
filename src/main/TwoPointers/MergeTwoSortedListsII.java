package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.
 *
 *  Note: You have to modify the array A to contain the merge of A and B. Do not output anything in your code.
 * TIP: C users, please malloc the result into a new array and return the result.
 * If the number of elements initialized in A and B are m and n respectively, the resulting size of array A after your code is executed should be m + n
 *
 * Example :
 *
 * Input :
 *          A : [1 5 8]
 *          B : [6 9]
 *
 * Modified A : [1 5 6 8 9]
 */
public class MergeTwoSortedListsII {

    /**
     * O(n) solution, it's just a simple merge. Mostly done to see if you can
     * keep track of both pointers accurately.
     */
    public static void merge(ArrayList<Integer> a, ArrayList<Integer> b) {
        int pointerA = 0, pointerB = 0;
        while(pointerA < a.size() && pointerB < b.size()) {
            if(a.get(pointerA) <= b.get(pointerB))
                pointerA++;
            else {
                a.add(pointerA, b.get(pointerB));
                pointerA++;
                pointerB++;
            }
        }
        while(pointerB < b.size()) {
            a.add(b.get(pointerB));
            pointerB++;
        }
    }

    public static void main(String[] args) {
        ArrayList arrayList1 = new ArrayList(Arrays.asList(3));
        ArrayList arrayList2 = new ArrayList(Arrays.asList(-4, -3));
//        ArrayList arrayList1 = new ArrayList(Arrays.asList(1, 5, 8));
//        ArrayList arrayList2 = new ArrayList(Arrays.asList(6, 9));
        merge(arrayList1, arrayList2);
        System.out.println(arrayList1);
    }
}
