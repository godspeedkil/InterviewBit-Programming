package Math;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Rearrange a given array so that Arr[i] becomes Arr[Arr[i]] with O(1) extra space.
 *
 * Example:
 *
 * Input : [1, 0]
 * Return : [0, 1]
 *  Lets say N = size of the array. Then, following holds true :
 * All elements in the array are in the range [0, N-1]
 * N * N does not overflow for a signed integer
 */
public class RearrangeArray {

    public static void arrangeArr(int[] arr) {
        int n = arr.length;

        for(int i=0; i<n; i++)
            arr[i] += (arr[arr[i]] % n) * n;
        for(int i=0; i<n; i++)
            arr[i] /= n;
    }

    /**
     * Solution utilizes clever math to store the value of the old position
     * and the new position within the value itself. The rest is just
     * extracting it by dividing each value by the size of the array.
     */
    public static void arrange(ArrayList<Integer> a) {
        for(int i=0; i<a.size(); i++)
            a.set(i, a.get(i) + ((a.get(a.get(i)) % a.size()) * a.size()));
        for(int i=0; i<a.size(); i++)
            a.set(i, a.get(i)/a.size());
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(1, 2, 3,
                4, 5, 6, 7, 0));
        arrange(arrayList);
        System.out.println(arrayList);
    }
}
