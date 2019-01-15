package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * You’re given a read only array of n integers. Find out if any integer occurs more than n/3 times in the array in linear time and constant additional space.
 *
 * If so, return the integer. If not, return -1.
 *
 * If there are multiple solutions, return any one.
 *
 * Example :
 *
 * Input : [1 2 3 1 1]
 * Output : 1
 * 1 occurs 3 times which is more than 5/3 times.
 */
public class NOver3RepeatNumber {

    /**
     * Better solution, also O(n) runtime, but O(1) additional space. A
     * variation of the voting algorithm. First pass gets two candidates for
     * majority in array. Second pass gets actual count of both.
     */
    public static int repeatedNumber(final List<Integer> a) {
        int count1 = 0, count2 = 0;
        int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;

        for(int i=0; i<a.size(); i++) {
            if(first == a.get(i))
                count1++;
            else if(second == a.get(i))
                count2++;
            else if(count1 == 0) {
                first = a.get(i);
                count1++;
            }
            else if(count2 == 0) {
                second = a.get(i);
                count2++;
            }
            else {
                count1--;
                count2--;
            }
        }

        count1 = count2 = 0;

        for(int i=0; i<a.size(); i++) {
            if(a.get(i) == first)
                count1++;
            else if(a.get(i) == second)
                count2++;
        }

        if(count1 > a.size()/3)
            return first;
        if(count2 > a.size()/3)
            return second;

        return -1;
    }

    /**
     * Initial naive solution, however utilizes extra O(n) space to keep
     * track of the count of each different value. Other than that, runs in O
     * (n) time, so it's not too bad of an option.
     */
    public static int repeatedNumberNaive(final List<Integer> a) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        for(Integer num : a) {
            if(num<min) min = num;
            if(num>max) max = num;
        }

        int[] range = new int[(max-min)+1];

        for(Integer num : a) {
            range[num-min]++;
        }

        double nOver3 = (double)a.size()/3;

        for(int i=0; i<range.length; i++)
            if(range[i] > nOver3)
                return i+min;

        return -1;
    }

    public static void main(String[] args) {
//        ArrayList<Integer> arrayList1 = new ArrayList<>(Arrays.asList(1, 2, 3,
//                1, 1));
//        System.out.println(repeatedNumber(arrayList1));
        ArrayList<Integer> arrayList2 = new ArrayList<>(Arrays.asList(1));
        System.out.println(repeatedNumber(arrayList2));
    }
}
