package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 *
 * You may assume that the intervals were initially sorted according to their start times.
 *
 * Example 1:
 *
 * Given intervals [1,3],[6,9] insert and merge [2,5] would result in [1,5],[6,9].
 *
 * Example 2:
 *
 * Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] would result in [1,2],[3,10],[12,16].
 *
 * This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 *
 * Make sure the returned intervals are also sorted.
 */
public class MergeIntervals {

    private static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }

        @Override
        public String toString() {
            return "[" + start + "," + end + "]";
        }
    }

    private static Interval merge(Interval first, Interval second) {
        int start = (first.start < second.start) ? first.start : second.start;
        int end = (first.end > second.end) ? first.end : second.end;
        return new Interval(start, end);
    }

    private static Interval validate(Interval interval) {
        if(interval.start < interval.end) return interval;
        else return new Interval(interval.end, interval.start);
    }

    /**
     * Simple solution, utilizes helper classes to merge and validate.
     * Considering, the original problem was horribly worded. Specifically,
     * the fact that no where does it say that the new interval can be
     * backwards.
     */
    public static ArrayList<Interval> insert(ArrayList<Interval> intervals,
                                       Interval newInterval) {
        newInterval = validate(newInterval);
        ArrayList<Interval> result = new ArrayList<>();
        if(intervals.isEmpty()) {
            result.add(newInterval);
            return result;
        }
        intervals.add(newInterval);
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        Interval previous = intervals.get(0);
        for(int i=0; i<intervals.size(); i++) {
            Interval current = intervals.get(i);
            if(current.start > previous.end) {
                result.add(previous);
                previous = current;
            } else {
                previous = merge(previous, current);
            }
        }
        result.add(previous);
        return result;
    }

    public static void main(String[] args) {
        ArrayList<Interval> arrayList1 =
                new ArrayList<>(Arrays.asList(new Interval(1, 2),
                        new Interval(3, 6)));
        System.out.println(insert(arrayList1, new Interval(10, 8)).toString());
    }
}
