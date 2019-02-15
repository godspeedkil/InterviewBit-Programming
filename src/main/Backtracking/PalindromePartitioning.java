package Backtracking;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Given a string s, partition s such that every string of the partition is a palindrome.
 *
 * Return all possible palindrome partitioning of s.
 *
 * For example, given s = "aab",
 * Return
 *
 *   [
 *     ["a","a","b"]
 *     ["aa","b"],
 *   ]
 *  Ordering the results in the answer : Entry i will come before Entry j if :
 * len(Entryi[0]) < len(Entryj[0]) OR
 * (len(Entryi[0]) == len(Entryj[0]) AND len(Entryi[1]) < len(Entryj[1])) OR
 * *
 * *
 * *
 * (len(Entryi[0]) == len(Entryj[0]) AND … len(Entryi[k] < len(Entryj[k]))
 * In the given example,
 * ["a", "a", "b"] comes before ["aa", "b"] because len("a") < len("aa")
 */
public class PalindromePartitioning {

    /**
     * For this solution, I made a strange adaptation between backtracking and dynamic
     * programming storage of palindromic values. Populating the table is O(n^2), which in this
     * case is fine, since it falls under the O(2^n) complexity of the backtracking function.
     */
    private static boolean[][] populateTable(String a) {
        int n = a.length();
        boolean table[][] = new boolean[n][n];
        int maxLength = 1;

        for(int i=0; i<n; i++)
            table[i][i] = true;

        int start = 0;
        for(int i=0; i<n-1; i++) {
            if(a.charAt(i)==a.charAt(i+1)) {
                table[i][i+1] = true;
                if(maxLength<2) {
                    start = i;
                    maxLength = 2;
                }
            }
        }

        for(int k=3; k<=n; k++) {
            for(int i=0; i<n-k+1; i++) {
                int j = i+k-1;
                if(table[i+1][j-1] && a.charAt(i)== a.charAt(j)) {
                    table[i][j] = true;
                    if(k>maxLength) {
                        start = i;
                        maxLength = k;
                    }
                }
            }
        }

        return table;
    }

    private static void backtrack(String a, ArrayList<ArrayList<String>> result,
                                  ArrayList<String> subset, int currentL, int currentR,
                                  boolean[][] table, int currentSize) {
        if (currentSize==a.length())
            result.add(subset);
        if (currentL<a.length() && currentR<a.length()) {
            ArrayList<String> newSubset = new ArrayList<>(subset);
            if (table[currentL][currentR]) {
                String sub = a.substring(currentL, currentR + 1);
                newSubset.add(sub);
                backtrack(a, result, newSubset, currentR + 1, currentR + 1, table, currentSize + sub.length());
            }

            backtrack(a, result, new ArrayList<>(subset), currentL, currentR + 1, table,
                    currentSize);
        }
    }

    public static ArrayList<ArrayList<String>> partition(String a) {
        boolean[][] table = populateTable(a);
        ArrayList<ArrayList<String>> result = new ArrayList<>();

        backtrack(a, result, new ArrayList<>(), 0, 0, table, 0);

        return result;
    }

    public static void main(String[] args) {
        String string1 = "aab";
        System.out.println(partition(string1));
        String string2 = "cccaacbcaabb";
        System.out.println(partition(string2));
    }
}
