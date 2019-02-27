package Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 *
 * Sample Input :
 *
 * (1, 1)
 * (2, 2)
 * Sample Output :
 *
 * 2
 * You will be give 2 arrays X and Y. Each point is represented by (X[i], Y[i])
 */
public class PointsOnTheStraightLine {

    private static int gcd(int a, int b) {
        if (b==0)
            return a;
        return gcd(b, a%b);
    }

    /**
     * The premise of this O(n^2) solution is to simply take one point as candidate and compare
     * against all others left. If the slope is the same, or it's the same point, we count it
     * towards the currMax. An important thing to keep track of is points on slope 0 (vertical to
     * our current point). At the end of every subloop, we update the maxPoints.
     */
    public static int maxPoints(ArrayList<Integer> a, ArrayList<Integer> b) {
        int n = a.size();

        if (n<2)
            return n;

        int maxPoints = 0;
        int currMax, samePoints, vertPoints; //vertPoints have slope 0

        HashMap<ArrayList<Integer>, Integer> slopes = new HashMap<>();

        for (int i=0; i<n; i++) {
            currMax = samePoints = vertPoints = 0;

            for (int j=i+1; j<n; j++) {
                if (a.get(i).equals(a.get(j)) && b.get(i).equals(b.get(j)))
                    samePoints++;

                else if (a.get(i).equals(a.get(j)))
                    vertPoints++;

                else {
                    int deltaY = b.get(j)-b.get(i);
                    int deltaX = a.get(j)-a.get(i);
                    int gcd = gcd(deltaX, deltaY);

                    deltaY /= gcd;
                    deltaX /= gcd;

                    ArrayList<Integer> temp = new ArrayList<>(Arrays.asList(deltaY, deltaX));
                    int currentCount = (slopes.get(temp)==null) ? 0 : slopes.get(temp);
                    slopes.put(temp, currentCount+1);
                    currMax = Math.max(currMax, slopes.get(temp));
                }

                currMax = Math.max(currMax, vertPoints);
            }

            maxPoints = Math.max(maxPoints, currMax+samePoints+1);

            slopes.clear();
        }

        return maxPoints;
    }

    public static void main(String[] args) {
        ArrayList arrayList1 = new ArrayList<Integer>(Arrays.asList(1, 2));
        System.out.println(maxPoints(arrayList1, arrayList1));
        ArrayList arrayList2 = new ArrayList<Integer>(Arrays.asList(-6, 5, -18, 2, 5, -2));
        ArrayList arrayList3 = new ArrayList<Integer>(Arrays.asList(-17, -16, -17, -4, -13, 20));
        System.out.println(maxPoints(arrayList2, arrayList3));
    }
}
