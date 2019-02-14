package StacksAndQueues;

import java.util.*;

/**
 * A long array A[] is given to you. There is a sliding window of size w which is moving from the very left of the array to the very right. You can only see the w numbers in the window. Each time the sliding window moves rightwards by one position. You have to find the maximum for each window. The following example will give you more clarity.
 *
 * Example :
 *
 * The array is [1 3 -1 -3 5 3 6 7], and w is 3.
 *
 * Window position	Max
 *
 * [1 3 -1] -3 5 3 6 7	3
 * 1 [3 -1 -3] 5 3 6 7	3
 * 1 3 [-1 -3 5] 3 6 7	5
 * 1 3 -1 [-3 5 3] 6 7	5
 * 1 3 -1 -3 [5 3 6] 7	6
 * 1 3 -1 -3 5 [3 6 7]	7
 * Input: A long array A[], and a window width w
 * Output: An array B[], B[i] is the maximum value of from A[i] to A[i+w-1]
 * Requirement: Find a good optimal way to get B[i]
 *
 *  Note: If w > length of the array, return 1 element with the max of the array.
 */
public class SlidingWindowMaximum {

    /**
     * Deque is probably the most useful data structure for this problem.
     * With it, we are capable of modifying both ends of a queue. Whenever a
     * new value is added, we make sure to remove all values before it that
     * are less than the value. This makes sure that the highest value of the
     * current window is always the first element of the queue. Once we start
     * leaving values behind, we make sure to remove them from the deque. It
     * is also important to note that the deque itself contains the indexes
     * of the values, otherwise we would make it harder to determine when a
     * value is left outside the window.
     */
    public static ArrayList<Integer> slidingMaximum(final List<Integer> A,
                                                  int B) {
        Deque<Integer> deque = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();

        int i;
        for (i=0; i<B; i++) {
            while (!deque.isEmpty() && A.get(i)>=A.get(deque.peekLast()))
                deque.removeLast(); // remove ones less than current

            deque.addLast(i);
        }

        for (; i<A.size(); i++) {
            result.add(A.get(deque.peekFirst())); // result of previous

            while (!deque.isEmpty() && deque.peek()<=i-B)   // remove those
                deque.removeFirst();                        // to the left

            while (!deque.isEmpty() && A.get(i)>=A.get(deque.peekLast()))
                deque.removeLast(); // remove ones less than current

            deque.addLast(i);
        }

        result.add(A.get(deque.peekFirst())); // for last window

        return result;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList1 = new ArrayList<>(Arrays.asList(1, 3,
                -1, -3, 5, 3, 6, 7));
        System.out.println(slidingMaximum(arrayList1, 3));
    }
}
