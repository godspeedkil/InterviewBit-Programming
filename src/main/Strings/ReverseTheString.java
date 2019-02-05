package Strings;

import java.util.Stack;

/**
 * Given an input string, reverse the string word by word.
 *
 * Example:
 *
 * Given s = "the sky is blue",
 *
 * return "blue is sky the".
 *
 * A sequence of non-space characters constitutes a word.
 * Your reversed string should not contain leading or trailing spaces, even if it is present in the input string.
 * If there are multiple spaces between words, reduce them to a single space in the reversed string.
 */
public class ReverseTheString {

    /**
     * A stack is a decent solution when reversing pretty much anything. This
     * is probably not the most elegant solution, but it does the job in O(n)
     * time.
     */
    public static String reverseWords(String a) {
        Stack<String> words = new Stack<>();
        StringBuilder currentWord = new StringBuilder();

        for(int i=0; i<a.length(); i++) {
            if(a.charAt(i)==' ') {
                if(!(currentWord.length()==0)) {
                    words.push(currentWord.toString());
                    currentWord = new StringBuilder();
                }
            }
            else {
                currentWord.append(a.charAt(i));
            }
        }
        if(!(currentWord.length()==0)) {
            words.push(currentWord.toString());
        }

        StringBuilder result = new StringBuilder();
        while(!words.isEmpty()) {
            result.append(words.pop());
            result.append(" ");
        }
        result.deleteCharAt(result.length()-1);

        return result.toString();
    }

    public static void main(String[] args) {
        String string1 = "the sky is blue";
        System.out.println(reverseWords(string1));
    }
}
