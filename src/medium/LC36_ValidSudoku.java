package medium;

import java.util.HashSet;
import java.util.Set;

public class LC36_ValidSudoku {

    public static void main(String[] args) {
        System.out.println(isValidSudoku(new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        }));
    }

    /**
     * <b>1st Try.</b> <br />
     * Check for rows, columns and squares<br />
     * Solved: 2023-06-25
     */
    public static boolean isValidSudoku(char[][] board) {

        // Check for rows
        Set<Character> set = new HashSet<>();

        for (char[] row : board) {
            set.clear();
            for (char c : row) {
                if (c != '.') {
                    if (set.contains(c)) return false;
                    set.add(c);
                }
            }
        }

        // Check for columns
        for (int i = 0; i < board[0].length; i++) {
            set.clear();
            for (int j = 0; j < board.length; j++) {
                if (board[j][i] != '.') {
                    if (set.contains(board[j][i])) return false;
                    set.add(board[j][i]);
                }
            }
        }

        // Check for squares
        int col = 0;
        int row = 0;
        while (col < board.length && row < board.length) {
            set.clear();
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (set.contains(board[row + i][col + j])) return false;
                    if (board[row + i][col + j] != '.') set.add(board[row + i][col + j]);
                }
            }

            col += 3;
            if (col >= board.length){
                row += 3;
                col = 0;
            }
        }

        return true;
    }

    /**
     * <a href="https://github.com/neetcode-gh/leetcode/blob/main/java/0036-valid-sudoku.java">Neetcode Solution</a> <br>
     * Same approach, more optimized.
     */
    public boolean isValidSudoku2(char[][] board) {
        //neetcode solution, slightly modified

        //a set of the characters that we have already come across (excluding '.' which denotes an empty space)
        Set<Character> rowSet = null;
        Set<Character> colSet = null;


        for (int i = 0; i < 9; i++) {
            //reinitialize the sets so we don't carry over found characters from the previous run
            rowSet = new HashSet<>();
            colSet = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                char r = board[i][j];
                char c = board[j][i];
                if (r != '.'){
                    if (rowSet.contains(r)){
                        return false;
                    } else {
                        rowSet.add(r);
                    }
                }
                if (c != '.'){
                    if (colSet.contains(c)){
                        return false;
                    } else {
                        colSet.add(c);
                    }
                }
            }
        }

        //block
        //loop controls advance by 3 each time to jump through the boxes
        for (int i = 0; i < 9; i = i + 3) {
            for (int j = 0; j < 9; j = j + 3) {
                //checkBlock will return true if valid
                if (!checkBlock(i, j, board)) {
                    return false;
                }
            }
        }
        //passed all tests, therefore valid board
        return true;
    }

    public boolean checkBlock(int idxI, int idxJ, char[][] board) {
        Set<Character> blockSet = new HashSet<>();
        //if idxI = 3 and indJ = 0
        //rows = 6 and cols = 3
        int rows = idxI + 3;
        int cols = idxJ + 3;
        //and because i initializes to idxI but only goes to rows, we loop 3 times (once for each row)
        for (int i = idxI; i < rows; i++) {
            //same for columns
            for (int j = idxJ; j < cols; j++) {
                if (board[i][j] == '.') {
                    continue;
                }

                if (blockSet.contains(board[i][j])) {
                    return false;
                }

                blockSet.add(board[i][j]);
            }
        }

        return true;
    }
}
