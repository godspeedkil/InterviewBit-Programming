package Hashing;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
 *
 *  Note:
 * Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
 * The solution set must not contain duplicate quadruplets.
 * Example :
 * Given array S = {1 0 -1 0 -2 2}, and target = 0
 * A solution set is:
 *
 *     (-2, -1, 1, 2)
 *     (-2,  0, 0, 2)
 *     (-1,  0, 0, 1)
 * Also make sure that the solution set is lexicographically sorted.
 * Solution[i] < Solution[j] iff Solution[i][0] < Solution[j][0] OR (Solution[i][0] == Solution[j][0] AND ... Solution[i][k] < Solution[j][k])
 */
public class FourSum {

    public static ArrayList<ArrayList<Integer>> fourSum(ArrayList<Integer> A, int B) {
        Collections.sort(A);
        HashSet<ArrayList<Integer>> tempSet = new HashSet<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        for (int i=0; i<A.size(); i++) {
            for (int j=i+1; j<A.size(); j++) {
                int k = j+1;
                int l = A.size()-1;

                while (k<l) {
                    int sum = A.get(i) + A.get(j) + A.get(k) + A.get(l);

                    if (sum>B) {
                        l--;
                    }
                    else if (sum<B) {
                        k++;
                    }
                    else {
                        ArrayList<Integer> temp = new ArrayList<>();
                        temp.add(A.get(i));
                        temp.add(A.get(j));
                        temp.add(A.get(k));
                        temp.add(A.get(l));
                        if (!tempSet.contains(temp)) {
                            tempSet.add(temp);
                            result.add(temp);
                        }
                        k++;
                        l--;
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList1 = new ArrayList<>(Arrays.asList(1, 0, -1, 0, -2, 2));
        System.out.println(fourSum(arrayList1, 0));
        ArrayList<Integer> arrayList2 = new ArrayList<>(Arrays.asList(-5, -12, 11, 30, 34, 18, 3, 24, 24, 16, -17, 31, -4, 17, 30, 28, 32, 4, 26));
        System.out.println(fourSum(arrayList2, 74));
        ArrayList<Integer> arrayList3 = new ArrayList<>(Arrays.asList(23, 20, 0, 21, 3, 38, 35,
                -6, 2, 5, 4, 21));
        System.out.println(fourSum(arrayList3, 29));
    }
}
