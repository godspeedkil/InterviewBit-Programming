package Backtracking;

import java.util.ArrayList;

/**
 * The set [1,2,3,…,n] contains a total of n! unique permutations.
 *
 * By listing and labeling all of the permutations in order,
 * We get the following sequence (ie, for n = 3 ) :
 *
 * 1. "123"
 * 2. "132"
 * 3. "213"
 * 4. "231"
 * 5. "312"
 * 6. "321"
 * Given n and k, return the kth permutation sequence.
 *
 * For example, given n = 3, k = 4, ans = "231"
 *
 *  Good questions to ask the interviewer :
 * What if n is greater than 10. How should multiple digit numbers be represented in string?
 *  In this case, just concatenate the number to the answer.
 * so if n = 11, k = 1, ans = "1234567891011"
 * Whats the maximum value of n and k?
 *  In this case, k will be a positive integer thats less than INT_MAX.
 * n is reasonable enough to make sure the answer does not bloat up a lot.
 */
public class KthPermutationSequence {

    private static void flip(ArrayList<String> current, int left, int right) {
        while (left<right) {
            String temp = current.get(left);
            current.set(left, current.get(right));
            current.set(right, temp);
            left++;
            right--;
        }
    }

    /**
     * Simple algorithm for permutating ints to the next permutation.
     * Step 1. Find p (first element from right to left less than its previous)
     * Step 2. Find q (first element from right to left greater than p).
     * Step 3. Swap p and q
     * Step 4. Reverse the elements from p+1 to length
     *
     * Note: It keeps looping over permutations.
     */
    private static void nextPermutation(ArrayList<String> current) {
        if (current==null || current.size()<2)
            return;

        int p = 0;
        for (int i=current.size()-2; i>=0; i--)
            if (Integer.parseInt(current.get(i))<Integer.parseInt(current.get(i+1))) {
                p = i;
                break;
            }

        int q = 0;
        for (int i=current.size()-1; i>p; i--)
            if (Integer.parseInt(current.get(i))>Integer.parseInt(current.get(p))) {
                q = i;
                break;
            }

        if (p==0 && q==0) {
            flip(current, 0, current.size()-1);
            return;
        }

        String temp = current.get(p);
        current.set(p, current.get(q));
        current.set(q, temp);

        if (p<current.size()-1)
            flip(current, p+1, current.size()-1);
    }

    public static String getPermutation(int A, int B) {
        ArrayList<String> result = new ArrayList<>();

        for (int i=1; i<=A; i++)
            result.add(i + "");

        for (int i=0; i<B-1; i++) {
            nextPermutation(result);
        }

        StringBuilder resultString = new StringBuilder();
        for (String num : result)
            resultString.append(num);

        return resultString.toString();
    }

    public static void main(String[] args) {
        System.out.println(getPermutation(3, 4));
    }
}
