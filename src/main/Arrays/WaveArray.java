package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Given an array of integers, sort the array into a wave like array and return it,
 * In other words, arrange the elements into a sequence such that a1 >= a2 <= a3 >= a4 <= a5.....
 *
 * Example
 *
 * Given [1, 2, 3, 4]
 *
 * One possible answer : [2, 1, 4, 3]
 * Another possible answer : [4, 1, 3, 2]
 *  NOTE : If there are multiple answers possible, return the one thats lexicographically smallest.
 *  So, in example case, you will return [2, 1, 4, 3]
 */
public class WaveArray {
    private static int getMinIndex(ArrayList<Integer> A) {
        int min = Integer.MAX_VALUE, minIndex = 0;
        for(int i=0; i<A.size(); i++) {
            if(A.get(i)<min) {
                min = A.get(i);
                minIndex = i;
            }
        }
        return minIndex;
    }

    /**
     * Naive first implemenation, has a (sort of) hidden O(n^2) runtime,
     * since for all n elements of A, getMinIndex gets called which, again,
     * goes through all n elements.
     *
     * However, it was built on the correct premise that, if all you want is
     * lexographically-correct wave arrays, then all you have to do is have
     * the smallest int at (2*i)+1, and the next smallest at (2*i), repeating
     * until you're out of elements.
     **/
    public static ArrayList<Integer> waveNaive(ArrayList<Integer> A) {
        ArrayList<Integer> result = new ArrayList<>();
        for(int j=0; j<A.size(); j++)
            result.add(0);
        int i = 0;
        while(!A.isEmpty()) {
            if(A.size()>1) {
                int minIndex = getMinIndex(A);
                result.set((2*i)+1, A.remove(minIndex));
            }
            if(!A.isEmpty()) {
                int minIndex = getMinIndex(A);
                result.set((2*i), A.remove(minIndex));
            }
            i++;
        }
        return result;
    }

    private static void swap(ArrayList<Integer> arr, int x, int y) {
        Integer temp = arr.get(x);
        arr.set(x, arr.get(y));
        arr.set(y, temp);
    }

    /**
     * Proper approach that doesn't run into the O(n^2) problem. If your list
     * is already sorted, then the only thing you need to worry about is
     * swapping every pair of elements, and you list will then be in wave
     * form, lexicographically ascending.
     *
     * Runs in O(n) time.
     */
    public static ArrayList<Integer> wave(ArrayList<Integer> A) {
        Collections.sort(A);

        for(int i=0; i<A.size()-1; i+=2)
            swap(A, i, i+1);

        return A;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(1, 2, 3,
                4));
        System.out.println(wave(arrayList).toString());
        ArrayList<Integer> arrayList1 = new ArrayList<>(Arrays.asList(5, 1, 3
                , 2, 4));
        System.out.println(wave(arrayList1).toString());
    }
}
