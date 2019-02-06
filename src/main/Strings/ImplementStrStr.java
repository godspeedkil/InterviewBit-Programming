package Strings;

/**
 * Implement strStr().
 *
 *  strstr - locate a substring ( needle ) in a string ( haystack ).
 * Try not to use standard library string functions for this question.
 *
 * Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 *
 *  NOTE: Good clarification questions:
 * What should be the return value if the needle is empty?
 * What if both haystack and needle are empty?
 * For the purpose of this problem, assume that the return value should be -1 in both cases.
 */
public class ImplementStrStr {

    public static int strStr(final String A, final String B) {
        if(A.isEmpty() || B.isEmpty()) return -1;

        int startIndex = -1;
        int pointerA = 0, pointerB = 0;

        while(pointerA<A.length()) {
            if(B.charAt(pointerB)!=A.charAt(pointerA)) {
                if(pointerB>0)
                    pointerA = startIndex+1;
                pointerB = 0;
            }
            if(pointerB<B.length() && B.charAt(pointerB)==A.charAt(pointerA)) {
                if(pointerB==0)
                    startIndex = pointerA;
                pointerB++;
            }
            if(pointerB>=B.length())
                return startIndex;
            pointerA++;
        }

        return -1;
    }

    public static void main(String[] args) {
//        String haystack1 = "b";
//        String needle1 = "baba";
//        System.out.println(strStr(haystack1, needle1));
//        String needle2 = "bbbbbababaaaaaa";
//        System.out.println(strStr(haystack1, needle2));
//        String haystack2 =
//                "bbaabbbbbaabbaabbbbbbabbbabaabbbabbabbbbababbbabbabaaababbbaabaaaba";
//        String needle3 = "babaaa";
//        System.out.println(strStr(haystack2, needle3));
        String haystack3 = "aabaaaababaabbbabbabbbaabab";
        String needle4 = "bba";
        System.out.println(strStr(haystack3, needle4));
    }
}
