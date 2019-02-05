package Strings;

/**
 * Implement atoi to convert a string to an integer.
 *
 * Example :
 *
 * Input : "9 2704"
 * Output : 9
 * Note: There might be multiple corner cases here. Clarify all your doubts using “See Expected Output”.
 *
 *  Questions: Q1. Does string contain whitespace characters before the number?
 * A. Yes Q2. Can the string have garbage characters after the number?
 * A. Yes. Ignore it. Q3. If no numeric character is found before encountering garbage characters, what should I do?
 * A. Return 0. Q4. What if the integer overflows?
 * A. Return INT_MAX if the number is positive, INT_MIN otherwise.
 * Warning : DO NOT USE LIBRARY FUNCTION FOR ATOI.
 */
public class Atoi {

    /**
     * The aim of this problem is not so much the difficulty of it, but
     * rather the vagueness of the solution. Unfortunately, this doesn't
     * really work with automated code-checking, and you just end up
     * modifying and remodifying your solution until it clears the automated
     * checks.
     */
    public static int atoi(final String A) {
        int currentIndex = 0;
        long num = 0;
        int n = A.length();
        int sign = 1;

        while(currentIndex<n && A.charAt(currentIndex)==' ')
            currentIndex++;

        if(currentIndex==n)
            return 0;

        if(A.charAt(currentIndex)=='-') {
            sign *= -1;
            currentIndex++;
        }
        else if(A.charAt(currentIndex)=='+') {
            currentIndex++;
        }

        while(currentIndex<n && A.charAt(currentIndex)>='0' &&
        A.charAt(currentIndex)<='9') {
            num = Math.abs(num);
            num = num * 10 + A.charAt(currentIndex)-'0';
            num *= sign;

            if(num>Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            else if(num<Integer.MIN_VALUE)
                return Integer.MIN_VALUE;

            currentIndex++;
        }

        return (int)num;
    }

    public static void main(String[] args) {
        String string1 = "9 2704";
        System.out.println(atoi(string1));
        String string2 = "5 88C340185Q 71 8079 834617385 2898422X5297Z6900";
        System.out.println(atoi(string2));
        String string3 = "1203987123409871230498";
        System.out.println(atoi(string3));
        String string4 = "1100000000";
        System.out.println(atoi(string4));
        String string5 = "-88297";
        System.out.println(atoi(string5));
        String string6 = "- 5";
        System.out.println(atoi(string6));
        String string7 = "5121478262";
        System.out.println(atoi(string7));
    }
}
