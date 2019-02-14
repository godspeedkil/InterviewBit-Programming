package StacksAndQueues;

import java.util.Stack;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 * push(x) – Push element x onto stack.
 * pop() – Removes the element on top of the stack.
 * top() – Get the top element.
 * getMin() – Retrieve the minimum element in the stack.
 * Note that all the operations have to be constant time operations.
 *
 * Questions to ask the interviewer :
 *
 * Q: What should getMin() do on empty stack?
 * A: In this case, return -1.
 *
 * Q: What should pop do on empty stack?
 * A: In this case, nothing.
 *
 * Q: What should top() do on empty stack?
 * A: In this case, return -1
 *
 *  NOTE : If you are using your own declared global variables, make sure to clear them out in the constructor.
 */
public class MinStack {

    /**
     * Biggest problem here is how to make sure you update the min when you
     * pop. 2*x - min makes sure to insert a value that is always lower than
     * the min. You do the inverse 2*min - x to update the min if you happen
     * to pop the min. Other than that, simply watch out when getting top, as
     * you need to make sure you're not getting a placeholder for min.
     */
    class Solution {
        Stack<Integer> stack = new Stack<>();
        int min = Integer.MAX_VALUE;

        public void push(int x) {
            if (stack.isEmpty()) {
                min = x;
                stack.push(x);
            }
            else {
                if (x<min) {
                    stack.push(2*x - min);
                    min = x;
                }
                else
                    stack.push(x);
            }
        }

        public void pop() {
            if (stack.isEmpty()) return;

            int temp = stack.pop();

            if (temp<min) {
                min = 2*min - temp;
            }
        }

        public int top() {
            if (stack.isEmpty())
                return -1;

            int temp = stack.peek();

            if (temp<min)
                return min;

            return temp;
        }

        public int getMin() {
            if (stack.isEmpty()) return -1;

            return min;
        }
    }
}
