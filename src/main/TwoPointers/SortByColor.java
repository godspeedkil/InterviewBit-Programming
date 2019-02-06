package TwoPointers;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given an array with n objects colored red, white or blue,
 * sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.
 *
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 *
 * Note: Using library sort function is not allowed.
 *
 * Example :
 *
 * Input : [0 1 2 0 1 2]
 * Modify array so that it becomes : [0 0 1 1 2 2]
 */
public class SortByColor {

    private static void swap(ArrayList<Integer> a, int index1, int index2) {
        Integer temp = a.get(index1);
        a.set(index1, a.get(index2));
        a.set(index2, temp);
    }

    /**
     * This O(n) solution works pretty well, can't think of much to say, it's
     * self-explanatory, based on swaps.
     */
    public static void sortColors(ArrayList<Integer> a) {
        int currentIndex = 0;
        for(int i=0; i<=2; i++) {
            for(int j=currentIndex; j<a.size(); j++) {
                if(a.get(j)==i) {
                    swap(a, j, currentIndex);
                    currentIndex++;
                }
            }
        }

        System.out.println(a);
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList1 = new ArrayList<>(Arrays.asList(0, 1, 2
                , 0, 1, 2));
        sortColors(arrayList1);
    }
}
