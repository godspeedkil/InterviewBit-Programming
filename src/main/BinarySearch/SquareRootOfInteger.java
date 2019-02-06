package BinarySearch;

/**
 * Implement int sqrt(int x).
 *
 * Compute and return the square root of x.
 *
 * If x is not a perfect square, return floor(sqrt(x))
 *
 * Example :
 *
 * Input : 11
 * Output : 3
 * DO NOT USE SQRT FUNCTION FROM STANDARD LIBRARY
 */
public class SquareRootOfInteger {

    /**
     * For this to be an O(logn) solution, we must use two pointers low and
     * high starting at both ends of the range 1 to a. If our guess is too
     * low, increase low, if it's too high decrease high.
     */
    public static int sqrt(int a) {
        long low = 1, high = a;

        while(low<=high) {
            long mid = (low+high)/2;

            if(mid*mid==a)
                return (int)mid;
            if(mid*mid>a)
                high = mid-1;
            else
                low = mid+1;
        }

        return (int)high;
    }

    public static void main(String[] args) {
        System.out.println(sqrt(20));
    }
}
