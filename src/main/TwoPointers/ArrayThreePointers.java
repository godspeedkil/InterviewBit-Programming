package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * You are given 3 arrays A, B and C. All 3 of the arrays are sorted.
 *
 * Find i, j, k such that :
 * max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i])) is minimized.
 * Return the minimum max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i]))
 *
 * **abs(x) is absolute value of x and is implemented in the following manner : **
 *
 *       if (x < 0) return -x;
 *       else return x;
 * Example :
 *
 * Input :
 *         A : [1, 4, 10]
 *         B : [2, 15, 20]
 *         C : [10, 12]
 *
 * Output : 5
 *          With 10 from A, 15 from B and 10 from C.
 */
public class ArrayThreePointers {

    /**
     * This ends up being the same as the MinimizeTheAbsDiff problem
     * previously seen. Don't know why they would repeat it.
     */
    public static int solve(ArrayList<Integer> A, ArrayList<Integer> B,
                            ArrayList<Integer> C) {
        int pointerA = 0, pointerB = 0, pointerC = 0;
        int min = Integer.MAX_VALUE;

        while(pointerA<A.size() && pointerB<B.size() && pointerC<C.size()) {
            int a = A.get(pointerA), b = B.get(pointerB), c = C.get(pointerC);
            int minABC = Math.min(Math.min(a, b), c);
            int maxABC = Math.max(Math.max(a, b), c);
            min = Math.min(min, Math.abs(maxABC-minABC));
            if(minABC==a) {
                pointerA++;
            }
            else if(minABC==b) {
                pointerB++;
            }
            else pointerC++;
        }

        return min;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList1 = new ArrayList<>(Arrays.asList(1, 4, 10));
        ArrayList<Integer> arrayList2 = new ArrayList<>(Arrays.asList(2, 15,
                20));
        ArrayList<Integer> arrayList3 = new ArrayList<>(Arrays.asList(10, 12));
        System.out.println(solve(arrayList1, arrayList2, arrayList3));
    }
}
