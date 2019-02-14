package StacksAndQueues;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * Given an array, find the nearest smaller element G[i] for every element A[i] in the array such that the element has an index smaller than i.
 *
 * More formally,
 *
 * G[i] for an element A[i] = an element A[j] such that
 *     j is maximum possible AND
 *     j < i AND
 *     A[j] < A[i]
 * Elements for which no smaller element exist, consider next smaller element as -1.
 *
 * Example:
 *
 * Input : A : [4, 5, 2, 10, 8]
 * Return : [-1, 4, -1, 2, 2]
 *
 * Example 2:
 *
 * Input : A : [3, 2, 1]
 * Return : [-1, -1, -1]
 */
public class NearestSmallerElement {

    /**
     * Efficient O(n) solution with O(1) additional space. This simply relies
     * on checking everything to the left through the use of a stack. Code is
     * pretty self-explanatory.
     */
    public static ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
        Stack<Integer> stack = new Stack<>();

        for (int i=0; i<A.size(); i++) {
            int current = A.get(i);

            while (!stack.empty() && stack.peek()>=current) {
                stack.pop();
            }

            if (stack.empty())
                A.set(i, -1);
            else
                A.set(i, stack.peek());

            stack.push(current);
        }

        return A;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList1 = new ArrayList<>(Arrays.asList(4, 5, 2
                , 10, 8));
        System.out.println(prevSmaller(arrayList1));
        ArrayList<Integer> arrayList2 = new ArrayList<>(Arrays.asList(3, 2, 1));
        System.out.println(prevSmaller(arrayList2));
    }
}
