package BinarySearch;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 *
 * This matrix has the following properties:
 *
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than or equal to the last integer of the previous row.
 * Example:
 *
 * Consider the following matrix:
 *
 * [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * Given target = 3, return 1 ( 1 corresponds to true )
 *
 * Return 0 / 1 ( 0 if the element is not present, 1 if the element is present ) for this problem
 */
public class MatrixSearch {

    /**
     * Binary search rows, then binary search columns for O(logn*logm)
     * efficiency).
     */
    public static int searchMatrix(ArrayList<ArrayList<Integer>> a, int b) {
        int columnLow = 0, columnHigh = a.get(0).size()-1;
        int rowLow = 0, rowHigh = a.size()-1;

        while(rowLow<rowHigh) {
            int rowMid = (rowLow+rowHigh)/2;
            if(b<a.get(rowMid).get(0))
                rowHigh = rowMid;
            else if(b>a.get(rowMid).get(columnHigh))
                rowLow = rowMid+1;
            else {
                rowLow = rowMid;    //store desired row in rowLow
                break;
            }
        }
        while(columnLow<columnHigh) {
            int columnMid = (columnLow+columnHigh)/2;
            if(a.get(rowLow).get(columnMid)==b)
                return 1;
            if(b<a.get(rowLow).get(columnMid))
                columnHigh = columnMid;
            else if(b>a.get(rowLow).get(columnMid))
                columnLow = columnMid+1;
        }
        if(a.get(rowLow).get(columnLow)==b)
            return 1;

        return 0;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList1 = new ArrayList<>(Arrays.asList(1, 3, 5,
                7));
        ArrayList<Integer> arrayList2 = new ArrayList<>(Arrays.asList(10, 11,
                16, 20));
        ArrayList<Integer> arrayList3 = new ArrayList<>(Arrays.asList(23, 30,
                34, 50));
        ArrayList<ArrayList<Integer>> matrix1 =
                new ArrayList<ArrayList<Integer>>(Arrays.asList(arrayList1,
                        arrayList2, arrayList3));
        System.out.println(searchMatrix(matrix1, 3));
        ArrayList<Integer> arrayList4 = new ArrayList<>(Arrays.asList(1));
        ArrayList<ArrayList<Integer>> matrix2 =
                new ArrayList<>(Arrays.asList(arrayList4));
        System.out.println(searchMatrix(matrix2, 0));
    }
}
