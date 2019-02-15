package Backtracking;

import javafx.beans.binding.IntegerBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * Given a set of distinct integers, S, return all possible subsets.
 *
 *  Note:
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * Also, the subsets should be sorted in ascending ( lexicographic ) order.
 * The list is not necessarily sorted.
 * Example :
 *
 * If S = [1,2,3], a solution is:
 *
 * [
 *   [],
 *   [1],
 *   [1, 2],
 *   [1, 2, 3],
 *   [1, 3],
 *   [2],
 *   [2, 3],
 *   [3],
 * ]
 */
public class Subsets {

    /**
     * Basic backtrack function, O(2^n) solution, since new branches are created for every
     * iteration of the loop.
     */
    private static void backtrack(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> result,
                                  ArrayList<Integer> subset, int currentIndex) {
        for (int i=currentIndex; i<A.size(); i++) {
            ArrayList<Integer> newSubset = new ArrayList<>(subset);
            newSubset.add(A.get(i));
            result.add(newSubset);

            backtrack(A, result, newSubset, i+1);
        }
    }

    public static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        Collections.sort(A);
        ArrayList<Integer> subset = new ArrayList<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        result.add(subset);

        int currentIndex = 0;
        backtrack(A, result, subset, currentIndex);

        return result;
    }

    /**
     * Naive, unfinished O(n^3) implementation using multiple-size sliding windows to get every
     * subset. To be fair O(n^3) is slightly better than O(n*2^n) and slightly worse than O(2^n).
     */
    public static ArrayList<ArrayList<Integer>> subsetsNaive(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        for (int i=A.size(); i>=1; i--) {
            int currentIndex = 0;
            while (currentIndex+i<=A.size()) {
                ArrayList<Integer> temp = new ArrayList<>();
                for (int j=currentIndex; j<currentIndex+i; j++) {
                    temp.add(A.get(j));
                }
                result.add(temp);
                currentIndex++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList1 = new ArrayList<>(Arrays.asList(1, 2, 3));
        System.out.println(subsets(arrayList1));
    }
}
