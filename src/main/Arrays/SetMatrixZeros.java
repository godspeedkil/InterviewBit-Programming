package Arrays;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * Given an m x n matrix of 0s and 1s, if an element is 0, set its entire row and column to 0.
 *
 * Do it in place.
 *
 * Example
 *
 * Given array A as
 *
 * 1 0 1
 * 1 1 1
 * 1 1 1
 * On returning, the array A should be :
 *
 * 0 0 0
 * 1 0 1
 * 1 0 1
 * Note that this will be evaluated on the extra memory used. Try to minimize the space and time complexity.
 */
public class SetMatrixZeros {

    /**
     * Simple O(m*n) solution. Considering any 0 will clear its row and
     * column, it is just a question of remembering the indices of the rows
     * and columns to be cleared. A HashSet works nicely in allowing for
     * quick lookup of the indices, while protecting us from introducing
     * repeated values.
     */
    public static void setZeroes(ArrayList<ArrayList<Integer>> a) {
        HashSet<Integer> rows = new HashSet<>();
        HashSet<Integer> columns = new HashSet<>();

        for(int i=0; i<a.size(); i++)
            for(int j=0; j<a.get(0).size(); j++)
                if(a.get(i).get(j) == 0) {
                    rows.add(i);
                    columns.add(j);
                }

        for(int i=0; i<a.size(); i++)
            for(int j=0; j<a.get(0).size(); j++)
                if(rows.contains(i) || columns.contains(j))
                    a.get(i).set(j, 0);
    }

    public static void main(String[] args) {
        ArrayList<Integer> first = new ArrayList<>(Arrays.asList(1, 0, 1));
        ArrayList<Integer> allOnes = new ArrayList<>(Arrays.asList(1, 1, 1));
        ArrayList<ArrayList<Integer>> arrayList1 = new ArrayList<>();
        arrayList1.add(first);
        arrayList1.add(allOnes);
        arrayList1.add(allOnes);
        setZeroes(arrayList1);
        System.out.println(arrayList1.toString());
    }
}
