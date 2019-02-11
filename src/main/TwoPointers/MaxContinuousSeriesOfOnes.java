package TwoPointers;

import com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * You are given with an array of 1s and 0s. And you are given with an integer M, which signifies number of flips allowed.
 * Find the position of zeros which when flipped will produce maximum continuous series of 1s.
 *
 * For this problem, return the indices of maximum continuous series of 1s in order.
 *
 * Example:
 *
 * Input :
 * Array = {1 1 0 1 1 0 0 1 1 1 }
 * M = 1
 *
 * Output :
 * [0, 1, 2, 3, 4]
 *
 * If there are multiple possible solutions, return the sequence which has the minimum start index.
 */
public class MaxContinuousSeriesOfOnes {

    /**
     * If we use the concept of a sliding window, we find that this is a
     * pretty efficient O(n) solution that needs only go through the array
     * once in order to find the max continuous series of 1s.
     */
    public static ArrayList<Integer> maxone(ArrayList<Integer> A, int B) {
        int windowL = 0, windowR = 0;
        int bestL = 0, bestWindow = 0;
        int currentZeros = 0;

        while (windowR<A.size()) {
            if (currentZeros<=B) {
                if (A.get(windowR)==0)
                    currentZeros++;
                windowR++;
            }
            if (currentZeros>B) {
                if (A.get(windowL)==0)
                    currentZeros--;
                windowL++;
            }
            int currentWindow = windowR-windowL;
            if ((currentWindow>bestWindow) && (currentZeros<=B)) {
                bestWindow = currentWindow;
                bestL = windowL;
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int i=bestL; i<(bestL+bestWindow); i++)
            result.add(i);

        return result;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList1 = new ArrayList<>(Arrays.asList(1, 1, 0
                , 1, 1, 0, 0, 1, 1, 1));
        int m1 = 1;
        System.out.println(maxone(arrayList1, m1));
    }
}
