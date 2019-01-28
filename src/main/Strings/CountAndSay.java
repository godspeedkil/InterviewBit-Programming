package Strings;

/**
 * The count-and-say sequence is the sequence of integers beginning as follows:
 *
 * 1, 11, 21, 1211, 111221, ...
 * 1 is read off as one 1 or 11.
 * 11 is read off as two 1s or 21.
 *
 * 21 is read off as one 2, then one 1 or 1211.
 *
 * Given an integer n, generate the nth sequence.
 *
 * Note: The sequence of integers will be represented as a string.
 *
 * Example:
 *
 * if n = 2,
 * the sequence is 11.
 */
public class CountAndSay {

    /**
     * O(n^2) solution, depends on generating every single one, then
     * generating the next one in the sequence.
     */
    public static String countAndSay(int A) {
        String result = "1";

        if(A==1) return result;

        String temp = "";

        for(int i=2; i<=A; i++) {
            char prev = result.charAt(0);
            char currentChar = result.charAt(0);
            int currentCounter = 0;
            for(int j=0; j<result.length(); j++) {
                currentChar = result.charAt(j);
                if(prev == currentChar) currentCounter++;
                else {
                    temp += currentCounter;
                    temp += prev;
                    currentCounter = 1;
                }
                prev = currentChar;
            }
            temp += currentCounter;
            temp += prev;
            result = temp;
            temp = "";
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(1));
        System.out.println(countAndSay(2));
        System.out.println(countAndSay(3));
        System.out.println(countAndSay(4));
        System.out.println(countAndSay(5));
        System.out.println(countAndSay(6));
        System.out.println(countAndSay(7));
    }
}
