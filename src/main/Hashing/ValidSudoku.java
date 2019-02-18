package Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Determine if a Sudoku is valid, according to: http://sudoku.com.au/TheRules.aspx
 *
 * The Sudoku board could be partially filled, where empty cells are filled with the character ‘.’.
 *
 *
 *
 * The input corresponding to the above configuration :
 *
 * ["53..7....", "6..195...", ".98....6.", "8...6...3", "4..8.3..1", "7...2...6", ".6....28.", "...419..5", "....8..79"]
 * A partially filled sudoku which is valid.
 *
 *  Note:
 * A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
 * Return 0 / 1 ( 0 for false, 1 for true ) for this problem
 */
public class ValidSudoku {

    private static int hashPush(char ch, HashSet<Integer> temp) {
        if (ch!='.') {
            int num = Integer.parseInt(ch+"");
            if (temp.contains(num))
                return 0;
            else
                temp.add(num);
        }
        return 1;
    }

    /**
     * Check grids, then check both rows and cols at the same time. Any problems cause it to
     * return zero.
     */
    public static int isValidSudoku(final List<String> A) {
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                HashSet<Integer> temp = new HashSet<>();
                for (int k=0; k<3; k++) {
                    for (int l=0; l<3; l++) {
                        int row = (i*3) + k;
                        int col = (j*3) + l;

                        char ch = A.get(row).charAt(col);
                        if (hashPush(ch, temp)==0)
                            return 0;
                    }
                }
            }
        }

        for (int i=0; i<9; i++) {
            HashSet<Integer> tempH = new HashSet<>();
            HashSet<Integer> tempV = new HashSet<>();
            for (int j=0; j<9; j++) {
                char chH = A.get(i).charAt(j);
                char chV = A.get(j).charAt(i);

                if (hashPush(chH, tempH)==0)
                    return 0;
                if (hashPush(chV, tempV)==0)
                    return 0;
            }
        }

        return 1;
    }

    public static void main(String[] args) {
        ArrayList<String> arrayList1 = new ArrayList<>(Arrays.asList("53..7....", "6..195...", ".98....6.", "8...6...3", "4..8.3..1", "7...2...6", ".6....28.", "...419..5", "....8..79"));
        System.out.println(isValidSudoku(arrayList1));
    }
}
