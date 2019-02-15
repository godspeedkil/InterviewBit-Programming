package Backtracking;

import java.util.*;

/**
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 *
 * Each number in C may only be used once in the combination.
 *
 *  Note:
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 * The solution set must not contain duplicate combinations.
 * Example :
 *
 * Given candidate set 10,1,2,7,6,1,5 and target 8,
 *
 * A solution set is:
 *
 * [1, 7]
 * [1, 2, 5]
 * [2, 6]
 * [1, 1, 6]
 */
public class CombinationSumII {

    /**
     * Same solution as CombinationSum, we just don't consider using the same number more than
     * once...
     */
    private static void backtrack(int target,
                                  ArrayList<Integer> nums, HashSet<ArrayList<Integer>> result,
                                  ArrayList<Integer> subset, int currentIndex) {
        for (int i=currentIndex; i<nums.size(); i++) {
            ArrayList<Integer> newSubset = new ArrayList<>(subset);
            int newSum = newSubset.get(0)+nums.get(i);
            if (newSum<=target) {
                newSubset.add(nums.get(i));
                newSubset.set(0, newSubset.get(0) + nums.get(i));
//                backtrack(target, nums, result, newSubset, i);
                backtrack(target, nums, result, new ArrayList<>(newSubset), i+1);
            }
            if (newSubset.get(0)==target) {
                newSubset.remove(0);
                result.add(newSubset);
            }
        }
    }

    public static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> a, int b) {
        Collections.sort(a);
        HashSet<ArrayList<Integer>> result = new HashSet<>();
        ArrayList<Integer> subset = new ArrayList<>();
        subset.add(0);

        backtrack(b, a, result, subset, 0);

        ArrayList<ArrayList<Integer>> result2 = new ArrayList<>(result);

        result2.sort(new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                int i = 0;
                while (i<o1.size() && i<o2.size()) {
                    if (o1.get(i)<o2.get(i))
                        return -1;
                    else if (o1.get(i)>o2.get(i))
                        return 1;
                    i++;
                }
                if (o1.size()<o2.size())
                    return -1;
                else if (o1.size()>o2.size())
                    return 1;
                return 0;
            }
        });

        return result2;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList1 = new ArrayList<>(Arrays.asList(10, 1, 2, 7, 6, 1, 5));
        System.out.println(combinationSum(arrayList1, 8));
    }
}
