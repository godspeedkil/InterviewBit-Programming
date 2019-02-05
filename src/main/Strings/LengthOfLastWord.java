package Strings;

/**
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
 *
 * If the last word does not exist, return 0.
 *
 * Note: A word is defined as a character sequence consists of non-space characters only.
 *
 * Example:
 *
 * Given s = "Hello World",
 *
 * return 5 as length("World") = 5.
 *
 * Please make sure you try to solve this problem without using library functions. Make sure you only traverse the string once.
 */
public class LengthOfLastWord {

    /**
     * Without utilizing library functions, we just go right-to-left (first
     * making sure to trim any excess whitespace at the end. After that, it's
     * just a simple counting algorithm.
     */
    public static int lengthOfLastWord(final String A) {
        int result = 0;
        int lastCharIndex = A.length()-1;

        for(int i=A.length()-1; i>=0; i--) {
            if(A.charAt(i)==' ') continue;
            else {
                lastCharIndex = i;
                break;
            }
        }

        for(int i=lastCharIndex; i>=0; i--) {
            if(A.charAt(i)==' ') break;
            else result++;
        }

        return result;
    }

    public static void main(String[] args) {
        String string1 = "Hello World";
        System.out.println(lengthOfLastWord(string1));
    }
}
