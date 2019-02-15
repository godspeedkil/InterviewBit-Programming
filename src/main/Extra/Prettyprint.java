package Extra;

import java.util.ArrayList;

/**
 * Print concentric rectangular pattern in a 2d matrix.
 * Let us show you some examples to clarify what we mean.
 *
 * Example 1:
 *
 * Input: A = 4.
 * Output:
 *
 * 4 4 4 4 4 4 4
 * 4 3 3 3 3 3 4
 * 4 3 2 2 2 3 4
 * 4 3 2 1 2 3 4
 * 4 3 2 2 2 3 4
 * 4 3 3 3 3 3 4
 * 4 4 4 4 4 4 4
 * Example 2:
 *
 * Input: A = 3.
 * Output:
 *
 * 3 3 3 3 3
 * 3 2 2 2 3
 * 3 2 1 2 3
 * 3 2 2 2 3
 * 3 3 3 3 3
 * The outermost rectangle is formed by A, then the next outermost is formed by A-1 and so on.
 *
 * You will be given A as an argument to the function you need to implement, and you need to return a 2D array.
 */
public class Prettyprint {

    /**
     * Simple O(n^2) solution that writes over each interior "square" of
     * numbers.
     */
    public static ArrayList<ArrayList<Integer>> prettyPrint(int A) {
        int currentNum = A;
        int size = (2*A)-1;
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        for(int i=0; i<size; i++)
            temp.add(0);

        for(int i=0; i<size; i++)
            result.add(new ArrayList<Integer>(temp));


        for(int i=0; i<=size/2; i++) {
            for (int j = i; j < size - i; j++) {
                result.get(j).set(i, currentNum);           // vertical left line
                result.get(j).set(size-1-i, currentNum);    // vertical right line
                result.get(i).set(j, currentNum);           // horizontal top line
                result.get(size-1-i).set(j, currentNum);    // horizontal bottom line
            }
            currentNum--;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(prettyPrint(7));
    }
}
