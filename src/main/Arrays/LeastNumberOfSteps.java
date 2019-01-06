package Arrays;

import java.lang.Math;
import java.util.ArrayList;

/**
 * You are in an infinite 2D grid where you can move in any of the 8 directions :
 *
 *  (x,y) to
 *     (x+1, y),
 *     (x - 1, y),
 *     (x, y+1),
 *     (x, y-1),
 *     (x-1, y-1),
 *     (x+1,y+1),
 *     (x-1,y+1),
 *     (x+1,y-1)
 * You are given a sequence of points and the order in which you need to cover the points. Give the minimum number of steps in which you can achieve it. You start from the first point.
 *
 * Input :
 *
 * Given two integer arrays A and B, where A[i] is x coordinate and B[i] is y coordinate of ith point respectively.
 * Output :
 *
 * Return an Integer, i.e minimum number of steps.
 * Example :
 *
 * Input : [(0, 0), (1, 1), (1, 2)]
 * Output : 2
 * It takes 1 step to move from (0, 0) to (1, 1). It takes one more step to move from (1, 1) to (1, 2).
 */
public class LeastNumberOfSteps {

    /**
     * Equivalent to drawing a straight line between both points
     *
     * Considering you can only move one step in a direction at a time, the
     * max number of steps is only dependent on the biggest dimension that
     * must be travelled, we only have two dimensions here so...
     */
    private static int getShortestPath(int x1, int y1, int x2, int y2) {
        int distanceX = Math.abs(x1-x2);
        int distanceY = Math.abs(y1-y2);
        return Math.max(distanceX, distanceY);
    }

    public static int coverPoints(ArrayList<Integer> A, ArrayList<Integer> B) {
        int stepCounter = 0;
        for(int i=0; i<A.size()-1; i++) {
            stepCounter += getShortestPath(A.get(i), B.get(i),
                                            A.get(i+1), B.get(i+1));
        }
        return stepCounter;
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<Integer>();
        A.add(0);
        A.add(0);
        A.add(1);
        ArrayList<Integer> B = new ArrayList<Integer>();
        B.add(0);
        B.add(1);
        B.add(2);
        System.out.println(coverPoints(A, B));
    }
}
