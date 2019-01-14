package Math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

/**
 * There are A cities numbered from 1 to A. You have already visited M cities, the indices of which are given in an array B of M integers.
 *
 * If a city with index i is visited, you can visit either the city with index i-1 (i >= 2) or the city with index i+1 (i < A) if they are not already visited.
 * Eg: if N = 5 and array M consists of [3, 4], then in the first level of moves, you can either visit 2 or 5.
 *
 * You keep visiting cities in this fashion until all the cities are not visited.
 * Find the number of ways in which you can visit all the cities modulo 10^9+7.
 *
 * Input Format
 *
 * The 1st argument given is an integer A, i.e total number of cities.
 * The 2nd argument given is an integer array B, where B[i] denotes ith city you already visited.
 * Output Format
 *
 * Return an Integer X % (1e9 + 7), number of ways in which you can visit all the cities.
 * Constraints
 *
 * 1 <= A <= 1000
 * 1 <= M <= A
 * 1 <= B[i] <= A
 * For Example
 *
 * Input:
 *     A = 5
 *     B = [2, 5]
 * Output:
 *     6
 *
 * Explanation:
 *     All possible ways to visit remaining cities are :
 *     1. 1 -> 3 -> 4
 *     2. 1 -> 4 -> 3
 *     3. 3 -> 1 -> 4
 *     4. 3 -> 4 -> 1
 *     5. 4 -> 1 -> 3
 *     6. 4 -> 3 -> 1
 */
public class CityTour {

    /**
     * Most naive solution, utilizes recursion to traverse through all
     * possibilities. Runtime is in the order of the permutations that are
     * the answer we are seeking.
     **/
    private static int solveRec(int A, ArrayList<Integer> B,
                                HashSet<Integer> possibilities) {
        int result = 0;

        for(Integer visited : B) {
            if(visited-1>0 && !B.contains(visited-1))
                possibilities.add(visited-1);
            if(visited+1<=A && !B.contains(visited+1))
                possibilities.add(visited+1);
        }
        Iterator iter = possibilities.iterator();
        while(iter.hasNext()) {
            Integer currentNum = (Integer)iter.next();
            ArrayList<Integer> tempList = new ArrayList<>(B);
            tempList.add(currentNum);
            HashSet<Integer> tempSet = new HashSet<>(possibilities);
            tempSet.remove(currentNum);
            result += solveRec(A, tempList, tempSet);
        }
        if(possibilities.isEmpty()) result++;

        return result;
    }

    public static int solve(int A, ArrayList<Integer> B) {
        HashSet<Integer> possibilities = new HashSet<>();
        for(Integer visited : B) {
            if(visited-1>0)
                possibilities.add(visited-1);
            if(visited+1<=A)
                possibilities.add(visited+1);
        }
        return solveRec(A, B, possibilities);
    }

    public static void main(String[] args) {
        System.out.println(solve(5, new ArrayList<>(Arrays.asList(2, 5))));
        System.out.println(solve(3, new ArrayList<>(Arrays.asList(1))));
        System.out.println(solve(4, new ArrayList<>(Arrays.asList(3, 1))));
        System.out.println(solve(10, new ArrayList<>(Arrays.asList(6))));
    }
}
