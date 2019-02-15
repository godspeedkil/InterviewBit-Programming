package Backtracking;

import java.util.*;

/**
 * Given a collection of integers that might contain duplicates, S, return all possible subsets.
 *
 *  Note:
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * The subsets must be sorted lexicographically.
 * Example :
 * If S = [1,2,2], the solution is:
 *
 * [
 * [],
 * [1],
 * [1,2],
 * [1,2,2],
 * [2],
 * [2, 2]
 * ]
 */
public class SubsetsII {

    /**
     * Again, pretty much the same solution as Subsets, we now just have to watch out for
     * duplicate sets. Using a HashSet solves the problem.
     */
    private static void backtrack(ArrayList<Integer> A, HashSet<ArrayList<Integer>> result,
                                  ArrayList<Integer> subset, int currentIndex) {
        for (int i=currentIndex; i<A.size(); i++) {
            ArrayList<Integer> newSubset = new ArrayList<>(subset);
            newSubset.add(A.get(i));
            result.add(newSubset);

            backtrack(A, result, newSubset, i+1);
        }
    }

    public static ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> A) {
        Collections.sort(A);
        ArrayList<Integer> subset = new ArrayList<>();
        HashSet<ArrayList<Integer>> result = new HashSet<>();

        result.add(subset);

        int currentIndex = 0;
        backtrack(A, result, subset, currentIndex);

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
        ArrayList<Integer> arrayList1 = new ArrayList<>(Arrays.asList(1, 2, 2));
        System.out.println(subsetsWithDup(arrayList1));
    }
}
