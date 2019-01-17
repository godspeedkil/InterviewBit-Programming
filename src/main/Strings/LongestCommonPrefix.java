package Strings;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * Longest common prefix for a pair of strings S1 and S2 is the longest string S which is the prefix of both S1 and S2.
 *
 * As an example, longest common prefix of "abcdefgh" and "abcefgh" is "abc".
 *
 * Given the array of strings, you need to find the longest S which is the prefix of ALL the strings in the array.
 *
 * Example:
 *
 * Given the array as:
 *
 * [
 *
 *   "abcdefgh",
 *
 *   "aefghijk",
 *
 *   "abcefgh"
 * ]
 * The answer would be “a”.
 */
public class LongestCommonPrefix {

    /**
     * Easy-to-understand solution, simply go column-by-column to compare the
     * characters, and build a String based on that. Problem is, it's O(n*k),
     * where k is the number of Strings in the original list.
     */
    public static String longestCommonPrefix(ArrayList<String> A) {
        int shortest = Integer.MAX_VALUE;
        for(int i=0; i<A.size(); i++)
            shortest = Math.min(shortest, A.get(i).length());

        StringBuilder result = new StringBuilder();

        for(int i=0; i<shortest; i++) {
            char currentChar = A.get(0).charAt(i);
            for(int j=0; j<A.size(); j++) {
                if(!(currentChar == A.get(j).charAt(i)))
                    return result.toString();
            }
            result.append(currentChar);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        ArrayList<String> arrayList1 = new ArrayList<>(Arrays.asList(
                "abcdefgh", "aefghijk", "abcefgh"));
        System.out.println(longestCommonPrefix(arrayList1));
    }
}
