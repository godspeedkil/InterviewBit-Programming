package Backtracking;

import java.util.ArrayList;

/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 2 3 ... n.
 *
 * Make sure the combinations are sorted.
 *
 * To elaborate,
 *
 * Within every entry, elements should be sorted. [1, 4] is a valid entry while [4, 1] is not.
 * Entries should be sorted within themselves.
 * Example :
 * If n = 4 and k = 2, a solution is:
 *
 * [
 *   [1,2],
 *   [1,3],
 *   [1,4],
 *   [2,3],
 *   [2,4],
 *   [3,4],
 * ]
 */
public class Combinations {

    /**
     * With a slight modification of basic backtracking, we can get the following solution...
     */
    private static void backtrack(int max, ArrayList<ArrayList<Integer>> result,
                                  ArrayList<Integer> subset, int currentNum, int subsetSize) {
        for (int i=currentNum; i<=max; i++) {
            ArrayList<Integer> newSubset = new ArrayList<>(subset);
            newSubset.add(i);
            backtrack(max, result, newSubset, i+1, subsetSize);
            if (newSubset.size()==subsetSize)
                result.add(newSubset);
        }
    }

    public static ArrayList<ArrayList<Integer>> combine(int A, int B) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> subset = new ArrayList<>();

        backtrack(A, result, subset, 1, B);

        return result;
    }

    public static void main(String[] args) {
        System.out.println(combine(4, 3));
        System.out.println(combine(1, 1));
    }
}
