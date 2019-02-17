package Backtracking;

import java.util.ArrayList;

/**
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 *
 * N Queens: Example 1
 *
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 *
 * Each solution contains a distinct board configuration of the n-queens’ placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
 *
 * For example,
 * There exist two distinct solutions to the 4-queens puzzle:
 *
 * [
 *  [".Q..",  // Solution 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // Solution 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 */
public class NQueens {

    private static void printSolutions(ArrayList<ArrayList<String>> solutions) {
        for (ArrayList<String> solution : solutions) {
            for (String row : solution)
                System.out.println(row);
            System.out.println();
        }
    }

    /**
     * isSafe helper function checks whether queens placed previously create a conflict with the
     * proposed positioning. A per-row approach is much better for working with ArrayLists.
     */
    private static boolean isSafe(ArrayList<String> board, int row, int col) {
        for (int i=0; i<row; i++)
            if (board.get(i).charAt(col)=='Q')
                return false;

        for (int i=row, j=col; i>=0 && j>=0; i--, j--)
            if (board.get(i).charAt(j)=='Q')
                return false;

        for (int i=row, j=col; i>=0 && j<board.size(); i--, j++)
            if (board.get(i).charAt(j)=='Q')
                return false;

        return true;
    }

    /**
     * Recursive function for handling the different cases. For every possible positioning on the
     * current row, we check safety and create a new call to continue down that branch.
     */
    private static void backtrack(ArrayList<ArrayList<String>> solutions, ArrayList<String> board
            , int n, int row) {
        if (row>=n)
            solutions.add(board);

        for (int i=0; i<n; i++) {
            if (isSafe(board, row, i)) {
                ArrayList<String> newBoard = new ArrayList<>(board);
                StringBuilder rowString = new StringBuilder(newBoard.get(row));
                rowString.setCharAt(i, 'Q');
                newBoard.set(row, rowString.toString());

                backtrack(solutions, newBoard, n, row+1);
            }
        }
    }

    public static ArrayList<ArrayList<String>> solveNQueens(int a) {
        ArrayList<ArrayList<String>> solutions = new ArrayList<>();
        ArrayList<String> board = new ArrayList<>();

        for (int i=0; i<a; i++) {
            String row = "";
            for (int j=0; j<a; j++)
                row = row + ".";
            board.add(row);
        }

        backtrack(solutions, board, a, 0);

        return solutions;
    }

    public static void main(String[] args) {
        printSolutions(solveNQueens(4));
    }
}
