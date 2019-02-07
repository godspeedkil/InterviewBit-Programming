package Strings;

import java.util.Stack;

/**
 * Given a string S, find the longest palindromic substring in S.
 *
 * Substring of string S:
 *
 * S[i...j] where 0 <= i <= j < len(S)
 *
 * Palindrome string:
 *
 * A string which reads the same backwards. More formally, S is palindrome if reverse(S) = S.
 *
 * Incase of conflict, return the substring which occurs first ( with the least starting index ).
 *
 * Example :
 *
 * Input : "aaaabaaa"
 * Output : "aaabaaa"
 */
public class LongestPalindromicSubstring {

    private static boolean isPalindrome(String A) {
        Stack<Character> letters = new Stack<>();
        for(int i=0; i<A.length()/2; i++) {
            letters.push(A.charAt(i));
        }
        for(int i=(int)Math.ceil(A.length()/2.0); i<A.length(); i++) {
            if(letters.pop()!=A.charAt(i))
                return false;
        }
        return true;
    }

    /**
     * Naive approach is just brute force O(n^3), check all vs all and keep
     * track of the longest.
     */
    public static String longestPalindromeNaive(String A) {
        String longest = "";

        for(int i=0; i<A.length(); i++) {
            for(int j=i; j<A.length(); j++) {
                String current = A.substring(i, j+1);
                if(isPalindrome(current) && current.length()>longest.length())
                    longest = current;
            }
        }

        return longest;
    }

    /**
     * Better approach improves up to O(n^2) by using dynamic programming to
     * keep track of the previous solutions to smaller substrings, through
     * the use of a table for quick lookup. 
     */
    public static String longestPalindrome(String A) {
        int n = A.length();
        boolean table[][] = new boolean[n][n];
        int maxLength = 1;

        for(int i=0; i<n; i++)
            table[i][i] = true;

        int start = 0;
        for(int i=0; i<n-1; i++) {
            if(A.charAt(i)==A.charAt(i+1)) {
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
                if(table[i+1][j-1] && A.charAt(i)== A.charAt(j)) {
                    table[i][j] = true;
                    if(k>maxLength) {
                        start = i;
                        maxLength = k;
                    }
                }
            }
        }

        return A.substring(start, start+maxLength);
    }

    public static void main(String[] args) {
//        System.out.println(isPalindrome("abba"));
//        System.out.println(isPalindrome("abbba"));
//        System.out.println(isPalindrome("abbb"));
//        System.out.println(longestPalindrome("aaaabaaa"));
        System.out.println(longestPalindrome("caba"));
        System.out.println(longestPalindrome("aaabcdbbb"));
    }
}
