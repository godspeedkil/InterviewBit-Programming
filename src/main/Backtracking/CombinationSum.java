package Backtracking;

import java.util.*;

/**
 * Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 *
 * The same repeated number may be chosen from C unlimited number of times.
 *
 *  Note:
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 * The combinations themselves must be sorted in ascending order.
 * CombinationA > CombinationB iff (a1 > b1) OR (a1 = b1 AND a2 > b2) OR … (a1 = b1 AND a2 = b2 AND … ai = bi AND ai+1 > bi+1)
 * The solution set must not contain duplicate combinations.
 * Example,
 * Given candidate set 2,3,6,7 and target 7,
 * A solution set is:
 *
 * [2, 2, 3]
 * [7]
 */
public class CombinationSum {

    /**
     * Backtracking solution creates two new branches, one with the same list of possible numbers
     * to choose from, and one without the first element. This way, we make sure to account for
     * possible repetitions, since the same number may be used twice.
     * Additionally, I decided to keep the total of the sum of the subsets within the first
     * element of the subset itself, that way it is much easier to keep updating it and looking
     * it up for comparison purposes. It just gets removed before adding an actual solution to
     * the result.
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
                backtrack(target, nums, result, newSubset, i);
                backtrack(target, nums, result, new ArrayList<>(newSubset), i+1);
            }
            if (newSubset.get(0)==target) {
                newSubset.remove(0);
                result.add(newSubset);
            }
        }
    }

    public static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
        Collections.sort(A);
        HashSet<ArrayList<Integer>> result = new HashSet<>();
        ArrayList<Integer> subset = new ArrayList<>();
        subset.add(0);

        backtrack(B, A, result, subset, 0);

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
        ArrayList<Integer> arrayList1 = new ArrayList<>(Arrays.asList(2, 3, 6, 7));
        System.out.println(combinationSum(arrayList1, 7));
        ArrayList<Integer> arrayList2 = new ArrayList<>(Arrays.asList(8, 10, 6, 11, 1, 16, 8));
        System.out.println(combinationSum(arrayList2, 28));
    }
}
