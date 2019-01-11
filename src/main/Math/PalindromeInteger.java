package Math;

/**
 * Determine whether an integer is a palindrome. Do this without extra space.
 *
 * A palindrome integer is an integer x for which reverse(x) = x where reverse(x) is x with its digit reversed.
 * Negative numbers are not palindromic.
 *
 * Example :
 *
 * Input : 12121
 * Output : True
 *
 * Input : 123
 * Output : False
 */
public class PalindromeInteger {

    /**
     * Question is not properly formulated, since solution with O(1) space
     * allocation works perfectly fine. 
     */
    public static int isPalindrome(int A) {
        if(A<0) return 0;
        int reversed = 0;
        int copyA = A;
        while(copyA != 0) {
            reversed = reversed * 10 + copyA % 10;
            copyA /= 10;
        }

        if(A == reversed) return 1;
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(12121));
        System.out.println(isPalindrome(123));
        System.out.println(isPalindrome(-1));
        System.out.println(isPalindrome(0));
    }
}
