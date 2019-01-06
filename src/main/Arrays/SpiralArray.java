package Arrays;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Given a matrix of m * n elements (m rows, n columns), return all elements of the matrix in spiral order.
 *
 * Example:
 *
 * Given the following matrix:
 *
 * [
 *     [ 1, 2, 3 ],
 *     [ 4, 5, 6 ],
 *     [ 7, 8, 9 ]
 * ]
 * You should return
 *
 * [1, 2, 3, 6, 9, 8, 7, 4, 5]
 */
public class SpiralArray {

    public static ArrayList<Integer> spiralOrder(final List<ArrayList<Integer>> A) {
        int startRow = 0;
        int startColumn = 0;
        int rowSize = A.size();
        int columnSize = A.get(0).size();
        ArrayList<Integer> result = new ArrayList<Integer>();

        while(startRow<rowSize && startColumn<columnSize) {
            for(int i=startColumn; i<columnSize; i++) {
                result.add(A.get(startRow).get(i));
            }
            startRow++;
            for(int i=startRow; i<rowSize; i++) {
                result.add(A.get(i).get(columnSize-1));
            }
            columnSize--;
            if(startRow<rowSize) {
                for(int i=columnSize-1; i>=startColumn; i--) {
                    result.add(A.get(rowSize-1).get(i));
                }
                rowSize--;
            }
            if(startColumn<columnSize) {
                for(int i=rowSize-1; i>=startRow; i--) {
                    result.add(A.get(i).get(startColumn));
                }
                startColumn++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> array =
                new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<10; i++) {
            array.add(new ArrayList<Integer>());
        }
        int i = 0;
        for(ArrayList row : array) {
            for(int j=0; j<10; j++) {
                row.add(i++);
            }
        }
        System.out.println(array.toString());
        ArrayList<Integer> result = spiralOrder(array);
        System.out.println(result.toString());
    }
}
