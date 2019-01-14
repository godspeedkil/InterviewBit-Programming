package Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 *
 * For example:
 *
 * Given [1,3],[2,6],[8,10],[15,18],
 *
 * return [1,6],[8,10],[15,18].
 *
 * Make sure the returned intervals are sorted.
 */
public class MergeOverlappingIntervals {

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

    private static Interval mergeHelper(Interval first, Interval second) {
        int start = (first.start < second.start) ? first.start : second.start;
        int end = (first.end > second.end) ? first.end : second.end;
        return new Interval(start, end);
    }

    private static Interval validate(Interval interval) {
        if(interval.start < interval.end) return interval;
        else return new Interval(interval.end, interval.start);
    }

    /**
     * This should definitely be listed BEFORE MergeIntervals, as that builds
     * on the solution for this one.
     */
    public static ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        ArrayList<Interval> result = new ArrayList<>();
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
                previous = mergeHelper(previous, current);
            }
        }
        result.add(previous);
        return result;
    }
}
