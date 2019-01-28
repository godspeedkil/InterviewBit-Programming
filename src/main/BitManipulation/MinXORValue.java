package BitManipulation;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given an array of N integers, find the pair of integers in the array which have minimum XOR value. Report the minimum XOR value.
 *
 * Examples :
 * Input
 * 0 2 5 7
 * Output
 * 2 (0 XOR 2)
 * Input
 * 0 4 7 9
 * Output
 * 3 (4 XOR 7)
 *
 * Constraints:
 * 2 <= N <= 100 000
 * 0 <= A[i] <= 1 000 000 000
 */
public class MinXORValue {
    Node tree = new Node();

    private class Node {
        Node left, right;
    }

    /**
     * Helper function to insert int into binary tree.
     */
    private void insert(int num) {
        Node current = tree;
        for(int i=31; i>=0; i--) {
            if((int)num/Math.pow(2,i) >= 1) {
                if(current.right==null)
                    current.right = new Node();
                current = current.right;
                num -= (int)Math.pow(2, i);
            }
            else {
                if(current.left==null)
                    current.left = new Node();
                current = current.left;
            }
        }
    }

    /**
     * Helper function gets min XOR difference between current int and tree.
     */
    private int getMin(int num) {
        int min = 0;
        Node current = tree;
        for(int i=31; i>=0; i--) {
            if((int)num/Math.pow(2,i) >= 1) {
                if(current.right==null) {
                    min += (int)Math.pow(2,i);
                    current = current.left;
                }
                else current = current.right;
                num -= (int)Math.pow(2,i);
            }
            else {
                if(current.left==null) {
                    min += (int)Math.pow(2,i);
                    current = current.right;
                }
                else current = current.left;
            }
        }
        return min;
    }

    /**
     * Proper solution runs in O(n) time. Build a binary tree that stores
     * previous ints as binary representations. For every new int compare
     * with previous ones, taking the path that leads to the min XOR
     * difference (i.e., follow path that most closely matches current int).
     */
    public int findMinXor(ArrayList<Integer> A) {
        insert(A.get(0));
        int min = Integer.MAX_VALUE;
        for(int i=1; i<A.size(); i++) {
            min = Math.min(min, getMin(A.get(i)));
            insert(A.get(i));
        }
        return min;
    }

    /**
     * Naive solution compares all against each other, O(n^2) time.
     */
    public static int findMinXorNaive(ArrayList<Integer> A) {
        int min = Integer.MAX_VALUE;

        for(int i=0; i<A.size(); i++) {
            for(int j=A.size()-1; j>i; j--) {
                min = Math.min(A.get(i) ^ A.get(j), min);
                if(min == 977) System.out.println(A.get(i) + ", " + A.get(j));
            }
        }

        return min;
    }

    public static void main(String[] args) {
        MinXORValue test = new MinXORValue();
//        System.out.println(test.findMinXor(new ArrayList<>(Arrays.asList(0, 2, 5,
//         7))));
        System.out.println(test.findMinXor(new ArrayList<>(Arrays.asList(492416, 275153, 684032, 319360, 543232, 804480, 525824, 671825, 1036753, 940625, 909521, 405120, 1076689, 80081, 57856, 1000145, 13649, 596049, 429649, 289489, 907136, 261120, 1247313, 902609, 576465, 1133696, 1128576, 877440, 1058432, 554449, 1206225, 1007953, 1066705, 1237329, 491601, 300753, 789073, 1233408, 513617, 657152, 993664, 93568, 324689, 457169, 254208, 1250560, 217169, 557568, 416896, 256465, 687313, 21888, 433536, 276224, 536145, 466304, 3200, 162176, 341376, 589824, 1075840, 411345, 401873, 52561, 653649, 1077376, 1011456, 339281, 297472, 931200, 869969, 1131601, 326272, 94801, 1246464, 646400, 727040, 1001856, 120192, 1093585, 309632, 313169, 160977, 1102720, 1126993))));
//        System.out.println(test.findMinXor(new ArrayList<>(Arrays.asList(492416, 491601))));
    }
}
