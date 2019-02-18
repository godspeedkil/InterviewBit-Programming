package Hashing;

import java.util.*;

/**
 * Given an array of integers, find two numbers such that they add up to a specific target number.
 *
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 < index2. Please note that your returned answers (both index1 and index2 ) are not zero-based.
 * Put both these numbers in order in an array and return the array from your function ( Looking at the function signature will make things clearer ). Note that, if no pair exists, return empty list.
 *
 * If multiple solutions exist, output the one where index2 is minimum. If there are multiple solutions with the minimum index2, choose the one with minimum index1 out of them.
 *
 * Input: [2, 7, 11, 15], target=9
 * Output: index1 = 1, index2 = 2
 */
public class TwoSum {

    /**
     * Just find if you've put the complement of the current number previously, and return the
     * answer.
     */
    public static ArrayList<Integer> twoSum(final List<Integer> A, int B) {
        HashMap<Integer, Integer> nums = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();

        for (int i=0; i<A.size(); i++) {
            int current = A.get(i);
            int difference = B-current;

            if (nums.containsKey(difference)) {
                int index = nums.get(difference);
                result.add(index);
                result.add(i+1);
                return result;
            }
            else if (!nums.containsKey(current)) {
                nums.put(current, i+1);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList1 = new ArrayList<>(Arrays.asList(2, 7, 11, 15));
        System.out.println(twoSum(arrayList1, 9));
        ArrayList<Integer> arrayList2 = new ArrayList<>(Arrays.asList(-5, 1, 4, -7, 10, -7, 0, 7,
                3, 0, -2, -5, -3, -6, 4, -7, -8, 0, 4, 9, 4, 1, -8, -6, -6, 0, -9, 5, 3, -9, -5, -9, 6, 3, 8, -10, 1, -2, 2, 1, -9, 2, -3, 9, 9, -10, 0, -9, -2, 7, 0, -4, -3, 1, 6, -3));
        System.out.println(twoSum(arrayList2, -1));
    }
}
