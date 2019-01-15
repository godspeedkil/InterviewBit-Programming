package Arrays;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given numRows, generate the first numRows of Pascal’s triangle.
 *
 * Pascal’s triangle : To generate A[C] in row R, sum up A’[C] and A’[C-1] from previous row R - 1.
 *
 * Example:
 *
 * Given numRows = 5,
 *
 * Return
 *
 * [
 *      [1],
 *      [1,1],
 *      [1,2,1],
 *      [1,3,3,1],
 *      [1,4,6,4,1]
 * ]
 */
public class PascalTriangle {

    /**
     * Reasonable O(n^2) solution with O(n^2) extra space utilization. Simply
     * relies on the basic knowledge of Pascal's triangle. Additionally, it
     * quickly overflows.
     */
    public static ArrayList<ArrayList<Integer>> solve(int A) {
        if(A==0) return new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>(Arrays.asList(1)));
        for(int i=1; i<A; i++) {
            result.add(new ArrayList<>());
            for(int j=0; j<=i; j++) {
                result.get(i).add(0);
            }
        }
        for(int i=0; i<result.size()-1; i++) {
            for(int j=0; j<result.get(i).size(); j++) {
                Integer upper = (Integer)result.get(i).get(j);
                Integer lower1 = (Integer)result.get(i+1).get(j);
                Integer lower2 = (Integer)result.get(i+1).get(j+1);
                result.get(i+1).set(j, lower1+upper);
                result.get(i+1).set(j+1, lower2+upper);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(solve(5).toString());
        System.out.println(solve(50).toString());
    }
}
