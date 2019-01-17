package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaximumConsecutiveGap {

    public static int maximumGap(final List<Integer> A) {
        if(A.size() < 2) return 0;

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        for(Integer num: A) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        int[] buckets = new int[max-min+1];

        for(Integer num: A) {
            buckets[num-min] = num;
        }

        int maxGap = 0;
        int prevNum = max;
        for(int i=buckets.length-1; i>=0; i--) {
            if(buckets[i]!=0) {
                int diff = Math.abs(buckets[i] - prevNum);
                maxGap = Math.max(maxGap, diff);
                prevNum = buckets[i];
            }
        }

        return maxGap;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList1 = new ArrayList<>(Arrays.asList(1, 10,
                5));
        System.out.println(maximumGap(arrayList1));
    }
}
