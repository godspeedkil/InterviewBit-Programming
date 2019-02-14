package StacksAndQueues;

import java.util.Stack;

/**
 * Write a program to validate if the input string has redundant braces?
 * Return 0/1
 *
 * 0 -> NO
 * 1 -> YES
 * Input will be always a valid expression
 *
 * and operators allowed are only + , * , - , /
 *
 * Example:
 *
 * ((a + b)) has redundant braces so answer will be 1
 * (a + (a + b)) doesn't have have any redundant braces so answer will be 0
 */
public class RedundantBraces {

    /**
     * Pretty good example of how NOT to specify requirements and constraints
     * . Test cases for this solution are outside the realms of what is
     * expected to be "logical need for braces." Either way, O(n) solution
     * works as expected.
     */
    public static int braces(String A) {
        Stack<Character> stack = new Stack<>();
        boolean hasOne = false;

        for (int i=0; i<A.length(); i++) {
            Character current = A.charAt(i);
            if (current=='(' || current=='+' || current=='*'
            || current=='-' || current=='/')
                stack.push(A.charAt(i));
            else if (current==')') {
                hasOne = true;
                Character top = stack.pop();
                if (top!='+' && top!='*' && top!='-' && top!='/')
                    return 0;
                else
                    stack.pop();
            }
        }

        if (!hasOne) return 0;

        return 1;
    }

    public static void main(String[] args) {
        String expr1 = "((a + b))";
        System.out.println(braces(expr1));
        String expr2 = "(a + (a + b))";
        System.out.println(braces(expr2));
        String expr3 = "a+b";
        System.out.println(braces(expr3));
    }
}
