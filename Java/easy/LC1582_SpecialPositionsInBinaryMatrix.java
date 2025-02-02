package easy;

public class LC1582_SpecialPositionsInBinaryMatrix {
     /**
     * <b>1st Try.</b> <br />
     * TODO this brute force solution can be optimized<br>
     * Solved: 2023-12-13
     */
    public int numSpecial(int[][] mat) {
        int specialNums = 0;

        for (int i = 0; i < mat.length; i++) { // i -> row
            for (int j = 0; j < mat[i].length; j++) {  // j -> col
                if (mat[i][j] == 1 && checkPos(i,j,mat)) {
                    specialNums++;
                }
            }
        }

        return specialNums;
    }

    private boolean checkPos(int row, int col, int[][] mat) {
        // 1. Check Row
        for (int i = 0; i < mat[row].length; i++) {
            if (col == i) continue;
            if (mat[row][i] == 1) {
                return false;
            }
        }

        for (int i = 0; i < mat.length; i++) {
            if (row == i) continue;
            if (mat[i][col] == 1) {
                return false;
            }
        }
        return true;
    }
}
