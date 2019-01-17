package Strings;

import java.util.Stack;

/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 *
 * Example:
 *
 * "A man, a plan, a canal: Panama" is a palindrome.
 *
 * "race a car" is not a palindrome.
 *
 * Return 0 / 1 ( 0 for false, 1 for true ) for this problem
 */
public class PalindromeString {

    public static int isPalindrome(String A) {
        A = A.toUpperCase();
        StringBuilder onlyAlphaNum = new StringBuilder(A);
        int left = 0, right = onlyAlphaNum.length()-1;

        while(left < right) {
            Character currentLeft = onlyAlphaNum.charAt(left);
            Character currentRight = onlyAlphaNum.charAt(right);
            if(Character.isLetterOrDigit(currentLeft) && Character.isLetterOrDigit(currentRight)) {
                if (currentLeft != currentRight)
                    return 0;
                left++;
                right--;
            }
            if(!Character.isLetterOrDigit(currentLeft))
                left++;
            else if (!Character.isLetterOrDigit(currentRight))
                right--;
        }

        return 1;
    }

    public static int isPalindromeNaive(String A) {
        StringBuilder onlyAlphaNum = new StringBuilder(A);
        for(int i=0; i<onlyAlphaNum.length(); i++)
            if(!Character.isLetterOrDigit(onlyAlphaNum.charAt(i))) {
                onlyAlphaNum.deleteCharAt(i);
                i--; // make sure we don't skip chars
            }

        String trimmedString = onlyAlphaNum.toString().toUpperCase();

        Stack<Character> characters = new Stack<Character>();

        for(int i=0; i<trimmedString.length()/2; i++) {
            characters.push(trimmedString.charAt(i));
        }

        for(int i=(int)Math.ceil(trimmedString.length()/2.0); i<trimmedString.length(); i++) {
            Character popped = characters.pop();
            Character currentChar = trimmedString.charAt(i);
            if (currentChar != popped) return 0;
        }

        return 1;
    }

    public static void main(String[] args) {
        String string1 = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(string1));
    }
}
