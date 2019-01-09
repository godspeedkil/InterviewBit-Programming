package Arrays;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * You are given a binary string(i.e. with characters 0 and 1) S consisting of characters S1, S2, …, SN. In a single operation, you can choose two indices L and R such that 1 ≤ L ≤ R ≤ N and flip the characters SL, SL+1, …, SR. By flipping, we mean change character 0 to 1 and vice-versa.
 *
 * Your aim is to perform ATMOST one operation such that in final string number of 1s is maximised. If you don’t want to perform the operation, return an empty array. Else, return an array consisting of two elements denoting L and R. If there are multiple solutions, return the lexicographically smallest pair of L and R.
 *
 * Notes:
 *
 * Pair (a, b) is lexicographically smaller than pair (c, d) if a < c or, if a == c and b < d.
 * For example,
 *
 * S = 010
 *
 * Pair of [L, R] | Final string
 * _______________|_____________
 * [1 1]          | 110
 * [1 2]          | 100
 * [1 3]          | 101
 * [2 2]          | 000
 * [2 3]          | 001
 *
 * We see that two pairs [1, 1] and [1, 3] give same number of 1s in final string. So, we return [1, 1].
 * Another example,
 *
 * If S = 111
 *
 * No operation can give us more than three 1s in final string. So, we return empty array [].
 */
public class Flip {

    private class Pair {
        public Integer num1;
        public Integer num2;

        Pair(Integer num1, Integer num2) {
            this.num1 = num1;
            this.num2 = num2;
        }
    }

    /**
     * Solution using a modification of sliding window algorithm, we really
     * only care about solutions that have a netGain of 1 or more, so we add
     * those to a list of up to A.length() possible netGain (in the case that
     * all are 0s).
     * Then we search through the solutions list from highest netGain to
     * lowest, obtaining only the highest, if there are any.
     */
    public ArrayList<Integer> flip(String A) {
        int winL = 0;
        int netGain = 0;
        ArrayList<ArrayList<Pair>> solutions = new ArrayList<>();
        for(int i=0; i<=A.length(); i++)
            solutions.add(new ArrayList<Pair>());

        for(int i=0; i<A.length(); i++) {
            netGain = Math.max(netGain, 0);
            if(A.charAt(i)=='0') {
                netGain++;
            }
            else netGain--;
            if(netGain>0)
                solutions.get(netGain).add(new Pair(winL, i));
            else if(netGain<0)
                winL=i+1;
        }

        ArrayList<Integer> result = new ArrayList<>();

        if(solutions.isEmpty()) return new ArrayList<>();

        for(int i=solutions.size()-1; i>=0; i--) {
            if(!solutions.get(i).isEmpty()) {
                result.add((Integer)solutions.get(i).get(0).num1+1);
                result.add((Integer)solutions.get(i).get(0).num2+1);
                break;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Flip flipper = new Flip();
        String num = "010";
        System.out.println(flipper.flip(num).toString() + " 1 1");
        String num1 = "111";
        System.out.println(flipper.flip(num1).toString() + " ");
        String num2 = "1101";
        System.out.println(flipper.flip(num2).toString() + " 3 3");
        String num3= "1101010001";
        System.out.println(flipper.flip(num3).toString() + " 3 9");
        String num4 = "0111000100010";
        System.out.println(flipper.flip(num4).toString() + " 5 11");
        String num5 = "1";
        System.out.println(flipper.flip(num5).toString() + " ");
    }
}
