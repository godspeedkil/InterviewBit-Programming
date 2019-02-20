package Hashing;

import java.util.HashSet;

/**
 * Given a string,
 * find the length of the longest substring without repeating characters.
 *
 * Example:
 *
 * The longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3.
 *
 * For "bbbbb" the longest substring is "b", with the length of 1.
 */
public class LongestSubstringWithoutRepeat {

    /**
     * Improved solution exploits the better aspects of Hash Sets to calculate the longest
     * substring.
     */
    public static int lengthOfLongestSubstring(String A) {
        HashSet<Character> currentLetters = new HashSet<>();
        int max = 0;
        int currentIndex = 0;

        for (char ch : A.toCharArray()) {
            while (currentLetters.contains(ch)) {
                currentLetters.remove(A.charAt(currentIndex));
                currentIndex++;
            }
            currentLetters.add(ch);
            max = Math.max(max, currentLetters.size());
        }

        return max;
    }

    /**
     * Using two pointers we can do the following naive O(n^2) implementation.
     */
    public static int lengthOfLongestSubstringNaive(String A) {
        HashSet<Character> currentLetters = new HashSet<>();

        int left = 0, right = 0;
        String result = "";

        while (right<A.length()) {
            right = left;
            StringBuilder currentSubstring = new StringBuilder();
            while (right<A.length() && !currentLetters.contains(A.charAt(right))) {
                currentLetters.add(A.charAt(right));
                currentSubstring.append(A.charAt(right));
                result = (currentSubstring.length()>result.length()) ? currentSubstring.toString() : result;
                right++;
            }
            left++;
            currentLetters.clear();
        }

        return result.length();
    }

    public static void main(String[] args) {
        String string1 = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(string1));
        String string2 = "bbbbbbbb";
        System.out.println(lengthOfLongestSubstring(string2));
        String string3 = "Gg123hhiijjkk";
        System.out.println(lengthOfLongestSubstring(string3));
        String string4 = "dadbc";
        System.out.println(lengthOfLongestSubstring(string4));
    }
}
