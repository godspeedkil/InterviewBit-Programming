package TwoPointers;

import com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH;

import java.util.*;

/**
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 *
 * Note:
 *
 *  Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
 * The solution set must not contain duplicate triplets. For example, given array S = {-1 0 1 2 -1 -4}, A solution set is:
 * (-1, 0, 1)
 * (-1, -1, 2)
 */
public class ThreeSumZero {

    /**
     * Having done ThreeSum previously, solution was pretty much the same. We
     * just have to be careful with duplicate triplets. Still O(n^2).
     */
    public static ArrayList<ArrayList<Integer>> threeSum(ArrayList<Integer> A) {
        Set<ArrayList<Integer>> uniques = new HashSet<>();

        A.sort(Integer::compareTo);
        for(int i=0; i<A.size()-2; i++) {
            int j=i+1, k=A.size()-1;
            while(j<k) {
                int temp = A.get(i)+A.get(j)+A.get(k);
                if(temp==0) {
                    uniques.add(new ArrayList<>(Arrays.asList(A.get(i),
                            A.get(j),
                            A.get(k))));
                }
                if(temp<=0)
                    j++;
                else
                    k--;
            }
        }

        return new ArrayList<>(uniques);
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList1 = new ArrayList<>(Arrays.asList(-1, 0,
                1, 2, -1, -4));
        System.out.println(threeSum(arrayList1));
    }
}
